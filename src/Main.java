import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("John", List.of(
                        new Book("Java", 500, 1999),
                        new Book("Spring", 450, 2005),
                        new Book("Hibernate", 300, 2001),
                        new Book("Patterns", 600, 2010),
                        new Book("Clean Code", 464, 2011)
                )),
                new Student("Anna", List.of(
                        new Book("Algorithms", 700, 2003),
                        new Book("Data Structures", 400, 1998),
                        new Book("Effective Java", 350, 2008),
                        new Book("Microservices", 520, 2020),
                        new Book("Docker", 280, 2005)
                )),
                new Student("Nik", List.of(
                        new Book("Java", 500, 1999),
                        new Book("Spring", 450, 2005),
                        new Book("Hibernate", 300, 2001),
                        new Book("Microservices", 520, 2020),
                        new Book("Docker", 280, 2019)
                )),
                new Student("Viktor", List.of(
                        new Book("Java", 500, 1999),
                        new Book("Spring", 450, 2005),
                        new Book("Hibernate", 300, 2001),
                        new Book("Patterns", 600, 2010),
                        new Book("Clean Code", 464, 2011)
                )),
                new Student("Tony", List.of(
                        new Book("Java", 500, 1999),
                        new Book("Data Structures", 400, 1998),
                        new Book("Effective Java", 350, 2000),
                        new Book("c#", 500, 2008),
                        new Book("Clean Code", 464, 2011)
                ))
        );

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .min(Comparator.comparingInt(Book::getPages));


        // Собираем все книги студентов в MyHashSet (чтобы убрать дубликаты)
        MyHashSet<Book> set = new MyHashSet<>();
        for (int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            for (int j = 0; j < st.getBooks().size(); j++) {
                set.insert(st.getBooks().get(j));
            }
        }

        System.out.println("\nСписок отсортировананных книг");

        Optional<Book> result = set.toList().stream()
                .peek(System.out::println)
                .sorted(Comparator.comparingInt(Book::getPages))
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .findFirst();

        System.out.println("\nРезультат поиска");
        System.out.println(
                result.map(b -> "Найдена книга " + b.getTitle() + ", год выпуска: " + b.getYear())
                        .orElse("Книга не найдена")
        );
    }

    private static Stream<java.util.List<Book>> setBuckets(MyHashSet<Book> set) {
        return Stream.of(set.toString())
                .map(x -> java.util.List.of());
    }
}