package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Created by tirael on 12.06.2017.
 */
public abstract class AbstractArrayStorage implements Storage {
    protected  Resume[] storage = new Resume[10000];
    protected  int size=0;


    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = CheckValue(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int CheckValue(String uuid);

}
