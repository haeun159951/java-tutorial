package com.siwoo.classes;

public class Human {
    private String email;
    private String address;
    private Name name;

    public Human(String email, String address, Name name) {
        this.email = email;
        this.address = address;
        this.name = name;
    }

    public boolean Verify(String email){
        if(this.email == email){
            return true;
        }
        return false;
    }

    public void sendEmail(){
        System.out.println("Email has been sent");
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", name=" + name.toString() +
                '}';
    }

    public static void main(String[] args) {
      Human human = new Human("haeun@gmail.com", "1 liszt gate", new Name("Haeun" , "Kim"));
      boolean isValid = human.Verify("haeun@gmail.com");
      System.out.println("email check: "+isValid);
      boolean isValid2 = human.Verify("haeun1111@gmail.com");
      System.out.println("email check: "+isValid2);
      human.sendEmail();
        System.out.println(human);
    }
}

class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return lastName + " " + lastName + "king king zzang";
    }
}