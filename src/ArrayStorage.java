import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size=0;

    void clear() {
        for (int i = 0; i <size ; i++) {
            storage[i]=null;
        }
        size=0;
    }

    void save(Resume r) {
        Resume CheckValue =CheckValue(r.getUuid());
         if (CheckValue==null) {
            boolean flag=checkFreeSize();
            if (flag) {
                for (int i = 0; i < storage.length; i++) {
                    if (storage[i]==null) {
                        storage[i] = r;
                        size++;
                        break;
                    }
                }
            }else System.out.println("not enough space");
         }else System.out.println("Resume already exist");
    }

    private boolean checkFreeSize() {
        return size<storage.length;
    }

    Resume get(String uuid) {
        Resume f = CheckValue(uuid);
        if (f!=null)
        return f;
        else
            System.out.println("Resume not found");
        return f;
    }

    void delete(String uuid) {
        for (int i = 0; i <size ; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size-1] = null;
                size--;
            }
        }
    }

    private Resume CheckValue(String uuid) {
        Resume a = Arrays.stream(storage)
                .filter(i -> i!=null)
                .filter(i -> i.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
        return a;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storage1= Arrays.stream(storage)
                .filter(x ->(x!=null))
                .toArray(Resume[]::new);
        return storage1;
    }

    int size() {
        return size;
    }

    void update(Resume u,Resume replace)
    {
        Resume f =CheckValue(u.getUuid());
        if (f!=null) {
            int index = Arrays.asList(storage).indexOf(f);
            storage[index] = replace;
        }else System.out.println("Resume not found");

    }

}
