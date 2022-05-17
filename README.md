# SpringPractice

--------------------------------
[스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/)
실습 <br>

## 실습환경<br>

- Project: Gradle Project 
- Spring Boot: 2.6.7 
- Language: Java 
- Packaging: Jar 
- Java: 11
- Dependencies: Spring Web, Thymeleaf + OJDBC8


## 강의 내용<br>

- 스프링 프로젝트 생성
- 스프링 부트로 웹 서버 실행
- 회원 도메인 개발
- 웹 MVC 개발
- DB 연동 - JDBC, JPA, 스프링 데이터 JPA
- 테스트 케이스 작성


## 학습 내용 정리<br>

#### 일반적인 웹 애플리케이션 계층 구조
> - 컨트롤러: 웹 MVC의 컨트롤러 역할
> - 서비스: 핵심 비즈니스 로직 구현
> - 리포지토리: 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
> - 도메인: 비즈니스 도메인 객체, ex) 회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨

#### 스프링 빈을 등록하는 2가지 방법 
> - 컴포넌트 스캔과 자동 의존관계 설정
> - 자바 코드로 직접 스프링 빈 등록하기

#### 컴포넌트 스캔 원리
> - @Component 애노테이션이 있으면 스프링 빈으로 자동 등록된다. 
> - @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문이다. 
> - @Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록된다. 
>   - @Controller 
>   - @Service 
>   - @Repository

#### 관점 지향 프로그래밍(AOP)
> - 특정 로직을 기준으로 핵심관심사항과 공통관심사항을 구분하여 각각 모듈화
> - 여러 객체에 공통적으로 사용할 수 있는 기능과 핵심기능을 구분함으로써 재사용성을 높여주는 기법
> #### 주요개념
> > - Aspect
> >   - 흩어진 관심사(Crosscutting Concerns)를 묶은 하나의 모듈. Advice와 Point Cut이 들어간다. 
> > - Target
> >   - Aspect가 가지고 있는 Advice가 적용되는 대상(클래스, 메서드 등등)을 말한다. 
> > - Advice
> >   - 해야할 일들에 대한 정보를 가지고 있다. 
> > - Join Point
> >   - 가장 흔한 Join Point는 메서드 실행 시점
> >   - Advice가 적용될 위치, 끼어들 수 있는 지점
> >     - 생성자 호출 직전
> >     - 생성자 호출 시
> >     - 필드에 접근하기 전
> >     - 필드에서 값을 가져갔을 때 
> > - Point Cut
> >   - Join Point의 적용위치와 같은 상세한 스펙을 정의한 것.

### Annotation 정리

> #### @ResponseBody 사용 원리
> - http의 body에 문자 내용을 직접 반환
> - viewResolver 대신에 HttpMessageConverter 가 동작
> - 기본 문자처리: StringHttpMessageConverter
> - 기본 객체처리: MappingJackson2HttpMessageConverter
> - byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
> - @Controller를 사용한 경우 body를 자바객체로 받기 위해서는 @ResponseBody 어노테이션을 반드시 명시해야 함
> 
> >`+` @RequestBody
> > - HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할
>
> > `+` xml이나 json기반의 메시지를 사용하는 요청의 경우에 주로 사용<br>


## 추가 학습 목표<br>

- DB -> 오라클클라우드 DB(연결 완료)
- myBatis 내용 추가(예정)

## 추가 학습 내용 정리

--------------------------------
### 오라클클라우드 연결
- yml 설정
  ```yaml
  spring:
      datasource:
          driver-class-name: oracle.jdbc.OracleDriver
          url: jdbc:oracle:thin:@db이름?TNS_ADMIN=지갑경로
          username: id
          password: pw


- dependency 설정
  - gradle(build.gradle)
      ```java
      compileOnly "com.oracle.database.jdbc:ucp:21.3.0.0"
      compileOnly "com.oracle.database.security:oraclepki:19.9.0.0"
      compileOnly "com.oracle.database.security:osdt_core:21.3.0.0"
      compileOnly "com.oracle.database.security:osdt_cert:19.9.0.0"

  - maven(pom.xml)
      ```xml
      <dependency>
          <groupId>com.oracle.database.jdbc</groupId>
          <artifactId>ojdbc8</artifactId>
          <scope>runtime</scope>
      </dependency>
      
      <dependency>
          <groupId>com.oracle.database.jdbc</groupId>
          <artifactId>ucp</artifactId>
          <version>21.3.0.0</version>
      </dependency>
      
      <dependency>
          <goupId>com.oracle.database.security</groupId>
          <atifactId>oraclepki</artifactId>
          <vrsion>19.9.0.0</version>
      </dependency>
      
      <dependency>
          <goupId>com.oracle.database.security</groupId>
          <atifactId>osdt_core</artifactId>
          <vrsion>21.3.0.0</version>
      </dependency>
      
      <dependency>
          <goupId>com.oracle.database.security</groupId>
          <atifactId>osdt_cert</artifactId>
          <vrsion>19.9.0.0</version>
      </dependency>
  
### gradle 의존성 옵션 정리
<img src="https://docs.gradle.org/current/userguide/img/java-library-ignore-deprecated-main.png" title="px(픽셀) 크기 설정" alt="RubberDuck"></img><br/>
- implementation
  - 의존 라이브러리 수정시 본 모듈까지만 재빌드
  - 본 모듈을 의존하는 모듈은 해당 라이브러리의 api 를 사용할 수 없음
- api
  - 의존 라이브러리 수정시 본 모듈을 의존하는 모듈들도 재빌드
  - 본 모듈을 의존하는 모듈들도 해당 라이브러리의 api 를 사용할 수 있음
- compileOnly
  - compile 시에만 빌드하고 빌드 결과물에는 포함하지 않음
  - ex) Lombok 등..
- runtimeOnly
  - 컴파일 시점에는 필요 없지만, 런타임에 필요한 라이브러리
  - ex) Logging, **DB관련 라이브러리**들이 해당
- annotationProcessor
  - annotation processor 명시(ex. lombok)
- testImplementation
  - 테스트 코드를 수행시 적용
