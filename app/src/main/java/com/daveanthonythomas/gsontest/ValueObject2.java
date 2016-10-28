package com.daveanthonythomas.gsontest;

/**
 * Created by dave on 2016-10-28.
 */

public class ValueObject2 extends ValueObject1 {

    private float volume;

    public ValueObject2(String sound, String particle, float volume) {
        super(sound, particle);
        this.volume = volume;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "ValueObject2{" +
                "volume=" + volume +
                '}';
    }

    public void getPolymorphismTypeAdapter() {

    }
}
