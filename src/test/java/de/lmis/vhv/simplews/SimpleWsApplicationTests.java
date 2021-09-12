package de.lmis.vhv.simplews;

import de.lmis.vhv.simplews.client.HelloWorldClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpleWsApplicationTests {
    @Autowired
    private HelloWorldClient helloWorldClient;

    @Test
    public void testSayHello() {
        assertThat(helloWorldClient.sayHello("John", "Doe"))
                .isEqualTo("Hello John Doe!");
    }

}
