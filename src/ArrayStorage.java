import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int countResumes = size();
        Arrays.fill(storage, 0, countResumes, null);
    }

    void save(Resume resume) {
        int countResumes = size();
        int lengthStorage = storage.length;
        if (countResumes == lengthStorage) {
            System.out.println("Резюме не добавлено, т.к. база данных переполнена!");
            return;
        }
        storage[countResumes] = resume;
    }

    Resume get(String uuid) {
        int countResumes = size();
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int countResumes = size();
        if (countResumes == 0) {
            return;
        }
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, countResumes - i);
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int countResumes = size();
        return Arrays.copyOf(storage, countResumes);
    }

    int size() {
        int countResumes = 0;
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }
            countResumes++;
        }
        return countResumes;
    }
}
