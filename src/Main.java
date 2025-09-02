import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Иван", List.of(
                        new Book("Java", 500, 1999),
                        new Book("Spring", 450, 2005),
                        new Book("Hibernate", 300, 2001),
                        new Book("Patterns", 600, 2010),
                        new Book("Clean Code", 464, 2011)
                )),
                new Student("Анна", List.of(
                        new Book("Algorithms", 700, 2003),
                        new Book("Data Structures", 400, 1998),
                        new Book("Effective Java", 350, 2008),
                        new Book("Microservices", 520, 2020),
                        new Book("Docker", 280, 2019)
                )),
                new Student("Никита", List.of(
                        new Book("Java", 500, 1999),
                        new Book("Spring", 450, 2005),
                        new Book("Hibernate", 300, 2001),
                        new Book("Microservices", 520, 2020),
                        new Book("Docker", 280, 2019)
                )),
                new Student("Виктор", List.of(
                        new Book("Java", 500, 1999),
                        new Book("Spring", 450, 2005),
                        new Book("Hibernate", 300, 2001),
                        new Book("Patterns", 600, 2010),
                        new Book("Clean Code", 464, 2011)
                )),
                new Student("Антон", List.of(
                        new Book("Java", 500, 1999),
                        new Book("Data Structures", 400, 1998),
                        new Book("Effective Java", 350, 2008),
                        new Book("Patterns", 600, 2010),
                        new Book("Clean Code", 464, 2011)
                ))
        );

        Optional<Book> result = students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .findFirst();


        System.out.println(
                result.map(b -> "Найдена книга "+ b.getTitle() + ", год выпуска: " + b.getYear())
                        .orElse("Книга не найдена")
        );
    }
}