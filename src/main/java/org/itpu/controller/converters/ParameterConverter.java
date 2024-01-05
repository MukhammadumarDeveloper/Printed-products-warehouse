package org.itpu.controller.converters;

import org.itpu.criteria.parameters.Parameter;
import org.itpu.entity.Appliance;



public interface ParameterConverter <A extends Appliance<A>> {
    Parameter<A> convert(String request) throws ParameterConversionException;

    String parameterName();
}
