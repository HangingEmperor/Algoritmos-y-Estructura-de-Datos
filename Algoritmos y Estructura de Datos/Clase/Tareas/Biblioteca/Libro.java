package Clase.Tareas.Biblioteca;

import java.awt.*;

public class Libro {

    private String author;
    private String title;
    private String editor;
    private String year;
    private String isbn;
    private String edition;
    private String description;
    private String genre;
    private int rating;
    private Image image;

    public Libro(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    public Libro(String author, String title, String editor, String year, String isbn, String edition, String description, String genre, int rating, Image image) {
        this.author = author;
        this.title = title;
        this.editor = editor;
        this.year = year;
        this.isbn = isbn;
        this.edition = edition;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", editor='" + editor + '\'' +
                ", year='" + year + '\'' +
                ", isbn='" + isbn + '\'' +
                ", edition='" + edition + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", image=" + image +
                '}';
    }
}
