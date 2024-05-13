import utils.MyBST;
public class Main {
        public static void main(String[] args) {
            MyBST<Integer, Integer> bst = new MyBST<Integer, Integer>();

            bst.put(12, 12);
            bst.put(54, 54);
            bst.put(26, 26);
            bst.put(10, 10);
            bst.put(5, 5);
            bst.put(84, 84);
            bst.put(16, 16);
            bst.put(6, 6);

            bst.inOrder();
            System.out.print(bst.getSize());

            bst.delete(10);

            bst.inOrder();
            System.out.print(bst.getSize());

        }
    }


