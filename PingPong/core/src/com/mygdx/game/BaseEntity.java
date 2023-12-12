package com.mygdx.game;

/*
 * Classe com métodos basicos utilizado em Entidades como Ball,Paddle
 * @author Greg
 * @version 1.0
 * @since 2023-12-12
 * */
public class BaseEntity {
    int x, y, width, height, size;

    public BaseEntity () {}

    public BaseEntity(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public BaseEntity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
