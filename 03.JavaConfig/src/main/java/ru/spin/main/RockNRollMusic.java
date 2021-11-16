package ru.spin.main;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component("musicBean") //id в скобках необязателен
@Component
@Scope("prototype")
public class RockNRollMusic implements Music {
    private List<String> songs = new ArrayList<>(Arrays.asList("Hound Dog", "That's all right mama", "Burning Love",
            "Are You Lonesome tonight", "Suspicious minds", "Jailhouse Rock"));

    @Override
    public int getSongsCount() {
        return songs.size();
    }

    @Override
    public String getSong(int i) {
        return songs.get(i);
    }
}
