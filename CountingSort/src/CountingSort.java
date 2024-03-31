import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original array: " + Arrays.toString(array));

        countingSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void countingSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int min = array[0];
        int max = array[0];

        // Знаходимо мінімальне та максимальне значення у масиві
        for (int num : array) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max - min + 1];
        int[] output = new int[array.length];

        // Заповнення count залежно від кількості кожного елемента у масиві
        for (int num : array) {
            count[num - min]++;
        }

        // Оновлення count з врахуванням кількості елементів, менших або рівних кожному числу
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Переміщення елементів у відсортований порядок у масиві output
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Копіювання відсортованого масиву з output у вхідний масив
        System.arraycopy(output, 0, array, 0, array.length);
    }
}
