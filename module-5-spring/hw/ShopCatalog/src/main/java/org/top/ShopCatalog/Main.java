package org.top.ShopCatalog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.top.ShopCatalog.model.Shop;
import org.top.ShopCatalog.service.RegisterService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("context.xml");

        RegisterService registerService = classPathXmlApplicationContext.getBean(RegisterService.class);
        Shop shop = Shop.builder()
                .name("магнит")
                .phoneNumber("88005555535")
                .shopDescription("Лучшие предложения во всем городе")
                .email("magnit@mail.ru")
                .websiteLink("magnit.ru")
                .category("Products")
                .address("Гагарина д6")
                .build();

        registerService.register(shop.getName(),shop.getAddress(), shop.getEmail(), shop.getPhoneNumber(), shop.getWebsiteLink(), shop.getCategory(), shop.getShopDescription());
    }
}
