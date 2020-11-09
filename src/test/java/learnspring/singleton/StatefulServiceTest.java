package learnspring.singleton;

import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import org.assertj.core.api.Assertions;

class StatelessServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);  // 같은 객체

        // Thread A : userA가 10000원 주문
        statefulService1.order("userA", 10000);
        // Thread B : userB가 20000원 주문
        statefulService1.order("userB", 20000);

        // Thread A : userA 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    @Test
    void statelessServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);  // 같은 객체

        // Thread A : userA가 10000원 주문
        int userAprice = statelessService1.order("userA", 10000);
        // Thread B : userB가 20000원 주문
        int userBprice = statelessService2.order("userB", 20000);

        // Thread A : userA 주문 금액 조회
        System.out.println("userAprice = " + userAprice);
        Assertions.assertThat(userAprice).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

        @Bean
        public StatelessService statelessService() {
            return new StatelessService();
        }
    }
}