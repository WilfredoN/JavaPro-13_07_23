package exceptions;
public class ArrayValueCalculator {
    public static int doCalc(String[][] ar) throws ArraySizeException, ArrayDataException {
        int sumReCheck = 0;
        if (ar.length * ar[0].length != 16) throw new ArraySizeException();
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                try {
                    sumReCheck += Integer.parseInt(ar[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new ArrayDataException(i, j);
                }
                }
        }
        return sumReCheck;
    }

    public static void main(String[] args) {
        String[][] workingArray = new String[4][4];
        for (int i = 0; i < workingArray.length; i++) {
            for (int j = 0; j < workingArray[i].length; j++) {
                workingArray[i][j] = String.valueOf((int) (5 + Math.random() * 20));
            }
        }
//        System.out.println(Arrays.deepToString(workingArray));
        String[][] notWorkingArray = new String[2][4];
        for (int i = 0; i < notWorkingArray.length; i++) {
            for (int j = 0; j < notWorkingArray[i].length; j++) {
                notWorkingArray[i][j] = String.valueOf((int) (5 + Math.random() * 20));
            }
        }
        try {
            int output = doCalc(workingArray);
            System.out.println("Сума чисел у масиві - " + output);
        }
        catch (ArraySizeException | ArrayDataException e) {
            System.out.println("Помилка у масиві - " + e.getMessage());
        }
    }
}
