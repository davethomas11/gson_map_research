/**
 * Copyright (c) 2016 Trader Corporation.  All rights reserved.
 * Created by Dave Thomas on 2016-10-28.
 */
package com.daveanthonythomas.gsontest;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ValueObjectDeserializer implements JsonDeserializer<ValueObject> {

    @Override
    public ValueObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject object = json.getAsJsonObject();

        if (object == null || !object.has("sound") || !object.has("particle")) {
            throw new JsonParseException("Invalid format for ValueObject: " + object.toString());
        }

        String sound = object.get("sound").getAsString();
        String particle = object.get("particle").getAsString();

        if (object.has("volume")) {

            float volume = object.get("volume").getAsFloat();

            return new ValueObject2(sound, particle, volume);
        } else {

            return new ValueObject(sound, particle);
        }
    }
}
