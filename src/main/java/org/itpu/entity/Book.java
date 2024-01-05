package org.itpu.entity;


import java.util.Objects;

public class Book extends Appliance<Book> {
    private String author;
    private String publisher;
    private String edition;
    private String format;
    private int numberOfPages;

    private String coverType;

    public String getCoverType() {
        return coverType;
    }

    public Book setCoverType(String coverType) {
        this.coverType = coverType;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getEdition() {
        return edition;
    }

    public String getFormat() {
        return format;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Book setEdition(String edition) {
        this.edition = edition;
        return this;
    }

    public Book setFormat(String format) {
        this.format = format;
        return this;
    }

    public Book setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher) && Objects.equals(edition, book.edition) && Objects.equals(format, book.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, publisher, edition, format, numberOfPages);
    }

    @Override
    public String toString() {
        return "Book " + specialField()  +"| author =" + author +"| publisher =" + publisher+"| edition =" + edition+"| format =" + format+"| number of pages =" + numberOfPages ;
    }
}
