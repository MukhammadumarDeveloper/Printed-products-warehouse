package org.itpu.dao;

import org.itpu.criteria.SearchCriteria;
import org.itpu.entity.Appliance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public abstract class AbstractDao <A extends Appliance<A>> implements ApplianceDAO<A>{

    private final Path csvPath;
    private final CsvLineParser<A> parser;

    protected AbstractDao(String path, CsvLineParser<A> parser){
        try {
            var resource = getClass().getClassLoader().getResource(path);
            if(resource ==null){
                throw new IllegalArgumentException("Csv file is not found: " + path);
            }
            csvPath = Path.of(resource.toURI());
            this.parser = Objects.requireNonNull(parser);
        }
        catch (IllegalArgumentException ex){
            throw ex;
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<A> find(SearchCriteria<A> criteria) {
        try (var in = Files.newBufferedReader(csvPath)){
            in.readLine();
            String line;
            var appliances  = new ArrayList<A>();
            while ((line = in.readLine()) != null){
            String[] csvLine = line.split(";");
            var appliance = parser.parse(csvLine);
            //Arrays.stream(csvLine).forEach(System.out::println);
          if(criteria.test(appliance)) appliances.add(appliance);
            }
            return appliances;
        }
        catch (IOException ex) {
           return  List.of();
            // System.err.println(ex);
        }
       // return null;
        }

    }
