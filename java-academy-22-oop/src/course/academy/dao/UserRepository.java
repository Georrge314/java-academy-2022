package course.academy.dao;

import course.academy.model.User;

public interface UserRepository extends Repository<Long, User> {
    User findUserByUsername(String username);
}
