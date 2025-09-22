public class Arr {
    private Object[] el;
    private int size;

    public Arr(int nSize) {
        this.el = new Object[nSize];
        this.size = 0;
    }

    public void add(Object obj) {
        //типо создаем новый и меняем их местами
        int newCapacity = size+1;
        Arr container = new Arr(size+1);
        container.el = new Object [size+1];
        for (int i=0; i<size;i++)
        {
            container.el[i]=this.el[i];
        }
        container.el[size] = obj;
        this.el= container.el;
        this.size++;
    }

    public int getSize() {// чтобы смотреть сколько элементов в контейнере
        return size;
    }

    // Извлечение элемента по индексу
    public Object pr(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Такого элемента нет))))) " );
        }
        return el[index];
    }

    // Удаление
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Такого элемента нет))))) " );
        }
        System.arraycopy(el, index + 1, el, index, size - index - 1);
        el[--size] = null;
    }
}