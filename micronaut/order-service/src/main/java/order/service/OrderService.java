package order.service;

import io.reactivex.Single;
import order.service.model.Order;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class OrderService {


    public Single<List<Order>> getOrders() {

        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1,"MacBook Pro","Prageeth","test order"));
        orders.add(new Order(2,"Water Bottle","Lakshitha","test order 2"));
        orders.add(new Order(3,"Headset","Herath","test order 3"));

        return Single.just(orders);
    }
}
