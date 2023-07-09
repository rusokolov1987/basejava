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
    }

    Resume get(String uuid) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int length = size();
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            if (storage[i].toString().equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, length - i);
                break;
            }
        }
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
