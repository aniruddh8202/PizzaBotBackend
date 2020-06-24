package com.example.Temporary.service_impl;

import com.example.Temporary.dto.MenuDTO;
import com.example.Temporary.models.Menu;

import java.util.List;

public interface IMenu {

    public Menu createMenu(MenuDTO menuDTO);

    public Menu updateMenu(Long id, MenuDTO menuDTO );

    public String deleteMenu(Long id);

    public Menu getMenu(Long id);

    public List<Menu> getAll();

}
