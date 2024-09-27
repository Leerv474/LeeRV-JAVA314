package com.top.ShopCatalog.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopMapper implements RowMapper<Shop> {
    @Override
    public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
        Shop shop = new Shop();
        shop.setName("name");
        shop.setAddress("address");
        shop.setPhoneNumber("phone_number");
        shop.setEmail("email");
        shop.setWebsiteLink("website_link");
        shop.setCategory("category");
        shop.setDescription("description");
        return shop;
    }
}