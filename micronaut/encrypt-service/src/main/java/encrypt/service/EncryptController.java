package encrypt.service;

import encrypt.service.model.Message;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/")
public class EncryptController {

    private final EncryptService encryptService;

    public EncryptController(EncryptService encryptService) {
        this.encryptService = encryptService;
    }

    @Get(value = "/encrypt/{text}")
    public Single<Message> encrypt(String text){
        return encryptService.encrypt(text);
    }
}
