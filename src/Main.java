import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Student> students = new MyArrayList<>();

        students.add(new Student("John", new MyArrayList<>()));
        students.get(0).getBooks().add(new Book("Java", 500, 1999));
        students.get(0).getBooks().add(new Book("Spring", 450, 2005));
        students.get(0).getBooks().add(new Book("Hibernate", 300, 2001));
        students.get(0).getBooks().add(new Book("Patterns", 600, 2010));
        students.get(0).getBooks().add(new Book("Clean Code", 464, 2011));

        students.add(new Student("Anna", new MyArrayList<>()));
        students.get(1).getBooks().add(new Book("Algorithms", 700, 2003));
        students.get(1).getBooks().add(new Book("Data Structures", 400, 1998));
        students.get(1).getBooks().add(new Book("Effective Java", 350, 2008));
        students.get(1).getBooks().add(new Book("Microservices", 520, 2020));
        students.get(1).getBooks().add(new Book("Docker", 280, 2019));

        students.add(new Student("Nik", new MyArrayList<>()));
        students.get(2).getBooks().add(new Book("Java", 500, 1999));
        students.get(2).getBooks().add(new Book("Spring", 450, 2005));
        students.get(2).getBooks().add(new Book("Hibernate", 300, 2001));
        students.get(2).getBooks().add(new Book("Microservices", 520, 2020));
        students.get(2).getBooks().add(new Book("Docker", 280, 2019));

        students.add(new Student("Viktor", new MyArrayList<>()));
        students.get(3).getBooks().add(new Book("Java", 500, 1999));
        students.get(3).getBooks().add(new Book("Spring", 450, 2005));
        students.get(3).getBooks().add(new Book("Hibernate", 300, 2001));
        students.get(3).getBooks().add(new Book("Patterns", 600, 2010));
        students.get(3).getBooks().add(new Book("Clean Code", 464, 2011));

        students.add(new Student("Tony", new MyArrayList<>()));
        students.get(4).getBooks().add(new Book("Java", 500, 1999));
        students.get(4).getBooks().add(new Book("Data Structures", 400, 1998));
        students.get(4).getBooks().add(new Book("Effective Java", 350, 2008));
        students.get(4).getBooks().add(new Book("Patterns", 600, 2010));
        students.get(4).getBooks().add(new Book("Patterns", 600, 2010));
        students.get(4).getBooks().add(new Book("Clean Code", 464, 2011));

        System.out.println("\nСписок студентов и их книг:");
        MyHashSet<Book> uniqueBooks = new MyHashSet<>();

        for (int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            for (int j = 0; j < st.getBooks().size(); j++) {
                uniqueBooks.insert(st.getBooks().get(j));
            }
        }

        IntStream.range(0, students.size())
                .mapToObj(students::get)
                .flatMap(st -> {
                    System.out.println("\nСтудент: " + st.getName());
                    IntStream.range(0, st.getBooks().size())
                            .mapToObj(st.getBooks()::get)
                            .forEach(book -> System.out.println("  " + book));
                    return IntStream.range(0, st.getBooks().size())
                            .mapToObj(st.getBooks()::get);
                })
                .peek(uniqueBooks::insert)
                .toList();

        System.out.println("\nВсе уникальные книги студентов (отсортированные):");
        uniqueBooks.toList().stream()
                .sorted(Comparator
                        .comparingInt(Book::getPages)
                        .thenComparing(Book::getTitle)
                        .thenComparingInt(Book::getYear))
                .forEach(System.out::println);

        List<Book> top3Books = uniqueBooks.toList().stream()
                .filter(b -> b.getYear() > 2000)
                .sorted(Comparator.comparingInt(Book::getPages))
                .limit(3)
                .toList();

        System.out.println("\nСписок из трёх книг по условию (год > 2000):");
        top3Books.forEach(book ->
                System.out.println("Найдена книга " + book.getTitle() + ", год выпуска: " + book.getYear())
        );
    }
}