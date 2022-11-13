public class Decode {
    public static String decode(String encodedString) {

        char[] encodedArray = encodedString.toCharArray();//convert encodedString to array

        StringBuilder c = new StringBuilder();
        int f = 0;

        for (char value : encodedArray) { //To Decode String
            for (int k = 0; k < Main.oriTable.length; k++) {
                if (value == Main.oriTable[k]) { //If encoded characters matches with Offset table then add Offset to Decode String
                    f = 1;
                    c.append(Main.oriTable[k + Main.offNum]);
                    break;
                }
                if (value == ' ') { //If spaces present in array add space
                    c.append(" ");
                    break;
                }
            }
            if (f == 0) { //If f=0 means No character present in table so just re-print it
                c.append(value);
            }
            f = 0; //Re-initialize f=0 for further Calculations
        }

        return c.toString(); //return resultant String
    }
}
