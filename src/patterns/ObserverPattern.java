package patterns;


import java.util.ArrayList;
import java.util.List;

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

interface Observer {
    void update();
}

class CurrentConditionsDisplay implements Observer {

    @Override
    public void update() {
        System.out.println("Got a update for current conditions display!");
    }
}

class StatisticsDisplay implements Observer {

    @Override
    public void update() {
        System.out.println("Got a update for statistics display!");
    }
}

class WeatherStation implements Subject {
    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }
}

public class ObserverPattern {

    public static void main(String[] args) {
        Observer currentConditionsDisplay = new CurrentConditionsDisplay();
        Observer statisticsDisplay = new StatisticsDisplay();

        Subject weatherStation = new WeatherStation();
        weatherStation.addObserver(currentConditionsDisplay);
        weatherStation.addObserver(statisticsDisplay);

        weatherStation.notifyObserver();

        weatherStation.removeObserver(currentConditionsDisplay);
        weatherStation.notifyObserver();

    }

}
