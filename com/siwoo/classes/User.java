package com.siwoo.classes;

import java.util.Objects;
import java.util.Stack;

public class User {
    private String password;
    private String name;
    private Email email;
    private com.siwoo.classes.bank.Address address;
    private User[] friends;  // 배열 프렌
    private int numOfFriends;

    public User(String password, String name, Email email, com.siwoo.classes.bank.Address address) {
        this.password = password;
        this.email = email;
        this.address = address;
        this.friends = new User[10]; // 10명을 담을 수 있는 크기
        this.name= name;
    }

    //패스워드 검사
    public boolean verify(String password) {
        if(this.password == password){
            return true;
        }
        return false;
    }

    //친구추가  //setter
    // 이미 추가 - 추가 노

    public void addFriend(User friend){
        if (alreadyfriend(friend)){  // 이미 추가 됬으면 리턴 낫
            return;
        }
        if(friends.length == numOfFriends){ // 프렌즈 배열의 길이와 넘버가 같으면
            User[] users = new User[2 * friends.length];  // 크기 두배
            for(int i =0; i< friends.length; i++){ // 전부 다 복사해주기 새 배열에
                users[i] = friends[i];
            }
            this.friends = users; // 다시 넘겨주기
        }
        this.friends[numOfFriends++] = friend;
    }

    public boolean alreadyfriend(User friend){
        for(User f: friends){
            if(f == null) continue;
            if(f.email.equals(friend.email)){
                return true;
            }
        }
        return false;
    }

    public void sendEmail(String message, User user) {
        email.sendTo(message, user.email);
        System.out.println("Successfully send an email to " +user.name);
    }

    public void checkUnreadEmails(){
        Iterable<String> message = this.email.getMessages();
        for (String m: message){
            System.out.println(m);
        }
        this.email.toTrash();
    }

    public void broadcast(String message){
        for(User f: friends) {
            if (f != null)
                this.email.sendTo(message, f.email);
        }
    }

    public static void main(String[] args) {
        Email email1 = new Email("haeun@gmail.com");
        Email email2 = new Email("123@gmail.com");
        Email email3 = new Email("kim@gmail.com");

        User user1 = new User("123", "haeun", email1 ,null);
        User user2 = new User("123", "siwoo", email2 ,null);
        User user3 = new User("123", "kim", email3 ,null);

        user1.sendEmail("hi", user2);
        user2.checkUnreadEmails();

        user1.sendEmail("ff", user3);
        user3.checkUnreadEmails();

        user1.addFriend(user2);
        user1.addFriend(user3);

        user1.broadcast("1");
        user1.broadcast("2");
        user1.broadcast("3");

        user2.checkUnreadEmails();
        System.out.println("=====================================");
        user3.checkUnreadEmails();
    }
}

class Email{
    private String email;
    private Stack<String> buckets = new Stack<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public Email(String email){
        this.email = email;
    }

    public void sendTo(String message, Email destination){
        destination.addMessage(message);
    }

    public void addMessage(String message){
        buckets.push(message);
    }

    public Iterable<String> getMessages(){
        return buckets;
    }
    public void toTrash(){
        this.buckets = new Stack<>();
    }

}

class Address {
    private String state;
    private String city;
    private String details;
    private String postalCode;

    public Address(String state, String city, String details, String postalCode) {
        this.state = state;
        this.city = city;
        this.details = details;
        this.postalCode = postalCode;
    }

    public String getPrettyFormat() {
        return String.format("%s, %s, %s %s", details, city, state, postalCode);
    }
}