package com.daveanthonythomas.gsontest;

/**
 * Created by dave on 2016-10-28.
 */

public class ValueObject {

    private String sound;
    private String particle;

    public ValueObject(String sound, String particle) {
        this.sound = sound;
        this.particle = particle;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getParticle() {
        return particle;
    }

    public void setParticle(String particle) {
        this.particle = particle;
    }

    @Override
    public String toString() {
        return "ValueObject{" +
                "sound='" + sound + '\'' +
                ", particle='" + particle + '\'' +
                '}';
    }
}
