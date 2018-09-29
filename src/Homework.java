import java.util.Arrays;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {

//Ввести n чисел с консоли.
        System.out.println("Введите сколько чисел вы хотите ввести:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int inpArr[] = new int[n];
        System.out.println("Введите " + n + " чисел, после ввода каждого нажмите Enter");
        for (int i = 0; i < n; i++) {
            int value = scan.nextInt();
            inpArr[i] = value;
        }
        System.out.println("Вы ввели: " + Arrays.toString(inpArr));

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = inpArr[i];
        }

//1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int i = 0; i < barrier; i++) {
                String count = Integer.toString(arr[i]);
                String count1 = Integer.toString(arr[i + 1]);
                int temp = 0;
                if (count.length() > count1.length()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        String count2 = Integer.toString(arr[0]);
        String count3 = Integer.toString(arr[n - 1]);
        System.out.println("Самое короткое число: " + (arr[0]) + ", его длина " + count2.length());
        System.out.println("Самое длинное число: " + (arr[n - 1]) + ", его длина " + count3.length());

//2. Упорядочить и вывести числа в порядке возрастания (убывания) значенийих длины.
        String increase = "Числа, в порядке возрастания их длины (в скобках длина): ";
        for (int i = 0; i < n; i++) {
            String count4 = Integer.toString(arr[i]);
            increase += arr[i] + " (" + count4.length() + "); ";
        }
        System.out.println(increase);

        String decrease = "Числа, в порядке уменьшения их длины (в скобках длина): ";
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int i = 0; i < barrier; i++) {
                String count = Integer.toString(arr[i]);
                String count1 = Integer.toString(arr[i + 1]);
                int temp = 0;
                if (count.length() < count1.length()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            String count4 = Integer.toString(arr[i]);
            decrease += arr[i] + " (" + count4.length() + "); ";
        }
        System.out.println(decrease);

//3. Вывести на консоль те числа, длина которых меньше (больше) средней,а также длину.
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String lenStr = Integer.toString(arr[i]);
            int lenInt = lenStr.length();
            sum += lenInt;
        }
        double ave = 1.0 * sum / n;
        String less = "Числа, длина которых меньше среднего: ";
        String more = "Числа, длина которых больше среднего: ";
        for (int i = 0; i < n; i++) {
            String lenStr = Integer.toString(arr[i]);
            int lenInt = lenStr.length();
            if (ave > lenInt * 1.0) {
                less = less + arr[i] + " (длина " + lenInt + "); ";
            }
            if (ave < lenInt * 1.0) {
                more = more + arr[i] + " (длина " + lenInt + "); ";
            }
        }
        System.out.println("Средняя длина введенных чисел: " + ave);
        System.out.println(less);
        System.out.println(more);

        //4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.

        String minNumStr = "Число, в котором число различных цифр минимально: ";
        int minNum = Integer.MAX_VALUE;
        int tempMin = 0;
        int tempN = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            String lenStr = Integer.toString(inpArr[i]);
            int lenNum = lenStr.length();
            int arrNum[] = new int[lenNum];
            int temN = inpArr[i];
            for (int j = 0; j < lenNum; j++) {
                arrNum[j] = temN % 10;
                temN = temN / 10;
            }
            tempN = 0;
            for (int j = 0; j < lenNum; j++) {
                for (int k = j + 1; k < lenNum; k++) {
                    if (arrNum[j] == arrNum[k]) {
                        tempN++;
                        break;
                    }
                }
            }
            tempMin = lenNum - tempN;
            if (minNum > tempMin) {
                minNum = tempMin;
                num = inpArr[i];
            }
            if (minNum == 1)
                break;
        }
        System.out.println(minNumStr + num);

//5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр.

        int onlyPair = 0;
        int pairOdd = 0;
        for (int i = 0; i < n; i++) {
            String lenStr = Integer.toString(inpArr[i]);
            int lenNum = lenStr.length();
            int arrNum[] = new int[lenNum];
            int temN = inpArr[i];
            for (int j = 0; j < lenNum; j++) {
                arrNum[j] = temN % 10;
                temN = temN / 10;
            }
            int countPair1 = 0;
            int countPair = 0;
            int countOdd = 0;
            for (int j = 0; j < lenNum; j++) {
                if (arrNum[j] % 2 == 0) {
                    countPair1++;
                } else break;
            }
            if (lenNum == countPair1) {
                onlyPair++;
            }
            if (lenNum % 2 == 0) {
                for (int j = 0; j < lenNum; j++) {
                    if (arrNum[j] % 2 == 0) {
                        countPair++;
                    } else {
                        countOdd++;
                    }
                }
                if (countPair == countOdd) {
                    pairOdd++;
                }
            }
        }
        System.out.println("Количество чисел содержащих только четные цыфры: " + onlyPair);
        System.out.println("Количество чисел содержащих одинаковое количество четных и нечетных цифр: " + pairOdd);

//6. Найти число, цифры в котором идут в строгом порядке возрастания. Еслитаких чисел несколько, найти первое из них.
        int grow = 0;
        for (int i = 0; i < n; i++) {
            String lenStr = Integer.toString(inpArr[i]);
            int lenNum = lenStr.length();
            int arrNum[] = new int[lenNum];
            int temN = inpArr[i];
            for (int j = 0; j < lenNum; j++) {
                arrNum[j] = temN % 10;
                temN = temN / 10;
            }
            int count = 0;
            for (int j = 0; j < lenNum - 1; j++) {
                if (arrNum[j] == arrNum[j + 1] + 1) {
                    count++;
                } else break;
            }
            if (count == lenNum - 1) {
                grow = inpArr[i];
                break;
            }
        }
        System.out.println("Первое число в котором цифры идут строго по возрастанию: " + grow);

//7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

        int onlyDiff = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String lenStr = Integer.toString(inpArr[i]);
            int lenNum = lenStr.length();
            int arrNum[] = new int[lenNum];
            int temN = inpArr[i];
            for (int j = 0; j < lenNum; j++) {
                arrNum[j] = temN % 10;
                temN = temN / 10;
            }

            tempN = 0;
            for (int j = 0; j < lenNum; j++) {
                for (int k = j + 1; k < lenNum; k++) {
                    if (arrNum[j] == arrNum[k]) {
                        tempN++;
                        break;
                    }
                }
            }
            count = lenNum - tempN;
            if (count == lenNum) {
                onlyDiff = inpArr[i];
                break;
            }

        }
        System.out.println("Первое число, состоящее только из различных цифр: " + onlyDiff);

    }


}


