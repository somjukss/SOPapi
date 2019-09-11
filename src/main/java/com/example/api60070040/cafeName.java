package com.example.api60070040;

public class cafeName {
    public String yourCafe;
    private static cafeName name = null;
    private static cafeName instance;
    private cafeName(){
    }
    public static cafeName getInstance(){
        if (instance == null){
            instance = new cafeName();
        }
        return instance;
    }

    public String getYourCafe() {
        return yourCafe;
    }

    public void setYourCafe(String yourCafe) {
        this.yourCafe = yourCafe;
    }

}
