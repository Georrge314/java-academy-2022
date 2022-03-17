package course.academy.dao.impl;

import course.academy.dao.UserRepository;
import course.academy.model.User;

class UserRepositoryMemoryImpl extends AbstractPersistableRepository<Long, User>
        implements UserRepository {

    public UserRepositoryMemoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }

    @Override
    public void save() {

    }

    @Override
    public void load() {

    }

    @Override
    public User findUserByUsername(String username) {
        for (User nextUser : super.findAll()) {
            if (nextUser.getUsername().equals(username)) {
                return nextUser;
            }
        }
        return null;
    }
}
