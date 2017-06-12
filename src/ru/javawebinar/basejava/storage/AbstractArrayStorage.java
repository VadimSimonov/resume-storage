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
        Resume f = CheckValue(uuid);
        if (f!=null)
            return f;
        else
            System.out.println("Resume not found");
        return f;
    }

    protected abstract Resume CheckValue(String uuid);

}
