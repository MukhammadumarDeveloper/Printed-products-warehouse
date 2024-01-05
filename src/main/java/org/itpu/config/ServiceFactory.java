package org.itpu.config;

import org.itpu.service.ApplianceService;
import org.itpu.service.ApplianceServiceImpl;

public enum ServiceFactory {
    INSTANCE;

    public ApplianceService getApplianceService(){
        return new ApplianceServiceImpl(DaoFactoryImpl.INSTANCE);
    }
}
