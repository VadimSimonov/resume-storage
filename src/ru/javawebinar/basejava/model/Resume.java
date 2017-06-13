package ru.javawebinar.basejava.model;

/**
 * com.urise.webapp.model.Resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {

        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume o) {
       /* if (uuid == o.uuid)
            return 0;

        if (uuid == null) {
            return -1;
        }
        if (o.uuid == null) {
            return 1;
        }*/

        String s=uuid;
        String a=o.uuid;
        return s.compareTo(a);
        }
    }
