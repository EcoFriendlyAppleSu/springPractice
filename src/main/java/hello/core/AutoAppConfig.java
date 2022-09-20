package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
/*
 * @Component 를 Scan해서 등록해준다. @Configuration 안에 @Component가 붙어 있어 수동 등록한 AppConfig는 제외해줘야한다.
 * Component Scan Scope 지정해서 사용할 수 있다. 패키지 시작 위치 검색 가능
 * */
public class AutoAppConfig {

    /*
    수동 Bean 등록
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
