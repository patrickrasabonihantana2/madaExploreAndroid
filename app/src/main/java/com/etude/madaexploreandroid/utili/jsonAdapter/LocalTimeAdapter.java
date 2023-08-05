package com.etude.madaexploreandroid.utili.jsonAdapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter implements JsonSerializer<LocalTime> {

    public JsonElement serialize(LocalTime time, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
}
