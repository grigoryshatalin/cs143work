
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author YOUR NAME
 *
 */
public class FileIOMethods implements Serializable {

    public static void writeLargeIntegerArray(LargeInteger[] array, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(array);
        }
    }

    public static LargeInteger[] readLargeIntegerArray(String fileName) throws IOException {
        ArrayList<LargeInteger> largeIntegersList = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            LargeInteger[] array = (LargeInteger[]) inputStream.readObject();
            largeIntegersList.addAll(Arrays.asList(array));
        } catch (EOFException e) {
            // End of file reached, continue processing
        } catch (ClassNotFoundException e) {
            // Handle class not found exception if necessary
        }

        return largeIntegersList.toArray(new LargeInteger[largeIntegersList.size()]);
    }

    public static LargeInteger addLargeIntegersFromFile(String fileName) throws IOException {
        try{
        LargeInteger sum = new LargeInteger("0");
        BufferedReader reader = null;
    
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    LargeInteger current = new LargeInteger(line);
                    sum = sum.add(current);
                } catch (LargeIntegerNumberFormatException e) {
                    // Handle the exception if needed, e.g., log it.
                } catch (LargeIntegerOverflowException e) {
                    // Handle the exception if needed, e.g., log it.
                    return null;
                }
            }
        } catch (IOException e) {
            throw e; // Re-throw IOException to the caller.
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Handle the exception if needed, e.g., log it.
                }
            }
        }
    
        return sum;
    }
    catch(LargeIntegerNumberFormatException e){

    }
    return new LargeInteger();
    }
    
}
