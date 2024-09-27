package com.top.ShopCatalog.controllers;

import com.top.ShopCatalog.config.JdbcConfig;
import com.top.ShopCatalog.dao.ShopJdbcTemp;
import com.top.ShopCatalog.models.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShopListController {
    @RequestMapping(value = "/shopList")
    public List<Shop> shopListController() {
        ShopJdbcTemp shopJdbcTemp = new ShopJdbcTemp();
        JdbcConfig jdbcConfig = new JdbcConfig();
        shopJdbcTemp.setDataSource(jdbcConfig.mysqlDataSource());
        return shopJdbcTemp.getShopList();
    }
}
