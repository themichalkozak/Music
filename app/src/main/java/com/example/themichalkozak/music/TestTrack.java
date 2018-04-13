package com.example.themichalkozak.music;

/**
 * Created by themichalkozak on 12/04/2018.
 */

public class TestTrack {

    private String name;
    private int resources;

    public TestTrack(String name, int resources) {
        this.name = name;
        this.resources = resources;
    }

    public String getName() {
        return name;
    }

    public int getResources() {
        return resources;
    }
}
