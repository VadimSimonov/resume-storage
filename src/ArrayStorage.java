import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[2];

    void clear() {
        storage = Arrays.stream(storage)
                .filter(i->i!=null)
                .map(n-> n=null)
                .toArray(Resume[]::new);
    }

    void save(Resume r) {
        /*Resume rr = new Resume();
        rr.uuid = "uuid1";
        storage[0]=rr;*/

        Resume f = Arrays.stream(storage)
                .filter(i -> i!=null)
                .filter(i-> i.toString().equals(r.toString()))
                .findFirst()
                .orElse(null);
         if (f==null) {
             for (int i = 0; i < storage.length; i++) {
                 if (storage[i] == null) {
                     storage[i] = r;
                     break;
                 }
             }
             int index=Arrays.asList(storage).indexOf(r);
             if (index ==-1) System.out.println("...");
         }else System.out.println("Resume ...");
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
    void update(Resume u,Resume replace)
    {
        Resume findit = Arrays.stream(storage)
                .filter(i->i.toString().equals(u.toString()))
                .findFirst()
                .orElse(null);
        if (findit!=null) {
            int index = Arrays.asList(storage).indexOf(findit);
            storage[index] = replace;
        }

    }

}
