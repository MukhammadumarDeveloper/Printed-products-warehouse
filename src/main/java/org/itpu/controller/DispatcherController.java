package org.itpu.controller;

import org.itpu.controller.concrete.ConcreteController;
import org.itpu.controller.concrete.ConcreteController.Response;
import org.itpu.controller.io.FinishStatus;
import org.itpu.controller.io.IOHolder;
import org.itpu.entity.Appliance;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class DispatcherController implements Closeable {
    private final IOHolder io;
    private final Map<String, ConcreteController<? extends Appliance<?>>> controllers;

    public DispatcherController(IOHolder io, Map<String, ConcreteController<?>> controllers){
        this.io = Objects.requireNonNull(io);
        this.controllers = Objects.requireNonNull(controllers);
    }
    public void listen() throws IOException{
        io.getReader()
                .stopOnStatus(FinishStatus.END_OF_INPUT)
                .doAction(request -> {
                    ConcreteController<? extends Appliance<?>> controller = controllers.get(request.toLowerCase());
                    if(controller == null) {
                        io.error("Unsupported appliance type: " + request);
                        return FinishStatus.CONTINUE;
                    }
                    Response<? extends Appliance<?>> response = controller.acceptRequest(io);
                    switch (response.status()){
                        case END_OF_INPUT -> {
                            return FinishStatus.END_OF_INPUT;
                        }
                        case SEARCH -> response.appliances().forEach(io::print);
                        case COUNT -> io.print(response.appliances().size());
                    }
                    return FinishStatus.CONTINUE;
                })
                .read();
    }


    @Override
    public void close() throws IOException {
        io.close();

    }
}
