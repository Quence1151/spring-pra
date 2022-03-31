# SpringPractice

--------------------------------
스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술 실습 <br>

## 변경점<br>

- DB -> 오라클클라우드 DB(연결 완료)
- myBatis 내용 추가(예정)


## 공부할 것들?

--------------------------------
###오라클클라우드 연결

- propertise 설정
  ```properties
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
  
###gradle 의존성 옵션 정리

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
