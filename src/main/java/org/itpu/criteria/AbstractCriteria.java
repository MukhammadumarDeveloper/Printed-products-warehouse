package org.itpu.criteria;

import org.itpu.criteria.parameters.Parameter;
import org.itpu.entity.Appliance;


import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<A extends Appliance<A>> implements SearchCriteria<A> {
    protected final Map<Class<?>, Parameter<A>> parameters = new HashMap<>();
    @Override
    public <F extends Parameter<A>> SearchCriteria<A> add(F parameter){
        parameters.put(parameter.getClass(), parameter);
        return this;
    }
    @Override
    public boolean test(A appliance) {
        return parameters.values().stream()
        .map(p->p.test(appliance))
                .reduce(Boolean::logicalAnd)
                .orElse(true);
    }
}
