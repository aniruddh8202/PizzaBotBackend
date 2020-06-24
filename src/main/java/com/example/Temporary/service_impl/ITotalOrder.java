package com.example.Temporary.service_impl;

import com.example.Temporary.dto.TotalOrderDTO;
import com.example.Temporary.models.TotalOrder;

import java.util.List;

public interface ITotalOrder {

    TotalOrder createTotalOrder(TotalOrderDTO totalOrderDTO);

    TotalOrder updateTotalOrder(Long id, TotalOrderDTO totalOrderDTO);

    String deleteTotalOrder(Long id);

    TotalOrder getOne(Long id);

    List<TotalOrder> getAll();

}
