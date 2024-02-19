public class DataContainer<type> {
    //TODO: Задача 4*: Контейнер для хранения и работы с разными типами данных
    //Напишите обобщенный (шаблонный) класс DataContainer, который представляет контейнер для хранения элементов разных типов данных. Этот контейнер должен поддерживать добавление элементов, получение элемента по индексу, удаление элемента по индексу, поиск элемента в контейнере и получение всех элементов.
    
    private type[] list = null;
    private int length = 0;

    public void add (type data) {
        Object[] objList = new Object[length + 1];

        for (int i = 0; i < length; i ++) {
            objList[i] = list[i];
        }

        length++;
        objList[length - 1] = data;
        list = (type[]) objList;
    }

    public type getDataByIndex (int index) throws Exception {
        if (index < 0 || index >= length) {
            throw new Exception("No element by index: " + index);
        }
        return list[index];
    }

    public void deleteByIndex (int index) throws Exception {
        if (index < 0 || index >= length) {
            throw new Exception("No element by index: " + index);
        }

        Object[] newList = new Object[length-1];

        int shift = 0;
        for (int i = 0; i < length - 1; i++) {
            if (index == i) {
                shift = 1;
            }
            newList[i] = list[i + shift];
        }
        length--;
        list = (type[]) newList;

    }

    public int searchData (type element) {
        for (int i = 0; i < length; i++) {
            if (list[i] == element) {
                return i;
            }
        }
        return -1;
    }
    
    public void printData() {
        for (int i = 0; i < length; i++) {
            System.out.printf("%d: %s\n", i, list[i].toString());

        }
        
    }

    public type[] getList () {
        return list;
    }
}
