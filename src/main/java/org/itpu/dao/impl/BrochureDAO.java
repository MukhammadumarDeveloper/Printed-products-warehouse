package org.itpu.dao.impl;

import org.itpu.dao.AbstractDao;
import org.itpu.dao.CsvLineParser;
import org.itpu.entity.Appliance;
import org.itpu.entity.Brochure;

import java.util.List;

import static org.itpu.dao.CsvLineParser.Extractor.forInt;
import static org.itpu.dao.CsvLineParser.Extractor.forString;

public class BrochureDAO extends AbstractDao<Brochure> {


    public BrochureDAO(String path) {
        super(path, new CsvLineParser<>(Brochure::new, List.of(
                forString(Brochure::setTitle),
                forString(Brochure::setDescription),
                forString(Brochure::setSize),
                forString(Brochure::setPaperType),
                forString(Brochure::setGraphics),
                forString(Brochure::setImages)
        )));
    }
}

