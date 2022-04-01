package com.data.jpa.bookmanager.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BookStatus {

    private int code;

    private String description;

    public boolean isDisplayed() {
        return code == 200;
    }

    public BookStatus() {
    }

    public BookStatus(int code) {
        this.code = code;
        this.description = parseDescription(code);
    }

    private String parseDescription(int code) {
        switch (code) {
            case 100:
                return "판매종료";
            case 200:
                return "판매중";
            case 300:
                return "판매보류";
            default:
                return "에러";
        }
    }
}
