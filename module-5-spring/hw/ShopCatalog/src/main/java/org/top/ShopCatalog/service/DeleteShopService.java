package org.top.ShopCatalog.service;

import lombok.Setter;
import org.top.ShopCatalog.dao.ShopDao;

@Setter
public class DeleteShopService {

    ShopDao shopDao;
    public void delete(long id) {
        shopDao.delete(id);
    }
}
