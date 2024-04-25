package org.example;

public class Product {
    private final String name;
    private final double price;
    private final EUnit unit;
    private final int barcode;
    private ESale sale;
    private double seasonalSale;

    public Product(String name, double price, EUnit unit, int barcode, ESale sale) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.barcode = barcode;
        this.sale = sale;
    }

    public double calcPrice(int amount) {
        if (sale == ESale.TWO_FOR_ONE) {
            return this.price * (amount / 2 + amount % 2);
        }
        if (sale == ESale.THREE_FOR_TWO) {
            return this.price * amount - this.price * (amount / 3);
        }
        if (sale == ESale.SEASONAL) {
            return (this.price - this.price * sale.getSeasonalSale()) * amount;
        }
        return this.price * amount;
    }

    public boolean barcodeMatch(int barcode) {
        return barcode == this.barcode;
    }

    public EUnit getUnit() {
        return this.unit;
    }

    public String getName() {
        return this.name;
    }

    public void changeSale(ESale newSale) {
        this.sale = newSale;
    }
}
