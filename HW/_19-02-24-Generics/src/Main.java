import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Generic<Integer> test = new Generic<Integer>();
        int[] array1 = {1, 2, 3 ,4 ,5};
        int[] array2 = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString((test.mergeArrays(array1, array2))));


        DataContainer<Integer> dc = new DataContainer<>();


        dc.add(5);
        dc.add(12);
        dc.add(12315);

        dc.printData();

        dc.deleteByIndex(2);

        dc.printData();

        System.out.println(dc.getDataByIndex(0));

        System.out.println(dc.searchData(12));
    }
}
