package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Created by tirael on 12.06.2017.
 */
public interface Storage {
    void clear();
    void update(Resume r,Resume u);
    void save(Resume r);
    Resume get(String uuid);
    void delete(String uuid);
    Resume[] getAll();
    int size();


}
