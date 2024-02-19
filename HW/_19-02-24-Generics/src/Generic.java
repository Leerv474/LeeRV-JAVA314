public class Generic<type> {
    //TODO: Задача 1: Сравнение массивов
    //Напишите обобщенный метод, который сравнивает два массива одного типа и возвращает true,
    //если они равны (имеют одинаковые значения в одном и том же порядке) и false в противном случае.

    public boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    //TODO: Задача 2: Слияние массивов
    //Напишите обобщенный метод для слияния двух массивов одного типа в один.
    public type[] mergeArrays(int[] array1, int[] array2) {
        Object[] objArray = new Object[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            objArray[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            objArray[i + array1.length] = array2[i];
        }

        return (type[])objArray;
    }

    //TODO: Задача 3: Поиск элемента
    //Напишите обобщенный метод для поиска элемента в массиве. Метод должен принимать массив и элемент для поиска, а затем возвращать индекс этого элемента в массиве. Если элемент не найден, вернуть -1.
    public int findElement(type[] array, type element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
        
    }
        
}
