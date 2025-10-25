package librarymanagementsystem;

public class ActionBook extends Book{

    public ActionBook() {
    }
    
    public ActionBook(String bookName, String ISBN, int publicationYear) {
        super(bookName, ISBN, publicationYear);
    }

    @Override
    String getBookCategory() {
        return "Action";
    }

    @Override
    void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Category: "+getBookCategory());
    }
    
}
