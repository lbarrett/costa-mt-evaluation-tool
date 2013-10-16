package costamt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class ReadTxt {

    public static ArrayList<String> ReadTxt(ArrayList<String> fileArray, String file) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();

            while (line != null) {

                fileArray.add(line);
                line = reader.readLine();

            }
            reader.close();
        } catch (Exception ex) {
        }
        return fileArray;
    }
}
