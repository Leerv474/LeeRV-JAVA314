package com.top.ShopCatalog.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shop {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String websiteLink;
    private String category;
    private String description;
}
