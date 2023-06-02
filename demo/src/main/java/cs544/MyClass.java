package cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Component;

@Component

// @Lazy

public class MyClass {
private String text;

public MyClass() {
setText("Hello");
System.out.println("MyClass Constructor - text: " + text);

}

public void sayHello() {
System.out.println("This is a " + getText());

}

public void setText(String text) {
System.out.println("Setting text to: " + text);
this.text = text;

}

public String getText() {
return text;

}
}