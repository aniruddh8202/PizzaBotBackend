package com.example.Temporary.dto;


import java.util.List;

public class MenuDTO {

    private String menuName;

    private List<Long> realPizzaIds;

    public MenuDTO() {
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Long> getRealPizzaIds() {
        return realPizzaIds;
    }

    public void setRealPizzaIds(List<Long> realPizzaIds) {
        this.realPizzaIds = realPizzaIds;
    }
}
