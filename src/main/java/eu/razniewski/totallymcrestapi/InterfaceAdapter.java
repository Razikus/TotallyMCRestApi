/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 *
 * @author adamr
 */
public class InterfaceAdapter implements JsonSerializer, JsonDeserializer {
    private static final String CLASSNAME = "CLASSNAME";
    private static final String DATA = "DATA";

        public Class getObjectClass(String className) {
            try {
                return Class.forName(className);
                } catch (ClassNotFoundException e) {
                    //e.printStackTrace();
                    throw new JsonParseException(e.getMessage());
                }
        }

    @Override
    public JsonElement serialize(Object t, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASSNAME, t.getClass().getName());
        jsonObject.add(DATA, jsc.serialize(t));
        return jsonObject;
    }

    @Override
    public Object deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = je.getAsJsonObject();
            JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
            String className = prim.getAsString();
            Class klass = getObjectClass(className);
                return jdc.deserialize(jsonObject.get(DATA), klass);
    }
    
}
