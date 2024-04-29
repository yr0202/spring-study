package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); // type 지정안해서 objec가 꺼내짐
            System.out.println("name = " + beanDefinitionName + "object = "+ bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // 빈에 하나하나에 대한 메타데이터 정보를 꺼내옴

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = "+ bean);
            }
            /* 출력
            name = appConfigobject = hello.core.AppConfig$$SpringCGLIB$$0@54e7df6a
            name = memberServiceobject = hello.core.member.MemberServiceImpl@3fed2870
            name = memberRepositoryobject = hello.core.member.MemoryMemberRepository@77128536
            name = orderServiceobject = hello.core.order.OrderServiceImpl@58326051
            name = discountPolicyobject = hello.core.discount.RateDiscountPolicy@32c4e8b2
             */
        }
    }
}
