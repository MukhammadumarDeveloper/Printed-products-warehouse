package org.itpu.criteria.parameters;

public class InvalidParameterArguments extends RuntimeException {
    public InvalidParameterArguments(String message){
        super(message);
    }
    public InvalidParameterArguments(String message, Throwable cause){
        super(message, cause);
    }
}
