package binaryTree;

/**
 * Created by User on 25.07.2017.
 */
public class BinaryStringTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<String>();


//        binarySearchTree.insert("asdfgg");
//        binarySearchTree.insert("ss32");
//        binarySearchTree.insert("df18");
//        binarySearchTree.insert("hj38");
//        binarySearchTree.insert("bn65");
//        binarySearchTree.insert("ju59");
//        binarySearchTree.insert("ku80");
//
//        binarySearchTree.printInOrder();
//        /*
//              hj38
//           /       \
//         bn65       ku80
//         /  \       /  \
//    asdfgg  df18  ju59  ss32
// */
//
//
//        Node node = binarySearchTree.findKey(binarySearchTree.root, "bn65");
//        System.out.println("Find node with key = bn65: ");
//        binarySearchTree.printRootInOrder(node);
//
//
//        System.out.println("\nDelete df18");
//        binarySearchTree.delete("df18");
//        binarySearchTree.printInOrder();
//
//
//        System.out.println("\nDelete ss32");
//        binarySearchTree.delete("" +"ss32");
//        binarySearchTree.printInOrder();
//
//
//        System.out.println("\nDelete asdfgg");
//        binarySearchTree.delete("asdfgg");
//        binarySearchTree.printInOrder();


//TODO 2
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            binarySearchTree.insert("" + i);
            binarySearchTree.insert("" + i + 20);
        }
        System.out.println((System.currentTimeMillis() - start) + " мс"); // ~30мс
    }
}
