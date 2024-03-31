public class SelectionSort {

    // Метод для сортування масиву вибором
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Обмін місцями
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Метод для сортування в реверсивному порядку за допомогою сортування вибором
    public static void selectionSortReverse(int[] arr) {
        selectionSort(arr);
        reverseArray(arr);
    }

    // Метод для сортування вибраного діапазону масиву за допомогою сортування вибором
    public static void selectionSortInRange(int[] arr, int start, int end) {
        if (start < 0 || end >= arr.length || start >= end)
            return;

        for (int i = start; i <= end - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Обмін місцями
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

        // Сортування вибором
        selectionSort(arr);
        System.out.println("Сортування вибором:");
        printArray(arr, 0, arr.length - 1);

        // Сортування в реверсивному порядку
        selectionSortReverse(arr);
        System.out.println("Сортування в реверсивному порядку:");
        printArray(arr, 0, arr.length - 1);

        // Сортування вибраного діапазону масиву
        int[] arr2 = {12, 11, 13, 5, 6, 7};
        selectionSortInRange(arr2, 1, 4);
        System.out.println("Сортування вибраного діапазону масиву:");
        printArray(arr2, 1, 4);
    }
}
