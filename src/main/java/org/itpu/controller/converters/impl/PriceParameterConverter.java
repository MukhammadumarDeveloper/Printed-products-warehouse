package org.itpu.controller.converters.impl;

import org.itpu.controller.converters.AbstractParameterConverter;
import org.itpu.controller.converters.ParameterConversionException;
import org.itpu.criteria.parameters.Parameter;
import org.itpu.criteria.parameters.impl.PriceParameter;
import org.itpu.entity.Appliance;
import org.itpu.entity.Range;



public class PriceParameterConverter <A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public PriceParameterConverter(){
        super("price");
    }

    @Override
    protected Parameter<A> internalConvert(String request){
        var value = request.split("-", 2);
        Range<Long> range = value.length==1
                ? new Range<>(Long.parseLong(value[0]), Long.parseLong(value[0]))
                :new Range<>(Long.parseLong(value[0]), Long.parseLong(value[1]));
        return new PriceParameter<>(range);
    }
}
