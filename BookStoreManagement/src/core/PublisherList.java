
package core;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import tools.MyUtil;
/**
 *
 * @author Minh Khang
 */
public class PublisherList extends ArrayList<Publisher> {
    String fName = "src\\data\\publishers.dat";
    public void readFromFile(){
        File f = new File(fName);
        if(!f.exists()){
            System.out.println("File is not existed");
            System.exit(0);
        }
        try{
            FileReader fr = new FileReader(f);
            BufferedReader bf= new BufferedReader(fr);
            String line;
            while ((line = bf.readLine()) != null){
                StringTokenizer stk = new StringTokenizer(line, ",");
                String ID = stk.nextToken().trim().toUpperCase();
                String name = stk.nextToken().trim().toUpperCase();
                String phone = stk.nextToken().trim().toUpperCase();
                Publisher p = new Publisher(ID, name, phone);
                this.add(p);
            }
            bf.close();
            fr.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void writeToFile() throws Exception{
        if( this.isEmpty()){
            System.out.println("Empty list!");
        }else{
            PrintWriter pw = new PrintWriter(fName);
            for (Publisher p: this)pw.println(p);
            pw.close();
            System.out.println("Writing file: DONE.");
        }
    }
    public void addPublisher(){
        String ID, name, phone;
        System.out.println("Data of new publisher: ");
        int pos;
        do{
            ID = MyUtil.readPattern("ID: ",  "P[\\d]{5}");
            pos = this.indexOf(new Publisher(ID));
            if(pos >= 0){
                System.out.println("ID is dublicate!");
            }
        }while(pos >= 0);
        name = MyUtil.readString("Name: ", 5, 30);
        phone = MyUtil.readPattern("Phone: ", "[\\d]{10,12}");
        Publisher p = new Publisher(ID, name, phone);
        this.add(p);
        }
    public void search(){
        String ID;
        System.out.println("ID of searched publisher: ");
        ID = MyUtil.SC.nextLine().trim().toUpperCase();
        int pos = this.indexOf(new Publisher(ID));
        if(pos < 0){
            System.out.println("Not found");
        }else{
            System.out.println("Found: " + this.get(pos));
        }
    }
    public void removePublisher(){
        String ID;
        System.out.println("ID of searched publisher:");
        ID = MyUtil.SC.nextLine().trim().toUpperCase();
        int pos = this.indexOf(new Publisher(ID));
        if(pos <0){
            System.out.println("Not found!");
        }else{
            this.remove(pos);
            System.out.println("Removed.");
        }
    }
    public void updatePublisher(){
        String ID;
        String name;
        String phone;
        System.out.println("ID of searches publisher: ");
        ID = MyUtil.SC.nextLine().trim().toUpperCase();
        int pos = this.indexOf(new Publisher(ID));
        if(pos < 0){
            System.out.println("Not found!");
        }else{
            Publisher p = this.get(pos);
            name = MyUtil.readString("Name: ", 5, 30);
            phone = MyUtil.readPattern("New phone: ", "[\\d]{10,12}");
            p.setPublisherName(name);
            p.setPhone(phone);
            System.out.println("Updated.");
        }
    }
    public void print(){
        for (Publisher p: this){
            System.out.println(p);
        }
    }
}
