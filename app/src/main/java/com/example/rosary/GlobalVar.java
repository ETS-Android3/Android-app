package com.example.rosary;


public class GlobalVar {

    private static GlobalVar instance;

    public static GlobalVar getInstance() {
        if (instance == null)
            instance = new GlobalVar();
        return instance;
    }

    private GlobalVar() {
    }

    private int index;

    public void setIndex(){
        index = 3;
    }

    public int getIndex(){
        return index;
    }

    public void decreaseIndex(){
        index--;
    }

    public void increaseIndex(){
        index++;
    }

}
