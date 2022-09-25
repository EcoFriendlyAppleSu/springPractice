package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonHasPrototypeTest {

    @Test
    public void singletonBeanHasPrototypeBeanTest() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestAutoConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = " + bean);
        }
    }

    @Test
    public void singletonBeanHasPrototypeBeanOccursProblemTest() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestAutoConfig.class);
        SingletonTestBean singletonTestBean1 = ac.getBean(SingletonTestBean.class);
        int logic1 = singletonTestBean1.logic();
        assertThat(logic1).isEqualTo(1);


        SingletonTestBean singletonTestBean2 = ac.getBean(SingletonTestBean.class);
        int logic2 = singletonTestBean2.logic();
        // assertThat(logic2).isEqualTo(2);
        assertThat(logic2).isEqualTo(1);
    }
    // Use prototype provider, Result = 1, 1
    // else, Result = 1, 2
}
