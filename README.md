# project-lion
## mission - 3 : challenge
### 커뮤니티 사이트에 데이터베이스 추가
아쉬운 점: 
 더 좋은 구조를 만들수 있을 거 같음🙄💦

### 관계성

![relationship](https://github.com/sodaMelon/project-lion/blob/mission-3-c/image/relationship-3-c.png?raw=true)
#### 1
- a,b: 위치정보를 담는 엔티티 Area
#### 2 
- a: User는 Area를 갖고 있어야한다. -> User-Area 1:1  (Area가 User정보를 가질 필요는 없으니 단방향맵핑)
- b : 일반 사용자 또는 상점 주인인지 분류 (깜빡함!!!!)
#### 3
- 특정 User는 Shop을 가질 수있다. -> User-Shop 0 또는 1 : 1 
- a : 어느지역 상점인지 대한 정보 메서드 Area findShopAreaByUser(Shop shop)

#### 4 
- ShopReview 와 ShopPost
- HttpSession에 저장된 로그인 세션값을 읽어와 주인만 ShopPost를 작성할 수 있게하는 메서드
ShopPost writeShopPost(HttpSession session, Shop targetShop, String ShopPost)
- 아무나 작성할수 있는 메서드 ShopReview writeShopReview(Shop targetShop, String review)


#### 세부조건
- 1. 테이블 실제 이름에 Entity 안들어가게
- 2. 변동될 가능성 고려하고 엔티티 작성하기
- 3. 엔티티를 먼저 구성하되 시간남으면 CRUD 까지
