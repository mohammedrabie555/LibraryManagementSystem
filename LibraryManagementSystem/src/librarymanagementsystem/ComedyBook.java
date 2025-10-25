package librarymanagementsystem;

public class ComedyBook extends Book{

    public ComedyBook() {
    }
    
    
    public ComedyBook(String bookName, String ISBN, int publicationYear) {
        super(bookName, ISBN, publicationYear);
    }

    @Override
    String getBookCategory() {
        return "Comedy";
    }

    @Override
    void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Category: "+getBookCategory());
    }
    
}
