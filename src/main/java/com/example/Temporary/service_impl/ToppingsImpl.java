package com.example.Temporary.service_impl;

import com.example.Temporary.dao.ToppingsDao;
import com.example.Temporary.dto.ToppingsDTO;
import com.example.Temporary.models.Toppings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingsImpl implements IToppings {

    @Autowired
    ToppingsDao toppingsDao;

    @Override
    public Toppings createTopping(ToppingsDTO toppingsDTO) {

        Toppings toppings = new Toppings();

        toppings.setToppingsName(toppingsDTO.getToppingsName());

        toppings.setToppingsPrice(toppingsDTO.getToppingsPrice());

        return toppingsDao.save(toppings);
    }

    @Override
    public Toppings updateTopping(Long id, ToppingsDTO toppingsDTO) {

        Toppings toppings = toppingsDao.getOne(id);

        toppings.setToppingsName(toppingsDTO.getToppingsName());

        toppings.setToppingsPrice(toppingsDTO.getToppingsPrice());


        return toppingsDao.save(toppings);
    }

    @Override
    public String deleteTopping(Long id) {

        toppingsDao.deleteById(id);

        return "Successfully Deleted Toppings with id"+id;
    }

    @Override
    public Toppings getOne(Long id) {
        return toppingsDao.getOne(id);
    }

    @Override
    public List<Toppings> getAll() {
        return toppingsDao.findAll();
    }
}
