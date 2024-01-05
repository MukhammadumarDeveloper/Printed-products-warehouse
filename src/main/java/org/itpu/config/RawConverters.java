package org.itpu.config;

import org.itpu.controller.converters.ParameterConverter;
import org.itpu.controller.converters.impl.TitleConverter;
import org.itpu.controller.converters.impl.PriceParameterConverter;
import org.itpu.entity.Appliance;

public enum RawConverters {
    PRICE(new PriceParameterConverter()),
    TITLE(new TitleConverter<>());


    private final ParameterConverter<?> converter;

    RawConverters(ParameterConverter<?> converter) {
        this.converter = converter;
    }

    public <A extends Appliance<A>> ParameterConverter<A> generic() {
        return (ParameterConverter<A>) converter;
    }
}
