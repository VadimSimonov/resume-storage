package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

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
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }
    }

    public  void clear() {
        for (int i = 0; i <size ; i++) {
            storage[i]=null;
        }
        size=0;
    }

    public Resume[] getAll() {
        Resume[] storage1= Arrays.stream(storage)
                .filter(x ->(x!=null))
                .toArray(Resume[]::new);
        return storage1;
    }

    public abstract void delete(String uuid);
    public abstract void save(Resume r);
    protected abstract int getIndex(String uuid);

}
