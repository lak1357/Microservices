package com.mitra.orderses.service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.mitra.orderses.dto.CoffeeOrder;
import com.mitra.orderses.event.OrderPlaced;

@Service
public class OrderQueryService {

	private Map<UUID, CoffeeOrder> coffeeOrders = new ConcurrentHashMap<>();

	public CoffeeOrder getOrder(UUID orderId) {
		return coffeeOrders.get(orderId);
	}

	@EventListener(classes = OrderPlaced.class)
	public void apply(OrderPlaced event) {
		coffeeOrders.putIfAbsent(event.getOrderInfo().getOrderId(), new CoffeeOrder());
		applyFor(event.getOrderInfo().getOrderId(), o -> o.place(event.getOrderInfo()));
	}

	private void applyFor(final UUID orderId, final Consumer<CoffeeOrder> consumer) {

		CoffeeOrder coffeeOrder = coffeeOrders.get(orderId);

		if (coffeeOrder != null) {
			consumer.accept(coffeeOrder);
		}
	}
}
