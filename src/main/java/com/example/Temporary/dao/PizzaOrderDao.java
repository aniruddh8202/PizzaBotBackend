package com.example.Temporary.dao;

import com.example.Temporary.models.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderDao extends JpaRepository<PizzaOrder, Long> {
}
