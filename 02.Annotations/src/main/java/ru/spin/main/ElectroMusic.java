package ru.spin.main;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class ElectroMusic implements Music {
    private List<String> songs = new ArrayList<>(Arrays.asList("Rock Your Body", "Electric City", "Supersonic"));

    @PostConstruct
    public void doInit() { //Не должно быть аргументов, любой тип, любое название
        System.out.println("Electro init");
    }

    @PreDestroy
    private int doDestroy() { //Не должно быть аргументов, любой тип возвращаемого значения, любое название
        System.out.println("Electro destroy");
        return 0;
    }

    @Override
    public String getSong(int i) {
        return songs.get(i);
    }
}
