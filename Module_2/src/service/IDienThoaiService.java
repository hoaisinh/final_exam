package service;

import java.util.List;

public interface IDienThoaiService<T> {
    List<T> getAll();
    void delete(int id);
    T findById(int id);
    List<T> findByName(String name);
    void add(T t);

}
