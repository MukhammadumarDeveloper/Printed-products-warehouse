package org.itpu.criteria.impl;

import org.itpu.criteria.AbstractCriteria;
import org.itpu.entity.Brochure;

public class BrochureSearchCriteria extends AbstractCriteria<Brochure> {
    @Override
    public Class<Brochure> getApplianceType() {
        return Brochure.class;
    }
}
