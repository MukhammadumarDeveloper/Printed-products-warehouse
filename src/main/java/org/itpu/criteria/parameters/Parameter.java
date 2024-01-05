package org.itpu.criteria.parameters;

import org.itpu.entity.Appliance;

public interface Parameter<A extends Appliance<A>> {
    boolean test(A appliance);

    static <A extends Appliance<A>> Parameter<A> any(){
        return appliance -> true;
    }
    static <A extends Appliance<A>> Parameter<A> none(){
        return appliance -> false;
    }
}
