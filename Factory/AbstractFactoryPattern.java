public class AbstractFactoryPattern {
    public static void main(String[] args) {
        PizzaStore NYStore = new NYPizzaStore();
        Pizza pizza = NYStore.createPizza("cheese");
    }
}

abstract class Pizza{
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    ...

    abstract void prepare();

    void bake(){};
    void cut(){};
    void box(){};
    void getName(){};
    void setName(){};
    //prepare를 제외하고 바뀌지 않음
}

class CheesePizza extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    //지역별 맞춤 factory를 사용
    public CheesePizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    void prepare(){
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        //factory를 호출해서 원자재를 얻음
    }
}

class NYPizzaStore extends PizzaStore{
    protected Pizza createPizza(String type){
        Pizza pizza;
        //NY style 피자 원재료를 공급해주기 위해
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if(type.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("NY Style Cheese Pizza!");
        }
        else if(){
            ...
        }

        return pizza;
    }
}

abstract class PizzaIngredientFactory{
    abstract Dough createDough();
    abstract Sauce createSauce();
    abstract Cheese createCheese();
}

class NYPizzaIngredientFactory extends PizzaIngredientFactory{

    @Override
    Dough createDough() {
        return new NYDough();
    }

    @Override
    Sauce createSause() {
        return new NYSauce();
    }

    @Override
    Cheese createCheese() {
        return new NYCheese();
    }
}
