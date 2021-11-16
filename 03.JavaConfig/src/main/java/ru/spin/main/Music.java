package ru.spin.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Music {
    List<String> songs = new ArrayList<>(Arrays.asList("No songs in genre"));
    String getSong(int i);
    int getSongsCount();
}
