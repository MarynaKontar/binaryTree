package binaryTree;

/**
 * Created by User on 25.07.2017.
 */
public class Node<T extends Comparable> {

    T key;                    // ключ узла
    Node<T> left;                // указатель на левого потомка
    Node<T> right;               // указатель на правого потомка

    public Node(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
