package org.itpu.criteria.impl;

import org.itpu.criteria.AbstractCriteria;
import org.itpu.entity.Magazine;

public class MagazineSearchCriteria extends AbstractCriteria<Magazine> {
    @Override
    public Class<Magazine> getApplianceType() {
        return Magazine.class;
    }
}
