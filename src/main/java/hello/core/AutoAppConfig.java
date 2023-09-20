package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;


@ComponentScan(
        //basePackages = "hello.core.member"
        //-> 해당 위치 아래에 있는 패키지에서만 찾는 역할
        //-> 모든 라이브러리를 다 찾기때문에 효율적으로 사용하기 위해서는 써놓는게 좋음
        //여러개 사용할 수도 있음
        //지정하지 않은 경우 -> default -> ComponentScan을 붙인 클래스부터 해당 위치 패키지와 하위 패키지를 찾음
        //-->권장하는 방법 -> 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것. / 스프링 부트도 해당 방법 제공함
        //스프링 부트를 사용할 시 -> 스프링 부트의 대표 시작 정보인 @SpringBootApplication을 이 프로젝트 시작 루트 위에 두는 것이 관례(해당 설정 안에 @ComponentScan이 들어있음!)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
@Component
public class AutoAppConfig {
    /*@Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }*/
}
