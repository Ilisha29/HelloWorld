## 웹, HTTP, MVC

#### HTTP와 관련한 알아야할 용어들

- URL(또는 URI)
- request line
- http method
- query string
- status line
- status code



**GET, POST 사용하는 기준은?**

- GET은 Select적인 성향을 가지고 있습니다. GET은 서버에서 어떤 데이터를 가져와서 보여준다거나 하는 용도이지 서버의 값이나 상태등을 바꾸지 않습니다. 게시판의 리스트라던지 글보기 기능 같은 것이 이에 해당하죠.
- POST는 서버의 값이나 상태를 바꾸기 위해서 사용합니다. 글쓰기를 하면 글의 내용이 디비에 저장이 되고 수정을 하면 디비값이 수정이 되죠. 이럴 경우에 POST를 사용합니다.



## MVC(Model View Controller)

#### 초기 웹 개발

- PHP, JSP, ASP와 같은 기술 활용해 웹 애플리케이션 개발
- HTML과 프로그래밍 언어가 혼재되어 프로그래밍



**프레임워크의 등장**

- MVC에 대한 개념은 이해하겠는데 실제 MVC 기반으로 구현을 하는데는 많은 어려움이 있었음.
- MVC 기반으로 개발한 결과 구현할 코드량도 많아지고 개발 생산성이 떨어지는 단점이 발생함.
- 이 같은 단점을 보완하기 위해 MVC 기반 개발을 지원하는 프레임워크가 등장함.
- 또한 많은 기반 코드를 구현해 제공함으로써 개발자들이 구현할 부분을 최소화해 생산성을 높이는 효과를 가져옴.