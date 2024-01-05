package org.itpu.service;

import org.itpu.criteria.SearchCriteria;
import org.itpu.entity.Appliance;

import java.util.Collection;

public interface ApplianceService {
    <A extends Appliance<A>> Collection<A> find(SearchCriteria<A> criteria);

}
