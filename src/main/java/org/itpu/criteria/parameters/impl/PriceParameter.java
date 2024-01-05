package org.itpu.criteria.parameters.impl;

import org.itpu.criteria.parameters.Parameter;
import org.itpu.entity.Appliance;
import org.itpu.entity.Range;


import java.security.InvalidParameterException;

public record PriceParameter<A extends Appliance<A>>(Range<Long> range) implements Parameter<A> {
    public PriceParameter{
        if(range.from()<0L){
            throw new InvalidParameterException("Price can't be less than 0, but was " + range.from());
        }
    }
    @Override
    public boolean test(A appliance){
        return range.isIn(appliance.getPrice());
    }
}
