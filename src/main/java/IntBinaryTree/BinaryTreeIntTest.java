package IntBinaryTree;

/**
 * Created by User on 25.07.2017.
 */
public class BinaryTreeIntTest {
    public static void main(String[] args) {
        BinaryTreeInt binarySearchTree = new BinaryTreeInt();

        binarySearchTree.insert(56);
        binarySearchTree.insert(32);
        binarySearchTree.insert(18);
        binarySearchTree.insert(38);
        binarySearchTree.insert(65);
        binarySearchTree.insert(59);
        binarySearchTree.insert(80);

        binarySearchTree.printInOrder();
        /*
              56
           /     \
          32      65
         /  \    /  \
        18   38  59   80
 */


        Node node = binarySearchTree.findKey(binarySearchTree.root, 65);
        System.out.println("Find node with key = 65: ");
        binarySearchTree.printRootInOrder(node);


        System.out.println("\nDelete 18");
        binarySearchTree.delete(18);
        binarySearchTree.printInOrder();
        /*
              56
           /     \
          32      65
            \    /  \
            38  59   80
 */


        System.out.println("\nDelete 32");
        binarySearchTree.delete(32);
        binarySearchTree.printInOrder();
        /*
              56
           /     \
           38      65
                  /  \
                 59   80
 */


        System.out.println("\nDelete 56");
        binarySearchTree.delete(56);
        binarySearchTree.printInOrder();
         /* (если приемник=наименьший в "правом дереве")
               59
            /     \
           38      65
                     \
                     80
 */
 /* (если приемник=наибольший в "левом дереве")
              38
                 \
                   65
                  /  \
                 59   80
 */


//TODO 1 Почему при использовании метода с рекурсией вставка єлементов происходит намного дольше? (~1200мс  -  ~400мс)
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            binarySearchTree.insert(i);
//            binarySearchTree.insert(i + 20);
//        }
//        System.out.println((System.currentTimeMillis() - start) + " мс"); // ~1200мс


        long start1 = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            binarySearchTree.insertWithoutRecurtion(i);
            binarySearchTree.insertWithoutRecurtion(i + 20);
        }
        System.out.println((System.currentTimeMillis() - start1) + " мс"); // ~400 мс


//        binarySearchTree.printInOrder();

    }
}
