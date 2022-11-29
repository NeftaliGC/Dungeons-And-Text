package controller;

import model.mochila;

public class controlMochila {
    
    mochila m;

    public void setMochila(mochila backpack) {
        this.m = backpack;
    }

    public String datosMochila(String d) {
        String s = "En la mochila hay: ";
        String datos = s + d;
        return d;
    }

}
