package org.itpu.controller.concrete;

import org.itpu.controller.converters.ParameterConverter;
import org.itpu.criteria.impl.MagazineSearchCriteria;
import org.itpu.criteria.SearchCriteria;
import org.itpu.entity.Magazine;
import org.itpu.service.ApplianceService;

import java.util.List;

public class MagazineController extends ConcreteController<Magazine> {
    public MagazineController(ApplianceService applianceService, List<ParameterConverter<Magazine>> converters){
        super(applianceService, converters);
    }

    @Override
    protected SearchCriteria<Magazine> createCriteria(){
        return new MagazineSearchCriteria();
    }
}
