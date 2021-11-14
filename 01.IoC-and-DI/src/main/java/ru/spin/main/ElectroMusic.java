package main.java.ru.spin.main;

public class ElectroMusic implements Music {
    private String singer;

    private ElectroMusic() {}

    public static ElectroMusic getElectroMusic() { //Фабричный метод
        return new ElectroMusic();
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void doInit() {
        System.out.println("Electro Initialization");
    }

    public void doDestroy() {
        System.out.println("Electro Destruction");
    }

    @Override
    public String getSong() {
        return "Rock Your Body";
    }
}
