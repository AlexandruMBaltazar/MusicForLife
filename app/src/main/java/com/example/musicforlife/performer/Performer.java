package com.example.musicforlife.performer;

public class Performer {
    private String name;
    private String song;
    private String featuring;

    public Performer(String name, String song, String featuring) {
        this.name = name;
        this.song = song;
        this.featuring = featuring;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getFeaturing() {
        return featuring;
    }

    public void setFeaturing(String featuring) {
        this.featuring = featuring;
    }
}
