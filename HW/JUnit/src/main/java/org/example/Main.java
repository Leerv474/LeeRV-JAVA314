package org.example;

public class Main {
    public static void main(String[] args) {
        SuperMarket superMarket = new SuperMarket();

        superMarket.addProductToStore(new Product("toothpick", 10, EUnit.PIECE, 1, ESale.TWO_FOR_ONE));
        superMarket.addProductToStore(new Product("apples", 250, EUnit.KILOGRAMS, 2, ESale.SEASONAL));
        superMarket.addProductToStore(new Product("rice", 120, EUnit.KILOGRAMS, 3, ESale.THREE_FOR_TWO));
        superMarket.addProductToStore(new Product("water bottle", 150, EUnit.LITERS, 4, ESale.NO_SALE));
        superMarket.addProductToStore(new Product("bread", 200, EUnit.PIECE, 5, ESale.NO_SALE));

//        superMarket.addToBin(1);
//        superMarket.addToBin(1);
//        superMarket.addToBin(1);
//        superMarket.addToBin(1);
//        superMarket.addToBin(1);

//        superMarket.addToBin(2);
//        superMarket.addToBin(2);
//
//        superMarket.addToBin(3);
//        superMarket.addToBin(3);
//        superMarket.addToBin(3);
//        superMarket.addToBin(3);
//
        superMarket.addToBin(4);
        superMarket.addToBin(4);
        superMarket.addToBin(4);
        superMarket.addToBin(4);
//
//        superMarket.addToBin(5);

        superMarket.listBin();
        System.out.println(superMarket.calcBinPrice());
    }
}