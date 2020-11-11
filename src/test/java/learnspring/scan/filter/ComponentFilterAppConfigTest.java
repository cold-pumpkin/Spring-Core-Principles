package learnspring.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        IncludeBean includeBean = ac.getBean("includeBean", IncludeBean.class);
        assertThat(includeBean).isNotNull();

        assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("excludeBean", ExcludeBean.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(classes = MyIncludeComponent.class), // type = FilterType.ANNOTATION 기본값
            excludeFilters = @ComponentScan.Filter(classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }
}
