package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size=0;

    public  void clear() {
        for (int i = 0; i <size ; i++) {
            storage[i]=null;
        }
        size=0;
    }


    public void save(Resume r) {
        if (CheckValue(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

   /* public boolean checkFreeSize() {
        return size<storage.length;
    }*/


    public void delete(String uuid) {
        for (int i = 0; i <size ; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size-1] = null;
                size--;
            }
        }
    }

    public int CheckValue(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] storage1= Arrays.stream(storage)
                .filter(x ->(x!=null))
                .toArray(Resume[]::new);
        return storage1;
    }

   /* public int size() {
        return size;
    }*/

    public void update(Resume r) {
        int index = CheckValue(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;

        }

    }
}
