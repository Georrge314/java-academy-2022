package course.academy.dao.impl;

import course.academy.dao.Identifiable;
import course.academy.dao.Persistable;
import course.academy.dao.Repository;
import course.academy.exception.NonexistingEntityException;

import java.util.*;

public abstract class AbstractPersistableRepository<K,V extends Identifiable<K>>
        implements Repository<K,V>, Persistable {
    private Map<K,V> items = new HashMap<>();
    private IdGenerator<K> idGenerator;

    public AbstractPersistableRepository(IdGenerator<K> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Collection<V> findAll() {
        return items.values();
    }

    @Override
    public List<V> findAllSorted(Comparator<V> comparator) { //O(N* log N) => O(1)
        var sorted = new ArrayList<>(items.values());
        sorted.sort(comparator);
        return sorted;
    }


    @Override
    public V findById(K id) {
        return items.get(id);
    }

    @Override
    public V create(V item) {
        item.setId(idGenerator.getNextId());
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public V update(V item) throws NonexistingEntityException {
        V old = findById(item.getId());
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + item.getId() + "' does not exist.");
        }
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public V deleteById(K id) throws NonexistingEntityException {
        V old = items.remove(id);
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + id + "' does not exist.");
        }
        return old;
    }

    @Override
    public long count() {
        return items.size();
    }
}
