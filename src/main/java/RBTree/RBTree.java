package RBTree;

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 判断节点node的颜色
    private boolean isRed(Node node) {
        if (node == null)
            return BLACK;
        return node.color;
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }

    //红色节点的含义为与其父节点元素在2-3树中处于同一个节点中，与其父节点一起对应3节点
    //节点插入的基本操作，对应到2-3树中：完成节点融合，融合节点的元素数量大于2，则节点分离
    //节点分离即树的长高，分离到上一层的节点颜色需变红，代表与其父亲节点融合
    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    //对应到2-3树中，即向一个2节点中插入一个节点；
    //如果插入节点比2节点小则直接插入；如果插入节点比2节点大，则插入后插入的节点变为黑色，
    //原节点为红色
    private Node leftRotate(Node node) {//插入的节点是x
        //调整为2-3树的形式
        Node x = node.right;
        node.right = x.left;
        x.left = node;

        //x顶替了node的位置，因此x的颜色应该和node相同;
        x.color = node.color;
        //node与x在2-3树中是同一个节点，因此node的颜色为红色
        node.color = RED;
        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    //向2-3树的3节点中插入一个比这两个节点都小的元素，需要进行右旋转
    //x为被插入的节点
    //该过程仅仅到完成节点融合，但是还没有到节点分离
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    //2-3树中插入节点到3节点，且插入节点比该3节点中的两个元素都大
    //此时插入节点之后，出现了节点分化，即树的长高
    //中间的节点需要与其父亲节点融合，因此改为红色
    private void flipColors(Node node) {
//        Node x=node.right;
//        Node left=node.left;
//        x.color=BLACK;
//        left.color=BLACK;
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }
        else {// key.compareTo(node.key) == 0
            node.value = value;
        }

        if(isRed(node)&&isRed(node.right)&&!isRed(node.left)){
            node=leftRotate(node);
        }
        if(isRed(node.left)&&isRed(node.left.left)){
            node=rightRotate(node);
        }
        if(isRed(node.left)&&isRed(node.right)){
            flipColors(node);
        }
        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {

        if (node == null)
            return null;

        if (key.equals(node.key))
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {   // key.compareTo(node.key) == 0
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }
}
