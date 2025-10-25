package librarymanagementsystem;

public abstract class Book <T> {
    private String bookName;
    private String ISBN;
    private int publicationYear;

    public Book() {
    }
    
    public Book(String bookName, String ISBN, int publicationYear) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    void displayBookInfo(){
        System.out.println(
                "Book Name: "+getBookName()+"\n"+
                "ISBN: "+getISBN()+"\n"+
                "Publication Year: "+getPublicationYear());
    }
    abstract String getBookCategory();

    @Override
    public String toString() {
        return "Book name: " + bookName 
                + "\nISBN: " + ISBN
                + "\nPublication year: " + publicationYear
                + "\nCategory: "+getBookCategory();
    }
    
}
