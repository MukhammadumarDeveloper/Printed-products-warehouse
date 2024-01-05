package org.itpu.controller.concrete;

import org.itpu.controller.converters.ParameterConverter;
import org.itpu.criteria.impl.BrochureSearchCriteria;
import org.itpu.criteria.SearchCriteria;
import org.itpu.entity.Brochure;
import org.itpu.service.ApplianceService;

import java.util.Collection;

public class BrochureController extends ConcreteController<Brochure> {
    public BrochureController(ApplianceService applianceService, Collection<ParameterConverter<Brochure>> parameterConverters){
        super(applianceService, parameterConverters);
    }

    @Override
    protected SearchCriteria<Brochure> createCriteria(){
        return new BrochureSearchCriteria();
    }
}
