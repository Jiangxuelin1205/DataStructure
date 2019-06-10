package Array;

/**
 * 实现泛型，实现动态数组，动态扩容和缩容
 **/
public class Array<E> {

    private Object[] data;
    private int capacity;//动态数组的容量
    private int index;//index指向数组中已经填充元素的下一个位置

    public Array() {//默认大小为4,方便测试
        data = (E[]) new Object[4];
        capacity = 4;
        index = 0;
    }

    public Array(int initialCapacity) {//默认大小为4,方便测试
        data = (E[]) new Object[initialCapacity];
        capacity = initialCapacity;
        index = 0;
    }

    public void add(E e) {
        if (index >= capacity) {
            resize(capacity * 2);
        }
        data[index++] = e;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void resize(int size) {
        Object[] newData = (E[]) new Object[size];
        System.arraycopy(data, 0, newData, 0, Math.min(size, capacity));
        capacity = size;
        data = newData;
    }

    public void remove() {
        if (index > 0 && index < capacity) {
            index--;
        }
        if (capacity / 2 != 0 && index < capacity / 2) {
            resize(capacity / 2);
        }
    }

}
