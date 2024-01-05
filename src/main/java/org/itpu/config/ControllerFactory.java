package org.itpu.config;

import org.itpu.controller.DispatcherController;
import org.itpu.controller.concrete.BookController;
import org.itpu.controller.concrete.MagazineController;
import org.itpu.controller.concrete.BrochureController;
import org.itpu.controller.io.IOHolder;
import org.itpu.service.ApplianceService;

import java.util.List;
import java.util.Map;

public enum ControllerFactory {
    INSTANCE;

    public DispatcherController dispatcher(ApplianceService applianceService){
        return new DispatcherController(
                IOHolder.system(),
                Map.of(
                        "book", new BookController(applianceService, List.of(
                                RawConverters.PRICE.generic(),
                                RawConverters.TITLE.generic()
                        )),
                        "magazine", new MagazineController(applianceService, List.of(
                                RawConverters.PRICE.generic(),
                                RawConverters.TITLE.generic()
                        )),
                        "brochure", new BrochureController(applianceService, List.of(
                                RawConverters.PRICE.generic(),
                                RawConverters.TITLE.generic()
                        ))
                )
        );
    }
}
