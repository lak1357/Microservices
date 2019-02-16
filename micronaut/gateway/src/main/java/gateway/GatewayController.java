package gateway;


import gateway.client.encryptservice.EncryptClient;
import gateway.client.encryptservice.model.Message;
import gateway.client.orderservice.OrderClient;
import gateway.client.orderservice.model.Order;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import java.util.List;

@Controller("/api/${api.version:v1}")
public class GatewayController {


    private final EncryptClient encryptClient;
    private final OrderClient orderClient;

    public GatewayController(EncryptClient encryptClient, OrderClient orderClient) {
        this.encryptClient = encryptClient;
        this.orderClient = orderClient;
    }

    @Get(value = "/encrypt/{text}")
    public Single<Message> encrypt(String text){
        return encryptClient.encrypt(text);
    }

    @Get(value = "/orders")
    public Single<List<Order>> getOrders(){
        return orderClient.getOrders();
    }


}
