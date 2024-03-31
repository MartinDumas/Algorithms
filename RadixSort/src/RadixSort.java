import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {170, 450, 75, -90, -82, 24, 2, 664};

        System.out.println("Original array: " + Arrays.toString(array));

        radixSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void radixSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        // Знаходимо максимальне число у масиві (для визначення кількості розрядів)
        int max = Math.abs(array[0]);
        for (int num : array) {
            max = Math.max(max, Math.abs(num));
        }

        // Сортування за допомогою кожного розряду, спочатку з менш значущих до більш значущих
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    public static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[19]; // Враховуємо від'ємні числа

        // Заповнюємо count залежно від кількості кожного розряду
        for (int num : array) {
            int digit = (num / exp) % 10;
            count[digit + 9]++; // Зміщуємо розряди для врахування від'ємних чисел
        }

        // Оновлюємо count з врахуванням попередніх підсумків
        for (int i = 1; i < 19; i++) {
            count[i] += count[i - 1];
        }

        // Розміщуємо елементи у відсортованому порядку у вихідному масиві
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit + 9] - 1] = array[i];
            count[digit + 9]--;
        }

        // Копіюємо відсортований масив у вихідний масив
        System.arraycopy(output, 0, array, 0, n);
    }
}
