package org.itpu;

import org.itpu.config.ControllerFactory;
import org.itpu.config.ServiceFactory;

import org.itpu.service.ApplianceService;

public class Main {
    public static void main(String[] args) {
        ApplianceService service = ServiceFactory.INSTANCE.getApplianceService();
        try (var dispatcher = ControllerFactory.INSTANCE.dispatcher(service)){
            dispatcher.listen();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        }
    }
