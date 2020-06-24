package com.example.Temporary.dto;

import lombok.Data;

import java.util.List;

@Data
public class PizzaOrderDTO {

    private Long realPizzaId;

    private Long quantity;

    private List<Long> toppings;

    private Long sizeId;

}
