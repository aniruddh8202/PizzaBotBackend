package com.example.Temporary.dao;

import com.example.Temporary.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDao extends JpaRepository<Menu, Long> {
}
