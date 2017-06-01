import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = Arrays.stream(storage)
                .filter(i->i!=null)
                .map(n-> n=null)
                .toArray(Resume[]::new);
    }

    void save(Resume r) {
/*
        storage = Arrays.stream(storage)
                .filter(i->i==null)
                .findFirst()
                .map(i->i=r)
                .orElse()
*/

        for (int i = 0; i <storage.length ; i++) {
                if (storage[i]==null) {
                    storage[i] = r;
                    break;
                }
        }

    }

    Resume get(String uuid) {
        return Arrays.stream(storage)
                .filter(n -> (n!=null) && n.toString().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    void delete(String uuid) {
        for (int i = 0; i <storage.length ; i++) {
            if (storage[i].toString().equals(uuid))
            storage[i]=null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        storage= Arrays.stream(storage)
                .filter(x ->(x!=null))
                .toArray(Resume[]::new);
        return storage;
    }

    int size() {
        return (int) Arrays.stream(storage)
                .filter(i->i!=null)
                .count();

    }
}
