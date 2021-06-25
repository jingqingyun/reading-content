package com.jingqingyun.reading.web.servlet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * LongSerializerComponent
 *
 * @author jingqingyun
 * @date 2020/11/4
 */
@JsonComponent
public class LongSerializerComponent {

    @JsonSerialize
    public static class LongSerializer extends JsonSerializer<Long> {

        @Override
        public void serialize(Long aLong, JsonGenerator jsonGenerator,
                SerializerProvider serializerProvider) throws IOException {
            ToStringSerializer.instance.serialize(aLong, jsonGenerator, serializerProvider);
        }

    }

}
