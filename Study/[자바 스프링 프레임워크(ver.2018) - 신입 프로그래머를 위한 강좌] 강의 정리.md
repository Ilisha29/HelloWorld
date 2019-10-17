# [자바 스프링 프레임워크(ver.2018) - 신입 프로그래머를 위한 강좌] 강의 정리

### 1강 스프링 개요

스프링 프레임워크는 주요 기능

DI : Dependency Indection? 주입기능

AOP : 관점지향 프로그래밍

MVC : Model(Data), View, Control

JDBC : 자바 데이터 베이스 커넥터

추가 : JSP 학습이 필요



자바 프레임워크 두가지 

- 스프링 프레임워크 : 웹개발
- 안드로이드 프레임워크 : 모바일 프레임워크 



##### 1.1 프레임워크란?

개발자들을 위한 추상적인 개발 도구

처음부터 시작하는게 아니라 일정한 틀이 제공된 상태에서 시작 (네비게이션과 같은 역할)

스프링 프레임 워크란 : DI AOP MVC JDBC를 제공해주는 웹 개발 및 보안 기능 제공 프레임 워크



##### 1.2 스프링 프레임워크 모듈

1. spring-core : 핵심 모듈, DI와 IoC를 제공
2. spring-aop : AOP 구현 기능 제공
3. spring-jdbc : 데이터베이스를 쉽게 다룰수 있는 기능 제공
4. spring-tx : 스프링에서 제공하는 트랜잭션 관련 기능 제공
5. spring-webmvc : 컨트롤러 뷰를 이용한 스프링 mvc 구현 기능 제공

스프링프레임워크에서 제공하고있는 모듈을사용하려면, 모듈에대한 의존설정을개발 프로젝트에 XML 파일등을 이용해 서개발자가 직접하면 된다. => 웹 어플리케이션을 개발하고 싶으면 XML파일에 명시만 해주면 자동으로 모듈 및 라이브러리를 다운받아 사용할 수 있도록 해줌.



##### 1.3 스프링 컨테이너 (IoC) 

 스프링에서 객체를 생성하고 조립하는 컨테이너(container)로, 컨테이너를 통해 생성된객체를 빈(Bean)이라고 부른다. 

 1) XML문서를 통해 객체 생성 및 속성 데이터 작성

 2) XML문서를 통해 객체를 스프링 컨테이너에 bean혹은 오브젝트라는 의미로 저장되있음

 3) 애플리케이션 구현할때 꺼내서 개발할 때 사용



### 2강 개발 환경 구축

##### 2.1 자바 설치

> 자바 계층 구조

```
JVM -> API -> JRE -> JDK
```

 개발자는 JDK가있어야 개발을할수있고, 단지프로그램만을 사용하는 사용자라면 JRE만설치되어있으면 된다.

##### 2.2 환경변수 설정

##### 2.3 IDE 다운로드



### 3강 스프링 프로젝트 생성

스프링 프로젝트 빌드 툴 = Maven

##### 3.1 프로젝트 생성

Maven으로 프로젝트 생성

Group Id : 전체 프로젝트 이름

Artifact Id : 단위 프로젝트



##### 3.2 pom.xml 작성

pom.xml 파일 => 필요한 모듈을 가져오기 위한 파일



##### 3.3 폴더 및 pom.xml 파일의 이해

spring 프로젝트를 생성단계에서 힘들다 => 프로젝트 생성 방법이 몇가지가 있고 원리가 어려워서 그렇다.

파일구조 디렉토리 구조를 잘 알아야 한다.



**프로젝트 폴더 -> src -> main -> java와 resource** 



1. java 폴더(lec03Pjt001/src/main/java)의경우특별한 것은없고, 앞으로만들어지는 자바파일들이 관리되는 폴더이다. 
2. resources 폴더(lec03Pjt001/src/main/resources)의경우 자원을관리하는폴더로 스프링설정파일(XML) 또는 프로퍼티 파일등이관리된다.
3.  java, resources 폴더는스프링 프레임워크의 기본구조를 이루는폴더로 개발자는이대로 폴더를 구성해야한다.



**pom.xml** 내가 프로젝트에  사용할 라이브러리/모듈들을 메인 저장소로부터 다운로드 저절로 받을 수 있게 해준다.

필요한 모듈을 명시만 해두면 알아서 다운로드 된다.



### 4강 처음해 보는 스프링 프로젝트

Hello World 출력단계

##### 4.1 Java파일을 이용한 프로젝트 실행

주의 : maven 버전 맞추기

 수많은 모듈들을 통해 프로젝트를 진행한다.

스프링 객체 == bean

applicationContext.xml로 만들어 resource에 넣는다.

<  bean      / > 홑태그 ==> 이것을 통해 IoC에 자동으로 객체를 생성

- 기존

```java
TranspotationWalk transpotationWalk = new TranspotationWalk();
transpotationWalk.move();
```

- 스프링
  1. 스프링컨테이너에 접근하는 방법

```java
import org.springframework.context.support.GenericXmlApplicationContext;


GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath : applicationContext.xml"); //classpath 자원의 이름

TranspotationWalk transpotationWalk  = ctx.getBean("tWalk",TranspotationWalk.class);
transpotationWalk.move();

ctx.close();
// 어노테이션과 xml을 통해 객체를 생성한다.
```



**스프링은 처음이 어렵다!! 설정하는 부분, 프로젝트 구조, 디렉토리 구조를 잘 파악하자!!!**



##### 4.2 우선 따라해보는 스프링 프로젝트



### 5강 또 다른 프로젝트 생성 방법

**방법 2개**

	1.  **개발환경**
 	2.  **로컬**

로컬에서 프로젝트 생성하는 방법!!!!!

이클립스에서 import해서 사용



폴더를 직접 생성

그리고 src-> main 폴더를생성하고 그 아래 java와 resource 폴더 생성

그리고 편집기를 통해서 pom.xml파일을 생성 src아래에 넣음

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>spring4</groupId>
    <artifactId>testPjt001</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.1.0.RELEASE</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>utf-8</encoding>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```



## 의존 객체

### 6강 DI 의존 주입

생성자에서 주입

set에서 주입

생성자 set모두 주입 // 일반적으로 Better



**스프링에서의 의존주입**

객체는 스프링컨테이너에 있다.

스프링컨테이너 내에서 객체간의 의존을 주입한다.



### 7강 다양한 의존 객체 주입

#### 7-1 : 생성자를 이용한 의존 객체 주입

#### 7-2 : setter를 이용한 의존 객체 주입

#### 7-3 : List 타입 의존 객체 주입

#### 7-4 : Map타입 객체 주입

쌍을 이룸 / Key & Value

아직 뭔소리인지 모르겠다. ;;;;



### 8강 스프링 설정 파일 분리

방법 1 <- 더 선호하는 방법

하나의 설정파일이 무한정 길어지는 것을 막기 위해 파일을 분리

**기능별로**분리를 하고 이름을 짓는다.

applicationContext.xml -> appCtx1.xml / appCtx2.xml / appCtx3.xml

3개 들어가는데 문자열 배열 상태로 입력한다.



방법 2

appCtx1에 나머지 두개를 

<import resource = "classpath:appCtx2.xml"/>

<import resource = "classpath:appCtx3.xml"/>



##### 빈의 범위

자바에서는 호출만해서 사용 따라서 자바에서 getBean으로 참조를 두번 하면 동일한 객체를 참조,

@ **싱글톤** : 스프링 컨테이너에서 생성된 빈 객체의 경우 동일한 타입에 대해서는 기본적으로 한 개만 생성이 되며, getBean() 메소드로 호출될 때 동일한 객체가 반환 된다.



@**프로토타입** : 싱글톤 범위와 반대의 개념도 있는데 이를 프로토타입 범위라고 한다. 프로토타입의 경우 개발자는 별도로 설정해야 하는데, 스프링 설정 파일에서 빈 객체를 정의할 때 scope 속성을 명시해 주면 된다.



#### 9강 의존객체 자동 주입

#### 9-1 의존객체 자동 주입이란?

 스프링설정파일에서 의존객체를 주입할때<constructor-org> 또는<property> 태그로 의존대상 객체를명시하지 않아도스프링 컨테이너 가자동으로 필요한의존 대상객체를 찾아서의존 대상객체가 필요한객체에 주입해주는 기능이다. 구현방법은 @Autowired와@Resource 어노테이션을 이용해서 쉽게구현할수있다.

#### 9-2 @Autowired 방법 1

 주입하려는 **객체타입이 일치**하는 객체를 자동으로 주입한다.

프로퍼티와 메소드에 사용하고 싶다면 디폴트 생성자를 명시해줘야한다.

**생성자 프로퍼티 메소드**모두 사용가능



#### 9-3 @Resource 방법 2

주입하려고 하는 **객체의 이름이 일치**하는 객체를 자동으로 주입

디폴트생성자 명시해주기!!!



### 10강 의존객체 선택

어떠한 객체자 주입이 될것인지 선택

동일한 객체가 2개 이상인 경우 스프링 컨테이너는 자동주입 대상객체를 판단하지 못해서 Exception을 발생시킨다.

qualifier 태그를 사용 ㅎㅎ

@Autowried(required = false) => 빈객체가 생성되지 않으면 주입하지 않도록 Exception 피하기 위해

**@Inject**자주 사용되지는 않음 // required속성을 지원하지 않음

qualifier == named

즉,

@Inject

@Named(value = "wordDao1")



## 설정 및 구현

### 11강 생명주기

객체의 생명주기에 대한 내용

##### 11-1 스프링 컨테이너 생명주기

GenericXmlApplicationContext ctx = new GenericXmlApplicationContext ctx(경로); // 컨테이너 생성

스프링 생성시점 == 빈객체 생성시점

ctx.close(); // 컨테이너 종료 빈객체들도 제거

##### 11-2 빈 객체 생명주기

**빈 객체의 생명주기는 스프링 컨테이너의 생명주기와 같다.**

##### 11-3 init-method, destroy-method 속성

 init-method 객체가 생성될때 실행되는 // 메소드 특정한작업을 할 수 있게 해줌

destroy-method 객체가 소멸될때 실행되는 메소드 // 메소드 특정한작업을 할 수 있게 해줌



### 12-1강 어노테이션을 이용한 스프링 설정

XML 파일을 JAVA파일로 변환하기

@Configuration //java파일을 이용한다 라는 의미

@Bean

class는 반환타입으로

id는 메소드 이름으로

property는 set메소드 이용해서 값 설정

list는 ArrayList사용

map 은 Map 타입으로



### 12-2강 어노테이션을 이용한 스프링 설정

12-2-1 Java파일 분리

12-2-2 @Import 어노테이션



### 13강 웹 프로그래밍 설계 모델

##### 1. 웹프로그래밍을 구축하기 위한 설계 모델

**Model1**

이용자(for 브라우저) <-요청 -> WAS <-요청-> 데이터베이스

장점 : 개발속도가 빠르다

단점 : 하나의 html에 모든 소스가 들어가서 유지보수가 힘들다.

**Model2**

브라우저 <-요청-> WAS(컨트롤러, 서비스, DAO(데이터베이스관련) / View<JSP> ) <-요청-> 데이터베이스

MVC 방법

##### 2. 스프링 MVC 프레임워크 설계구조

DispatcherServlet 요청을 받음

HandlerMapping 알맞은 컨트롤러 선택

HandlerMapping 적합한 컨트롤러에서 알맞은 메소드 탐색

ViewResolver 적합한 JSP 뷰를 찾아줌

##### 3. DispatcherServlet 설정

web.xml에 서블릿을 매핑

##### 4. Controller 객체

@Controller

##### 5. Controller 객체 - @RequestMapping

컨트롤러 아래의 메소드에는 @RequestMapping 어노테이션을 사용한다.

##### 6. Controller 객체 - @Model 타입의 파라미터

컨트롤러에서 작업한 것을 위로 올릴때 사용

##### 7. View객체

리퀘스트에 관련된 내용



**정리**

![1562660430640](C:\Users\Owner\AppData\Roaming\Typora\typora-user-images\1562660430640.png)

 개발자의 관여가 필요한 부분      : Model View Controller
 개발자의 관여가 필요 없는 부분

 : DispatcherServlet(설정만 하면됨), HandlerMapping, Handler Adapter, ViewResolver

### 14강. 스프링 MVC 웹서비스 - 1

웹 서비스를 하기 위한 기본적인 요소들을 배우는시간

톰캣 => 서버 제공

1. 톰캣 설치
2. STS(Spring Tool Suit) 설치 //웹서비스를 쉽게 구현할 수 있도록 하는 기능
3. STS이용해서 프로젝트 생성



### 15강. 스프링 MVC 웹서비스 - 2

##### 15-1 프로젝트 전체 구조

1. java파일
2. webapp
3. resources
4. spring폴더
5. views폴더 : jsp파일 위치, 웹설정 파일(web.xml)
6. pom.xml파일(pom.xml)

##### 15-2  web.xml

DispathcerServlet이 사용자의 요청을 받는거로 하였다. 따라서 DispatcherServlet을 경로를 / 로 등록한다.



### 16강.  STS를 이용하지 않은 웹 프로젝트

1. 웹 어플 폴더 생성

main - java

main - webapp - resource

​							- WEB INF  - spring   &  views



2.  pom.xml작성
3.  web.xml작성
4.  스프링 설정 파일(servlet-context.xml) 작성
5. root-context.xml 작성
6. 컨트롤러와 뷰 작성

STS를 이용한것 뿐만 아니라 손수 만들어보면서 전체적인 흐름과 구조를 파악해야 한다.!!!!

구조를 익히기!!

![캡처](https://user-images.githubusercontent.com/40922963/62420958-a1c76780-b6d5-11e9-80a5-3e8d75645e86.JPG)

![캡처2](https://user-images.githubusercontent.com/40922963/62420960-a4c25800-b6d5-11e9-83a3-2c3061cc391b.JPG)

### 17강. Service & Dao 객체 구현

컨트롤러에서 기능하는 서비스를 구현

1. 웹 어플리 케이션 준비

web.xml에서 가장 중요한 일은 디스패처서블릿 경로를 등록하는것

뭐다 가져오기만 하네......

서비스 객체 구현 방법 3가지

1. new 연산자 이용한 service 객체 생성 및 참조 // 자바 이용
2. 빈객체 생성 -> autowired 의존 객체 자동 주입 // 빈생성 
3. @service 어노테이션을 달아주면 알아서 컨테이너에서 객체를 생성 @Repository @Resource



##### DAO 객체 구현 // 스프링 자동주입 이용

@Repository

public class ~~~~ implements ~~Dao{



@Autowired

MemberDao dao;   



### 18강. 컨트롤러 객체 구현

@RequestMapping

method -> POST OR GET

GET이 메소드의 디폴트값

POST는 명시를 해줘야한다.



파라미터를 어노테이션을 이용해서 받을 수 있따.

@RequestParam("memId") String memId

@RequestParam(value = "memPw", required = false, defaultValue = "1234") String memPw



### 19강. 컨트롤러 객체 구현

@ModelAttribute("설정이름")  Member member

뷰에서 : 설정이름.memId 등 사용가능

뷰에서 사용될 이름을 바꿀 수 있다.



ModelAtrribute가 적용된 메소드는 항상 같이 호출된다.!!



Model : 뷰에 데이터만 전달하기 위한 객체

Model & View : 데이터와 뷰를 함께 전달

![캡처](https://user-images.githubusercontent.com/40922963/62427001-30b0a000-b727-11e9-83b8-d57ad98bd70f.JPG)

실행 결과는 같다.



### 20강. 세션, 쿠키

공통점 : 클라이언트와 서버 관계를 유지

**세션 : 서버에서 관리**

**쿠키 : 클라이언트에서 관리**

HTTP : Connectionless Protocol (서버의 효율적인 유지를 위해) 



세션 사용방법 2가지

1 : HttpServletRequest / getSession()으로 세션을 얻음.

2 : HttpSesssion 

세션 객채를 얻는 방법에 차이가 있을 뿐 거의 동일



세션 삭제

session.invalidate();



### 21강. 리다이렉트, 인터셉트

리다이렉트 : 지금 페이지에서 특정 페이지로 전환하는 기능