package org.itpu.dao.impl;

import org.itpu.dao.AbstractDao;
import org.itpu.dao.CsvLineParser;
import org.itpu.entity.Appliance;
import org.itpu.entity.Magazine;

import java.util.List;

import static org.itpu.dao.CsvLineParser.Extractor.*;
import static org.itpu.dao.CsvLineParser.Extractor.forString;

public class MagazineDAO extends AbstractDao<Magazine> {
    public MagazineDAO(String path) {
        super(path, new CsvLineParser<>(Magazine::new, List.of(
                forString(Magazine::setTitle),
                forString(Magazine::setPublisher),
                forString(Magazine::setIssueDate),
                forString(Magazine::setFormat),
                forInt(Magazine::setNumberOfPages),
                forString(Magazine::setCoverType),
                forString(Magazine::setPaperType)
        )));
    }
}
