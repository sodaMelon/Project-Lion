# project-lion
## mission - 3 : challenge
- [★챌린지과제 말고 베이직과제(미션3)를 확인하고 싶다면?! 링크 클릭 !!!!](https://github.com/sodaMelon/project-lion/tree/mission-3)
- (※ 서로 다른 브랜치에 있을뿐... 미션3은 베이직/챌린지 둘다 했습니다.. )
### 목적을 가진 커뮤니티 사이트 만들기
아쉬운 점: 
 더 좋은 구조를 만들수 있을 거 같음🙄💦

### 관계성

![relationship](https://github.com/sodaMelon/project-lion/blob/mission-3-c/image/relationship-3-c.png?raw=true)
#### 1
- a,b: 위치정보를 담는 엔티티 Area
#### 2 
- a: User는 Area를 갖고 있어야한다. -> User-Area 1:1  (Area가 User정보를 가질 필요는 없으니 단방향맵핑)
- b : 일반 사용자 또는 상점 주인인지 분류 User의 boolean Shopkeeper (일반 사용자일때 false, 상점주인일때 true)
#### 3
- 특정 User는 Shop을 가질 수있다. -> User-Shop 0 또는 1 : 1 
- a : 어느지역 상점인지 대한 정보 메서드 Area findShopAreaByUser(Shop shop)

#### 4 
- ShopReview 와 ShopPost
- HttpSession에 저장된 로그인 세션값을 읽어와 주인만 ShopPost를 작성할 수 있게하는 메서드
ShopPost writeShopPost(HttpSession session, Shop targetShop, String ShopPost)
- 아무나 작성할수 있는 메서드 ShopReview writeShopReview(Shop targetShop, String review)


#### 세부조건 
- 1. 테이블 실제 이름에 Entity 안들어가게 -> yes
- 2. 변동될 가능성 고려하고 엔티티 작성하기 -> yes(자신없음..)
- 3. 엔티티를 먼저 구성하되 시간남으면 CRUD 까지 -> 하는중(필수사항은 아니라서 고민 좀더 해보는중)
