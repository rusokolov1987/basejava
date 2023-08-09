package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 100000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (STORAGE_LIMIT == size) {
            System.out.println("БД переполнена!");
        } else if (isExist(index)) {
            System.out.println("Резюме " + resume.getUuid() + " уже есть в БД!");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (!isExist(index)) {
            System.out.println("Резюме " + uuid + " нет в БД!");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (!isExist(index)) {
            System.out.println("Резюме " + uuid + " нет в БД!");
            return;
        }
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (!isExist(index)) {
            System.out.println("Резюме " + resume.getUuid() + " нет в БД!");
        }
        else {
            storage[index] = resume;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isExist(int index) {
        return index > -1;
    }
}
