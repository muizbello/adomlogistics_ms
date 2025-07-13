package adomlogistics.utils;

public class BasicHashMap<K, V> {
    private Entry<K, V>[] table;
    private int capacity = 16; // Initial capacity
    private int size;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public BasicHashMap() {
        table = (Entry<K, V>[]) new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        if (key == null) return;

        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> current = table[hash];
            Entry<K, V> previous = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
        size++;
    }

    public V get(K key) {
        if (key == null) return null;

        int hash = hash(key);
        Entry<K, V> entry = table[hash];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V remove(K key) {
        if (key == null) return null;

        int hash = hash(key);
        Entry<K, V> current = table[hash];
        Entry<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[hash] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public K[] keys() {
        K[] keys = (K[]) new Object[size];
        int index = 0;

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                keys[index++] = entry.key;
                entry = entry.next;
            }
        }
        return keys;
    }

    @SuppressWarnings("unchecked")
    public V[] values() {
        V[] values = (V[]) new Object[size];
        int index = 0;

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                values[index++] = entry.value;
                entry = entry.next;
            }
        }
        return values;
    }

    @SuppressWarnings("unchecked")
    public Entry<K, V>[] entrySet() {
        Entry<K, V>[] entries = (Entry<K, V>[]) new Entry[size];
        int index = 0;

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                entries[index++] = entry;
                entry = entry.next;
            }
        }
        return entries;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }
}