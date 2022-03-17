package course.academy.dao;

import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.model.User;

public interface UserRepository {
    User create(User user) throws InvalidRepositoryStateException;
    User update(User user) throws InvalidRepositoryStateException;
    User deleteById(int id) throws InvalidRepositoryStateException;
    User findById(int id) throws InvalidRepositoryStateException;
    User findByUsername(String username);
    User[] findAll();
    int size();
}
