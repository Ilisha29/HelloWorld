# [Book] 스프링부트와 AWS로 혼자 구현하는 웹 서비스 (2 tries)

## 01장 인텔리제이로 스프링 부트 시작하기

### 1.1 인텔리제이 소개

#### 인텔리 제이의 강점

- 강력한 추천 기능
- 훨씬 더 다양한 리팩토링과 디버깅 기능
- 이클립스의 깃에 비해 훨씨 높은 자유도
- 프로젝트 시작할때 인덱싱을 하여 파일을 비롯한 자원들에 대한 빠른 검색 속도
- HTML과 CSS, JS, XML에 대한 강력한 기능 지원
- 자바, 스프링 부트 버전업에 맞춘 빠른 업데이트



### 1.2 인텔리제이 설치하기

#### 툴박스를 이용하면 버전관리에 편리하다.



### 1.3 인텔리제이 커뮤니티에서 프로젝트 생성하기

#### 1. IDE환경 세팅

#### 2. Create New Project

- Gradle유형으로 프로젝트 생성 

프로젝트 유형은 Maven과 Gradle로 나뉜다는 것을 알고있다.

- GroupId와 ArtifactId 등록

책에 있는 그대로 따라썼다. 이전까지의 시도에서는 나름의 이름을 지었는데 막혀서 넘어가지 못한 경험을 하자 이번에는 반드시 해결하고 싶은 마음에 자세하게 이해하면서 책을 그대로 따라해보기로 했다.

- 그래이들옵션 디폴트값으로 설정
- 디렉토리 위치 선택



### 1.4 그레이들 프로젝트를 스프링 부트 프로젝트로 변경하기

#### 프로젝트 플러그인 의존성 관리를 위한 설정

```java
buildscript {
    ext { //전역변수선언
        springBootVersion = '2.1.7.RELEASE'
    }
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}
```

#### 플러그인의 의존성 적용

```java
apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management' //스프링 부트 읜존성 관리
```

#### 그외 설정

```java
repositories { //의존성들을 어떤 원격저장소에서 받을지 설정
    mavenCentral()
    jcenter()
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-web')
    testCompile('org.springframework.boot:spring-boot-starter-test')
    testCompile group: 'junit', name: 'junit', version: '4.12'
}

```

- dependencies의 의존성코드들은 직접 버전을 명시하지 않아야만 자동으로 버전관리를 해준다.

- 의존성들이 제대로 반영됬는지는 IDE왼쪽 Gradle탭에서 확인할 수 있다.



### 1.5 인텔리제이에서 깃과 깃허브 사용하기

#### IDE를 통해 깃과 연동

- Action 창에 검색을 통해 share project on github를 클릭
- 저장소 이름과 설명 작성



#### .gitignore를 추가해 불필요한 파일이 올라가지 않도록 하자

##### .ignore 플러그인의 기능

- 파일 위치 자동완성
- 이그노어 처리 여부 확인
- 다양한 이그노어 파일 지원



#### .gitignore파일 생성

```java
.gradle
.idea
```

앞으로 gradle폴도와 idea폴더에 생성되는 모든 파일들은 커밋되지 않는다.



## 02장 스프링 부트에서 테스트 코드를 작성하자

### 2.1 테스트 코드 소개

#### TDD : 테스트가 주도하는 개발

#### 단위 테스트 : 단위 기능에 대한 순수한 테스트코드 작성



#### TDD 사이클

- 항상 실패하는 테스트를 작성 (Red)
- 테스트가 통과하는 프로덕션 코드를 작성 (Green)
- 테스트가 통과하면 프로덕션 코드를 리팩토링 (Refactor)



#### 테스트 코드의 이점

- 단위 테스트는 초기에 문제를 발견하게함
- 단위 테스트는 개발자가 나중에 코드를 리팩토링하거나 라이브러리 업그레이드 등에서 기존 기능이 올바르게 작동하는지 확일할 수 있습니다.
- 단위 테스트는 기능에 대한 불확실성을 감소시킬 수 있습니다.
- 단위 테스트는 시스템에 대한 실제 문서를 제공합니다. 즉, 단위 테스트 자체가 문서로 사용될 수 있습니다.



### 2.2 Hello Controller 테스트 코드 작성하기

#### 메인 클래스인 Application.class생성

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 자동설정, 스프링 Bean 읽기 쓰기를 자동으로 해줌 이부분이 코드의 시작
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장 WAS를 실행
    }
}
```

- WAS (Web Application Server) : 웹 애플리케이션 서버
- 내장 WAS : 항상 서버에 톰캣을 설치할 필요가 없게되고,  Jar파일을 실행하면 됨.



#### HelloController에 사용한 어노테이션

- RestController : JSON을 반환한느 컨트롤러

- GetMapping  : Get요청을 받는 API

  이전에는 @RequestMapping(method = RequestMethod.GET)으로 사용



#### HelloControllerTest에 사용한 어노테이션

- RunWith

스프링 부트 테스트와 JUnit 사이에 연결자 역할

- WebMvcTest

여러개의 테스트 어노테이션 중 WebMvc테스트에 집중할 수 있는 어노테이션

- Autowired

스프링이 관리하는 빈을 주입받습니다.

- private MockMvc mvc

웹 API를 테스트할 때 사용합니다.

스프링 MVC테스트의 시작점

- mvc.perform

체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있습니다.

- .andExpect(status().isOk())

.mvc.perform 결과를 검증합니다.

HTTP Header의 Status 검증합니다.

- .andExpect(content().string(hello))

.mvc.perform 결과를 검증합니다.

응답의 본문 내용을 검증합니다.

```
실수했던 부분

- 잘 따라썼다고 생각했는데, 테스트 코드가 성공하지 못하였다. 그래서 틀린 부분을 보니까
main폴더의 하위 폴더명을 com.jojoldu.book.springboot라고 했었는데 자세히 보니 test폴더에서는 실수로 jojoldo라고 잘못썼기 때문에 발생했던 문제였다.
```



#### 절대 수동으로 검증하고 테스트 코드를 작성하지말자.



### 2.3 롬복 소개 및 설치하기

#### 롬복 이란?

자주 사용하는 Getter, Setter, 기본생성자, toString등을 어노테이션으로 자동으로 생성



#### 롬복 설치후 세팅

plugins에서 설치를 받고 재시작을 한다. 단 plugin를 하는 것은 한번만 하면되지만, gradle에서 의존성을 추가하는 것과 프로젝트 빌드 셋팅에서 enable annotation processing을 체크하는것은 프로젝트마다 해줘야 한다.



### 2.4 Hello Controller 코드를 롬복으로 전환하기

#### HelloResponseDto 추가

- Getter

선언된 모든 필드의 get메소드를 생성해 줍니다.

- RequiredArgsConstructor

선언된 모든 final필드가 포함된 생성자를 생성해 줍니다.

final이 없는 필드는 생성자에 포함되지 않습니다.



#### HelloResponseDtoTest 추가

- assertThat

테스트 검증 메소드

- isEqualTo

assertj의 동등 비교 메소드입니다.



#### asserj의 asserThat가 JUnit 의 assertThat보다 편리한 이유

- 더 나은 자동완성기능
- 추가적인 라이브러리의 설치가 불필요



#### HelloController에 ResponseDto 추가

- RequestParam

외부에서 APi로 넘긴 파라미터를 가져오는 어노테이션



#### HelloControllerTest에 DtoTest추가

- param

API테스트를 할 때 사용될 요청 파라미터를 설정

String만 허용됨

- jsonPath

JSON응답값을 필드별로 검증할 수 있는 메소드

$를 기준으로 필드명을 명시합니다.



## 3장 스프링부트에서 JPA로 데이터베이스 다뤄보자

### 3.0 들어가기

#### ORM : 객체 매핑 (JPA)

#### SQL Mapper : 쿼리 매핑 (MyBatis, iBatis)



### 3.1 JPA 소개

#### 관계형 데이터베이스와 객체지향 프로그래밍의 패러다임차이

관계형 데이터 베이스 : 어떻게 데이터를 저장할지

객체지향 프로그래밍 : 기능과 속성을 한곳에서 관리



#### 패러다임의 차이로 발생하는 구현시의 어려움을 해결하기 위해 등장한 JPA

JPA는 지향하는 바가 다른 **두개의 영역 중간에서 패러다임 일치**를 시켜주는 기술

따라서, JPA는 개발자는 객체지향적 프로그래밍을 하고, JPA는 이를 관계형 데이터베이스에 맞게 SQL을 대신생성하여 실행.



#### Spring Data JPA

- JPA  <--- Hibernate <--- Spring Data Jpa

- 구현체 교체의 용이성 (새로운 JPA구현체가 나온다해도 넘어가기 용이하다.)
- 저장소 교체의 용이성 (의존성 교체로 MongoDB등으로 다른 저장소 교체가 용이하다.)



### 3.2 프로젝트에 Spring Data Jpa 적용하기

#### 의존성 추가

```java
compile('org.springframework.boot:spring-boot-starter-data-jpa')
compile('com.h2database:h2')
```

#### 도메인 패키지에 posts패키지와 Posts 클래스를 생성

- @Entity

테이블과 링크될 클래스임을 나타냄

- @Id

해당 테이블의 PK필드를 나타냄

- @GeneratedValue

PK의 생성 규칙을 나타냄

- @Column

테이블의 칼럼을 나타내머 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨

- @NoArgsConstructor

기본 생성자 자동 추가

- @Builder

해당 클래스의 빌더 패턴 클래스를 생성

##### 주의 : Entity클래스에서는 Setter메소드를 생성하지 않는다. DB에 값을 채우는 것은 생성자를 통해서 채우지만, 이 책에서는 빌더 클래스를 사용.



### 3.3 Spring Data JPA 테스트 코드 작성

#### PostsRepositoryTest 생성

- @After

단위 테스트가 끝날떄마다 수행되는 메소드

여러 테스트가 동시에 진행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아있어 다음 테스트 실행시 테스트가 실패할 수 있다.



### 3.4 등록/수정/조회 API만들기

#### Spring 웹 계층

- Web Layer : 뷰 템플릿 영역, **외부 요청과 응답**을 처리
- Service Layer : Controller와 Dao의 중간 영역
- Repository Layer : Database와 같이 저장소에 접근하는 영역
- Dtos : 계층 간에 데이터 교환을 위한 객체
- Domain Model : 개발대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화시킨 것



#### 의존성 주입의 3가지 방법

- @Autowired
- setter
- 생성자

##### 생성자 주입을 통해서 의존성 주입을 하자. 여기서는 @RequiredArgsConstructor가 해준다.



### 3.5 JPA Auditing으로 생성시간/수정시간 자동화하기

#### BaseTimeEntity 추가

- @MappedSuperclass

JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식

- @EntityListeners(AuditingEntityListener.class)

BaseTimeEntity 클래스에 Auditing 기능을 포함시킴

- @CreatedDate

Entity가생성되어 저장될때 시간이 자동 저장됨

- @LastModifiedDate

조회한 Entity의 값을 변경할 때 시간이 자동 저장됩니다.



## 4장 머스테치로 화면 구성하기

### 4.1 서버 템프릿 엔진과 머스테치 소개

#### 템플릿 엔진이란?

지정된 템플릿 양식과 데이터가 합쳐져 HTML문서를 출력하는 소프트웨어 (JSP, React, Vue)



#### 서버 템플릿 엔진

서버 템플릿 엔진을 이용한 화면 생성은 **서버에서 Java 코드로 문자열**을 만든뒤 HTML로 변환하여 브라우져로 전달함

#### 클라이언트 템플릿 엔진

브라우져위에서 작동함. 또한 Vue, React를 이용한 SPA는 브라우져에서 화면을 생성



#### 머스테치

수많은 언어를 지원하는 심플한 템플릿 엔진

##### 장점

- 문법이 다른 템플릿 엔진보다 심플
- 로직 코드를 사용할수 없어 view의 역할과 서버의 역할을 명확히 분리
- Mustache.js와 Mustache.java 2가지 다 있어,하나의 문법으로 클라이언트/서버 템플릿 모두 사용 가능



### 4.2 기본 페이지 만들기

#### index.mustache 만들기

```html
<!DOCTYPE HTML>
<html>
<head>
    <title>스프링 부트 웹서비스</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />

</head>
<body>
    <h1>스프링 부트로 시작하는 웹 서비스</h1>
</body>
</html>
```



### 4.3 게시글 등록 화면 만들기

#### 레이아웃 분리

##### index.mustache

```html
{{>layout/header}}

<h1>스프링 부트로 시작하는 웹 서비스</h1>

{{>layout/footer}}
```

##### header.mustache

```html
<!DOCTYPE HTML>
<html>
<head>
    <title>스프링부트 웹서비스</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
```

##### footer.mustache

```html
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!--index.js 추가-->
<script src="/js/app/index.js"></script>
</body>
</html>
```



### 4.4 전체 조회 화면 만들기

#### 머스테치를 적용한 index.mustache

```html
{{>layout/header}}

<h1>스프링 부트로 시작하는 웹 서비스 Ver.2</h1>
<div class="col-md-12">
    <div class="row">
        <div class="col-md-6">
            <a href="/posts/save" role="button" class="btn btn-primary">글 등록</a>
        </div>
    </div>
    <!-- 목록 출력 영역 -->
    <table class="table table-horizontal table-bordered">
        <thead class="thead-strong">
        <tr>
            <th>게시글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>최종수정일</th>
        </tr>
        </thead>
        <tbody id="tbody">
        {{#posts}}
            <tr>
                <td>{{id}}</td>
                <td><a href="/posts/update/{{id}}">{{title}}</a></td>
                <td>{{author}}</td>
                <td>{{modifiedDate}}</td>
            </tr>
        {{/posts}}
        </tbody>
    </table>
</div>

{{>layout/footer}}
```

- {{#posts}}

posts라는 List를 순회

- {{id}} 등의 {{변수명}}

List에서 뽑아낸 객체의 필드를 사용

#### 

#### @Transactional옵션 설정

트랙잭션 어노테이션에 **readOnly = true**옵션을 주면 트랜잭션 범위는 유지하면서 오직 조회기능만 남겨두어 속도를 개선시킬 수 있다.



### 4.5 게시글 수정, 삭제 화면 만들기

#### 게시글 수정 js파일 추가

##### index.js

```javascript
update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
```

```html
		<tbody id="tbody">
        {{#posts}}
            <tr>
                <td>{{id}}</td>
                <td><a href="/posts/update/{{id}}">{{title}}</a></td>
                <td>{{author}}</td>
                <td>{{modifiedDate}}</td>
            </tr>
        {{/posts}}
        </tbody>
```

##### IndexController

```java
	@GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
```

#### 게시글 삭제

##### index.js

```javascript

delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
```

##### PostsService

```java
@Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postsRepository.delete(posts);
    }
```

##### PostsApiController

```java
@DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
```

### 

## 05장 스프링 시큐리티와 OAuth 2.0으로 로그인 기능 구현하기

### 5.1 스프링 시큐리티와 스프링 시큐리티 Oauth2 클라이언트

##### OAuth를 사용하지 않을시 생기는 번거로움

- 로그인시 보안
- 비밀번호 찾기
- 비밀번호 변경
- 회원정보 변경
- 회원가입시 이메일 혹은 전화번호 인증



#### 스프링 부트 1.5 vs 스프링 부트 2.0

스프링 부트 1.5 : url주소 명시

스프링 부트 2.0 : client 인정정보만 입력



### 5.2 구글 서비스 등록

1. 새프로젝트 생성
2. 사용자 인증정보 만들기
3. OAuth 클라이언트 ID
4. 승인된 리디렉션 URI추가
5. application-oauth등록
6. .gitignore등록



### 5.3 구글 로그인 연동하기

#### User클래스 생성

#### Role Enum클래스 생성

#### UserRepository 생성

#### 스프링 시큐리티 설정

- ```
  compile('org.springframework.boot:spring-boot-starter-oauth2-client')
  ```



### 5.4 어노테이션 기반으로 개선하기

#### 중복제거

어노테이션을 추가하여 중복되는 코드들을 줄여보자

##### @interface LoginUser

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}

```



##### WebConfig.c

```java
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
```



### 5.5 세션 저장소로 데이터베이스 사용하기

#### 세션동기화 설정

##### 1. 톰캣 세션을 사용

##### 2. MySQL과 같은 데이터베이스를 세션 저장소로 사용

- 가장 쉬운방법
- 로그인 요청마다 DB IO가 발생하여 성능상 이슈가 생길 수 있음
- 사내시스템 용도로 사용

##### 3. Redis, Mmcached와 같은 메모리 DB를 세션 저장소로 사용

- B2C서비스에서 가장 많이 사용
- 외부 메모리 서버가 필요



### 5.6 네이버 로그인

#### 네이버 API등록

#### 시큐리티 설정등록

##### OAuthAttributes.java

```java
private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
```

### 5.7 기존 테스트에 시큐리티 적용하기

#### 문제 1. CustomOAuth2UserService를 찾을 수 없음

main과 test는 각자의 환경 구성을 갖는데, 테스트 코드를 실행하면 각자의 환경에도 불구하고, test에 application.properties가 없으면 main에서 그대로 가져온다.

하지만 oauth와 관련된 application-oauth.properties는 가져오지 못하기때문에 문제각 발생한다.

**가짜 설정값** 들을 통해 문제를 해결한다.

##### application.properties

```properties
spring.jpa.show_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.h2.console.enabled=true
spring.session.store-type=jdbc

# Test OAuth

spring.security.oauth2.client.registration.google.client-id=test
spring.security.oauth2.client.registration.google.client-secret=test
spring.security.oauth2.client.registration.google.scope=profile,email

```

#### 문제 2. 302 Status Code

```java
testCompile('org.springframework.security:spring-security-test')
```

- @WithMockUser(roles='USER')

인증된 모의 사용자를 만들어 사용함

roles에 권한 추가가 가능하다.

ROLE_USER 권한을 가진 사용자가 API를 요청하는 것과 동일한 효과를 가짐



#### 문제 3. @WebMvcTest에서 CustomOAuth2UserService을 찾을 수 없음

#### @WebMvcTest가 스캔대상에 벗어난것을 필요로해서 생긴다.

