package repository;

import java.util.List;

public interface IDienThoaiRepo<T> {
    List<T> getAll();
    void delete(int id);
    T findById(int id);
    void add(T t);
    List<T> findByName(String name);

}
