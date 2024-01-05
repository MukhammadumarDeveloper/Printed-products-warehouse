package org.itpu.criteria.parameters.impl;

import org.itpu.criteria.parameters.InvalidParameterArguments;
import org.itpu.criteria.parameters.Parameter;
import org.itpu.entity.Appliance;

public record TitleParameter<A extends Appliance<A>> (String title) implements Parameter<A> {

    public TitleParameter {
        if(title==null||title.isBlank()){
            throw new InvalidParameterArguments(" Title can't be empty");
        }
    }

    @Override
    public boolean test(A appliance){
        return title.equals(appliance.getTitle());
    }
}
