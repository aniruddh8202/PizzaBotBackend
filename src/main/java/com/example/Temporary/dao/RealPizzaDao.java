package com.example.Temporary.dao;

import com.example.Temporary.models.RealPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RealPizzaDao extends JpaRepository<RealPizza, Long> {

    @Query("Select r from RealPizza r where r.realPizzaName = ?1")
    RealPizza findRealPizzaByName(String name);

}
