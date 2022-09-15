package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("Bean Name Find")
    @Test
    public void findBeanByName() throws Exception {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("Bean Find without type")
    @Test
    public void findBeanByType() throws Exception {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // 부모는 자식을 포함할 수 있다.
    }

    @DisplayName("Bean Find Using Instance")
    @Test
    public void findBeanByInstance() throws Exception {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    } // 구체적인 타입을 사용해서 조회를 사용하는 것은 지양해야한다.


    @DisplayName("No Such Bean Exception Test")
    @Test
    public void findBeanFailTest() throws Exception {
        assertThatThrownBy(() -> ac.getBean("xxxx", MemberService.class))
                .isInstanceOf(NoSuchBeanDefinitionException.class);
    }
}
