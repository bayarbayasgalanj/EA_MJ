package cs544;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
// @Component
public  class MySuper {
    @Value("From Super")
    private String text;

    public MySuper () { System.out.println("MySuper Constructor - text: " + getText ()); }

    @PostConstruct
    public void init() {
        this.setText("From Super Init");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        System.out.println("Setting Text to: " + text);
        this.text = text;
    }
}
