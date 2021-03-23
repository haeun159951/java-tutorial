package com.siwoo.classes.abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Button {
    private int width;
    private int height;
    private String label;
    private int numOfClicked;

    public Button(int width, int height, String label) {
        this.width = width;
        this.height = height;
        this.label = label;
    }

    public void click(){
        //System.out.println("click"); //unique
        hook(); //unique
        numOfClicked++; //common
    }

    abstract void hook();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getLabel() {
        return label;
    }

    public int getNumOfClicked() {
        return numOfClicked;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Button{" +
                "width=" + width +
                ", height=" + height +
                ", label='" + label + '\'' +
                '}';
    }
}


class DisableBtn extends Button {
    private boolean enabled = true;

    public DisableBtn(int width, int height, String label) {
        super(width, height, label);
    }

    @Override
    void hook() {
        if (enabled)
            System.out.println("Clicked");
    }

    public void setEnable(boolean enable) {
        enabled = enable;
    }

    public static void main(String[] args) {
        DisableBtn button = new DisableBtn(1, 1, "btn1");
        button.setEnable(true);
        button.click();
        System.out.println("----------------");
        button.setEnable(false);
        button.click();
    }
}

class SubmitButton extends Button{

    public SubmitButton(int width, int height, String label) {
        super(width, height, label);
    }

    @Override
    void hook() {
        System.out.println("submit the form");
    }
}

class SendMessageButton extends Button {

    private List<String> messages = new ArrayList<>();

    public SendMessageButton(int width, int height, String label) {
        super(width, height, label);
    }

    public void addMessage(String message){
        messages.add(message);
    }

    @Override
    public void hook(){
        System.out.printf("send a message [%s] to you %n",
                String.join(",", messages));
    }
}

class ArrayButton extends Button {
    private List<Button> children = new ArrayList<>();
    private int index = -1;

    public ArrayButton(int width, int height, String label) {
        super(width, height, label);
    }

    @Override
    void hook() {
        if (index == -1)
            System.out.println("not selected");
        else
            children.get(0).click();
    }

    public void select(int index) {
        if (children.size() <= index || index < 0) throw new NoSuchElementException();
        this.index = index;
    }

    public void addButton(Button button) {
        if (button == null) {
            throw new NoSuchElementException();
        }
        children.add(button);
    }

    public void clickAll() {
        for (Button button : children)
            button.click();
    }

    public static void main(String[] args) {
        ArrayButton button = new ArrayButton(10, 10, "parent");
        button.addButton(new SubmitButton(5, 5, "child1"));
        button.addButton(new SubmitButton(5, 5, "child2"));
        SendMessageButton messageButton = new SendMessageButton(5, 5, "child3");
        messageButton.addMessage("Hi, Haeun!");
        button.addButton(messageButton);
        button.click();
        button.select(0);
        button.click();
        System.out.println(button.children.get(0).getNumOfClicked());
        button.select(2);
        button.click();
        System.out.println(button.children.get(2).getNumOfClicked());
        System.out.println("button: " + button.getNumOfClicked());

    }
}

