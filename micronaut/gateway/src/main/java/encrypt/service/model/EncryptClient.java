package encrypt.service.model;


import encrypt.service.model.Message;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client(id = "encrypt-service")
public interface EncryptClient extends EncryptOperation {


}
