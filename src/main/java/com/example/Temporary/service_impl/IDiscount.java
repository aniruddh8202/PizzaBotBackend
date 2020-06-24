package com.example.Temporary.service_impl;

import com.example.Temporary.dto.DiscountDTO;
import com.example.Temporary.models.Discount;

import java.util.List;

public interface IDiscount {

    Discount craeteDiscount(DiscountDTO discountDTO);

    Discount updateDiscount(Long id, DiscountDTO discountDTO);

    String deleteDiscount(Long id);

    Discount getOne(Long id);

    List<Discount> getAll();

}
