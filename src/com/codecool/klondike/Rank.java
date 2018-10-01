package com.codecool.klondike;

public enum Rank {
    Ace(1),
    Eight(8),
    Five(5),
    Four(4),
    Jack(11),
    King(13),
    Nine(9),
    Queen(12),
    Seven(7),
    Six(6),
    Ten(10),
    Three(3),
    Two(2);

    private int cardValue;

    Rank(int rankValue) {
        cardValue = rankValue;
    }

    public int getValue() {
        return cardValue;
    }

    public boolean previousEqual(Card card) {
        return (cardValue - 1) == card.getRank().getValue();
    }
    public boolean nextEqual(Card card) {
        return ((cardValue + 1) == card.getRank().getValue());
    }
}
