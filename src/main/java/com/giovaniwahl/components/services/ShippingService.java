package com.giovaniwahl.components.services;

import com.giovaniwahl.components.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public Double shipment(Order order){
        double basic= order.getBasic();
        if (basic<100){
            return 20.0;
        }
        if (basic >= 100 && basic < 200){
            return 12.0;
        }
        return 0.0;
    }
}
