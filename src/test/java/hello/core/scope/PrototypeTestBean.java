package hello.core.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeTestBean {

    private int count = 0;

    public void addCount() {
        count++;
    }

    public int getCount() {
        return this.count;
    }
}
