package org.top.ShopCatalog.dao;

import org.top.ShopCatalog.model.Shop;

import java.util.List;

public interface ShopDao {
    void save(Shop shop);
    List<Shop> getShopList();
    void delete(long id);
}
