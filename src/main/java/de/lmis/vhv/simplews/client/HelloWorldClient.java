package de.lmis.vhv.simplews.client;

import de.vhv.types.helloworld.Greeting;
import de.vhv.types.helloworld.ObjectFactory;
import de.vhv.types.helloworld.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class HelloWorldClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldClient.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String sayHello(String firstName, String lastName) {
        ObjectFactory factory = new ObjectFactory();
        Person person = factory.createPerson();

        person.setFirstName(firstName);
        person.setLastName(lastName);

        LOGGER.info("Client sending person[firstName={},lastName={}]", person.getFirstName(),
                person.getLastName());

        Greeting greeting = (Greeting) webServiceTemplate.marshalSendAndReceive(person);

        LOGGER.info("Client received greeting='{}'", greeting.getGreeting());
        return greeting.getGreeting();
    }
}