package com.example.Temporary.service_impl;

import com.example.Temporary.dto.PizzaOrderDTO;
import com.example.Temporary.models.PizzaOrder;

import java.util.List;

public interface IPizzaOrder {

    PizzaOrder createPizzaorder(PizzaOrderDTO pizzaOrderDTO);

    PizzaOrder updatePizza(Long id, PizzaOrderDTO pizzaOrderDTO);

    String deletePizza(Long id);

    PizzaOrder getOne(Long id);

    List<PizzaOrder> getAll();

}
