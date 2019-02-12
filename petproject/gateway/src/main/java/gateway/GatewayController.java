package gateway;

import encrypt.service.model.EncryptClient;
import encrypt.service.model.Message;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/api/${api.version:v1}")
public class GatewayController {


    private final EncryptClient encryptClient;

    public GatewayController(EncryptClient encryptClient) {
        this.encryptClient = encryptClient;
    }

    @Get(value = "/encrypt/{text}")
    public Single<Message> encrypt(String text){
        return encryptClient.encrypt(text);
    }
}
