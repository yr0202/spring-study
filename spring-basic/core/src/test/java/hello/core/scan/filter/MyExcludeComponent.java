package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//MyExcludeComponent 붙은 거는 ComponentScan에 제외할거야... 라고 이해...?
public @interface MyExcludeComponent {
}
