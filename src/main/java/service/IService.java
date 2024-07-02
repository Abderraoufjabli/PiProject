package service;


import java.util.List;

public interface IService <T> {

    public void create(T t);

    public void update(T t);

    public List<T> readAll();

    public void delete(T t);
}
