package org.itpu.controller.converters.impl;

import org.itpu.controller.converters.AbstractParameterConverter;
import org.itpu.criteria.parameters.Parameter;
import org.itpu.criteria.parameters.impl.TitleParameter;
import org.itpu.entity.Appliance;


public class TitleConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public TitleConverter(){
        super("title");
    }

    @Override
    protected Parameter<A> internalConvert(String request) {
        return new TitleParameter(request);
    }
}
