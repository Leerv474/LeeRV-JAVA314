package org.example;

public enum ESale {
    NO_SALE,
    TWO_FOR_ONE,
    THREE_FOR_TWO,
    SEASONAL;

    public double getSeasonalSale() {
        return 0.5;
    }
}
