package encrypt.service;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class EncryptController {

    @Get(value = "/encrypt/{text}")
    public String encrypt(String text){
        String encrypted = new StringBuffer(text).reverse().toString();
        return encrypted;
    }

}
