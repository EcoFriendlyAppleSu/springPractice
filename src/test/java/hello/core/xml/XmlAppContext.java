package hello.core.xml;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    @Test
    public void xmlAppContext() throws Exception {
        //given
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        //when
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
