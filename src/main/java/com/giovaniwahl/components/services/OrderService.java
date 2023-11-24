package com.giovaniwahl.components.services;

import com.giovaniwahl.components.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ShippingService shippingService;
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public Double total(Order order){
        double frete = shippingService.shipment(order);
        double desconto = order.getBasic() * (order.getDiscount()/100);
        return order.getBasic() - desconto + frete;
    }
}
