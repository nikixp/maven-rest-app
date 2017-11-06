package com.example.rest;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Student
 */
@Provider
public class ServiceProvider implements ContextResolver<ObjectMapper> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return MAPPER;
    }
    
    static {
      MAPPER.setSerializationInclusion(Include.NON_EMPTY);
      MAPPER.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
    }
}
