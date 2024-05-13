import utils.MyBST;

public class MyApplication {
    public static void main(String[] args) {
        MyBST<Integer, Integer> bst = new MyBST<Integer, Integer>();

        bst.put(12, 91);
        bst.put(54, 86);
        bst.put(26, 63);
        bst.put(84, 23);
        bst.put(16, 84);
        bst.put(6, 7);
        bst.put(12, 12);
        bst.put(54, 54);
        bst.put(26, 26);
        bst.put(10, 10);
        bst.put(5, 5);
        bst.put(84, 84);
        bst.put(16, 16);
        bst.put(6, 6);

        bst.inOrder();
        System.out.println(bst.getSize());

        bst.delete(10);

        bst.inOrder();
        System.out.println(bst.getSize());

        System.out.println(bst.get(12));
        System.out.println(bst.get(16));
        System.out.println(bst.get(6));
    }
}

import utils.interfaces.MyBSTInterface;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyBST<K extends Comparable<K>, V> implements MyBSTInterface<K,V> {
    private Node root;
    private int size;

    public MyBST() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;
        return node;
    }

    @Override
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node tmp = node;
            node = findMin(tmp.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;
        }
        size--;
        return node;
    }

    private Node findMin(Node node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    @Override
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}

