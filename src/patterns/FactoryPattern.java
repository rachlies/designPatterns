package patterns;

public class FactoryPattern {
    public static void main(String[] args) {
        PizzaFactory pepperoniPizzaFactory = new PepperoniPizzaFactory();
        PizzaFactory cheesePizzaFactory = new CheesePizzaFactory();
        System.out.println(pepperoniPizzaFactory.createPizza().text());
        System.out.println(cheesePizzaFactory.createPizza().text());
    }
}

interface Pizza {
    String text();
}

class CheesePizza implements  Pizza {
    public String text() {
        return "I am cheese Pizza!";
    }
}

class PepperoniPizza implements  Pizza {
    public String text() {
        return "I am pepperoni Pizza!";
    }
}

interface PizzaFactory {
    Pizza createPizza();
}

class PepperoniPizzaFactory implements PizzaFactory{

    @Override
    public Pizza createPizza() {
        return new PepperoniPizza();
    }
}

class CheesePizzaFactory implements PizzaFactory{

    @Override
    public Pizza createPizza() {
        return new CheesePizza();
    }
}