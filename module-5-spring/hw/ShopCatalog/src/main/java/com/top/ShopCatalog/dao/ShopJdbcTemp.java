package com.top.ShopCatalog.dao;

import com.top.ShopCatalog.models.Shop;
import com.top.ShopCatalog.models.ShopMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ShopJdbcTemp implements ShopDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Shop> getShopList() {
        String query = "select * from shops";
        return jdbcTemplateObject.query(query, new ShopMapper());
    }
}