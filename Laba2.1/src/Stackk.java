import java.util.Scanner;

class StackEl {
    char elem;
    StackEl next;
    int size = 0;
}

class Stack {
    StackEl head;

    Stack(StackEl head) {
        head = head;  // указатель на первый элемент
    }

    void Push(char el) {
        StackEl q = new StackEl();
        q.elem = el;
        q.next = head;
        head = q;
    }

    char Pop() {
        char res;
        StackEl q = new StackEl();
        res = head.elem;

        q = head;
        head = head.next;

        q = null;
        System.gc();

        return res;
    }
    static boolean check(String s) {
        char br1 = '(';
        char br2 = ')';

        Stack S = new Stack(null);
        int OK = 1;
        for (int i = 0; (OK == 1) && (i != s.length()); i++) {

            if (s.charAt(i) == br1) { // открывающая скобка
                S.Push(s.charAt(i));
            }
            else if (s.charAt(i) == br2) { // закрывающая скобка
                if (S.head == null)
                    OK = 0;
                else {
                    char upper = S.Pop();
                    if (upper != br1)
                        OK = 0;
                }
            }

        }

        if ((S.head == null) & (OK == 1)) {
            return true;
        } else {
            return false;
        }

    }

}


public class Stackk {
    public static void main(String[] args) {
        String s;
        Scanner key = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        s = key.nextLine();

        if (Stack.check(s)) {
            System.out.println("Выpажение пpавильное");
        } else
        System.out.println("Выpажение непpавильное");
    }
}