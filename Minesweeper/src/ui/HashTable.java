package ui;

public class HashTable<K, V> {
    private Entry<K, V>[] table;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> current = table[hash];
            while (current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                    return;
                }
                if (current.getNext() == null) {
                    current.setNext(newEntry);
                    return;
                }
                current = current.getNext();
            }
        }
    }

    public V get(K key) {
        int hash = hash(key);
        Entry<K, V> entry = table[hash];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }
}
