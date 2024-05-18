package patterns;

interface Coffee {
    long cost();
    String text();
}

class SimpleCoffee implements Coffee {

    @Override
    public long cost() {
        return 10;
    }

    @Override
    public String text() {
        return "Plain Coffee ";
    }

}


class Espresso implements Coffee {
    @Override
    public long cost() {
        return 12;
    }

    @Override
    public String text() {
        return "Espresso ";
    }
}

class Latte implements Coffee {
    @Override
    public long cost() {
        return 15;
    }

    @Override
    public String text() {
        return "Latte ";
    }
}


abstract class CoffeeAddon implements Coffee {

    private final Coffee decoratedCoffee;

    public CoffeeAddon(Coffee decoratedCoff)  {
        this.decoratedCoffee = decoratedCoff;
    }

    @Override
    public long cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String text() {
        return decoratedCoffee.text();
    }
}


class CoffeeDecoratorWithMilk extends CoffeeAddon {
    CoffeeDecoratorWithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public long cost() {
        return super.cost() + 1;
    }

    @Override
    public String text() {
        return super.text() + " with milk";
    }
}


class CoffeeDecoratorWithSugar extends CoffeeAddon {
    CoffeeDecoratorWithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public long cost() {
        return super.cost() + 1;
    }

    @Override
    public String text() {
        return super.text() + " with sugar";
    }
}



public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        print(simpleCoffee);


        Coffee espresso = new Espresso();
        print(espresso);

        Coffee latte = new Latte();
        print(latte);

    }

    private static void print(Coffee simpleCoffee) {
        System.out.println("Cost: " + simpleCoffee.cost() + ", Description: " + simpleCoffee.text());

        Coffee simpleMilkCoffee = new CoffeeDecoratorWithMilk(simpleCoffee);
        System.out.println("Cost: " + simpleMilkCoffee.cost() + ", Description: " + simpleMilkCoffee.text());

        Coffee simpleMAndSugarCoffee = new CoffeeDecoratorWithMilk(new CoffeeDecoratorWithSugar(simpleCoffee));
        System.out.println("Cost: " + simpleMAndSugarCoffee.cost() + ", Description: " + simpleMAndSugarCoffee.text());
    }
}
