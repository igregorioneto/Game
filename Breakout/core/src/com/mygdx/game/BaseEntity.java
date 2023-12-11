package com.mygdx.game;

public class BaseEntity {
    int x, y, width, height, size;

    public BaseEntity() {
    }

    public BaseEntity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public BaseEntity(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}
