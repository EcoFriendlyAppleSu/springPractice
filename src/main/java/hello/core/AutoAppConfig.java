package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


/*
 * @Component 를 Scan해서 등록해준다. @Configuration 안에 @Component가 붙어 있어 수동 등록한 AppConfig는 제외해줘야한다.
 * Component Scan Scope 지정해서 사용할 수 있다. 패키지 시작 위치 검색 가능
 * */

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
