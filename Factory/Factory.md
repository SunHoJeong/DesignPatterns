Factory Pattern
===============

```java
//interface 형식에 concrete class를 인스턴스를 담다
Duck duck = new MallardDuck();


---------------------------------------------

//확장이 필요할 때 코드를 다시 확인하고
//추가 또는 제거를 해야하는 '변화에 닫힌 코드'
Duck duck;
if(picnic){
    duck = new MallardDuck();
} else if(hunting){
    duck = new DecoyDuck();
}
...

```

바뀔수 있는 부분과 바뀌지 않는 부분을 분리하여 캡슐화하자
캡슐화가 필요한 객체 생성 부분을 Factory 클래스에게 위임한다

```java
public Pizza orderPizza(String type){
    Pizza pizza;
    
    if(type.equals("cheese")){
        pizza = new CheesePizza();
    }else if(type.equals("greek")){
        pizza = new GreekPizaa();
    }
    ...// 바뀌는 부분 -> 캡슐화 필요
    
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    ...// 안바뀌는 부분
}
```


```java
public class PizzaStore{
    SimplePizzaFactory factory;
    public PizzaStore(SimplePizzaFactory factory){
        this.factory = factory;
    }
    
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = factory.createPizza(type);
        
        ...
    }
}
```

factory 객체를 통해 객체 생성 부분을 '캡슐화'는 OK
하지만, 지점별로 그 지역의 특성과 입맛을 반영해야한다면?
- NYPizzaFactory
- ChicagoPizzaFactory
와 같이 지역별 factory를 구현해줘야 한다!

```java
NYPizzaFactory nyfactory = new NYPizzaFactory();
PizzaStore nyStore = new PizzaStore(NYFactory); // 생성자로 NYfactory를 넘겨주어 지역별 입맛 반영
nyStore.order("cheese");
``` 

피자를 만드는 활동 자체는 전부 PizzaStore 클래스에 국한 시키고
분점마다 고유의 스타일을 살릴 수 있는 방법이 뭘까?


#### 팩토리 메소드 패턴
객체를 생성하기 위해 인터페이스를 정의하고, 객체 생성의 책임을 서브 클래스에게 위임한다.

```java
public abstract class PizzaStore{
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);
            
        pizza.prepare();
        pizza.bake(); // 공통 작업
         ...
        return pizza;
    }
    protected abstract Pizza createPizza(String type);//서브클래스에게 객체 생성을 위임
}
```
팩토리 메소드는 객체 생성을 처리하며, 팩토리 메소드를 이용하면 객체를 생성하는 작업을
서브클래스에 캡슐화시킬 수 있다. 이로써 수퍼클래스의 공통 코드와 서브클래스의 객체 생성 코드를 분리시킬 수 있다. 

#### 추상 팩토리 패턴
인터페이스를 이용하여 서로 연관된 또는 의존하는 객체를 구상(concrete) 클래스를 지정하지 않고 생성할 수 있다

#### 팩토리 메소드 패턴과 추상 팩토리 패턴의 공통점
- 객체 생성 캡슐화(코드 분리)
- Template Method Pattern을 사용

#### 팩토리 메소드 패턴과 추상 팩토리 패턴의 차이점
- 팩토리 메소드 패턴 : 클라이언트 코드와 인스턴스를 생성하는 구상 클래스를 분리시켜야할 때
- 추상 팩퇼 패턴 : 클라이언트에서 서로 연관된 일련의 제품을 만들때