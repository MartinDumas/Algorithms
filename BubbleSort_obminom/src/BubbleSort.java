public class BubbleSort {

    // Метод для сортування масиву
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // Обмін елементів, якщо вони не відсортовані
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Метод для сортування в реверсивному порядку
    public static void bubbleSortReverse(int[] arr) {
        bubbleSort(arr);
        reverseArray(arr);
    }

    // Метод для сортування в обмеженому діапазоні
    public static void bubbleSortInRange(int[] arr, int start, int end) {
        if (start < 0 || end >= arr.length || start >= end)
            return;

        int n = end - start + 1;
        for (int i = 0; i < n-1; i++) {
            for (int j = start; j < end-i; j++) {
                if (arr[j] > arr[j+1]) {
                    // Обмін елементів, якщо вони не відсортовані
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Метод для обернення масиву
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

    // Метод для виведення масиву на екран в заданому діапазоні
    public static void printArray(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        // Сортування
        bubbleSort(arr);
        System.out.println("Сортування:");
        printArray(arr, 0, arr.length - 1);

        // Сортування в реверсивному порядку
        bubbleSortReverse(arr);
        System.out.println("Сортування в реверсивному порядку:");
        printArray(arr, 0, arr.length - 1);

        // Сортування в обмеженому діапазоні
        int[] arr2 = {12, 11, 13, 5, 6, 7};
        bubbleSortInRange(arr2, 1, 4);
        System.out.println("Сортування в обмеженому діапазоні:");
        printArray(arr2, 1, 4);
    }
}
