package binaryTree;

/**
 * Created by User on 25.07.2017.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(T key) {
        root = insertKey(root, key);
    }

    private Node<T> insertKey(Node<T> root, T key) {
        //empty root
        if (root == null) {
            root = new Node<T>(key);//когда доходим до листьев дерева, то вставляем новое значение key. И при этом у этой ноды right=null и left=null!!!!!!
            return root;
        }

        //not empty tree. Если меньше, то налево, если больше, то направо
        if (key.compareTo(root.key)<0)
            root.left = insertKey(root.left, key);//когда приходим к листу дерева, его root.left=null и попадаем в  root = new IntBinaryTree.Node(key)
        else if (key.compareTo(root.key)>0)
            root.right = insertKey(root.right, key);//-||-

        //если key=root.key, то не надо искать слева и справа
        return root;
    }



    Node<T> findKey(Node<T> root, T key){
        //если дошли до нужного root (root.key == key), то возвращаем его
        if(key.compareTo(root.key)==0 || root==null) return root;
        //если key меньше root.key ищем слева, если больше - справа
        if(key.compareTo(root.key)<0) return findKey(root.left, key);
        return findKey(root.right,key);
    }


    void delete(T key) {
        root = deleteKey(root, key);
    }

    private Node<T> deleteKey(Node<T> root, T key) {
        //если root пустой
        if (root == null) return root;

        //ходим по дереву
        if (key.compareTo(root.key)<0)
            root.left = deleteKey(root.left, key);//root.left становится равным null в момент return root.right, return root.left или return root
        else if (key.compareTo(root.key)>0)
            root.right = deleteKey(root.right, key);

            //удаляем. Три случая, когда можно удалять: 1. нет не одного child (leaf), 2. есть один child, 3. есть два child
        else {
            //1,2.один child или не одного (leaf)
            //Если нет не одного child (node=leaf), то просто удалаем его. Если есть один child, то копируем child в node и удаляем child
            if (root.left == null)
                return root.right;// в этот момент root.right может стать root.left (например когда удалаем с одним child (32 после удаления 18 имеет 1 child)
            else if (root.right == null) return root.left;

            //3. два child. сначала получаем приемника (наименьший в "правом дереве" или наибольший в левом). Копируем его value на место удаляемого значения
            root.key = minValueInRightTree(root.right);
//            root.key = maxValueInLeftTree(root.left);

//            System.out.println("------------");
//            printRootInOrder(this.root);
//            System.out.println("------------");

            // Удаляем приемника (иначе будет повтор)
            root.right = deleteKey(root.right, root.key);
//            root.left = deleteKey(root.left, root.key);
        }
        return root;
    }

    private T minValueInRightTree(Node<T> rightRoot) {
        T minv = rightRoot.key;
        while (rightRoot.left != null) {
            minv = rightRoot.left.key;
            rightRoot = rightRoot.left;
        }
        return minv;
    }

    private T maxValueInLeftTree(Node<T> leftRoot) {
        T maxv = leftRoot.key;
        while (leftRoot.right != null) {
            maxv = leftRoot.right.key;
            leftRoot = leftRoot.right;
        }
        return maxv;
    }


    void printInOrder() {
        printRootInOrder(root);
    }

    void printRootInOrder(Node root) {
        if (root != null) {
            printRootInOrder(root.left);
            System.out.println(root.key);
            printRootInOrder(root.right);
        }
    }
}
