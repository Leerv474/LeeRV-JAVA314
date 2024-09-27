package com.top.ShopCatalog.dao;

import com.top.ShopCatalog.models.Shop;

import javax.sql.DataSource;
import java.util.List;

public interface ShopDao {
    public void setDataSource(DataSource dataSource);

    public List<Shop> getShopList();
}
