package com.giovaniwahl.components.services;

import com.giovaniwahl.components.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public Double total(Order order){
        return order.getBasic()-(order.getDiscount()/100)* order.getBasic();
    }
}
