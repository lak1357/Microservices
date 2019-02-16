package gateway.client.orderservice;

import gateway.client.orderservice.model.Order;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Status;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.List;

@Fallback
public class OrderClientFallback implements OrderOperation {


    @Override
    @Status(HttpStatus.SERVICE_UNAVAILABLE)
    public Single<List<Order>> getOrders() {
        List<Order> orders = new ArrayList<>();
        return Single.just(orders);
    }
}
