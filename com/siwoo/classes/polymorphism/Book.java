package com.siwoo.classes.polymorphism;

import java.util.ArrayList;
import java.util.List;

public interface Book {
    String title();
    String author();
    int price();
    int pages();
    int rate();
    String category();

    public static void main(String[] args) {
        Novel ant = new Novel("개미", "베르나르 베르베르", 32000, 500, 4,"과학&추리");
        Novel ground = new Novel("토지", "박경리", 15800, 1500, 5, "역사");
        ProgrammingBook headFirstJava = new ProgrammingBook("헤드퍼스트 자바", "버트베이츠", 280000, 300,4,"Java");
        ProgrammingBook secretOfJS = new ProgrammingBook("자바스크립트 닌자", "베어 바이블", 12000, 280,5,"Javascript");
        Book parentReference  = ant; // 업캐스팅 자식에서 부모로 올라감
        System.out.println(parentReference.author());
        //System.out.println(parentReference.genre());  // 오직 부모의 api 메서드만 가능하다.
        Novel novel = (Novel)parentReference;
        System.out.println(novel.genre());

        //다형성을 사용하면 하나의 변수 타입으로 여러가지 타입의 객체를 일관되게 사용가능
        List<Book> books = new ArrayList<>();
        books.add(ant);
        books.add(ground);
        books.add(headFirstJava);
        books.add(secretOfJS);

        for(Book book:books){
            System.out.println(book.title() + " " + book.price());
            if(book instanceof ProgrammingBook){
                System.out.println("이 책은 프로그래밍 책입니다. 언어는 " + ((ProgrammingBook) book).language());
            }
        }
    }
}

abstract class AbstractBook implements Book{
    private String title;
    private String author;
    private int price;
    private int pages;
    private int rate;

    public AbstractBook(String title, String author, int price, int pages, int rate) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.rate = rate;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String author() {
        return author;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public int pages() {
        return pages;
    }

    @Override
    public int rate() {
        return rate;
    }

    @Override
    public abstract String category();
}


class Novel extends AbstractBook{
    private String genre;

    public Novel(String title, String author, int price, int pages, int rate, String genre) {
        super(title, author, price, pages, rate);
        this.genre = genre;
    }

    public String genre(){
        return genre;
    }
    @Override
    public String category() {
        return "문학";
    }
}


class ProgrammingBook extends AbstractBook{
    public String language;

    public ProgrammingBook(String title, String author, int price, int pages, int rate, String language) {
        super(title, author, price, pages, rate);
        this.language = language;
    }

    public String language(){
        return language;
    }

    @Override
    public String category() {
        return "IT";
    }
}