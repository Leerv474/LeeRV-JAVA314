package org.top.ShopCatalog.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.top.ShopCatalog.model.Shop;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

public class ShopDaoImpl implements ShopDao {
    private static final String insertQuery = "insert into shops " +
            "(name, address, phone_number, email, website_link, category, shop_description)" +
            "values(:name, :address, :phone_number, :email, :website_link, :category, :shop_description)";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ShopDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void save(Shop shop) {
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(insertQuery,
                new MapSqlParameterSource()
                        .addValue("name", shop.getName())
                        .addValue("address", shop.getAddress())
                        .addValue("phone_number", shop.getPhoneNumber())
                        .addValue("email", shop.getEmail())
                        .addValue("website_link", shop.getWebsiteLink())
                        .addValue("category", shop.getCategory())
                        .addValue("shop_description", shop.getShopDescription()),
                keyholder,
                new String[]{"id"});
        shop.setId(Objects.requireNonNull(keyholder.getKey().longValue()));
    }

    private static final String selectQuery = "select * from shops";

    @Override
    public List<Shop> getShopList() {
        String selectQuery = "SELECT * FROM shops"; // Replace with your actual query

        List<Shop> shopList = jdbcTemplate.query(selectQuery, (rs, rowNum) -> {
            Shop shop = new Shop();
            shop.setId(rs.getInt("id"));
            shop.setName(rs.getString("name"));
            shop.setAddress(rs.getString("address"));
            shop.setPhoneNumber(rs.getString("phone_number"));
            shop.setEmail(rs.getString("email"));
            shop.setWebsiteLink(rs.getString("website_link"));
            shop.setCategory(rs.getString("category"));
            shop.setShopDescription(rs.getString("shop_description"));
            return shop;
        });

        return shopList;
    }

    @Override
    public void delete(long id) {
        String deleteQuery = "DELETE FROM shops WHERE id = :id";
        jdbcTemplate.update(deleteQuery, new MapSqlParameterSource().addValue("id", id));
    }
}
