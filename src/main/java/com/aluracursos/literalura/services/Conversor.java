package com.aluracursos.literalura.services;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Conversor {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T obtenerDatos(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
