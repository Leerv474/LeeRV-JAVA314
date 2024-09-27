package org.top.springdemo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private Long id;
    private String email;
    private String password;
}