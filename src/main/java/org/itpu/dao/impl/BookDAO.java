package org.itpu.dao.impl;

import org.itpu.dao.AbstractDao;
import org.itpu.dao.CsvLineParser;
import org.itpu.entity.Appliance;
import org.itpu.entity.Book;

import java.util.List;

import static org.itpu.dao.CsvLineParser.Extractor.*;


public class BookDAO extends AbstractDao<Book> {
    public BookDAO(String path) {
        super(path, new CsvLineParser<>(Book::new, List.of(
                forString(Book::setTitle),
                forString(Book::setAuthor),
                forString(Book::setPublisher),
                forString(Book::setEdition),
                forString(Book::setFormat),
                forInt(Book::setNumberOfPages),
                forString(Book::setCoverType),
                forString(Book::setPaperType),
                forInt(Book::setPrice)
        )));
    }
}
