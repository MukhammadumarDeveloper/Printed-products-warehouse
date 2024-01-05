package org.itpu.dao;

import org.itpu.entity.Appliance;

public interface DaoFactory {
    public <A extends Appliance<A>>ApplianceDAO<A> getApplianceDAO(Class<A> applianceClass);
}
