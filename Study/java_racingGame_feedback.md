# 자동차 경주 게임 피드백

### 테스트하기 쉬운 코드란?

- 테스트 장애물이 적은 코드를 말한다.

불확실성(랜덤값)의 값 혹은 부수효과(전역 변수)를 주는 데이터는 테스트 하기 어렵다.

**순수함수**는 불확실성과 부수효과가 없는 함수를 의미하며 테스트하기 쉽다.

**반환 값** 또한 반환 값이 없는 함수 보다 있는 함수가 테스트에 용이하다.



결국 테스트하기 쉬운 코드를 개발하려면 위에 적은 **테스트하기 어려운 장애물들을 분리**하는 최대한 분리하는 것이 중요하다.( 현실적으로는 공존 상태 )



```java
public class Car {
    private static final int FORWARD_NUM = 4;

    private int position;

    [...]  
// 나의 생각 : getRandomNo()메소드를 다른 클래스로 분리하고, move()함수에는 랜덤 값을 매개변수로 준다.
    public void move() { //사용시에 move(anotherClass.getRandomNo())
        if (getRandomNo() >= 4)
            this.position++;
    }

    public int getRandomNo() { //another클래스로 리팩토링
        Random random = new Random();
        return random.nextInt(10);
    }
}
```

### 프로덕션 코드 리뷰

---

### code convention, format 맞추기

클린코드 혹은 가독성을 위해 항상 주의해야 하는 부분이다.

**공백 라인**도 문맥 분리를 위해 사용해야한다.

**space**도 고려 해야 한다. // intelliJ는 `ctrl+alt+l`를 수시로 해주자!

**이름 짓기**도 이름만 보면 어떤 역할을 하는 것인지 바로 알 수 있도록 하자.



### 객체의 상태 접근을 제한한다.

- 객체 인스턴스 변수에 바로 접근하지 않고(private로 선언) 메소드를 통해서 접근 하도록 한다.



### 인스턴스 변수의 수를 최소화한다.

 변수가 많은게 좋은것이 아니다. 중복되는 기능을 가진 인스턴스 변수가 있다면 제거해 줘야 한다.



### getter와 setter 메소드 사용을 최대한 자제하자.



### 상태 데이터를 get하지 말고 메시지를 보내라.

**tell don't ask**를 의미한다!!!!!!!!!



### Collection 활용 로직 처리

Arrays.sort() 이런것을 활용하라는 말인 것 같다. 이렇게 이미 짜여진 로직이 없을 때만 직접 구현하라는 의미로 받아 드려진다.



### 적정 test수준을 생각하자.



### MVC

클래스 분리 할 때 항상 이 클래스가 MVC패턴구조(Model, View, Controller)에 어디에 속할지 잘 생각하고 분리하자.