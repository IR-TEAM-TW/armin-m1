package edu.ws2024.cXX.am.data;

import androidx.annotation.Nullable;

import java.util.List;

public class Artist {
    @Nullable
    private int image;
    @Nullable
    private String name;
    @Nullable
    private int birth;
    @Nullable
    private int death;
    @Nullable
    private List<Integer> images;

    public Artist(int image, @Nullable String name, int birth, int death, @Nullable List<Integer> images) {
        this.image = image;
        this.name = name;
        this.birth = birth;
        this.death = death;
        this.images = images;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    @Nullable
    public List<Integer> getImages() {
        return images;
    }

    public void setImages(@Nullable List<Integer> images) {
        this.images = images;
    }
}
