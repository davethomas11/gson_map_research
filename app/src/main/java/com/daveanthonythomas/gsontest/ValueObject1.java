package com.daveanthonythomas.gsontest;

/**
 * Created by dave on 2016-10-28.
 */

public class ValueObject1 extends ValueObject {

    private String sound;
    private String particle;

    public ValueObject1(String sound, String particle) {
        this.sound = sound;
        this.particle = particle;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "ValueObject{" +
                "sound='" + sound + '\'' +
                ", particle='" + particle + '\'' +
                '}';
    }
}
