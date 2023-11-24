package com.giovaniwahl.components;

import com.giovaniwahl.components.entities.Order;
import com.giovaniwahl.components.services.OrderService;
import com.giovaniwahl.components.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ComponentsApplication implements CommandLineRunner {

	private final OrderService orderService;
	private final ShippingService shippingService;

	public ComponentsApplication(OrderService orderService, ShippingService shippingService) {
		this.orderService = orderService;
		this.shippingService = shippingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ComponentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order order1 = new Order( 1034,150.00,20.0);
		Order order2 = new Order( 2282,800.00,10.0);
		Order order3 = new Order( 1309,95.90,0.0);

		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);

		for (int i =0; i < orders.toArray().length; i++){
			double totalPed = shippingService.shipment(orders.get(i)) + orderService.total(orders.get(i));
			System.out.println(" \nPedido código "+ orders.get(i).getCode());
			System.out.println(String.format("Valor total: R$ %2.2f", totalPed));
		}
	}
}
