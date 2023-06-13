/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author overw
 */
public class BooksManagement extends FileManagement {

    Scanner sc = new Scanner(System.in);
    Book book = null;
    PublishersManagement publisherManagement = new PublishersManagement();
    ArrayList<Book> listBook = getListFromFile("");
    String fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Publisher_Info\\Publisher.dat";

    // input() publisher
    public void input() {
        // Books ID: regex = P[0-9]{5}
        String booksID = null;
        String booksName = null;
        double bookPrice = 0;
        int bookQuantity = 0;
        String bookStatus = "Available";
        String publishersID = "";
        boolean flag = true;
        if (listBook.isEmpty()) {
            listBook = new ArrayList<>();
        }
        // BooksID input and validated
        do {
            System.out.print("Enter book ID(Bxxxxx): ");
            try {
                booksID = sc.nextLine();
                if (!booksID.matches("B[0-9]{5}")) {
                    throw new Exception();
                }
                for (Book b : listBook) {
                    if (b.getId().equals(booksID)) {
                        throw new Error();
                    }
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! ID must start with B and ends with 5 digits");
            } catch (Error e) {
                System.out.println("ID is duplicated");
            }
        } while (flag);

        // bookName input and validated
        flag = true;
        do {
            System.out.print("Enter book name: ");
            try {
                booksName = sc.nextLine();
                if (!(booksName.length() >= 5 && booksName.length() <= 30)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! name need at least 5 characters and below 30");
            }
        } while (flag);

        // bookPrice input and validated
        flag = true;
        do {
            System.out.print("Enter book price: ");
            try {
                bookPrice = Double.parseDouble(sc.nextLine());
                if (!(bookPrice > 0)) {
                    throw new Error();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! " + e);
            } catch (Error e) {
                System.out.println("Price need greater than 0");
            }
        } while (flag);

        // bookQuantity input and validated
        flag = true;
        do {
            try {
                System.out.print("Enter book quantity: ");
                bookQuantity = Integer.parseInt(sc.nextLine());
                if (!(bookQuantity >= 0)) {
                    throw new Error();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! " + e);
            } catch (Error e) {
                System.out.println("Quantity need greater than or equals to 0");
            }
        } while (flag);

        // book publisherID;
        flag = true;
        do {
            try {
                boolean cont = false;
                System.out.print("Enter publisherID: ");
                publishersID = sc.nextLine();
                ArrayList<Publisher> listPublisherFromFiles = publisherManagement.getListFromFile("");
                System.out.println("input from user: " + publishersID);
                for (Publisher p : listPublisherFromFiles) {
                    // If using == operator will return false all case ex: P12345 == P12345 return false;
                    if (p.getId().equals(publishersID)) {
                        cont = true;
                        break;
                    }
                }
                if (!cont) {
                    throw new Error();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! " + e);
            } catch (Error e) {
                System.out.println("PublisherId not found");
            }
        } while (flag);
        book = new Book();
        book.setId(booksID);
        book.setName(booksName);
        book.setPrice(bookPrice);
        book.setQuantity(bookQuantity);
        book.setStatus(book.getStatus());
        book.setBookPublisher(publishersID);
        listBook.add(book);
        // Auto update when user forget to save files on case 3!!
        updateFile(listBook, "");
    }

    // update Book
    public void updateBook() {
        boolean flag = true;
        String booksID = null;
        do {
            System.out.print("Enter book ID(Bxxxxx)to update: ");
            try {
                booksID = sc.nextLine();
                if (!booksID.matches("B[0-9]{5}")) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! ID must start with B and ends with 5 digits");
            }
        } while (flag);
        flag = true;
        int index = -1;
        for (Book b : listBook) {
            if (b.getId().equals(booksID)) {
                index = listBook.indexOf(b);
            }
        }
        if (index >= 0) {
            String booksName = null;
            double bookPrice = 0;
            int bookQuantity = 0;
            String bookStatus = "Available";
            String publishersID = "";
            // bookName input and validated
            flag = true;
            do {
                System.out.print("Enter book name: ");
                try {
                    booksName = sc.nextLine();
                    if (booksName.isEmpty()) {
                        break;
                    }
                    if (!(booksName.length() >= 5 && booksName.length() <= 30)) {
                        throw new Exception();
                    }
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! name need at least 5 characters and below 30");
                }
            } while (flag);

            // bookPrice input and validated
            flag = true;
            do {
                System.out.print("Enter book price: ");
                try {
                    bookPrice = Double.parseDouble(sc.nextLine());
                    if (!(bookPrice > 0)) {
                        throw new Error();
                    }
                    flag = false;
                } catch (NumberFormatException n) {
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! " + e);
                } catch (Error e) {
                    System.out.println("Price need greater than 0");
                }
            } while (flag);

            // bookQuantity input and validated
            flag = true;
            do {
                try {
                    System.out.print("Enter book quantity: ");
                    bookQuantity = Integer.parseInt(sc.nextLine());
                    if (!(bookQuantity >= 0)) {
                        throw new Error();
                    }
                    flag = false;
                } catch (NumberFormatException n) {
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! " + e);
                } catch (Error e) {
                    System.out.println("Quantity need greater than or equals to 0");
                }
            } while (flag);

            // book publisherID;
            flag = true;
            do {
                try {
                    boolean cont = false;
                    System.out.print("Enter publisherID: ");
                    publishersID = sc.nextLine();
                    ArrayList<Publisher> listPublisherFromFiles = publisherManagement.getListFromFile("");
                    if (publishersID.isEmpty()) {
                        throw new UnknownError();
                    }
                    for (Publisher p : listPublisherFromFiles) {
                        // If using == operator will return false all case ex: P12345 == P12345 return false;
                        if (p.getId().equals(publishersID)) {
                            cont = true;
                            break;
                        }
                    }
                    if (!cont) {
                        throw new Error();
                    }
                    flag = false;
                } catch (UnknownError e) {
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! " + e);
                } catch (Error e) {
                    System.out.println("PublisherId not found");
                }
            } while (flag);
            book = new Book();
            book.setId(booksID);
            book.setName(booksName.isEmpty() ? listBook.get(index).getName() : booksName);
            book.setPrice(bookPrice == 0 ? listBook.get(index).getPrice() : bookPrice);
            book.setQuantity(bookQuantity == 0 ? listBook.get(index).getQuantity() : bookQuantity);
            book.setStatus(book.getStatus());
            book.setBookPublisher(publishersID.isEmpty() ? listBook.get(index).getBookPublisher() : publishersID);
            listBook.set(index, book);
            updateFile(listBook, "");
            System.out.println("=> Updated successfully");
        } else {
            flag = false;
            System.out.println("=> *BookID does not exist");
            System.out.println("=> Updated failed");
        }
    }

    //Delete item from list Book
    // Deleted publishers with ID
    public void delete() {
        boolean flag = true;
        String bookId;
        Iterator<Book> iterator = listBook.iterator();
        if (listBook.isEmpty()) {
            System.out.println("=> Nothing to delete");
        } else {
            try {
                System.out.print("Enter bookID to delete: ");
                bookId = sc.nextLine();
                // If use for each and remove a obj will return exception ConcurrentModificationException
                while (iterator.hasNext()) {
                    Book b = iterator.next();
                    if (b.getId().equals(bookId)) {
                        iterator.remove();
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println("*BookId or PublisherId does not exist");
                    System.out.println("=> *Deleted failed");
                } else {
                    System.out.println("=> *Deleted successfully");
                    updateFile(listBook, "");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    // Display items form list Book
    public void display() {
        boolean flag = true;
//        listBook = getListFromFile("");
        System.out.println("=> *Did u already save files yet?");
        System.out.print("=> Back (Y/N)? or enter to Yes!: ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("N")) {
            System.out.println("=> *Please save files first");
        } else {
            if (listBook.isEmpty()) {
                System.out.println("=> Nothing to output");
            } else {
                System.out.println("=== Infomation of Publishers ===");
                Collections.sort(listBook, /* Lamda expression */ (Book o1, Book o2) -> {
                            int cont = (o2.getQuantity() - o1.getQuantity());
                            int result = (int) (cont == 0 ? (o1.getPrice() - o2.getPrice()) : cont);
                            return result;
                        }
                );
                for (Book b : listBook) {
                    System.out.println(b);
                }
            }
        }
    }

    @Override
    public void writeFile() throws IOException {
        boolean flag = true;
        String fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Book_Info\\Book.dat";
        if (listBook.isEmpty()) {
            System.out.println("Please create book first!!");
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
            ArrayList<Book> listB = getListFromFile("");
            if (listB.isEmpty()) {
                updateFile(listBook, "");
            } else {
                // check if Book already in file then nothing update
                int index = 0;
                for (Book b : listBook) {
                    if (!(listB.get(index).getId().equals(b.getId()))) {
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
                for (Book b : listBook) {
                    bw.append(b.toString());
                    bw.newLine();
                }
                bw.close();
            }

        }
    }

    @Override
    public void readFile(String fileName) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Search the book
    public void searchBook() {
        boolean flag = true;
        String[] split = null;
        do {
            try {
                System.out.print("Enter Book name and PublisherId(name, id): ");
                String input = sc.nextLine();
                split = input.split(", ");
                flag = false;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (flag);
        flag = true;
        Collections.sort(listBook, (Book o1, Book o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        for (Book b : listBook) {
            if (b.getName().contains(split[0]) && b.getBookPublisher().contains(split[1])) {
                System.out.println("Id: " + b.getId()
                        + ", Name: " + b.getName()
                        + ", PublisherId: " + b.getBookPublisher()
                        + ", Status: " + b.getStatus()
                        + ", Price: " + b.getPrice()
                        + ", Quantity: " + b.getQuantity()
                );

                flag = false;
            }
        }
        if (flag) {
            System.out.println("=> *Have no any Book!");
        }
    }

    public ArrayList<Book> getListFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        ArrayList<Book> listB = new ArrayList<>();
        try {
            if (fileName == "") {
                fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Book_Info\\Book.dat";
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

            for (int i = 0; i < list.size(); i += 6) {
                Book book = new Book();
                book.setId(list.get(i));
                book.setName(list.get(i + 1));
                book.setPrice(Double.parseDouble(list.get(i + 2)));
                book.setQuantity(Integer.parseInt(list.get(i + 3)));
                book.setBookPublisher(list.get(i + 4));
                book.setStatus(list.get(i + 5));
                listB.add(book);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return listB;
    }
}
