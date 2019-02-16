package order.service;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;
import order.service.model.Order;

import java.util.List;

@Controller("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Get("/")
    public Single<List<Order>> getOrders(){
        return orderService.getOrders();
    }

}
