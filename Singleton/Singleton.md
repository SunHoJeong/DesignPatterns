Singleton Pattern

==============

특정 클래스에 대해서 객체 인스턴스가 하나만 만들어지고 

어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴



하나의 객체 생성만이 필요한 것들이 있다

Thread Pool, Cache, 설정 객체..와 같은 것들이다

위에와 같은 것들은 객체가 여러개 존재한다면 혼란스러울 수 있다

그렇다면 객체를 하나만 만들어서 좋을점이 뭐가 있을까?

- 일관성
- 자원 사용의 효율성



#### 전역변수

전역 변수는 애플리케이션이 시작될 때 객체가 생성된다

- 불필요한 자원을 잡아먹는 자원 사용의 비효율성



전역변수의 문제점을 갖지 않는 싱글톤 패턴을 더 알아보자



#### 고전적인 싱글턴 패턴

```
public class Singleton{
	private static Singleton instance;
  
  private Singleton(){}
  
  //public이므로 어디서든 접근 가능
  //static으로 선언하여 Singleton.getInstance()로 외부에서 접근 가능
  public static Singleton getInstance(){
  	if(instance == null){
  	//lazy instantiation
  		instance = new Singleton();
  	}
  	return instance;
  }
}
```



하지만 멀티 쓰레드 환경에서 이 코드를 사용한다면?

A thread에서 객체가 null임을 확인하고 객체를 생성하기 전에

B trhead에서도 객체가 null임을 확인하여 객체 생성 로직을 탔다면?

--> 두개의 다른 객체가 생성됨으로써 Singleton 패턴 정의와 맞지 않는 상황이 발생한다



#### 멀티 쓰레딩 문제 해결

```
//synchronized 키워드를 추가하여 멀티 쓰레딩 문제를 해결
public static synchronized Singleton getInstance(){
  	if(instance == null){
  		instance = new Singleton();
  	}
  	return instance;
  }
```

위의 코드는 멀티 쓰레딩에서 발생하는 문제를 해결하였지만

너무 큰 부분을 동기화 블럭으로 잡고 있어서 효율성에 문제가 있습니다

즉, 오버헤드가 너무 많이 발생합니다



#### 더 효율적인 방법?

1. getInstance()의 속도가 그리 중요하지 않다면 그냥 둔다
   하지만 메소드를 동기화하면 성능이 100배 정도 저하됨을 기억!

2. 인스턴스를 필요할 때 생성하지 말고 처음부터 만들기

   ```
   public class Singleton{
   	//static 변수를 초기화할 때 인스턴스를 생성
   	private static Singleton instance = new Singleton();
   	
   	public static Singleton getInstance(){
   		return instance;
   	}
   }
   ```

   

3. DCL(Double-Checking Locking)을 써서 getInstance()에서 동기화되는 부분을 줄인다

   ```
   public class Singleton{
   	private volitile static Singleton instance;
     
     private Singleton(){}
     
     public static Singleton getInstance(){
     	// instance를 확인하고 없으면 동기화 블럭 안으로
     	if(instance == null){
     		synchronized(Singleton.class){
     			if(instance == null){
     				instance = new Singleton();
     			}
     		}
     	}
     	return instance;
     }
   }
   ```

   



