package com.example.Temporary.service_impl;

import com.example.Temporary.dao.RealPizzaDao;
import com.example.Temporary.dto.RealPizzaDTO;
import com.example.Temporary.models.RealPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealPizzaimpl implements IRealPizza {

    @Autowired
    RealPizzaDao realPizzaDao;

    @Override
    public RealPizza createRealPizza(RealPizzaDTO realPizzaDTO) {

        RealPizza realPizza = new RealPizza();

        realPizza.setRealPizzaName(realPizzaDTO.getRealPizzaName());

        realPizza.setBasePizzaPrice(realPizzaDTO.getBasePizzaPrice());

        return realPizzaDao.save(realPizza);
    }

    @Override
    public RealPizza updateRealPizza(Long id, RealPizzaDTO realPizzaDTO) {

        RealPizza realPizza = realPizzaDao.getOne(id);

        realPizza.setRealPizzaName(realPizzaDTO.getRealPizzaName());

        realPizza.setBasePizzaPrice(realPizzaDTO.getBasePizzaPrice());


        return realPizzaDao.save(realPizza);
    }

    @Override
    public String deletePizza(Long id) {

        realPizzaDao.deleteById(id);

        return "Successfully Deleted Pizza";
    }

    @Override
    public RealPizza getOne(Long id) {
        return realPizzaDao.getOne(id);
    }

    @Override
    public List<RealPizza> getAll() {
        return realPizzaDao.findAll();
    }

    @Override
    public RealPizza getByName(String name) {
        return realPizzaDao.findRealPizzaByName(name);
    }
}
