package com.example.Temporary.service_impl;

import com.example.Temporary.dao.MenuDao;
import com.example.Temporary.dao.RealPizzaDao;
import com.example.Temporary.dto.MenuDTO;
import com.example.Temporary.models.Menu;
import com.example.Temporary.models.RealPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuImpl implements IMenu {

    @Autowired
    MenuDao menuDao;

    @Autowired
    RealPizzaDao realPizzaDao;

    @Override
    public Menu createMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();

        menu.setMenuName(menuDTO.getMenuName());

        List<RealPizza> realPizzas = new ArrayList<RealPizza>();

        for(Long i : menuDTO.getRealPizzaIds()){
            RealPizza realPizza = realPizzaDao.getOne(i);
            realPizzas.add(realPizza);
        }

        menu.setRealPizzas(realPizzas);

        return menuDao.save(menu);
    }

    @Override
    public Menu updateMenu(Long id, MenuDTO menuDTO) {

        Menu menu = menuDao.getOne(id);

        menu.setMenuName(menuDTO.getMenuName());

        List<RealPizza> realPizzas = new ArrayList<RealPizza>();

        for(Long i : menuDTO.getRealPizzaIds()){
            RealPizza realPizza = realPizzaDao.getOne(i);
            realPizzas.add(realPizza);
        }

        menu.setRealPizzas(realPizzas);


        return menuDao.save(menu);
    }

    @Override
    public String deleteMenu(Long id) {

        menuDao.deleteById(id);

        return "Successfully Deleted";
    }


    @Override
    public Menu getMenu(Long id) {
        return menuDao.getOne(id);
    }

    @Override
    public List<Menu> getAll() {
        return menuDao.findAll();
    }
}
