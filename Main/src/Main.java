
import java.util.Scanner;

public class Main {
    static String encodedString = ""; //Declare static string for storing encodedString output
    static char[] oriTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '*', '+',
            ',', '-', '.', '/' };//Given character Table
    static char[] copyTable = oriTable.clone(); //Make copy of given table
    static char offChar; //class level character of Offset
    static int offNum = 0; //class level Offset number
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// To get input from keyboard
        System.out.println("Please input plain text: ");
        String str = sc.nextLine();     // Example Input String "HELLO WORLD";
        System.out.println("Enter Offset: "); //Enter Offset character,example:B or F
        char in = sc.nextLine().charAt(0); //Read character

        int offset = 0;
        for (int i = 0; i < 44; i++) { //Store offset character index in offset variable
            if (in == oriTable[i]) {
                offset = i;
            }

        }
        offChar = oriTable[offset]; //Store class level offset character
        offNum = offset;       //Store offset index
        System.out.println("Encoded String:= " + in + Encode.encode(str)); //call public String encode(plainText) method
        System.out.println("Decoded String:= "+ Decode.decode(encodedString)); //call public String decode(encodeText) method

    }
}





