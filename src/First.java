import java.util.Scanner;

public class First {

    public static void main (String[] args) {

        System.out.println(getBucketCount(3.4, 1.5));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket,
                                     int extraBuckets) {

        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }

        else {
            double totalArea = width * height;
            int bucketsRequired = (int) Math.ceil(totalArea / areaPerBucket);
            if (extraBuckets >= bucketsRequired) return 0;
            else return bucketsRequired - extraBuckets;
        }
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        else {
            double totalArea = width * height;
            int bucketsRequired = (int) Math.ceil(totalArea / areaPerBucket);
            return bucketsRequired;
        }
    }

    public static int getBucketCount(double area, double areaPerBucket) {

        if (area <= 0 || areaPerBucket <= 0) return -1;

        else return (int) Math.ceil(area / areaPerBucket);
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner s = new Scanner((System.in));
        int sum = 0;
        long avg = 0L;
        int count = 0;

        while (true) {
//            System.out.print("Enter a number: ");
            boolean isInt = s.hasNextInt();

            if(isInt) {
                int number = s.nextInt();
                sum += number;
                count++;
                avg = Math.round((double) sum / count);
            }
            else break;
        }
        System.out.println("SUM = " + sum + " AVG = " + avg);
    }

    public static void minAndMaxInputChallenge() {
        Scanner s = new Scanner(System.in);

        int min = 0, max = 0;

        boolean firstEntry = true;

        while (true) {
            System.out.print("Enter number: ");

            boolean isInt = s.hasNextInt();

            if(isInt) {
                int enteredNumber = s.nextInt();
                if (firstEntry) {
                    min = enteredNumber;
                    max = enteredNumber;
                    firstEntry = false;
                }
                else if (enteredNumber < min) min = enteredNumber;
                else if (enteredNumber > max) max = enteredNumber;
            }
            else break;
        }
        s.close();
        System.out.println("Min No. = " + min);
        System.out.println("Max No. = " + max);
    }

    public static void readingUserInputChallenge() {

        int count = 0;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter number #" + (count + 1) + ": ");

            boolean isInt = scanner.hasNextInt();

            if (isInt) {
                int enteredNumber = scanner.nextInt();
                sum += enteredNumber;
                count++;
                if (count == 10) break;
            }
            else System.out.println("Invalid Number");

            scanner.nextLine();
        }
        scanner.close();
        System.out.println(sum);
    }

    public static boolean hasSameLastDigit(int a, int b, int c) {

        if ((a < 10) || (b < 10) || (c < 10) || (a > 1000) || (b > 1000) ||
                (c > 1000)) return false;

        else {
            if ((b % 10 == a % 10) || (b % 10 == c % 10) || (a % 10 == c % 10)) return true;
        }

        return false;
    }

    public static boolean isValid (int number) {
        if ((number < 10) || (number > 1000)) return false;
        else return true;
    }


    public static void printSquareStar(int number) {

        if (number < 5) System.out.println("Invalid Value");

        else {
            for (int row = 1; row <= number; row++) {
                for (int col = 1; col <= number; col++) {
                    if ((row == 1) || (row == number)) System.out.print("*");
                    else if ((col == 1) || (col == number)) System.out.print("*");
                    else if (col == row) System.out.print("*");
                    else if (col == (number - row + 1)) System.out.print("*");
                    else System.out.print(" ");
                    if (col == number) System.out.println();
                }
            }
        }
    }

    public static int getLargestPrime(int number) {

        if (number <= 1) return -1;

        int largestFactor = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
               int foundFactor = i;
               largestFactor = getLargestPrime(foundFactor);
            }
        }
        if (largestFactor == 0) {
            largestFactor = number;
        }
        return largestFactor;
    }



    //A big bag is 5 kilos, a small bag is 1 kilo. Can only use whole bags to hit the goal
    public static boolean canPack(int bigCount, int smallCount, int goal) {

        if ((bigCount < 0) || (smallCount < 0) || (goal < 0)) return false;

        for (int i = 0; i <= bigCount; i++) {
            for (int j = 0; j <= smallCount; j++) {
                if ((i * 5) + j == goal) return true;
            }
        }
        return false;
    }

    public static void numberToWords(int number) {

        if (number < 0) System.out.println("Invalid Value");

        else if (number == 0) System.out.println("Zero");

        else {
            int reverse = reverse(number);
            int digitCounter = getDigitCount(number);
            int printedDigitCounter = getDigitCount(reverse);
            int extract = 0;

            while (reverse > 0) {
                if (digitCounter == 1) {
                    extract = number;
                }
                else extract = reverse % 10;

                switch (extract) {
                    case 0:
                        System.out.print("Zero ");
                        break;
                    case 1:
                        System.out.print("One ");
                        break;
                    case 2:
                        System.out.print("Two ");
                        break;
                    case 3:
                        System.out.print("Three ");
                        break;
                    case 4:
                        System.out.print("Four ");
                        break;
                    case 5:
                        System.out.print("Five ");
                        break;
                    case 6:
                        System.out.print("Six ");
                        break;
                    case 7:
                        System.out.print("Seven ");
                        break;
                    case 8:
                        System.out.print("Eight ");
                        break;
                    case 9:
                        System.out.print("Nine ");
                        break;
                    default:
                        System.out.print("NaN ");
                        break;
                }

                reverse /= 10;
            }

            for (int i = 0; i < digitCounter-printedDigitCounter; i++) {
                System.out.print("Zero ");
            }
        }
    }

    public static int reverse(int number) {

        int reverse = 0;

        while (number != 0) {
            reverse += number % 10;
            if ((number >= 10) || (number <= -10)) reverse *= 10;
            number /= 10;
        }
        return reverse;
    }

    public static int getDigitCount(int number) {
        if (number < 0) return -1;

        if (number == 0) return 1;

        else {
            int count = 0;
            while (number > 0) {
                number /= 10;
                count++;
            }
            return count;
        }
    }

    public static boolean isPerfectNumber( int number ) {

        if (number < 1) return false;

        int i = 1;
        int accumulator = 0;

        while (i < number) {
            if (number % i == 0) accumulator += i;
            i++;
        }
        return (accumulator == number);
    }

    public static void printFactors (int number) {

        if (number < 1) System.out.println("Invalid Value");

        int i = 1;

        while (i <= number) {
            if (number % i == 0) System.out.print(i + " ");
            i++;
        }
    }

    public static int getGreatestCommonDivisor (int a, int b) {

        if ((a < 10) || (b < 10)) return -1;

        int greatestDivisor = 0;

        for (int i = 1; i < a; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                greatestDivisor = i;
            }
        }

        return greatestDivisor;
    }


    public static boolean hasSharedDigit(int num1, int num2) {

        if ((num1 < 10) || (num1 > 99) || (num2 < 10) || (num2 > 99)) return false;

        else {
            do {
                int test1 = num1 % 10;
                int num3 = num2;

                do {
                    int test2 = num3 % 10;

                    if (test1 == test2) return true;

                    num3 /= 10;

                } while (num3 > 0);

                num1 /= 10;

            } while (num1 > 0);
        }


        return false;
    }
}
