package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    /*
    * 객체를 생성하고 의존관계를 주입하는 것을 보여준다.
    * */
    @Test
    public void lifeCycleTest() throws Exception {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient networkClient = ac.getBean("networkClient",NetworkClient.class);
        ac.close(); // ApplicationContext에 존재하지 않고 그 아래에서 가져와야한다.

    }

    @Configuration
    static class LifeCycleConfig {

        /*
        * destroyMethod 는 자동으로 추론해 종료 해준다.
        * */
        // @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient(); // Get Instance
            networkClient.setUrl("http://helloSpringDev"); // Setter
            return  networkClient;
        }
    }
}
