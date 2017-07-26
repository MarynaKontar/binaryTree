package IntBinaryTree;

/**
 * Created by User on 25.07.2017.
 */
public class Node {

    int key;                    // ключ узла
    Node left;                // указатель на левого потомка
    Node right;               // указатель на правого потомка

    public Node(int key) {
        this.key = key;
        left=null;
        right=null;
    }

    @Override
    public String toString() {
        return "IntBinaryTree.Node{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
