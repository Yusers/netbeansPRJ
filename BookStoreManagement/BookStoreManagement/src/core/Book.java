
package core;

/**
 *
 * @author Minh Khang
 */
public class Book {
    String bookId;
    String bookName;
    double bookPrice;
    String publisherId;
    String status = "Available";
    int quantity;

    public Book(String bookId, String bookName, double bookPrice, int quantity, String publisherId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.publisherId = publisherId;
        this.quantity = quantity;
    }
    
    public Book(String bookId, String bookName, double bookPrice){
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.quantity = quantity;
        this.publisherId = publisherId;
        status =(quantity>0)? "Available" : "Not available";
    }
        
    public Book(String bookId){
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object obj) {
        Book b =(Book)obj;
        return this.bookId.equalsIgnoreCase(b.bookId);
    }

    @Override
    public String toString() {
        return bookId + ", " + bookName + ", " + bookPrice + ", " + quantity + ", " + publisherId + ", " + status;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
