package com.example.hotelmanagement;

public class User {

    String name, phone, inTime,  inDate, outTime,  outDate, roomType, token, adharcard, person, adharcard1, child, amount;

    public User() {

    }

    public User(String name, String phone, String inTime, String inDate, String outTime,
                String outDate,String roomType, String token,String adharcard,String person,
                String adharcard1,String child, String amount) {
        this.name = name;
        this.phone = phone;
        this.inTime = inTime;
        this.inDate = inDate;
        this.outTime = outTime;
        this.outDate = outDate;
        this.roomType = roomType;
        this.token = token;
        this.adharcard = adharcard;
        this.person = person;
        this.adharcard1 = adharcard1;
        this.child = child;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getInTime() {
        return inTime;
    }

    public String getInDate() {
        return inDate;
    }

    public String getOutTime() {
        return outTime;
    }

    public String getOutDate() {
        return outDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getToken(){ return token; }

    public String getAdharcard() {
        return adharcard;
    }

    public String getPerson() {
        return person;
    }

    public String getAdharcard1() {
        return adharcard1;
    }

    public String getChild() {
        return child;
    }

    public String getAmount(){
        return amount;
    }
}
