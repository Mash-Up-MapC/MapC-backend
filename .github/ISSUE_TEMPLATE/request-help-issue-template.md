---
name: Request Help issue template
about: Describe Request Help

---

# Q. `<Issue Title>`

> FIXME: Describe the task in free format
> 육하원칙에 따른 자세한 설명일수록 좋다
* `<something task description>`


## Issue
```
FIXME: fill source code or log
...
```

## Expected Result
> FIXME: Describe the expected result
* `<something>`

<br>

## Actual Result
> FIXME: Describe the actual result
* `<something>`

<br> 

## relate to issue
> FIXME: Describe relate to issue
* `<issue title> <#issue number>`

<br>

> #### Reference
> FIXME: fill reference link
> * `[title](link)`

---

<br>

## Check List
- [ ] issue 제목은 유의미한가?
- [ ] issue 내용은 issue 내용만 확인하고도 모르는 사람도 파악할 수 있을 정도로 기술되었는가? (무엇을, 언제, 어디서...)
- [ ] reference가 있다면 추가했는가?
- [ ] 관련 issue가 있다면 추가했는가?
- [ ] 유의미한 Label을 추가했는가?
- [ ] Assginees를 추가했는가?
- [ ] Estimate를 추가했는가?
- [ ] 관련 Milestone이 있다면 추가했는가?
- [ ] 관련 Epics가 있다면 추가했는가?

---

<br>

> FIXME: Remove below example content
# Example

# Q. JPA에서 단건 조회가 왜 안되나요?

## Issue
* [JPA / Hibernate One to Many Mapping Example with Spring Boot](https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/)를 보고 mapping한 후 단건 조회를 했는데 아래와 같은 문제가 발생합니다
* commit: #56fd24
```java
java.lang.RuntimeException: Unable to instantiate application com.example.test
at java.lang.reflect.Method.invokeNative(Method.java)
at java.lang.reflect.Method.invoke(Method.java:515)
...

public class Product {

    @Id
    private Long productId;

    @ManyToOne
    private User user;
    ...
}
```

<br>

## Expected Result
* 상품 ID로 단건의 상품을 조회하고 싶어요

<br>

## Actual Result
* 아래 stacktrace의 RuntimeException 발생
```java
java.lang.RuntimeException: Unable to instantiate application com.example.test
at java.lang.reflect.Method.invokeNative(Method.java)
at java.lang.reflect.Method.invoke(Method.java:515)
...
```

<br>

## relate to issue
* 상품 단건 조회 API 구현 #15

<br>

> #### Reference
> [JPA / Hibernate One to Many Mapping Example with Spring Boot](https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/)

---

<br>

## Check List
- [x] issue 제목은 유의미한가?
- [x] issue 내용은 issue 내용만 확인하고도 모르는 사람도 파악할 수 있을 정도로 기술되었는가? (무엇을, 언제, 어디서...)
- [x] reference가 있다면 추가했는가?
- [x] 관련 issue가 있다면 추가했는가?
- [x] 유의미한 Label을 추가했는가?
- [x] Assginees를 추가했는가?
- [ ] Estimate를 추가했는가?
- [ ] 관련 Milestone이 있다면 추가했는가?
- [x] 관련 Epics가 있다면 추가했는가?
