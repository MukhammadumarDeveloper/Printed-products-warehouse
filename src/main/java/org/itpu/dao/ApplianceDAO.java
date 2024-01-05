package org.itpu.dao;

import org.itpu.criteria.SearchCriteria;
import org.itpu.entity.Appliance;

import java.util.Collection;

public interface ApplianceDAO <A extends Appliance<A>> {
    Collection<A> find(SearchCriteria<A> criteria);

}
