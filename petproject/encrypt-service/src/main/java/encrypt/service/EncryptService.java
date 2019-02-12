package encrypt.service;


import encrypt.service.model.Message;
import io.micronaut.runtime.server.EmbeddedServer;
import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class EncryptService {

    private final EmbeddedServer embeddedServer;

    public EncryptService(EmbeddedServer embeddedServer) {
        this.embeddedServer = embeddedServer;
    }

    public Single<Message> encrypt(String text){
        String encrypted = new StringBuffer(text).reverse().toString();
        return Single.just(new Message(encrypted + "->" + embeddedServer.getPort()));
    }

}
