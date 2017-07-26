package IntBinaryTree;

/**
 * Created by User on 25.07.2017.
 */
public class BinaryTreeInt {

    Node root;

    public BinaryTreeInt() {
        root = null;
    }

    void insert(int key) {
        root = insertKey(root, key);
    }

    private Node insertKey(Node root, int key) {
        //empty root
        if (root == null) {
            root = new Node(key);//когда доходим до листьев дерева, то вставляем новое значение key. И при этом у этой ноды right=null и left=null!!!!!!
            return root;
        }

        //not empty tree. Если меньше, то налево, если больше, то направо
        if (key < root.key)
            root.left = insertKey(root.left, key);//когда приходим к листу дерева, его root.left=null и попадаем в  root = new IntBinaryTree.Node(key)
        else if (key > root.key)
            root.right = insertKey(root.right, key);//-||-

        //если key=root.key, то не надо искать слева и справа
        return root;
    }


    void insertWithoutRecurtion(int key){
        if(root == null){
            root = new Node(key);
            return;
        }
        Node node = new Node(key);
        Node temp =root;
        Node prev=root;

        // Идем по дереву: если меньше, то налево, если больше, то направо, пока не дойдем до leaf (left или right  =null)
        while (temp != null){
            prev = temp;
            if(key < temp.key)
                temp = temp.left;
            else if(key > temp.key)
                temp = temp.right;
            else return;//если такой элемент уже есть
        }

        //Записываем node или справа или слева
        if(prev.key < key )
            prev.right = node;
        else if(prev.key > key)
            prev.left = node;
    }

    Node findKey(Node root, int key){
        //если дошли до нужного root (root.key == key), то возвращаем его
        if(root.key == key || root==null) return root;
        //если key меньше root.key ищем слева, если больше - справа
        if(key < root.key) return findKey(root.left, key);
        return findKey(root.right,key);
    }


    void delete(int key) {
        root = deleteKey(root, key);
    }

    private Node deleteKey(Node root, int key) {
        //если root пустой
        if (root == null) return root;

        //ходим по дереву
        if (key < root.key)
            root.left = deleteKey(root.left, key);//root.left становится равным null в момент return root.right, return root.left или return root
        else if (key > root.key)
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

    private int minValueInRightTree(Node rightRoot) {
        int minv = rightRoot.key;
        while (rightRoot.left != null) {
            minv = rightRoot.left.key;
            rightRoot = rightRoot.left;
        }
        return minv;
    }

    private int maxValueInLeftTree(Node leftRoot) {
        int maxv = leftRoot.key;
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
