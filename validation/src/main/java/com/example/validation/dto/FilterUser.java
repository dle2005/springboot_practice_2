package com.example.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
public class FilterUser {

    private String name;

    private int age;

}
