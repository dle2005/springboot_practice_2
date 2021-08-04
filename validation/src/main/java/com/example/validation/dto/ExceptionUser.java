package com.example.validation.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ExceptionUser {

    @Size(min = 1, max = 10)
    private String name;

    @Min(1)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ExceptionUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
