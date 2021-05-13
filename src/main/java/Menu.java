import binary_tree.BinaryTree;
import binary_tree.Node;
import binary_tree.TreePrinter;

import java.util.Scanner;

public class Menu {

    public static void menu(BinaryTree tree) {
        Scanner scanner = new Scanner(System.in);

        TreePrinter.printNode(tree.getRoot());
        while (true) {
            System.out.print("Enter ID or 'E' to exit: ");
            String line = scanner.nextLine();
            if (line.equals("E")) {
                System.exit(0);
            } else {
                try {
                    Node.print(tree.getMap().get(Integer.parseInt(line)));
                } catch (Exception e) {
                    System.out.println("Unacceptable!");
                }
            }
        }
    }
}
