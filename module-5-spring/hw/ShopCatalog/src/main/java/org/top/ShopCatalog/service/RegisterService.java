package org.top.ShopCatalog.service;

import lombok.RequiredArgsConstructor;
import org.top.ShopCatalog.dao.ShopDao;
import org.top.ShopCatalog.model.Shop;
import org.top.ShopCatalog.util.ShopRegisterValidator;

@RequiredArgsConstructor
public class RegisterService {
    private final ShopRegisterValidator shopRegisterValidator;
    private final ShopDao shopDao;

    public void register(String name, String address, String email, String phoneNumber, String webLink, String category, String shopDescription) {
        if (shopRegisterValidator.isValid(email, phoneNumber, webLink)) {
            throw new IllegalArgumentException("Invalid email, phone number or weblink");
        }
        shopDao.save(Shop.builder()
                .name(name)
                .email(email)
                .address(address)
                .phoneNumber(phoneNumber)
                .websiteLink(webLink)
                .category(category)
                .shopDescription(shopDescription)
                .build()
        );
        System.out.println("Book registered successfully");
    }
}
