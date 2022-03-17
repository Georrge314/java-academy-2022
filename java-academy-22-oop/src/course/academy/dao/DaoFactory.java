package course.academy.dao;

public interface DaoFactory {
    BookRepository createBookRepository();
    UserRepository createUserRepository();
}
