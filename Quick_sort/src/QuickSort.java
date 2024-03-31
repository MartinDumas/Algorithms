import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = getPivotIndex(arr, low, high);
        int pivotValue = arr[pivotIndex];

        swap(arr, pivotIndex, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int getPivotIndex(int[] arr, int low, int high) {
        // Вибір опорного елемента
        // Можна вибрати будь-який із трьох варіантів: напочатку, вкінці або випадковий
        // В цьому випадку обравши опорним елементом перший елемент масиву
        // Для інших варіантів змінити на low, high або getRandomIndex(low, high)
        return low;
    }

    private static int getRandomIndex(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        // Сортування з вибором опорного елемента напочатку
        long startTime = System.nanoTime();
        quickSort(arr);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // переведемо наносекунди в мілісекунди
        System.out.println("Час сортування: " + duration + " мілісекунд");
        printArray(arr);


    }
}
