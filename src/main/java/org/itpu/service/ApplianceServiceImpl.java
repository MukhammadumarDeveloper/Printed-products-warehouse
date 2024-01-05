package org.itpu.service;

import org.itpu.criteria.SearchCriteria;
import org.itpu.dao.DaoFactory;
import org.itpu.entity.Appliance;

import java.util.Collection;

public class ApplianceServiceImpl implements ApplianceService{
    private final DaoFactory factory;

    public ApplianceServiceImpl(DaoFactory factory){
        this.factory = factory;
    }

    @Override
    public <A extends Appliance<A>>Collection<A> find (SearchCriteria<A> criteria){
        var dao =factory.getApplianceDAO(criteria.getApplianceType());
        if(dao == null){
            throw new IllegalStateException("No dao is found for " + criteria.getApplianceType());
        }
        return dao.find(criteria);
    }
}
