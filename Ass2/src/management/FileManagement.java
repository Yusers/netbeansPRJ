/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import ass2.core.Customer;
import ass2.core.Order;
import ass2.core.Product;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author overw
 */
public class FileManagement<E> {

    Path currentRelativePath = Paths.get("");
    private String fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\Customers.txt";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = currentRelativePath.toAbsolutePath().toString() + "\\src\\Info\\" + fileName;
    }

    // Write File
    public void writeFile(ArrayList<Object> list, String fileName) throws IOException {
        boolean flag = true;
        setFileName(fileName != "" ? fileName : null);
        System.out.println("=> File Save: " + getFileName());
        File fout;
        FileOutputStream fos;
        BufferedWriter bw;
        fout = new File(getFileName());
        ArrayList<Object> listP = getListFromFile(fileName);
        if (listP.isEmpty()) {
            updateFile(list);
        } else {
            // check if publishers already in file then nothing update
            int index = 0;
            for (Object e : list) {
                if(!e.equals(listP.get(index))) {
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
            for (Object p : listP) {
                bw.append(p.toString());
                bw.newLine();
            }
            bw.close();
        }
    }

    // updateFile
    public void updateFile(ArrayList<Object> list) {
        String dataType = "Customer";
        setFileName("customers.txt");
        for (Object e : list) {
            if (e instanceof Order) {
                dataType = "Order";
                break;
            } else if (e instanceof Product) {
                dataType = "Product";
                break;
            }
        }
        if (dataType.equals("Order")) {
            setFileName("orders.txt");
        }
        if (dataType.equals("Product")) {
            setFileName("products.txt");
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
            for (Object e : list) {
                bw.write(e.toString().trim());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    // Read from file
    public ArrayList<Object> getListFromFile(String fileName) {
        ArrayList<Object> listInfo = new ArrayList<>();
        setFileName(fileName);
        try {
            File file = new File(getFileName());
            if (!file.exists()) {
                System.out.println("file does not exist!");
                throw new IOException();
            }
            List<String> allLines = Files.readAllLines(Paths.get(getFileName()));
            // set and add to listPublisher
            String[] split = null;
            for (String line : allLines) {
                split = line.split(",");
                if (split.length == 4) {
                    for (int i = 0; i < split.length; i += 4) {
                        Customer customer = new Customer();
                        customer.setId(split[i]);
                        customer.setName(split[i + 1]);
                        customer.setAddress(split[i + 2]);
                        customer.setPhone(split[i + 3]);
                        listInfo.add((E) customer);
                    }
                } else if (split.length == 5) {
                    for (int i = 0; i < split.length; i += 5) {
                        Product product = new Product();
                        product.setId(split[i]);
                        product.setName(split[i + 1]);
                        product.setUnit(split[i + 2]);
                        product.setOrigin(split[i + 3]);
                        product.setPrice(Double.parseDouble(split[i + 4]));
                        listInfo.add((E) product);
                    }
                } else {
                    for (int i = 0; i < split.length; i += 6) {
                        Order order = new Order();
                        order.setId(split[i]);
                        order.setCustomerID(split[i + 1]);
                        order.setProductID(split[i + 2]);
                        order.setQuantity(Integer.parseInt(split[i + 3]));
                        order.setDate(split[i + 4]);
                        order.setStatus(Boolean.parseBoolean(split[i + 5]));
                        listInfo.add((E) order);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }

        return listInfo;
    }
}
