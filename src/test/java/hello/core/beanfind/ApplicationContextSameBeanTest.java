package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanTest {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( SameBeanConfig.class );
		
//		@Test
//		@DisplayName( "타입으로 조회시 같은타입이 둘이상있으면 오류남" )
//		void findAllBean(){
//			Assertions.assertThrows( NoUniqueBeanDefinitionException.class , ()-> ac.getBean( SameBeanConfig.class ) );
//		}
		@Test
		@DisplayName( "타입으로 조회시 같은 타입이 둘 이상 있으면 , 빈이름을 지정하면된다." )
		void findAllBea2n(){
				
				MemberRepository memberRepository =ac.getBean( "memberRepository1",MemberRepository.class );
				org.assertj.core.api.Assertions.assertThat( memberRepository ).isInstanceOf( MemberRepository.class );
		}
		@Test
		@DisplayName( "특정타입을 모두조회하기" )
		void findAllBean3(){
		Map<String,MemberRepository> beanOfType =ac.getBeansOfType( MemberRepository.class );
		
		for( String key :beanOfType.keySet()){
				System.out.println( key + beanOfType.get( key ));
		}
	
		}
		
		@Configuration
		static class SameBeanConfig{
				
				@Bean
				public MemberRepository memberRepository1(){
						return new MemoryMemberRepository();
				}
				
				@Bean
				public MemberRepository memberRepository2(){
						return new MemoryMemberRepository();
						
				}
		}
}
