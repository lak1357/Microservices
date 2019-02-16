package gateway.client.encryptservice;

import gateway.client.encryptservice.model.Message;
import io.micronaut.retry.annotation.Fallback;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Single;

@Fallback
@Retryable(attempts = "2")
public class EncryptClientFallback implements EncryptOperation {

    @Override
    public Single<Message> encrypt(String text) {
        return Single.just(new Message("Fallback!"));
    }

}
