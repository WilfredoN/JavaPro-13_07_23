package multithreading.advanced;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> implements Iterable<T> {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<T> toStoreList;

    public ThreadSafeList(int toStoreCapacity) {
        this.toStoreList = new ArrayList<>(toStoreCapacity);
    }

    public void add(T value) {
        lock.writeLock().lock();
        try {
            toStoreList.add(value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T get(int index) {
        lock.readLock().lock();
        try {
            return toStoreList.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock();
        try {
            return toStoreList.size();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Iterator<T> iterator() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(toStoreList).iterator();
        } finally {
            lock.readLock().unlock();
        }
    }
}
