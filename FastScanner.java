import java.io.*;
import java.util.*;

class FastScanner {
        private DataInputStream dataInputStream;
        private byte[] buffer;
        private int pointer, counter;
 
        FastScanner() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[8192];
            pointer = counter = 0;
        }
                                 
        public ArrayList<Integer> nextLine() throws IOException {
            ArrayList<Integer> arrayNumbers = new ArrayList<Integer>();
            byte character;
            int number = 0;
            boolean hasMinus = false;
            while ((character = readCharacter()) != -1) {
           		if (character == '-') {
           			hasMinus = true;
           		} 
           		if (character == 10) {
           			break;
           		}
           		if (Character.isWhitespace(character) && number > 0) { 
           			if (hasMinus) {
           				number = -number;
           				hasMinus = false;
           			}
           			arrayNumbers.add(number);
           			number = 0;
           		}
           		if (Character.isDigit(character)) {
           			number = number * 10 - '0' + character;
           		} 
          	}
            return arrayNumbers;
        }
 
        public boolean hasNextLine() throws IOException {
            byte thrower = readCharacter();
            pointer--;       	
            return !(thrower == -1);
       	}
                                     
        private byte readCharacter() throws IOException {
            if (pointer >= counter) {
            	pointer = 0;
            	counter = dataInputStream.read(buffer);
        	    if (counter == -1) {
    	            buffer[0] = -1;
	            }
			}
			return buffer[pointer++];
        }   
}