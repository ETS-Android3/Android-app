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

    private int count;

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

    public void setCount(){ count = 0; }

    public int getCount(){return count;}

    public void increaseCount() { count++;}

    public void decreaseCount() {count--;}

    public void setCount(int num){count = num;}


    }
