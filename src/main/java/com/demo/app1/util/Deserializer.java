package com.demo.app1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Deserializer
{
    private static final Logger log = LoggerFactory.getLogger(Deserializer.class);

    public static <T> T deserialize(String payload, Class<T> type, ObjectMapper objectMapper) {
        T output = null;
        try {
            output = objectMapper.readValue(payload, type);
        } catch (Exception ex) {
            log.error("Could not parse to type: {}, the payload: {}. Exception: {}", type.getName(), payload, ex.getMessage());
        }
        return output;
    }

    public static <T> T deserialize(String payload, CollectionType type, ObjectMapper objectMapper) {
        T output = null;
        try {
            output = objectMapper.readValue(payload, type);
        } catch (Exception ex) {
            log.error("Could not parse to type: {}, the payload: {}. Exception: {}", type, payload, ex.getMessage());
        }
        return output;
    }
}
