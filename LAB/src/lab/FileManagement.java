/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author overw
 */
public abstract class FileManagement<E> {

    Path currentRelativePath = Paths.get("");
    private String fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Publisher_Info\\Publisher.dat";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\" + fileName;
    }

    public abstract void writeFile() throws IOException;

    public abstract void readFile(String fileName) throws IOException;

//    Generic 
    public void updateFile(ArrayList<E> list, String fileName) {
        String dataType = "Publisher";
        for (E e : list) {
            if (e instanceof Book) {
                dataType = "Book";
                break;
            }
        }
        if (dataType.equals("Book")) {
            setFileName("Book_Info\\Book.dat");
        }
        File file = new File(getFileName());
        if (!file.exists()) {
            System.out.println("File do not exist please try again");
            System.exit(0);
        }
        try {
            File fout = new File(getFileName());
            FileOutputStream fos = new FileOutputStream(fout, false);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            fout.createNewFile();
            for (E p : list) {
                bw.write(p.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
