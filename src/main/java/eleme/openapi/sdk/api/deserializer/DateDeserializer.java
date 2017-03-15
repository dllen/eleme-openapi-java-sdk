package eleme.openapi.sdk.api.deserializer;

import eleme.openapi.sdk.api.json.gson.JsonDeserializationContext;
import eleme.openapi.sdk.api.json.gson.JsonDeserializer;
import eleme.openapi.sdk.api.json.gson.JsonElement;
import eleme.openapi.sdk.api.json.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateDeserializer implements JsonDeserializer<Date> {

    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String dateTimeStr = json.getAsString();
        dateTimeStr = dateTimeStr.replace("T", " ");
        try {
            return simpleDateFormat.parse(dateTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
