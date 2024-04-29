package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration //설정 정보
@ComponentScan(// 자동으로 스프링 빈을 쫙 끌어올려준다
        basePackages = "hello.core.member", //member만 컴포넌트 스캔의 대상이 된다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 위 코드는 AppConfig와 충돌을 피하기 위함

        // 시작 위치를 지정하지 않으면 default 시작 위치는
        // AutoAppConfig을 포함한 hello.core 패키지의 하위 폴더를 싹 뒤진다
)
public class AutoAppConfig {

}
