package encrypt.service;

import encrypt.service.model.Message;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("/")
public interface EncryptClient {

    @Get(value = "/encrypt/{text}")
    Single<Message> encrypt(String text);

}

