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
        ValueObject entry1Value = new ValueObject("guitar", "guitar");

        KeyObject entry2Key = new KeyObject("dirt", "dirt");
        ValueObject entry2Value = new ValueObject2("square", "note", 0.5f);

        Blocks blocks = new Blocks();
        blocks.addBlock(entry1Key, entry1Value);
        blocks.addBlock(entry2Key, entry2Value);

        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

        System.out.println(gson.toJson(blocks));

        String jsonInput = "{\"blocks\":[[{\"name\":\"dirt\",\"variant\":\"dirt\"},{\"volume\":0.5," +
                "\"particle\":\"note\",\"sound\":\"square\"}],[{\"name\":\"stone\"," +
                "\"variant\":\"bricks\"},{\"particle\":\"guitar\",\"sound\":\"guitar\"}]]}";

        Type typeOfHashMap = new TypeToken<HashMap<KeyObject, ValueObject>>() { }.getType();

        gson = new GsonBuilder().enableComplexMapKeySerialization()
                .registerTypeAdapter(ValueObject.class, new ValueObjectDeserializer())
                .create();


        Blocks blocks2 = gson.fromJson(jsonInput, Blocks.class);

        for (Map.Entry<KeyObject, ValueObject> entry : blocks2.getBlocks().entrySet()) {

            System.out.println("Key: " + entry.getKey().toString());
            System.out.println("Value: " + entry.getValue().toString());
        }
    }
}
