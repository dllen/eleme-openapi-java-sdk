/*
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eleme.openapi.sdk.api.json.gson;

import eleme.openapi.sdk.api.json.gson.internal.bind.JsonTreeReader;
import eleme.openapi.sdk.api.json.gson.internal.bind.JsonTreeWriter;
import eleme.openapi.sdk.api.json.gson.stream.JsonReader;
import eleme.openapi.sdk.api.json.gson.stream.JsonToken;
import eleme.openapi.sdk.api.json.gson.stream.JsonWriter;

import java.io.*;


public abstract class TypeAdapter<T> {


    public abstract void write(JsonWriter out, T value) throws IOException;


    public final void toJson(Writer out, T value) throws IOException {
        JsonWriter writer = new JsonWriter(out);
        write(writer, value);
    }


    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    TypeAdapter.this.write(out, value);
                }
            }

            @Override
            public T read(JsonReader reader) throws IOException {
                if (reader.peek() == JsonToken.NULL) {
                    reader.nextNull();
                    return null;
                }
                return TypeAdapter.this.read(reader);
            }
        };
    }


    public final String toJson(T value) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, value);
        } catch (IOException e) {
            throw new AssertionError(e); // No I/O writing to a StringWriter.
        }
        return stringWriter.toString();
    }


    public final JsonElement toJsonTree(T value) {
        try {
            JsonTreeWriter jsonWriter = new JsonTreeWriter();
            write(jsonWriter, value);
            return jsonWriter.get();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }


    public abstract T read(JsonReader in) throws IOException;


    public final T fromJson(Reader in) throws IOException {
        JsonReader reader = new JsonReader(in);
        return read(reader);
    }


    public final T fromJson(String json) throws IOException {
        return fromJson(new StringReader(json));
    }


    public final T fromJsonTree(JsonElement jsonTree) {
        try {
            JsonReader jsonReader = new JsonTreeReader(jsonTree);
            return read(jsonReader);
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
