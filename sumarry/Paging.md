# Paging / JPA_SpringBoot_Thymeleaf

### JpaRepository
https://github.com/Leewoowon980522/Jpa_PagingTest/blob/master/sumarry/JpaRepository.md
### Paging
+ 게시글 등을 가져올떄 가지고올 게시물이 많으면 서버로 부터 가지고올 데이터의 양이 많아지는데 그에 따라 로딩시간이 길어지기 때문에 필요한 데이터의 수를 나누어 화면에 보여주는 것

### Entity설계
```java
@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String title;
    private String content;
}
```

### 특정 데이터 가져오기