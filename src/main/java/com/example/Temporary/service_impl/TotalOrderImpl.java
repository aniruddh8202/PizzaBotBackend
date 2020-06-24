package com.example.Temporary.service_impl;

import com.example.Temporary.dao.DiscountDao;
import com.example.Temporary.dao.PizzaOrderDao;
import com.example.Temporary.dao.TotalOrderDao;
import com.example.Temporary.dto.TotalOrderDTO;
import com.example.Temporary.models.Discount;
import com.example.Temporary.models.PizzaOrder;
import com.example.Temporary.models.TotalOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TotalOrderImpl implements ITotalOrder{

    @Autowired
    TotalOrderDao totalOrderDao;

    @Autowired
    PizzaOrderDao pizzaOrderDao;

    @Autowired
    DiscountDao discountDao;

    public Double calculatedDiscountPrice(Double rawTotal, Double percentage){

        return rawTotal - (rawTotal * (percentage/100));
    }

    @Override
    public TotalOrder createTotalOrder(TotalOrderDTO totalOrderDTO) {

        TotalOrder totalOrder = new TotalOrder();

        Double sumOfPizzaorders = 0.0;

        List<PizzaOrder> pizzaOrderList = new ArrayList<>();

        Discount discount = discountDao.getOne(totalOrderDTO.getDiscountId());

        for(Long i : totalOrderDTO.getPizzaOrders()){

            PizzaOrder pizzaOrder = pizzaOrderDao.getOne(i);

            pizzaOrderList.add(pizzaOrder);

            sumOfPizzaorders += pizzaOrder.getPizzaCalculatedPrice();

        }

        totalOrder.setDiscount(discount);

        totalOrder.setPizzaOrders(pizzaOrderList);

        totalOrder.setRawTotal(sumOfPizzaorders);

//      Applying Discount when Amount is over 500
        if(sumOfPizzaorders > 500) {
            Double calculatedPrice = calculatedDiscountPrice(sumOfPizzaorders, discount.getDiscountCalculationPercentage());

            totalOrder.setDiscountedPrice(calculatedPrice);
        }
        else{
            totalOrder.setDiscountedPrice(sumOfPizzaorders);
        }
        return totalOrderDao.save(totalOrder);
    }

    @Override
    public TotalOrder updateTotalOrder(Long id, TotalOrderDTO totalOrderDTO) {

        TotalOrder totalOrder = totalOrderDao.getOne(id);

        Double sumOfPizzaorders = 0.0;

        List<PizzaOrder> pizzaOrderList = new ArrayList<>();

        Discount discount = discountDao.getOne(totalOrderDTO.getDiscountId());

        for(Long i : totalOrderDTO.getPizzaOrders()){

            PizzaOrder pizzaOrder = pizzaOrderDao.getOne(i);

            pizzaOrderList.add(pizzaOrder);

            sumOfPizzaorders += pizzaOrder.getPizzaCalculatedPrice();

        }

        totalOrder.setDiscount(discount);

        totalOrder.setPizzaOrders(pizzaOrderList);

        totalOrder.setRawTotal(sumOfPizzaorders);

//      Applying Discount when Amount is over 500
        if(sumOfPizzaorders > 500) {
            Double calculatedPrice = calculatedDiscountPrice(sumOfPizzaorders, discount.getDiscountCalculationPercentage());

            totalOrder.setDiscountedPrice(calculatedPrice);
        }
        else{
            totalOrder.setDiscountedPrice(sumOfPizzaorders);
        }


        return totalOrderDao.save(totalOrder);
    }

    @Override
    public String deleteTotalOrder(Long id) {

        totalOrderDao.deleteById(id);

        return "Successfully Deleted";
    }

    @Override
    public TotalOrder getOne(Long id) {
        return totalOrderDao.getOne(id);
    }

    @Override
    public List<TotalOrder> getAll() {
        return totalOrderDao.findAll();
    }
}
