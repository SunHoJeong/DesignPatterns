Decorator Pattern
=================

#### Q. 여러 가지 기능을 조합해서 새로운 기능을 만들고 싶다...
어떻게 구현해야 할까?
- A. 상속을 통해 조합별 경우를 생각하여 서브 클래스를 구현?
    - 너무 많은 클래스가 만들어질 '위험' 존재
- A. 각 추가 기능별로 개별적인 클래스를 설계하고 기능을 조합할 떄 각 클래스의 객체 조합을 이용하자!
    
### 데코레이터 패턴
데코레이터 패턴은 서브 클래스를 만들어 기능을 유연하게 확장시 객체에 추가적인 요건을 동적으로 첨부함
기본 기능에 더하여 추가할 기능을 Decorator 클래스에 정의
객체의 결합을 통해 기능을 동적이고 유연하게 확장할 수 있는 패턴
-> 클래스 코드를 전혀 수정하지 않고 객체에 새로운 기능을 추가할 수 있음

#### OCP(Open-Closed Principle)
- 코드는 변경에 대해서는 '닫혀'있고 확장에 대해서는 '열려'있어야 함
- 새로운 기능을 추가하는데 유연하면서 강하고 튼튼한 디자인이 가능하기 때문


<img src="decorator.jpg" width="600" height="300" title="decorator" alt="decorator"></img>

- Component
    - 공통 operation 정의, 이 기능은 ConcreteComponent와 Decorator도 가지고 있음
- ConcreteComponent
    - 기본 기능을 구현하는 클래스
- Decorator
    - Decorator의 공통 기능 제공
- ConcreteDecoratorA, ConcreteDecoratorB
    - ConcreteDecorator 클래스는
    
<img src="decorator2.jpg" width="600" height="300" title="decorator" alt="decorator"></img>
- 도로를 표시하는 기본 기능만 필요한 경우 RoadDisplay를 이용
- 도로를 표시하는 기본 기능 + 차선을 표시하는 추가 기능이 필요한 경우 RoadDisplay와 LaneDecorator를 이용
    - 차선 표시 기능 : LaneDecorator 제공
    - 도로 표시 기능 : RoadDisplay 클래스  draw 메서드 호출(super.draw())
        - DisplayDecorator 클래스에서 Display 객체로 RoadDisplay를 참조(합성)
        
      
     



