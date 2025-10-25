package librarymanagementsystem;

public class HistoricalBook extends Book{

    public HistoricalBook() {
    }
    
    
    public HistoricalBook(String bookName, String ISBN, int publicationYear) {
        super(bookName, ISBN, publicationYear);
    }

    @Override
    String getBookCategory() {
        return "Historical";
    }

    @Override
    void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Category: "+getBookCategory());
    }
    
}
