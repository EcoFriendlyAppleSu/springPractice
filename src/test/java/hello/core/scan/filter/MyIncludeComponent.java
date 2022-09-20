package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // class level에서 사용
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
