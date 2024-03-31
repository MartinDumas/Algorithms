import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        long startTime = System.nanoTime();
        mergeSort(array);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/ 1_000_000.0;

        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Time taken: " + duration + " ms");
    }

    public static void mergeSort(int[] a) {
        if (a.length <= 1) return;

        int mid = a.length / 2;
        int[] left = new int[mid];
        int[] right = new int[a.length - mid];
//        В перший підмасив записуємо першу половину елементів вхідного масиву, а в другий масив
//– другу половину елементів вхідного масиву

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }
//        Ділимо отримані підмасиви знову на два рекурсивно доки не отримаємо підмасив з одного
//                елемента
        mergeSort(left);
        mergeSort(right);

        merge(a, left, right);
    }
//    Перебираємо елементи двох підмасивів та порівнюємо їх між собою і вставляємо менший з них у
//    результуючий масив та переходимо на наступний елемент

    public static void merge(int[] a, int[] left, int[] right) {
        int i = 0, j = 0, idx = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                a[idx] = left[i];
                i++;
            } else {
                a[idx] = right[j];
                j++;
            }
            idx++;
        }
//        Дописуємо елементи, які залишились або в лівому або в правому підмасивах в кінець результуючого масиву
        while (i < left.length) {
            a[idx] = left[i];
            i++;
            idx++;
        }

        while (j < right.length) {
            a[idx] = right[j];
            j++;
            idx++;
        }
    }
}
