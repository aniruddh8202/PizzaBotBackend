package com.example.Temporary.service_impl;

import com.example.Temporary.dao.DiscountDao;
import com.example.Temporary.dto.DiscountDTO;
import com.example.Temporary.models.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountImpl implements IDiscount {

    @Autowired
    DiscountDao discountDao;

    @Override
    public Discount craeteDiscount(DiscountDTO discountDTO) {

        Discount discount = new Discount();

        discount.setDiscountName(discountDTO.getDiscountName());

        discount.setDiscountCalculationPercentage(discountDTO.getDiscountCalculationPercentage());

        return discountDao.save(discount);
    }

    @Override
    public Discount updateDiscount(Long id, DiscountDTO discountDTO) {

        Discount discount = discountDao.getOne(id);

        discount.setDiscountName(discountDTO.getDiscountName());

        discount.setDiscountCalculationPercentage(discountDTO.getDiscountCalculationPercentage());

        return discountDao.save(discount);
    }

    @Override
    public String deleteDiscount(Long id) {

        discountDao.deleteById(id);

        return "Successfully Deleted";
    }

    @Override
    public Discount getOne(Long id) {
        return discountDao.getOne(id);
    }

    @Override
    public List<Discount> getAll() {
        return discountDao.findAll();
    }
}
