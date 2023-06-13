package lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import lab.Publisher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author overw
 */
public class PublishersManagement extends FileManagement {

    Scanner sc = new Scanner(System.in);
    Publisher publisher = null;
    ArrayList<Publisher> listPublisher = getListFromFile("");
    String fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Publisher_Info\\Publisher.dat";

    // input() publisher
    public void input() {
        // PublishersID: regex = P[0-9]{5}
        String publishersID = null;
        String publishersName = null;
        String publishersPhone = null;
        boolean flag = true;
        if (listPublisher == null) {
            listPublisher = new ArrayList<>();
        }
        // publishersID input and validated
        do {
            System.out.print("Enter publisher ID(Pxxxxx): ");
            try {
                publishersID = sc.nextLine();
                if (!publishersID.matches("P[0-9]{5}")) {
                    throw new Exception();
                }
                for (Publisher p : listPublisher) {
                    if (p.getId().equals(publishersID)) {
                        throw new Error();
                    }
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! ID must start with P and ends with 5 digits");
            } catch (Error e) {
                System.out.println("ID is duplicated");
            }
        } while (flag);

        // publisherName input and validated
        flag = true;
        do {
            System.out.print("Enter publisher name: ");
            try {
                publishersName = sc.nextLine();
                if (!(publishersName.length() >= 5 && publishersName.length() <= 30)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! name need at least 5 characters and below 30");
            }
        } while (flag);

        // publisherPhone input and validated
        flag = true;
        do {
            System.out.print("Enter publisher phone: ");
            try {
                publishersPhone = sc.nextLine();
                if (!(publishersPhone.length() >= 10 && publishersPhone.length() <= 12)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! phone need at least 10 digits");
            }
        } while (flag);

        publisher = new Publisher();
        publisher.setId(publishersID);
        publisher.setName(publishersName);
        publisher.setPhone(publishersPhone);
        listPublisher.add(publisher);
        // Auto update when user forget to save files on case 3!!
        updateFile(listPublisher, "");
    }

    // Deleted publishers with ID
    public void delete() {
        boolean flag = true;
        String publisherID;
        Iterator<Publisher> iterator = listPublisher.iterator();
        if (listPublisher == null) {
            System.out.println("=> Nothing to delete");
        } else {
            try {
                System.out.print("Enter publisherID to delete: ");
                publisherID = sc.nextLine();
                // If use for each and remove a obj will return exception ConcurrentModificationException
                while (iterator.hasNext()) {
                    Publisher p = iterator.next();
                    if (p.getId().equals(publisherID)) {
                        iterator.remove();
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println("*PublisherId does not exist");
                    System.out.println("=> *Deleted failed");
                } else {
                    System.out.println("=> *Deleted successfully");
                    updateFile(listPublisher, "");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void display() {
        boolean flag = true;
        System.out.println("=> *Did u already save files yet?");
        System.out.print("=> Back (Y/N)? or enter to back!: ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("N")) {
            System.out.println("=> *Please save files first");
        } else {
            listPublisher = getListFromFile("");
            if (listPublisher.isEmpty()) {
                System.out.println("=> Nothing to output");
            } else {
                System.out.println("=== Infomation of Publishers ===");
                Collections.sort(listPublisher, new Comparator<Publisher>() {
                    @Override
                    public int compare(Publisher o1, Publisher o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                for (Publisher p : listPublisher) {
                    System.out.println(p);
                }
            }
        }
    }

    @Override
    public void writeFile() throws IOException {
        boolean flag = true;
        String fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Publisher_Info\\Publisher.dat";
        if (listPublisher.isEmpty()) {
            System.out.println("Please create publisher first!!");
        } else {
            do {
                System.out.print("Custom directions(Y/N) or enter to ignore?: ");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    System.out.print("Enter directions(C:\\Users\\yoursFile): ");
                    fileName = sc.nextLine();
                }
                flag = false;
            } while (flag);
            flag = true;
            System.out.println("=> File save: " + fileName);
            File fout;
            FileOutputStream fos;
            BufferedWriter bw;
            fout = new File(fileName);
            ArrayList<Publisher> listP = getListFromFile("");
            if (listP.isEmpty()) {
                updateFile(listPublisher, "");
            } else {
                // check if publishers already in file then nothing update
                int index = 0;
                for (Publisher p : listPublisher) {
                    if (!(listP.get(index).getId().equals(p.getId()))) {
                        flag = false;
                        index--;
                    }
                    index++;
                }
            }
            if (!flag) {
                fout.createNewFile();
                fos = new FileOutputStream(fout, false);
                bw = new BufferedWriter(new FileWriter(fileName, true));
                for (Publisher p : listPublisher) {
                    bw.append(p.toString());
                    bw.newLine();
                }
                bw.close();
            }

        }
    }

    public ArrayList<Publisher> getListFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        ArrayList<Publisher> listP = new ArrayList<>();
        try {
            if (fileName == "") {
                fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Publisher_Info\\Publisher.dat";
                File file = new File(fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
            List<String> allLines = Files.readAllLines(Paths.get(fileName));
            // set and add to listPublisher
            for (String line : allLines) {
                String[] split = line.split(",");
                for (String s : split) {
                    String[] info = s.split(": ");
                    for (int i = 0; i < info.length; i++) {
                        if (i % 2 != 0) {
                            list.add(info[i]);
                        }
                    }
                }
            }

            for (int i = 0; i < list.size(); i += 3) {
                Publisher p = new Publisher();
                p.setId(list.get(i));
                p.setName(list.get(i + 1));
                p.setPhone(list.get(i + 2));
                listP.add(p);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return listP;
    }

    @Override
    public void readFile(String fileName) throws IOException {
        Path currentRelativePath = Paths.get("");
        if (fileName == "") {
            fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Publisher_Info\\Publisher.dat";
        }
        List<String> allLines = Files.readAllLines(Paths.get(fileName));

        if (listPublisher == null) {
            System.out.println("=> Nothing to read");
        } else {
            for (String line : allLines) {
                System.out.println(line);
            }
        }
    }
}
