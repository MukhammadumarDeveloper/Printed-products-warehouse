package org.itpu.controller.concrete;

import org.itpu.controller.converters.ParameterConverter;
import org.itpu.criteria.impl.BookSearchCriteria;
import org.itpu.criteria.SearchCriteria;
import org.itpu.entity.Book;
import org.itpu.service.ApplianceService;

import java.util.List;

public class BookController extends ConcreteController<Book> {


    public BookController(ApplianceService applianceService, List<ParameterConverter<Book>> converters){
     super(applianceService, converters);
    }

    @Override
    protected SearchCriteria<Book>createCriteria(){
        return new BookSearchCriteria();
    }
}
