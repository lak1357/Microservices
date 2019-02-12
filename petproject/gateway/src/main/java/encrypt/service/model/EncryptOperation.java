package encrypt.service.model;

import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

public interface EncryptOperation {

    @Get(value = "/encrypt/{text}")
    Single<Message> encrypt(String text);
}
