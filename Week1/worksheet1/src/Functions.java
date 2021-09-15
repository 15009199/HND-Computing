public class Functions {

    public static void main(String[] args) {
        int[] integerArray1 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int[] integerArray2 = new int[]{ 1,2,3,4,5 };

        outputArrayValues(integerArray1);
        outputArrayValues(integerArray2);
    }

    public static void outputArrayValues(int[] arrayParameter) {
        for (int i = 0; i < arrayParameter.length; i++) {

            System.out.println("array value: "+arrayParameter[i]);

        }
        System.out.println("_______________");
    }

}
