package cs544D5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AClass extends MySuper {
    private BClass bClass;

    @Autowired
    public AClass(BClass b) {
        System.out.println("MyClass Constructor");
        setText("Hello");
        this.bClass = b;
    }

    public void getAText() {
        System.out.println("This is a " + getText());
    }

    public void getBText() {
        System.out.println("This is a " + bClass.getText());
    }
}