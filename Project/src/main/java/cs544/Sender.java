package cs544;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {
    private static final String topicExchangeName = "spring-boot-exchange";
    @Autowired
    private RabbitTemplate template;

    @Override
    public void run(String... args) throws Exception {
        template.convertAndSend(topicExchangeName, "foo.bar.baz", "Hello from Sender");
        template.convertAndSend(topicExchangeName, "foo.bar.baz", "Hello from Sender22");
    }
}
