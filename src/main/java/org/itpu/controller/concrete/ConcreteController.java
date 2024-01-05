package org.itpu.controller.concrete;

import org.itpu.controller.converters.ParameterConversionException;
import org.itpu.controller.converters.ParameterConverter;
import org.itpu.controller.io.FinishStatus;
import org.itpu.controller.io.IOHolder;
import org.itpu.criteria.SearchCriteria;
import org.itpu.criteria.parameters.Parameter;
import org.itpu.entity.Appliance;
import org.itpu.service.ApplianceService;

import java.io.IOException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class ConcreteController <A extends Appliance<A>> {
    protected final ApplianceService applianceService;
    protected final Map<String, ParameterConverter<A>> parameterConverters;
    public static record Response<A extends Appliance<A>>(FinishStatus status, Collection<A> appliances) {}
    protected ConcreteController(ApplianceService applianceService,
                                 Collection<ParameterConverter<A>> parameterConverters) {
        this.applianceService = Objects.requireNonNull(applianceService);
        this.parameterConverters = Objects.requireNonNull(parameterConverters).stream()
                .collect(Collectors.toMap(
                        ParameterConverter::parameterName,
                        Function.identity()
                ));
    }
    protected abstract SearchCriteria<A> createCriteria();

    public Response<A> acceptRequest(IOHolder io) throws IOException {
        SearchCriteria<A> criteria = createCriteria();
        var status = io.getReader()
                .stopOnStatus(FinishStatus.END_OF_INPUT)
                .stopOnStatus(FinishStatus.SEARCH)
                .stopOnStatus(FinishStatus.CANCEL)
                .stopOnStatus(FinishStatus.COUNT)
                .doAction(request -> {
                    try {
                        criteria.add(toParameter(request));
                    }
                    catch (IllegalArgumentException ex) {
                        io.error("Invalid parameter: " + ex.getMessage());
                    }
                    catch (ParameterConversionException ex) {
                        io.error(ex.getMessage());
                    }
                    return FinishStatus.CONTINUE;
                })
                .read();
        return new Response<>(status, status.isSuccess() ? applianceService.find(criteria) : List.of());
    }

    private Parameter<A> toParameter(String parameter) throws ParameterConversionException {
        var desc = parameter.split("=");
        var converter = parameterConverters.get(desc[0].strip().toLowerCase());
        if (converter == null) {
            throw new IllegalArgumentException(desc[0].strip());
        }
        return converter.convert(desc[1].strip());
    }
}