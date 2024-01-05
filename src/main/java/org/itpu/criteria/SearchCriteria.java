package org.itpu.criteria;

import org.itpu.criteria.parameters.Parameter;
import org.itpu.entity.Appliance;



public interface SearchCriteria <A extends Appliance<A>>{
    public Class<A> getApplianceType();

    public <P extends Parameter<A>> SearchCriteria<A> add(P parameter);

    public boolean test(A appliance);


}
