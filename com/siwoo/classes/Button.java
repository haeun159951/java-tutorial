package com.siwoo.classes;

//button class
// 속성 - 이름
// 행동 - 클릭 , 언클릭, 토

public class Button {
    private String name;
    private String color;
    private boolean clicked;

    public Button(String name, String color, boolean clicked) {
        this.name = name;
        this.color = color;
        this.clicked = clicked;
    }

    public void click(){
        clicked = true;
    }

    public void unClick(){
        clicked= false;
    }

    public boolean toggle(){
        if(clicked){
            unClick();
            return true;
        }
        click();
        return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    @Override
    public String toString() {
        return String.format("%s button (%s)", name, clicked? "on": "off");
    }

    public static void main(String[] args) {
        Button btn = new Button("Submit", "blue", true);
        btn.click();
        System.out.println("btn click" + btn.toString());
        btn.unClick();
        System.out.println("btn unclick" + btn.toString());
        btn.toggle();
        System.out.println("btn toggle" + btn.toString());
    }
}

