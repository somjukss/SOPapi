package com.example.api60070040;

import java.io.*;

public class Cake implements Serializable {
    private int id;
    private String name;
    private int price;
    private String type;

    public Cake(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Cheesecake extends Cake{
    public Cheesecake(int id, String name, int price, String type) {
        super(id, name, price, type);
    }
}
class Cakebasic extends Cake{

    public Cakebasic(int id, String name, int price, String type) {
        super(id, name, price, type);
    }
}
class Icecremecake extends Cake{

    public Icecremecake(int id, String name, int price, String type) {
        super(id, name, price, type);
    }
}
