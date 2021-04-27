package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    private String filename;
    public FileCreator(String filename) {
        this.filename = filename;
    }

    public void createFile(float[] randomNumbers) {
        // if the file already exists, delete it
        File file = new File(filename + ".txt");
        file.delete();

        //write to the new file
        try {
            FileWriter fileWriter = new FileWriter(filename + ".txt");
            for (float randomNumber: randomNumbers) {
                fileWriter.write(String.valueOf(randomNumber));
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println(filename + ".txt has been written.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
