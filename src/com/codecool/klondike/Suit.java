package com.codecool.klondike;

public enum Suit {
    DIAMONDS(1, "diamonds"),
    HEARTS(2, "hearts"),
    CLUBS(3, "clubs"),
    SPADES(4, "spades");

    private int number;
    private String textName;

    Suit(int number, String textName) {
        this.number = number;
        this.textName = textName;
    }

    public int getValue() {
        return number;
    }

    public String getTextName() {
        return  textName;
    }
}
