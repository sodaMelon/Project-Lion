# project-lion
## Basic Mission
### 커뮤니티 사이트에 데이터베이스 추가
아쉬운 점: 캡슐화 안됨, 로그인에 세션사용(※jwt를 세션스토리지나 쿠키에 저장하는 것이 좋은 방법이다.)

### 관계성

- ![relationship](https://github.com/sodaMelon/project-lion/blob/mission-3/image/relationship.png)
Post는 1개의 User, 1개의 Board가 필요하다 (Post는 User와 Board에 의존성을 가진다. 그러나 다른 둘은 타 객체에 의존성을 가지지 않는다-> 단방향 맵핑)
1개의 Board는 M개의 Post를 가질 수 있다 (Board-Post 는 1:M)
1개의 User는 N개의 Post를 가질 수 있다. (User-Post는 1:N)

### 1) 글쓰기를 위한 기본 Board 세팅 (Board create)

- ![make-boards](https://github.com/sodaMelon/project-lion/blob/mission-3/image/1.jpg)
4개의 게시판이 생성되었음

### 2) 글쓰기를 위한 기본 유저 생성 (User crate)
- ![make-user](https://github.com/sodaMelon/project-lion/blob/mission-3/image/2.jpg)

### 3)로그인(User read)
- ![login](https://github.com/sodaMelon/project-lion/blob/mission-3/image/login.jpg)
 세션에 User정보를 저장한후, 필요할때마다 꺼내쓴다.

### 4)현재 로그인한 아이디로 글쓰기 (Post create & write)
- ![write](https://github.com/sodaMelon/project-lion/blob/mission-3/image/writeToBoard.jpg)

