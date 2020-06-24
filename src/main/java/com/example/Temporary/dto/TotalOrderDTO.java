package com.example.Temporary.dto;


import lombok.Data;

import java.util.List;

@Data
public class TotalOrderDTO {

    private List<Long> pizzaOrders;

    private Long discountId;

}
