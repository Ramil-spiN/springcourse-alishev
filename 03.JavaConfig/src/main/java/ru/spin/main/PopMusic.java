package ru.spin.main;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PopMusic implements Music {
    private List<String> songs = new ArrayList<>(Arrays.asList("Umbrella", "Rolling in the Deep", "Dancing on My Own"));

    @Override
    public int getSongsCount() {
        return songs.size();
    }

    @Override
    public String getSong(int i) {
        return songs.get(i);
    }
}
