package com.csss.training.fileaccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larry on 11/7/15.
 */
public class FileAccess {

    private File file;

    public FileAccess(String fileName){
        this.file = new File(fileName);
    }

    public List<String> readFile() throws IOException{
        ArrayList<String> fileData = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        while(bufferedReader.ready()){
            fileData.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        return fileData;
    }

    public void writeFile(List<String> fileData) throws IOException{
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for(String s: fileData){
            bw.write(s);
            bw.newLine();
        }bw.close();
    }
}
