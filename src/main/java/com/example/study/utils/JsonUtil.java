package com.example.study.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json 处理工具类.
 *
 * @author 尹俊峰
 * @date 2017年3月17日
 * @since 2.1.1
 */
public final class JsonUtil {

    private static final LogUtil LOGGER = LogUtil.newInstance(JsonUtil.class);

    private static final JsonParser parser = new JsonParser();

    private static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .registerTypeAdapter(LocalDateTime.class,
                    (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) -> new JsonPrimitive(
                            src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
            .registerTypeAdapter(LocalDate.class,
                    (JsonSerializer<LocalDate>) (src, typeOfSrc, context) -> new JsonPrimitive(
                            src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
            .registerTypeAdapter(LocalDateTime.class,
                    (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                            LocalDateTime
                                    .parse(json.getAsJsonPrimitive().getAsString(),
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
            .registerTypeAdapter(LocalDate.class,
                    (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) ->
                            LocalDate.parse(json.getAsJsonPrimitive().getAsString(),
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd")))
            .create();

    /**
     * Object对象转换成json字符串.
     *
     * @param obj 被转换对象
     * @return json字符串
     */
    public static String toJsonString(Object obj) {
        try {
            return GSON.toJson(obj);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * json 字符串转换成为 Json 对象.
     *
     * @param json 目标json串
     * @return json对象
     */
    public static JsonObject toJsonObject(String json) {
        try {
            return parser.parse(json).getAsJsonObject();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new JsonObject();
        }
    }

    /**
     * Object 转换成为 Json 对象.
     *
     * @param obj 对象
     * @return json对象
     */
    public static JsonObject toJsonObject(Object obj) {
        try {
            JsonElement je = GSON.toJsonTree(obj);
            return je.isJsonNull() ? new JsonObject() : je.getAsJsonObject();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new JsonObject();
        }
    }

    /**
     * Object 转换成为 Json 对象.
     *
     * @param obj 对象
     * @return json对象
     */
    public static JsonElement toJsonElement(Object obj) {
        try {
            return GSON.toJsonTree(obj);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * json 字符串转换成为 Json 数组对象.
     *
     * @param json 格式字符串
     * @return Json数组
     */
    public static JsonArray toJsonArray(String json) {
        try {
            JsonElement je = parser.parse(json);
            return je.isJsonArray() ? je.getAsJsonArray() : new JsonArray();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new JsonArray();
        }
    }

    /**
     * Object 转换成为 Json 数组对象.
     *
     * @param obj 目标对象
     * @return Json数组
     */
    public static JsonArray toJsonArray(Object obj) {
        try {
            JsonElement je = GSON.toJsonTree(obj);
            return je.isJsonArray() ? je.getAsJsonArray() : new JsonArray();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new JsonArray();
        }
    }

    /**
     * json 字符串转换成为指定对象.
     *
     * @param json json格式字符串
     * @param clazz 指定类型对象
     * @return 指定类型对象
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return GSON.fromJson(json, clazz);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * JsonElement 转换成为指定对象.
     *
     * @param json JsonElement
     * @param type 指定类型对象
     * @return 指定类型对象
     */
    public static <T> T toObject(String json, TypeToken<T> type) {
        try {
            return GSON.fromJson(json, type.getType());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * JsonElement 转换成为指定对象.
     *
     * @param element JsonElement
     * @param clazz 指定类型
     * @return 指定类型对象
     */
    public static <T> T toObject(JsonElement element, Class<T> clazz) {
        return toObject(element.toString(), clazz);
    }

    /**
     * JsonElement 转换成为指定对象.
     *
     * @param element JsonElement
     * @param type 指定类型
     * @return 指定类型对象
     */
    public static <T> T toObject(JsonElement element, TypeToken<T> type) {
        return toObject(element.toString(), type);
    }

    /**
     * JsonObject 转换成为指定对象.
     *
     * @param jsonObj JsonObject
     * @param clazz 指定类型对象
     * @return 指定类型对象
     */
    public static <T> T toObject(JsonObject jsonObj, Class<T> clazz) {
        return toObject(jsonObj.toString(), clazz);
    }

    /**
     * JsonObject 转换成为指定对象.
     *
     * @param jsonObj JsonObject
     * @param type 指定类型对象
     * @return 指定类型对象
     */
    public static <T> T toObject(JsonObject jsonObj, TypeToken<T> type) {
        return toObject(jsonObj.toString(), type);
    }

    /**
     * json 字符串转换成为map.
     *
     * @param json 格式字符串
     * @return Map<K               ,                               V>
     */
    public static <K, V> Map<K, V> toMap(String json) {
        try {
            return GSON.fromJson(json, new TypeToken<Map<K, V>>() {
            }.getType());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new HashMap<>();
        }
    }

    /**
     * json字符串转换成为map.
     *
     * @param json 格式字符串
     * @return Map<K               ,                               V>
     */
    public static <K, V> Map<K, V> toMap(String json, Type type) {
        try {
            return GSON.fromJson(json, type);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new HashMap<>();
        }
    }

    /**
     * 转换为 {@code Map<string,string>}.
     */
    public static Map<String, String> toStringMap(String json) {
        Map<String, String> paramMap = new HashMap<String, String>();
        JsonObject jObj = toJsonObject(json);
        for (Map.Entry<String, JsonElement> entry : jObj.entrySet()) {
            if (entry.getValue().isJsonNull()) {
                // "key":null 时，null 序列化出来变为 JsonNull 对象
                continue;
            }
            if (entry.getValue() instanceof JsonArray) {
                paramMap.put(entry.getKey(), entry.getValue().getAsJsonArray().toString());
            } else if (entry.getValue() instanceof JsonObject) {
                paramMap.put(entry.getKey(), entry.getValue().getAsJsonObject().toString());
            } else {
                paramMap.put(entry.getKey(), entry.getValue().getAsString());
            }
        }
        return paramMap;
    }

    /**
     * JsonObject转换成为map.
     *
     * @param element json元素
     * @return {@code Map<K, V>}
     */
    public static <K, V> Map<K, V> toMap(JsonElement element) {
        return toMap(element.toString());
    }

    /**
     * JsonObject转换成为map.
     *
     * @param jsonObj json对象
     * @return {@code Map<K, V>}
     */
    public static <K, V> Map<K, V> toMap(JsonObject jsonObj) {
        return toMap(jsonObj.toString());
    }

    /**
     * json字符串转换成为list.
     *
     * @param json 格式字符串
     * @return List<T>
     */
    public static <T> List<T> toList(String json) {
        try {
            List<T> result = GSON.fromJson(json, new TypeToken<List<T>>() {
            }.getType());
            return result == null ? new ArrayList<>() : result;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * json字符串转换成为list.
     *
     * @param json 格式字符串
     * @param type 返回值类型
     * @return List<T>
     */
    public static <T> List<T> toList(String json, TypeToken<List<T>> type) {
        try {
            List<T> result = GSON.fromJson(json, type.getType());
            return result == null ? new ArrayList<>() : result;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * JsonElement转list.
     *
     * @param element json元素
     * @return {@code List<T>}
     */
    public static <T> List<T> toList(JsonElement element) {
        return toList(element.toString());
    }

    /**
     * JsonElement转list.
     *
     * @param element json元素
     * @param type 返回值类型
     * @return List<T>
     */
    public static <T> List<T> toList(JsonElement element, TypeToken<List<T>> type) {
        return toList(element.toString(), type);
    }

    /**
     * JsonObject转list.
     *
     * @param jsonObj json对象
     * @return {@code List<T>}
     */
    public static <T> List<T> toList(JsonObject jsonObj) {
        return toList(jsonObj.toString());
    }

    /**
     * JsonObject转list.
     *
     * @param jsonObj json对象
     * @param type 返回值类型
     * @return List<T>
     */
    public static <T> List<T> toList(JsonObject jsonObj, TypeToken<List<T>> type) {
        return toList(jsonObj.toString(), type);
    }

    /**
     * get JsonObject from JsonObject.
     *
     * @return JsonObject
     */
    public static JsonObject getJsonObject(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsJsonObject() : new JsonObject();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new JsonObject();
        }
    }

    /**
     * get JsonArray from JsonObject.
     *
     * @return JsonArray
     */
    public static JsonArray getJsonArray(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && jsonObj.get(memberName).isJsonArray() ?
                    jsonObj.get(memberName).getAsJsonArray() : new JsonArray();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return new JsonArray();
        }
    }

    /**
     * get String from JsonObject.
     *
     * @return String
     */
    public static String getString(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsString() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get Boolean from JsonObject.
     *
     * @return Boolean
     */
    public static Boolean getBoolean(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsBoolean() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get Integer from JsonObject.
     *
     * @return Integer
     */
    public static Integer getInt(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsInt() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get Short from JsonObject.
     *
     * @return Short
     */
    public static Short getShort(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsShort() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get Double from JsonObject.
     *
     * @return Double
     */
    public static Double getDouble(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsDouble() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get Float from JsonObject.
     *
     * @return Float
     */
    public static Float getFloat(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsFloat() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get Byte from JsonObject.
     *
     * @return Byte
     */
    public static Byte getByte(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsByte() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get Character from JsonObject.
     *
     * @return Character
     */
    public static Character getChar(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsCharacter() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get BigDecimal from JsonObject.
     *
     * @return BigDecimal
     */
    public static BigDecimal getBigDecimal(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsBigDecimal() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * get BigInteger from JsonObject.
     *
     * @return BigInteger
     */
    public static BigInteger getBigInteger(JsonObject jsonObj, String memberName) {
        try {
            return null != jsonObj.get(memberName) && !jsonObj.get(memberName).isJsonNull() ?
                    jsonObj.get(memberName).getAsBigInteger() : null;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }

    /**
     * 判断是否是json.
     */
    public static boolean isJson(String json) {
        try {
            JsonElement parse = parser.parse(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
