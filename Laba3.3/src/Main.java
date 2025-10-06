import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final int ITERATIONS = 2000;

    public static void main(String[] args) {
        System.out.println("Расширенное тестирование производительности ArrayList и LinkedList");
        System.out.println("Количество итераций: " + ITERATIONS);
        System.out.println("=" + "=".repeat(131));

        //для ArrayList
        long addTime = AddAL();
        long addAtIndexTime = AddAtIndexAL();
        long getTime = GetAL();
        long deleteTime = DeleteAL();
        long deleteFromStartTime = DeleteFromStartAL();
        long containsTime = ContainsAL();
        long sizeTime = SizeAL();

        // для LinkedList
        long addTimeArrayList = AddLL();
        long addAtIndexTimeArrayList = AddAtIndexLL();
        long getTimeArrayList = GetLL();
        long deleteEndTimeArrayList = DeleteEndLL();
        long deleteStartTimeArrayList = DeleteStartLL();
        long containsTimeArrayList = ContainsLL();
        long sizeTimeArrayList = SizeLL();

        printResults(addTime, addAtIndexTime, getTime, deleteTime,
                deleteFromStartTime, containsTime, sizeTime,
                addTimeArrayList, addAtIndexTimeArrayList, getTimeArrayList, deleteEndTimeArrayList,
                deleteStartTimeArrayList, containsTimeArrayList, sizeTimeArrayList);
        printAnalysis(addTime, addAtIndexTime, getTime, deleteTime,
                deleteFromStartTime, containsTime, sizeTime,
                addTimeArrayList, addAtIndexTimeArrayList, getTimeArrayList, deleteEndTimeArrayList,
                deleteStartTimeArrayList, containsTimeArrayList, sizeTimeArrayList);
    }

    //Метода add - добавление в конец

    private static long AddAL() {
        List<Integer> list = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long AddLL() {
        List<Integer> list = new LinkedList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    //Метода add - добавление по индексу

    private static long AddAtIndexAL() {
        List<Integer> list = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i, i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long AddAtIndexLL() {
        List<Integer> list = new LinkedList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i, i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

     // Метода get - доступ по индексу

    private static long GetAL() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long GetLL() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

     //Метода delete - удаление с конца

    private static long DeleteAL() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = ITERATIONS - 1; i >= 0; i--) {
            list.remove(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long DeleteEndLL() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = ITERATIONS - 1; i >= 0; i--) {
            list.remove(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

     // Метода delete - удаление с начала

    private static long DeleteFromStartAL() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(0);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long DeleteStartLL() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.remove(0);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    //Метода contains - поиск

    private static long ContainsAL() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.contains(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long ContainsLL() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.contains(i); // Поиск существующих элементов
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    //Метода size - получение размера

    private static long SizeAL() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.size();
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long SizeLL() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.size();
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static void printResults(long addTime, long addAtIndexTime, long getTime,
                                     long deleteTime, long deleteFromStartTime,
                                     long containsTime, long sizeTime,
                                     long addTimeLL, long addAtIndexTimeLL, long getTimeLL,
                                     long deleteEndTimeLL, long deleteStartTimeLL,
                                     long containsTimeLL, long sizeTimeLL) {

        System.out.printf("%-20s | %-12s | %-21s | %-21s |%-22s | %-22s%n",
                "Метод", "Итерации", "Время (нс) ArrayList", "Время (мс) ArrayList", "Время (нс) LinkedList", "Время (мс) LinkedList");
        System.out.printf("%-20s-+-%-12s-+-%-21s-+-%-21s-+-%-22s+-%-22s%n",
                "-".repeat(20), "-".repeat(12), "-".repeat(21), "-".repeat(21),"-".repeat(22),"-".repeat(22));

        printRow("add", ITERATIONS, addTime,addTimeLL);
        printRow("add(index)", ITERATIONS, addAtIndexTime,addAtIndexTimeLL);
        printRow("get", ITERATIONS, getTime,getTimeLL);
        printRow("delete (end)", ITERATIONS, deleteTime,deleteEndTimeLL);
        printRow("delete (start)", ITERATIONS, deleteFromStartTime,deleteStartTimeLL);
        printRow("contains", ITERATIONS, containsTime,containsTimeLL);
        printRow("size", ITERATIONS, sizeTime,sizeTimeLL);
}


    private static void printRow(String method, int iterations, long timeNs,long timeNsLL) {
        double timeMCAR= timeNs / 1_000_000.0;
        //System.out.printf("%-21.1f", timeMCAR);
        System.out.printf("%-20s | %-12d | %-21d | %-21.3f | %-21d | %-15.3f%n",
                method, iterations, timeNs, timeNs / 1_000_000.0,timeNsLL, timeNsLL / 1_000_000.0);
    }

    private static void printAnalysis(long addTime, long addAtIndexTime, long getTime,
                                      long deleteTime, long deleteFromStartTime,
                                      long containsTime, long sizeTime,
                                      long addTimeLL, long addAtIndexTimeLL, long getTimeLL,
                                      long deleteEndTimeLL, long deleteStartTimeLL,
                                      long containsTimeLL, long sizeTimeLL) {
        System.out.println("\n" + "=".repeat(131));
        System.out.println("СРАВНЕНИЕ ПРОИЗВОДИТЕЛЬНОСТИ:");
        int LL=0,AL=0;
        if(addTime>addTimeLL){
            AL++;
            System.out.println("• add - O(1): Быстрое добавление в конец. Быстрее в ArrayList. ");
        }
        else {
            LL++;
            System.out.println("• add - O(1): Быстрое добавление в конец. Быстрее в LinkedList. ");
        }

        if(addAtIndexTime>addAtIndexTimeLL){
            AL++;
            System.out.println("• add(index) - O(n): Медленная вставка по индексу (требует поиска позиции). Быстрее в ArrayList.");
        }
        else {
            LL++;
            System.out.println("• add(index) - O(n): Медленная вставка по индексу (требует поиска позиции). Быстрее в LinkedList.");
        }

        if(getTime>getTimeLL){
            AL++;
            System.out.println("• get - O(n): Медленный доступ по индексу (последовательный поиск). Быстрее в ArrayList.");
        }
        else {
            LL++;
            System.out.println("• get - O(n): Медленный доступ по индексу (последовательный поиск). Быстрее в LinkedList.");
        }

        if(deleteTime>deleteEndTimeLL){
            AL++;
            System.out.println("• delete(end) - O(1): Быстрое удаление с конца. Быстрее в ArrayList.");
        }
        else {
            LL++;
            System.out.println("• delete(end) - O(1): Быстрое удаление с конца. Быстрее в LinkedList.");
        }

        if(deleteFromStartTime>deleteStartTimeLL){
            AL++;
            System.out.println("• delete(start) - O(1): Быстрое удаление с начала. Быстрее в ArrayList.");
        }
        else {
            LL++;
            System.out.println("• delete(start) - O(1): Быстрое удаление с начала. Быстрее в LinkedList.");
        }

        if(containsTime>containsTimeLL){
            AL++;
            System.out.println("• contains - O(n): Медленный поиск (линейный обход). Быстрее в ArrayList.");
        }
        else {
            LL++;
            System.out.println("• contains - O(n): Медленный поиск (линейный обход). Быстрее в LinkedList.");
        }
        if(sizeTime>sizeTimeLL){
            AL++;
            System.out.println("• size - O(1): Быстрое получение размера (хранится в поле). Быстрее в ArrayList.");
        }
        else {
            LL++;
            System.out.println("• size - O(1): Быстрое получение размера (хранится в поле). Быстрее в LinkedList.");
        }

         if (AL>LL){
             System.out.println("Делаем вывод, что быстрее в данном случае работал LinkedList.");
         }
         else {System.out.println("Делаем вывод, что быстрее в данном случае работал ArrayList.");}
        System.out.println("Но отличия были не сильно значительны. Для итерации по всем элементам - оба эффективны. ");
        System.out.println("Однако LinkedList потребляет больше памяти из-за хранения ссылок.");
    }
}