import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int length = size();
        Arrays.fill(storage, 0, length - 1, null);
    }

    void save(Resume resume) {
        int countResume = size();
        int lengthStorage = storage.length;
        if (countResume == lengthStorage) {
            System.out.println("Резюме не добавлено, т.к. база данных переполнена!");
            return;
        }
        storage[countResume] = resume;
        System.out.println("Резюме добавлено!");
    }

    Resume get(String uuid) {
        return null;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int length = size();
        return Arrays.copyOf(storage, length);
    }

    int size() {
        int length = 0;
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }
            length++;
        }
        return length;
    }
}
