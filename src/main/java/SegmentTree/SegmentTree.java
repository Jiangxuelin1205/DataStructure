package SegmentTree;

import java.util.Arrays;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    SegmentTree(E[] array, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[array.length];
        System.arraycopy(array, 0, this.data, 0, array.length);
        tree = (E[]) new Object[array.length * 4];
        build(0, 0, data.length - 1);
    }

    private void build(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        int mid = left + (right - left) / 2;
        build(leftIndex, left, mid);
        build(rightIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("参数不合法");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //递归到底的情况,即，如果查询的区间刚好是当前的区间，树在该区间的值
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int middle = l + (r - l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        if (queryR <= middle) { //查询区间落在线段树上的左区间
            return query(leftChild, l, middle, queryL, queryR);
        } else if (queryL >= middle + 1) {//查询区间落在线段树的右区间内
            return query(rightChild, middle + 1, r, queryL, queryR);
        }
        //如果查询的区间既不在左子树内又不在右子树内
        E leftResult = query(leftChild, l, middle, queryL, middle);
        E rightResult = query(rightChild, middle + 1, r, middle + 1, queryR);
        return this.merger.merge(leftResult, rightResult);
    }

    int getSize() {
        return data.length;
    }

    E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is out of bound");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        return "SegmentTree{" +
                "tree=" + Arrays.toString(tree) +
                '}';
    }
}
