public class InsertionSort {

    // Метод для сортування масиву вставками
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Метод для сортування в реверсивному порядку за допомогою сортування вставками
    public static void insertionSortReverse(int[] arr) {
        insertionSort(arr);
        reverseArray(arr);
    }

    // Метод для сортування вибраного діапазону масиву за допомогою сортування вставками
    public static void insertionSortInRange(int[] arr, int start, int end) {
        if (start < 0 || end >= arr.length || start >= end)
            return;

        for (int i = start + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Метод для обертання масиву
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Метод для виведення масиву на екран
    public static void printArray(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        // Сортування вставками
        insertionSort(arr);
        System.out.println("Сортування вставками:");
        printArray(arr, 0, arr.length - 1);

        // Сортування в реверсивному порядку
        insertionSortReverse(arr);
        System.out.println("Сортування вставками в реверсивному порядку:");
        printArray(arr, 0, arr.length - 1);

        // Сортування вибраного діапазону масиву
        int[] arr2 = {12, 11, 13, 5, 6, 7};
        insertionSortInRange(arr2, 1, 4);
        System.out.println("Сортування вставками вибраного діапазону масиву:");
        printArray(arr2, 1, 4);
    }
}
