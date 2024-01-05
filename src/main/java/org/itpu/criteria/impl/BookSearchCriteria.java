package org.itpu.criteria.impl;
import org.itpu.criteria.AbstractCriteria;
import org.itpu.entity.Book;

public class BookSearchCriteria extends AbstractCriteria<Book> {
    @Override
    public Class<Book> getApplianceType(){
        return Book.class;
    }
}
