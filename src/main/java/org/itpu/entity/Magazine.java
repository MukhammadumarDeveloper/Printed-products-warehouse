package org.itpu.entity;

import org.itpu.entity.properties.Categorized;
import org.itpu.entity.properties.Printable;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Magazine extends Appliance<Magazine> implements Printable {
    private String publisher;
    private String issueDate;
    private String format;
    private int numberOfPages;
    private String coverType;


    public Magazine setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Magazine setIssueDate(String issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public Magazine setFormat(String format) {
        this.format = format;
        return this;
    }

    public Magazine setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public Magazine setCoverType(String coverType) {
        this.coverType = coverType;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getFormat() {
        return format;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getCoverType() {
        return coverType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return numberOfPages == magazine.numberOfPages && Objects.equals(publisher, magazine.publisher) && Objects.equals(issueDate, magazine.issueDate) && Objects.equals(format, magazine.format) && Objects.equals(coverType, magazine.coverType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publisher, issueDate, format, numberOfPages, coverType);
    }

    @Override
    public String toString() {
        return "Magazine{" + specialField() + ", "
                +"publisher='" + publisher + '\'' +
                "issue date='" + issueDate + '\'' +
                "format='" + format + '\'' +
                "number of pages='" + numberOfPages + '\'' +
                "cover type='" + coverType + '\'' +
                '}';
    }

    @Override
    public void print(OutputStream out) {
        try{
            out.write(toString().getBytes(StandardCharsets.UTF_8));
            out.flush();
        }
        catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
}
