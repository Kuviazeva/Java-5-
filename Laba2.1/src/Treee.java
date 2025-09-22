import java.util.Scanner;

class Node {
    char el;
    Node left;
    Node right;
}

class TreeFoo {
    //для себя для проверки
    //static void PrintTree(Node Tree, int l) {
    //    if (Tree != null) {
    //        PrintTree(Tree.right, l + 1);
    //        for (int i = 1; i <= l; i++) System.out.print("    ");
    //        System.out.println(Tree.elem);
    //        PrintTree(Tree.left, l + 1);
    //    }
    //}

    static float Cal(Node Tree) {
        float n1, n2;
        if (Tree.left == null)
            return Tree.el - '0';
        n1 = Cal(Tree.left);
        n2 = Cal(Tree.right);
        switch (Tree.el) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            case '^':
            {
                float c=1;
                for (int i=0;i<n2;i++) c=c*n1;
                return c;
            }
        }
        return -1;
    }


    static int Prior(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return 5;
    }

    static Node MakeT(String Str, int first, int last) {
        int MinPrt, i, k = 0, prt;
        Node Tree = new Node();
        if (first > last)
            return null;
        if (first == last) {
            if ((Str.charAt(first) == '(') || (Str.charAt(first) == ')'))
                return null;
            Tree.el = Str.charAt(first);
            Tree.left = null;
            Tree.right = null;
            return Tree;
        }

        if ((Str.charAt(first) == '(') && (Str.charAt(last) == ')')) {
            if (Stack.check(Str.substring(first + 1, last))) {
                first++;
                last--;
            }
        }


        MinPrt = 5;
        int flag = 0;
        for (i = first; i <= last; i++) {
            if (Str.charAt(i) == '(')
                flag++;
            else if (Str.charAt(i) == ')')
                flag--;
            else if (flag == 0) {
                prt = Prior(Str.charAt(i));
                if (prt <= MinPrt) {
                    MinPrt = prt;
                    k = i;
                }
            }
        }

        Tree.el = Str.charAt(k);
        Tree.left = MakeT(Str, first, k - 1);
        Tree.right = MakeT(Str, k + 1, last);
        return Tree;
    }

}

public class Treee {
    public static void main(String[] args) {
        String s;
            Scanner key = new Scanner(System.in);
            System.out.println("Введите выражение: ");
            s = key.nextLine();
        //замена переменных на их значения
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isLetter(curChar)) {
                System.out.printf("Введите значение переменной '%c': ", curChar);
                Scanner scanner = new Scanner(System.in);
                String elStr = scanner.nextLine();
                Integer el = Integer.parseInt(elStr);

                s=s.replaceAll(Character.toString(curChar), Integer.toString(el));
            }
        }
        //System.out.printf(s); // вывод выражения после подстановки переменных

            if (Stack.check(s)) {
                System.out.println("Выpажение пpавильное");

                Node tree = TreeFoo.MakeT(s, 0, s.length() - 1);

                //TreeFoo.PrintTree(tree, 0);
                System.out.println("Результат вычислений: ");
                System.out.println(TreeFoo.Cal(tree));

            } else
                System.out.println("Выpажение непpавильное");



    }
}