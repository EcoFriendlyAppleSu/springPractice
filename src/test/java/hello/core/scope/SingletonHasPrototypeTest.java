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
        assertThat(logic2).isEqualTo(2);
    } // 처음 주입 받을 때만 PrototypeBean을 생성한다.
    // 이는 찾기 힘든 오류를 만들어낸다.
}
