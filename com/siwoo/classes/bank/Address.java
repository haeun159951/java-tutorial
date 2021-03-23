package com.siwoo.classes.bank;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

    private String postalCode;
    private String city;
    private String street;
    private String unit;
    private String type;
    public static final String HOUSE = "House";
    public static final String CONDO = "Condo";

    public Address(String postalCode, String city, String street, String unit, String type) {

        String a1 = "^[A-Z][0-9][A-Z] [0-9][A-Z][0-9]$";
        Pattern pattern = Pattern.compile(a1);
        Matcher matcher = pattern.matcher(postalCode);

        if(!matcher.matches()){
            throw new IllegalArgumentException();
        }

        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.unit = unit;
        this.type = type;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHouse(){
        return this.type.equals(HOUSE);
    }

    public boolean isCondo(){
        return this.type.equals(CONDO);
    }

    public boolean inSameCity(Address address){
        return this.city.equals(address.city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(postalCode, address.postalCode) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(unit, address.unit) && Objects.equals(type, address.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, city, street, unit, type);
    }
}
