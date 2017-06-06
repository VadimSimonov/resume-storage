import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Resume[]storage1=Arrays.stream(storage)
                .filter(i->i!=null)
                .map(i-> i=null)
                .toArray(Resume[]::new);
        //.collect(Collectors.toList());
        System.arraycopy(storage1,0,storage,0,storage1.length);
    }

    void save(Resume r) {
        Resume f =CheckValue(r.uuid);
         if (f==null) {
            boolean fl=checkFreeSize(storage);
            if (fl==true) {
                for (int i = 0; i < storage.length; i++) {
                    if (storage[i] == null) {
                        storage[i] = r;
                        break;
                    }
                }
            }else System.out.println("not enough space");
         }else System.out.println("Resume already exist");
    }

    private boolean checkFreeSize(Resume[] storage) {
        boolean flag=false;
        for (int i = 0; i <storage.length ; i++) {
            if (storage[i]==null)
            {flag=true;
                break;
            }
        }

        return flag;
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
        Resume a=CheckValue(uuid);
        if (a!= null) {
            Collection c = new ArrayList(Arrays.asList(storage));
            c.remove(a);
            c.toArray(storage);
        }else System.out.println("Resume not found");
    }

    private Resume CheckValue(String uuid) {
        Resume a = Arrays.stream(storage)
                .filter(i -> i!=null)
                .filter(i -> i.uuid.equals(uuid))
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
        return (int) Arrays.stream(storage)
                .filter(i->i!=null)
                .count();
    }
    void update(Resume u,Resume replace)
    {
        Resume f =CheckValue(u.uuid);
        if (f!=null) {
            int index = Arrays.asList(storage).indexOf(f);
            storage[index] = replace;
        }else System.out.println("Resume not found");

    }

}
