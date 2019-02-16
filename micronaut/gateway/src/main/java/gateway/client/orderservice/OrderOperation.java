package gateway.client.orderservice;

import gateway.client.orderservice.model.Order;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import java.util.List;

public interface OrderOperation {

    @Get(value = "/orders")
    Single<List<Order>> getOrders();
}
