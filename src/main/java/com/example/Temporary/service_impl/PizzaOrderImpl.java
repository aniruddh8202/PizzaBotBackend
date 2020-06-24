package com.example.Temporary.service_impl;

import com.example.Temporary.dao.PizzaOrderDao;
import com.example.Temporary.dao.RealPizzaDao;
import com.example.Temporary.dao.SizesDao;
import com.example.Temporary.dao.ToppingsDao;
import com.example.Temporary.dto.PizzaOrderDTO;
import com.example.Temporary.models.PizzaOrder;
import com.example.Temporary.models.Sizes;
import com.example.Temporary.models.Toppings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaOrderImpl implements IPizzaOrder {

    @Autowired
    PizzaOrderDao pizzaOrderDao;

    @Autowired
    RealPizzaDao realPizzaDao;

    @Autowired
    ToppingsDao toppingsDao;

    @Autowired
    SizesDao sizesDao;

    @Override
    public PizzaOrder createPizzaorder(PizzaOrderDTO pizzaOrderDTO) {

        PizzaOrder pizzaOrder = new PizzaOrder();

        Double sumOfToppings = 0.0;

        pizzaOrder.setRealPizza(realPizzaDao.getOne(pizzaOrderDTO.getRealPizzaId()));

        pizzaOrder.setQuantity(pizzaOrderDTO.getQuantity());

        List<Toppings> toppingsList = new ArrayList<>();

        for(Long i : pizzaOrderDTO.getToppings()){
            Toppings toppings = toppingsDao.getOne(i);
            sumOfToppings += toppings.getToppingsPrice();
            toppingsList.add(toppings);
        }
        

        pizzaOrder.setToppings(toppingsList);

        pizzaOrder.setSizes(sizesDao.getOne(pizzaOrderDTO.getSizeId()));

        Sizes size = sizesDao.getOne(pizzaOrderDTO.getSizeId());

        Double calculatePrice = (realPizzaDao.getOne(pizzaOrderDTO.getRealPizzaId()).getBasePizzaPrice() * pizzaOrderDTO.getQuantity()) + sumOfToppings + size.getSizePrice();

        pizzaOrder.setPizzaCalculatedPrice(calculatePrice);

        return pizzaOrderDao.save(pizzaOrder);
    }

    @Override
    public PizzaOrder updatePizza(Long id, PizzaOrderDTO pizzaOrderDTO) {

        PizzaOrder pizzaOrder = pizzaOrderDao.getOne(id);

        Double sumOfToppings = 0.0;

        pizzaOrder.setRealPizza(realPizzaDao.getOne(pizzaOrderDTO.getRealPizzaId()));

        pizzaOrder.setQuantity(pizzaOrderDTO.getQuantity());

        List<Toppings> toppingsList = new ArrayList<>();

        for(Long i : pizzaOrderDTO.getToppings()){
            Toppings toppings = toppingsDao.getOne(i);
            sumOfToppings += toppings.getToppingsPrice();
            toppingsList.add(toppings);
        }

        pizzaOrder.setToppings(toppingsList);

        pizzaOrder.setSizes(sizesDao.getOne(pizzaOrderDTO.getSizeId()));

        Sizes size = sizesDao.getOne(pizzaOrderDTO.getSizeId());

        Double calculatePrice = (realPizzaDao.getOne(pizzaOrderDTO.getRealPizzaId()).getBasePizzaPrice() * pizzaOrderDTO.getQuantity()) + sumOfToppings + size.getSizePrice();

        pizzaOrder.setPizzaCalculatedPrice(calculatePrice);


        return pizzaOrderDao.save(pizzaOrder);
    }

    @Override
    public String deletePizza(Long id) {

        pizzaOrderDao.deleteById(id);

        return "Successfully Deleted Pizza Order with id:"+id;
    }

    @Override
    public PizzaOrder getOne(Long id) {
        return pizzaOrderDao.getOne(id);
    }

    @Override
    public List<PizzaOrder> getAll() {
        return pizzaOrderDao.findAll();
    }
}
