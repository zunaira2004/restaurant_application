package com.example.smd_a2;

public class Item {
    public String restaurant_name, location, phone_no, description, subItem;
    public Item(String r_name,String l, String ph,String des, String si)
    {
        restaurant_name=r_name;
        location=l;
        phone_no=ph;
        description=des;
        subItem=si;
    }
    public Item(){}
    String getRestaurant_name() {
        return restaurant_name;
    }
    String getLocation(){
        return location;
    }
    String getPhone_no() {
        return phone_no;
    }

    public String getSubItem() {
        return subItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public void setSubItem(String subItem) {
        this.subItem = subItem;
    }
}
