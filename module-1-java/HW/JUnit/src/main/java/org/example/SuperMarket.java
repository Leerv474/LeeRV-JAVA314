package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperMarket {
    List<Product> listOfProducts = new ArrayList<>();
    HashMap<Product, Integer> shoppingBin = new HashMap<>();

    public void addProductToStore(Product newProduct) {
        this.listOfProducts.add(newProduct);
    }
    public void addToBin(int barcode) {
        for (Product product : listOfProducts) {
            if (product.barcodeMatch(barcode)) {
                int amount = shoppingBin.getOrDefault(product, 0);
                amount++;
                shoppingBin.put(product, amount);
            }
        }
    }

    public void listBin() {
        System.out.println("Shopping bin");
        for (HashMap.Entry<Product, Integer> product : this.shoppingBin.entrySet()) {
            String productName = product.getKey().getName();
            int amount = product.getValue();
            System.out.println(productName + ' ' + amount);
        }
   }

    public double calcBinPrice() {
        double totalPrice = 0;
        for (HashMap.Entry<Product, Integer> product : this.shoppingBin.entrySet()) {
            totalPrice += product.getKey().calcPrice(product.getValue());
        }
        return totalPrice;
    }
}
