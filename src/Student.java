
public class Student {
    private final String NAME;
    private final MyArrayList<Book> BOOKS;

    public Student(String name, MyArrayList<Book> books) {
        this.NAME = name;
        this.BOOKS = books;
    }

    public String getName() {
        return NAME;
    }

    public MyArrayList<Book> getBooks() {
        return BOOKS;
    }

    @Override
    public String toString() {
        return "Student {" + "name:'" + NAME + '\'' + ", books" + BOOKS + '}';
    }
}
