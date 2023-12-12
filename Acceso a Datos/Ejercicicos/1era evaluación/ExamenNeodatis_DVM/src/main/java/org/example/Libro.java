package org.example;

import java.io.Serializable;

/**
 * Clase POJO gestión estructura Libro
 */
public class Libro implements Serializable {

    private String isbn;

    private String title;

    private int publicationYear;

    private int pagNum;

    private String theme;


    public Libro() {
    }

    public Libro(String isbn, String title, int publicationYear, int pagNum, String theme) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pagNum = pagNum;
        this.theme = theme;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPagNum() {
        return pagNum;
    }

    public void setPagNum(int pagNum) {
        this.pagNum = pagNum;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pagNum=" + pagNum +
                ", theme='" + theme + '\'' +
                '}';
    }
}
