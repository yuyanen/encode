public class Encode {
    public static String encode(String plaintext) {//Used to decode plaintext
        char[] charArray = plaintext.toCharArray(); // convert plaintext to character array

        //To Get Offset Table based on Offset value
        for (int j = 0; j < Main.offNum; j++) {
            char lastChar = Main.oriTable[Main.oriTable.length - 1]; //store last element of given array in lastChar variable
            int l = Main.oriTable.length; //Calculate length of array
            int last = Main.oriTable.length - 1;  // last character position
            for (int i = l - 2; i >= 0; i--) { //Shift every character from beginning to end by one time
                Main.oriTable[last] = Main.oriTable[i]; //store oriTable[i]th element in last location of array
                last--; //decrement last so all element till 1st will Shift to last
            }
            Main.oriTable[0] = lastChar; //Store last element of array at 1st location
        }
        int[] position =  new int[charArray.length]; //integer array to store index of resultant array
        int pos = 0; //Index of position array
        int f = 0; //Flag to check whether element of String is present on Table or not
        for (char c : charArray) {
            for (int i = 0; i < Main.copyTable.length; i++) {
                if (c == Main.copyTable[i]) { // IF element from String present in table then add its position in array
                    f = 1; //Indicate element of String is present in Table
                    position[pos] = i; //Store that element index
                    pos++; //Increment pos index of array
                    break;
                }
            }
            if (f == 0 && c != ' ') { //If element from input String not present in table then type cast that character to integer and store in array
                position[pos] = c;
                pos++;
            }
            f = 0;
            if (c == ' ') {//If space is present in input String then add 0 to position array
                position[pos] = 0;
                pos++;
            }
        }
        StringBuilder re = new StringBuilder(); //resultant encoded String to be return
        for (int j : position) {//If 0 present in position array it Indicate presence of space so add space to encoded String
            if (j == 0) {
                re.append(" ");
            }
            if (j != 0 && j >= 0 && j <= 43) {//To encode element from table
                re.append(Main.oriTable[j]);
            }
            if (j >= 97 && j <= 122) { //To encode element of lowerCases
                char single = (char) j; //Typecast integer to character from position array
                re.append(single);
            }
            if (j >= 58 && j <= 64) { //To encode element of special character
                char single = (char) j; ////Typecast integer to character from position array
                re.append(single);
            }
            if (j >= 91 && j <= 96) {//To encode element of special character
                char single = (char) j; //Typecast integer to character from position array
                re.append(single);
            }
            if (j >= 123 && j <= 126) {//To encode element of special character
                char single = (char) j; //Typecast integer to character from position array
                re.append(single);
            }
        }
        Main.encodedString = Main.encodedString + re; //Update static encodedString String for decode
        return re.toString(); //return resultant encoded string
    }

}
