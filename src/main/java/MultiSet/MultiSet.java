package MultiSet;

import java.util.*;

public class MultiSet<E> extends AbstractSet<E> implements Set<E> {
    private TreeMap<E, Integer> map;

    public MultiSet() {
        this.map = new TreeMap<>();
    }

    public MultiSet(E[] x, int first, int last) {
        this.map = new TreeMap<>();
        for (E e : x) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }
    }

    @Override
    public int size() {
        //遍历map，计算出每个元素出现的次数
        int size = 0;
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            size += entry.getValue();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        int size = this.size();
        Object[] o = new Object[size];
        int j = 0;
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            Object key = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                o[j] = key;
                j++;
            }
        }
        return o;
    }

    @Override
    public boolean add(E e) {
        if (map.containsKey(e)) {
            map.put(e, map.get(e) + 1);
        } else {
            map.put(e, 1);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o, map.get(o));
    }

    @Override
    public void clear() {
        map.clear();
    }

    public int getCount(Object o) {
        return map.getOrDefault(o, 0);
    }

    public boolean containsAll(MultiSet<E> another) {
        //与另一个MultiSet对比，如果包括该Set全部的键，且键出现的次数相同，则返回true;否则返回false;
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            if (!(another.contains(entry.getKey()) && entry.getValue() == another.getCount(entry.getKey()))) {
                return false;
            }

        }
        return true;
    }
}
