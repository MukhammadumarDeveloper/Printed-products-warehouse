package org.itpu.controller.converters;

import org.itpu.criteria.parameters.InvalidParameterArguments;
import org.itpu.criteria.parameters.Parameter;
import org.itpu.entity.Appliance;



public abstract class AbstractParameterConverter<A extends Appliance<A>> implements ParameterConverter<A> {
    private final String parameterName;
    protected AbstractParameterConverter(String parameterName){
        this.parameterName = parameterName;
    }
    @Override
    public Parameter<A> convert(String request) throws ParameterConversionException {
        try {
            return internalConvert(request);
        } catch (NumberFormatException ex) {
            throw new ParameterConversionException("The passed value is not a number: " + request);
        } catch (InvalidParameterArguments ex) {
            String errorMessage = String.format("Request '%s' is invalid because %s", request, ex.getMessage());
            throw new ParameterConversionException(errorMessage);
        }
    }
    protected abstract Parameter<A> internalConvert(String request) throws ParameterConversionException;

    @Override
    public String parameterName(){
        return parameterName;
    }
}
