package librarymanagementsystem;

public class TragedyBook extends Book{

    public TragedyBook() {
    }
    
    public TragedyBook(String bookName, String ISBN, int publicationYear) {
        super(bookName, ISBN, publicationYear);
    }

    @Override
    String getBookCategory() {
        return "Tragedy";
    }

    @Override
    void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Category: "+getBookCategory());
    }
    
}
