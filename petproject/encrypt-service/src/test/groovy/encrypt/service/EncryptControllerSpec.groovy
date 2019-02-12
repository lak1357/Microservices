package encrypt.service

import encrypt.service.EncryptClient
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification


class EncryptControllerSpec extends Specification {

    @Shared @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer);

    @Shared
    EncryptClient encryptClient = embeddedServer.applicationContext.getBean(EncryptClient.class);

    void 'test encrypt controller'(){
        expect:
        "!olleH".equals(encryptClient.encrypt("Hello!").blockingGet().getText())
    }

    void 'test encrypt controller2'(){
        expect:
        "test".equals(encryptClient.encrypt("tset").blockingGet().getText())
    }
}
