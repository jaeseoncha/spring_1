package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFIndTest {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( TestConfig.class );
		
		@Test
		@DisplayName( "부모타입으로조회시 자식이 둘이사있으면 중복오류가 발생한다." )
		void findTest(){
				DiscountPolicy bean = ac.getBean( DiscountPolicy.class );
		}
		
		
		@Test
		@DisplayName( "부모타입으로조회시 자식이 둘이사있으면 중복오류가 발생한다.그럴댄 빈이름을 적어주면됨" )
		void findTest2(){
				DiscountPolicy bean = ac.getBean( "rateDiscountPolicy",RateDiscountPolicy.class );
				System.out.println( "bean = " + bean );
		}
		@Test
		@DisplayName( "부모타입으로조회시 자식이 둘이사있으면 중복오류가 발생한다.특정하위타입으로 지정" )
		void findTest3(){
				DiscountPolicy bean = ac.getBean( RateDiscountPolicy.class );
		}
		@Test
		@DisplayName( "오브젝트타입으로다꺼내기" )
		void findTest3ByObject(){
				Map<String,Object> beansOfTypes = ac.getBeansOfType( Object.class );
				
				for(String key : beansOfTypes.keySet()){
						System.out.println( "key = " + key +"value " + beansOfTypes.get( key ));
				}
		}		
		
		@Configuration
		static class TestConfig{

				@Bean
				public DiscountPolicy rateDiscountPolicy(){
						return new RateDiscountPolicy();
				}
				@Bean
				public DiscountPolicy fixDiscountPolicy(){
						return new FixDiscountPolicy();
				}
				
		}
}
