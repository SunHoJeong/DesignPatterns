# Template Pattern



### Template Method Pattern

메소드에서 알고리즘의 골격을 정의한다. 알고리즘의 여러 단계 중 일부는 서브클래에서 구현할 수 있다.

템플릿 메소드를 이용하면 알고리즘의 구조는 그대로 유지하면서 서브클래스에서 특정 단계를 재정의할 수 있다



```java
public abstract class CaffeinBeverage{
  //template method
  void final prepareRecipe(){
    boilWater();
    brew();
    pourInCup();
    if(customWantsCondiments()){
      addCOndiments();
    }
  }
  
  abstract brew();
  
  abstract addCOndiments();
  
  void boilWater(){
  	//...  
  }
  
  void pourInCup(){
    //...
  }
  
  //hook method 
  //Sub Class 에서 오버라이딩 가능
  boolean customWantsCondiments(){
    return true;
    //ex)Sub Class에서 재정의하여 고객에게 여부를 물어본 후 T/F 리턴 기능 
  }
}

```

- prepareRecipe() 메소드를 통해 어떤 알고리즘(순서)에 대한 템플릿(틀)을 제공
  - 코드(알고리즘)를 수정할때 용이
- prepareRecipe() 메소드를 final 키워드로 정의하여 알고리즘(순서)를 함부로 바꿀 수 없도록 제한
- Sub Class에서 공통적으로 가지고 있는 부분은 Super Class에서 직접 정의(boilWater(), pourInCup())
  - 코드 중복성 제거 -> 코드 재사용 
- Sub Class에서 각각 재정의가 필요한 부분은 abstract로 정의
  - 알고리즘의 특정 단계를 제공해야할 때 사용
- hook method 
  - 추상 클래스에서 선언되는 메소드
  - 기본적인 내용만 구현되어 있거나 아무 코드도 들어있지 않은 메소드
  - 알고리즘의 특정 부분이 선택적으로 적용될 때 여부를 판단하기 위해 사용



### 헐리우드 원칙

"먼저 연락하지 마세요. 저희가 연락 드리겠습니다."

헐리우드 원칙을 활용하면 의존성 부패를 방지할 수 있다. 저수준 구성요소에서 시스템에 접속을 할 수는 있지만

언제 어떤 식으로 그 구성요소들을 사용할지는 고수준 구성요소에서 결정한다.



#### Q. 의존성 부패(dependency rot)?

어떤 고수준 구성요소가 저수준 구성요소에 의존하고, 그 저수준 구성요소는 다시 고수준 구성요소에 의존하고,

그 고수준 구성요소는 다시 또 다른 구성요소에 의존하고... 같은 식으로 의존성이 복잡하게 꼬여있는 상황







