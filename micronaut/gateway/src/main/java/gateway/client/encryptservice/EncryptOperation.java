package gateway.client.encryptservice;

import gateway.client.encryptservice.model.Message;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

public interface EncryptOperation {

    @Get(value = "/encrypt/{text}")
    Single<Message> encrypt(String text);
}
