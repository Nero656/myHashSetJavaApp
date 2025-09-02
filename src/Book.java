import java.util.Objects;

public class Book {
    String title;
    int pages;
    int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return title + " (" + year + ", " + pages + " стр.)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return year == book.year && pages == book.pages && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, pages);
    }
}
