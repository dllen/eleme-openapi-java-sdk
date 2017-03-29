/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eleme.openapi.sdk.api.json.gson;

import eleme.openapi.sdk.api.json.gson.internal.$Gson$Preconditions;
import eleme.openapi.sdk.api.json.gson.internal.Excluder;
import eleme.openapi.sdk.api.json.gson.internal.bind.TreeTypeAdapter;
import eleme.openapi.sdk.api.json.gson.internal.bind.TypeAdapters;
import eleme.openapi.sdk.api.json.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.*;

import static eleme.openapi.sdk.api.json.gson.Gson.*;


public final class GsonBuilder {
    private Excluder excluder = Excluder.DEFAULT;
    private LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
    private FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
    private final Map<Type, InstanceCreator<?>> instanceCreators
            = new HashMap<Type, InstanceCreator<?>>();
    private final List<TypeAdapterFactory> factories = new ArrayList<TypeAdapterFactory>();
    /**
     * tree-style hierarchy factories. These come after factories for backwards compatibility.
     */
    private final List<TypeAdapterFactory> hierarchyFactories = new ArrayList<TypeAdapterFactory>();
    private boolean serializeNulls = DEFAULT_SERIALIZE_NULLS;
    private String datePattern;
    private int dateStyle = DateFormat.DEFAULT;
    private int timeStyle = DateFormat.DEFAULT;
    private boolean complexMapKeySerialization = DEFAULT_COMPLEX_MAP_KEYS;
    private boolean serializeSpecialFloatingPointValues = DEFAULT_SPECIALIZE_FLOAT_VALUES;
    private boolean escapeHtmlChars = DEFAULT_ESCAPE_HTML;
    private boolean prettyPrinting = DEFAULT_PRETTY_PRINT;
    private boolean generateNonExecutableJson = DEFAULT_JSON_NON_EXECUTABLE;
    private boolean lenient = DEFAULT_LENIENT;


    public GsonBuilder() {
    }

    public GsonBuilder setVersion(double ignoreVersionsAfter) {
        excluder = excluder.withVersion(ignoreVersionsAfter);
        return this;
    }


    public GsonBuilder excludeFieldsWithModifiers(int... modifiers) {
        excluder = excluder.withModifiers(modifiers);
        return this;
    }


    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        excluder = excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }


    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }


    public GsonBuilder enableComplexMapKeySerialization() {
        complexMapKeySerialization = true;
        return this;
    }


    public GsonBuilder disableInnerClassSerialization() {
        excluder = excluder.disableInnerClassSerialization();
        return this;
    }


    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy serializationPolicy) {
        this.longSerializationPolicy = serializationPolicy;
        return this;
    }


    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy namingConvention) {
        this.fieldNamingPolicy = namingConvention;
        return this;
    }


    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... strategies) {
        for (ExclusionStrategy strategy : strategies) {
            excluder = excluder.withExclusionStrategy(strategy, true, true);
        }
        return this;
    }


    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy strategy) {
        excluder = excluder.withExclusionStrategy(strategy, true, false);
        return this;
    }


    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy strategy) {
        excluder = excluder.withExclusionStrategy(strategy, false, true);
        return this;
    }


    public GsonBuilder setPrettyPrinting() {
        prettyPrinting = true;
        return this;
    }


    public GsonBuilder setLenient() {
        lenient = true;
        return this;
    }


    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }


    public GsonBuilder setDateFormat(String pattern) {
        // TODO(Joel): Make this fail fast if it is an invalid date format
        this.datePattern = pattern;
        return this;
    }


    public GsonBuilder setDateFormat(int style) {
        this.dateStyle = style;
        this.datePattern = null;
        return this;
    }


    public GsonBuilder setDateFormat(int dateStyle, int timeStyle) {
        this.dateStyle = dateStyle;
        this.timeStyle = timeStyle;
        this.datePattern = null;
        return this;
    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    public GsonBuilder registerTypeAdapter(Type type, Object typeAdapter) {
        $Gson$Preconditions.checkArgument(typeAdapter instanceof JsonSerializer<?>
                || typeAdapter instanceof JsonDeserializer<?>
                || typeAdapter instanceof InstanceCreator<?>
                || typeAdapter instanceof TypeAdapter<?>);
        if (typeAdapter instanceof InstanceCreator<?>) {
            instanceCreators.put(type, (InstanceCreator) typeAdapter);
        }
        if (typeAdapter instanceof JsonSerializer<?> || typeAdapter instanceof JsonDeserializer<?>) {
            TypeToken<?> typeToken = TypeToken.get(type);
            factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(typeToken, typeAdapter));
        }
        if (typeAdapter instanceof TypeAdapter<?>) {
            factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) typeAdapter));
        }
        return this;
    }


    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory factory) {
        factories.add(factory);
        return this;
    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    public GsonBuilder registerTypeHierarchyAdapter(Class<?> baseType, Object typeAdapter) {
        $Gson$Preconditions.checkArgument(typeAdapter instanceof JsonSerializer<?>
                || typeAdapter instanceof JsonDeserializer<?>
                || typeAdapter instanceof TypeAdapter<?>);
        if (typeAdapter instanceof JsonDeserializer || typeAdapter instanceof JsonSerializer) {
            hierarchyFactories.add(0,
                    TreeTypeAdapter.newTypeHierarchyFactory(baseType, typeAdapter));
        }
        if (typeAdapter instanceof TypeAdapter<?>) {
            factories.add(TypeAdapters.newTypeHierarchyFactory(baseType, (TypeAdapter) typeAdapter));
        }
        return this;
    }


    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }


    public Gson create() {
        List<TypeAdapterFactory> factories = new ArrayList<TypeAdapterFactory>();
        factories.addAll(this.factories);
        Collections.reverse(factories);
        factories.addAll(this.hierarchyFactories);
        addTypeAdaptersForDate(datePattern, dateStyle, timeStyle, factories);

        return new Gson(excluder, fieldNamingPolicy, instanceCreators,
                serializeNulls, complexMapKeySerialization,
                generateNonExecutableJson, escapeHtmlChars, prettyPrinting, lenient,
                serializeSpecialFloatingPointValues, longSerializationPolicy, factories);
    }

    private void addTypeAdaptersForDate(String datePattern, int dateStyle, int timeStyle,
                                        List<TypeAdapterFactory> factories) {
        DefaultDateTypeAdapter dateTypeAdapter;
        if (datePattern != null && !"".equals(datePattern.trim())) {
            dateTypeAdapter = new DefaultDateTypeAdapter(datePattern);
        } else if (dateStyle != DateFormat.DEFAULT && timeStyle != DateFormat.DEFAULT) {
            dateTypeAdapter = new DefaultDateTypeAdapter(dateStyle, timeStyle);
        } else {
            return;
        }

        factories.add(TreeTypeAdapter.newFactory(TypeToken.get(Date.class), dateTypeAdapter));
        factories.add(TreeTypeAdapter.newFactory(TypeToken.get(Timestamp.class), dateTypeAdapter));
        factories.add(TreeTypeAdapter.newFactory(TypeToken.get(java.sql.Date.class), dateTypeAdapter));
    }
}
