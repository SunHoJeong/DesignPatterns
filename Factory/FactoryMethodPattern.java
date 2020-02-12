
public class FactoryMethodPattern {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        Pizza pizza = nyStore.createPizza("cheese");
        System.out.println("snow ordered a " + pizza.getName());
    }
}

abstract class PizzaStore{
    public Pizza orderPizza(String type){
        Pizza pizza;

        //객체 생성을 서브 클래스에게 위임
        //수퍼 클래스에서는 어떤 피자가 만들어지는지 알 수 없다
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

class NYPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }
        else if(type.equals("peperoni")){
            return new NYStylePeperoniPizza();
        }
        ...
    }
}

abstract class Pizza{
    String name;
    String dough;
    String sauce;

    void prepare(){
        System.out.println(name);
        System.out.println(dough);
        System.out.println(sauce);
    }

    void bake(){};
    void cut(){};
    void box(){};
    void getName(){};
    //추상 클래스에서 공통 작업들을 정의
}

class NYStyleCheesePizza extends Pizza{
    public NYStyleCheesePizza(){
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinra Sauce";
        //서브 클래스마다 특징을 구현
    }
}
