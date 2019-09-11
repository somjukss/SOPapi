package com.example.api60070040;

public class CakeFactory {
    public  static Cake createCake(int id,String name,int price,String type) {
        if (type.equals("Cakebasic")) {
            return new Cakebasic(id, name, price, type);
        } else if (type.equals("Cheesecake")){
            return new Cheesecake(id, name, price, type);
        } else{
            return new Icecremecake(id, name, price, type);
        }
    }
}
