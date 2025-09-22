public class Main {
    //на githab честно пыталась, но чет так и не разобралась как и куда там что загружать
    // и где брать ссылку которой делиться, так что так
    public static void main() {
        Arr container = new Arr(0); //пустой контейнер

        // Добавляем элементы
        container.add("Привет");
        container.add(new Integer(42));
        container.add(true);
        container.add(3.14f);
        container.add('A');
        container.add('A');
        container.add('A');

        // Вывод всего что есть, авансом извлечение элемента смотрим
        for (int i = 0; i < container.getSize(); i++) {
            System.out.println("Элемент [" + i + "] = " + container.pr(i));
        }

        // Удалeние
        container.remove(2);

        // Еще вывод
        System.out.println("\nПосле удаления:");
        for (int i = 0; i < container.getSize(); i++) {
            System.out.println("Элемент [" + i + "] = " + container.pr(i));
        }
    }
}