package main.java.ru.spin.main;

public class RockNRollMusic implements Music {
    public void doInit() {
        System.out.println("RockNRoll Initialization");
    }

    public void doDestroy() {
        System.out.println("RockNRoll Destruction");
    }

    @Override
    public String getSong() {
        return "Hound Dog";
    }
}
