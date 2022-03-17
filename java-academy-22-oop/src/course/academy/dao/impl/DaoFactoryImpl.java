package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.DaoFactory;
import course.academy.dao.Repository;
import course.academy.dao.UserRepository;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public BookRepository createBookRepository() {
        return new BookRepositoryMemoryImpl(new Repository.IntegerIdGenerator());
    }

    @Override
    public UserRepository createUserRepository() {
        return new UserRepositoryMemoryImpl(new Repository.LongIdGenerator());
    }
}
