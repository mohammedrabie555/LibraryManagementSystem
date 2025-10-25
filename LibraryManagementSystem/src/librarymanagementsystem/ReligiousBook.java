package librarymanagementsystem;

public class ReligiousBook extends Book{

    public ReligiousBook() {
    }
    
    
    public ReligiousBook(String bookName, String ISBN, int publicationYear) {
        super(bookName, ISBN, publicationYear);
    }

    @Override
    String getBookCategory() {
        return "Religious";
    }

    @Override
    void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Category: "+getBookCategory());
    }
    
}
