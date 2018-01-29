package com.jftshop.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by ThinkPad on 2017/6/25.
 */
public class DateConverter implements JsonSerializer<Date> {


    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null ) {
            return new JsonPrimitive("");
        } else {
            return new JsonPrimitive( JFTStringUtils.date2String( src )  );
        }
    }
}
