package com.daveanthonythomas.gsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<KeyObject, ValueObject> map = new HashMap<>();

        KeyObject entry1Key = new KeyObject("stone", "bricks");
        ValueObject entry1Value = new ValueObject1("guitar", "guitar");

        KeyObject entry2Key = new KeyObject("dirt", "dirt");
        ValueObject entry2Value = new ValueObject2("square", "note", 0.5f);

        map.put(entry1Key, entry1Value);
        map.put(entry2Key, entry2Value);

        // http://jansipke.nl/serialize-and-deserialize-a-list-of-polymorphic-objects-with-gson/
        RuntimeTypeAdapterFactory<ValueObject> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(ValueObject.class)
                .registerSubtype(ValueObject1.class)
                .registerSubtype(ValueObject2.class);
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                .registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

        System.out.println(gson.toJson(map));

        String jsonInput = "[[{\"name\":\"dirt\",\"variant\":\"dirt\"},{\"volume\":0.5," +
                "\"particle\":\"note\",\"sound\":\"square\"}],[{\"name\":\"stone\"," +
                "\"variant\":\"bricks\"},{\"particle\":\"guitar\",\"sound\":\"guitar\"}]]";

        Type typeOfHashMap = new TypeToken<HashMap<KeyObject, ValueObject>>() { }.getType();



        HashMap<KeyObject, ValueObject> map2 = gson.fromJson(jsonInput, typeOfHashMap);

        for (Map.Entry<KeyObject, ValueObject> entry : map2.entrySet()) {

            System.out.println("Key: " + entry.getKey().toString());
            System.out.println("Value: " + entry.getValue().toString());
        }
    }
}
