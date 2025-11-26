package com.example.spring.selection_insertion.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {

    String error;
    String detail;

}
