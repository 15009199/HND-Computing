public class IntegerSorter {

    public static void main(String[] args) {
        int[] integerArray1 = new int[]{ 7,5,3,9,1,4,2,8,10,6 };

        outputArrayValues(integerArray1); // print unsorted array
        bubbleSort(integerArray1); // sort the array, ascending order
        outputArrayValues(integerArray1);
        bubbleSortDescending(integerArray1); // sort the array, descending order
        outputArrayValues(integerArray1);
    }

    public static void outputArrayValues(int[] arrayParameter) {
        for (int i = 0; i < arrayParameter.length; i++) {

            System.out.println("array value: "+arrayParameter[i]);

        }
        System.out.println("_______________");
    }

    public static void bubbleSort(int[] arrayParameter) {
        int currentValue, nextValue;

        for (int x = 0; x < arrayParameter.length; x++) {
            for (int i = 0; i < arrayParameter.length - 1; i++) {
                currentValue = arrayParameter[i];
                nextValue = arrayParameter[i + 1];

                if (currentValue > nextValue) {
                    arrayParameter[i] = nextValue;
                    arrayParameter[i + 1] = currentValue;
                    System.out.println("swapping: " + currentValue + " with " + nextValue);
                }
            }
        }
        System.out.println("_______________");
    }

    public static void bubbleSortDescending(int[] arrayParameter) {
        int currentValue, nextValue;

        for (int x = 0; x < arrayParameter.length; x++) {
            for (int i = 0; i < arrayParameter.length - 1; i++) {
                currentValue = arrayParameter[i];
                nextValue = arrayParameter[i + 1];

                if (currentValue < nextValue) {
                    arrayParameter[i] = nextValue;
                    arrayParameter[i + 1] = currentValue;
                    System.out.println("swapping: " + currentValue + " with " + nextValue);
                }
            }
        }
        System.out.println("_______________");
    }
}
