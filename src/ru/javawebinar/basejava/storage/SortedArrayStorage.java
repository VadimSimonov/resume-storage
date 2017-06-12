package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by tirael on 12.06.2017.
 */
public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int CheckValue(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
