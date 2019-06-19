package com.garciagiovane.cloud.geradorid;

public class GeradorId {
    private int id = 0;

    public int gerarId(){
        return id += 1;
    }
}
