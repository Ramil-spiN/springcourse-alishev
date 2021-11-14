package ru.spin.main;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ElectroMusic implements Music {
    private List<String> songs = new ArrayList<>(Arrays.asList("Rock Your Body", "Electric City", "Supersonic"));

    @Override
    public String getSong(int i) {
        return songs.get(i);
    }
}
