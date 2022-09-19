import java.util.*;

public class RollTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a valid ticket number!");
        String input = scanner.nextLine();
        char[] inputArr = input.toCharArray();

        if(tryParse(String.valueOf(inputArr)) == null){
            System.out.println("Ticket should have only integer values!");
            System.exit(0);
        }

        if(!isLengthCorrect(inputArr)){
            System.out.println("Ticket should have length of six!");
            System.exit(0);
        }

        System.out.println("The number of tickets in the input roll is: " + getFinalResult(inputArr));
    }

    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static boolean isLengthCorrect(char[] arrLength) {
        if (arrLength.length != 6) {
            return false;
        }else return true;
    }

    private static boolean compareIds(char[] inputArr){

        List<String> firstPart1 = new ArrayList<String>();
        List<String> firstPart2 = new ArrayList<String>();

        for (int i = 0; i < inputArr.length; i++) {
            if (i <= 2) {
                firstPart1.add(String.valueOf(inputArr[i]));
            } else if (i > 2) {
                firstPart2.add(String.valueOf(inputArr[i]));
        }
    }
        Collections.sort(firstPart1);
        Collections.sort(firstPart2);

        return firstPart1.equals(firstPart2);
    }

    private static int getFinalResult(char[] inputArr) {
        int sum = 0;

        if(compareIds(inputArr)){
            for (int i = 0; i < inputArr.length; i++) {
                if (i <= 2) {
                    sum += Character.getNumericValue(inputArr[i]);
                }
            }
        }else{
            System.out.println("The first three digits are not the same of last three digits!");
            System.exit(0);
        }
        return sum;
    }
}


