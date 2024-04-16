package org.example;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BinTest {
    SuperMarket superMarket = new SuperMarket();
    @Before
    public void setUp() {
        superMarket.addProductToStore(new Product("toothpick", 10, EUnit.PIECE, 1, ESale.TWO_FOR_ONE));
        superMarket.addProductToStore(new Product("apples", 250, EUnit.KILOGRAMS, 2, ESale.SEASONAL));
        superMarket.addProductToStore(new Product("rice", 120, EUnit.KILOGRAMS, 3, ESale.THREE_FOR_TWO));
        superMarket.addProductToStore(new Product("water bottle", 150, EUnit.LITERS, 4, ESale.NO_SALE));
        superMarket.addProductToStore(new Product("bread", 200, EUnit.PIECE, 5, ESale.NO_SALE));

        superMarket.addToBin(1);
        superMarket.addToBin(1);
        superMarket.addToBin(1);
        superMarket.addToBin(1);
        superMarket.addToBin(1);

        superMarket.addToBin(2);
        superMarket.addToBin(2);

        superMarket.addToBin(3);
        superMarket.addToBin(3);
        superMarket.addToBin(3);
        superMarket.addToBin(3);

        superMarket.addToBin(4);
        superMarket.addToBin(4);
        superMarket.addToBin(4);
        superMarket.addToBin(4);

        superMarket.addToBin(5);
    }

    @org.junit.Test
    public void testProductBin() {
        double actualResult = superMarket.calcBinPrice();
        assertEquals(1440, actualResult, 0.1);
    }
}
