package gateway.client.orderservice;


import io.micronaut.http.client.annotation.Client;

@Client(id = "order-service")
public interface OrderClient extends OrderOperation {

}
