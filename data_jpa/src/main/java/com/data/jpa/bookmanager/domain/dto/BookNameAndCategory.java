package com.data.jpa.bookmanager.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class BookNameAndCategory {

    private String name;

    private String category;
}

//public interface BookNameAndCategory {
//
//    String getName();
//    String getCategory();
//}
