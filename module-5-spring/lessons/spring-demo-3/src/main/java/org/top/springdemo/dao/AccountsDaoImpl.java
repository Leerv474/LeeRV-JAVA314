package org.top.springdemo.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.top.springdemo.model.Account;

import javax.sql.DataSource;
import java.util.Objects;

public class AccountsDaoImpl implements AccountsDao {
    // Account a(username, password) -> Spring jdbc -> sql: query -> postgres

    private static final String query = "INSERT INTO accounts (email, password) VALUES(:email, :password) RETURNING id";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public AccountsDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void save(Account account) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query,
                new MapSqlParameterSource()
                        .addValue("email", account.getEmail())
                        .addValue("password", account.getPassword()),
                keyHolder,
                new String[]{"id"});
        account.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }
}