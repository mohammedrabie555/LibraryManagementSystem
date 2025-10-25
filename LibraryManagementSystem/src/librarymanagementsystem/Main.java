package librarymanagementsystem;

import java.util.Scanner;

public class Main {
    
    static LibraryManagementSystem lms = new LibraryManagementSystem();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the City Library: \n");
        
        while(true){
            System.out.println("""
                               1. Add new book
                               2. Display the available books
                               3. Display a specific book info
                               4. Update / Modify a specific book info
                               5. Remove book
                               6. Add new member
                               7. Display all library members
                               8. Display a specific member and his borrowed books
                               9. Update / Modify a member info
                               10.Borrow a book
                               11.Return a borrowed book from a specific member
                               12.Remove member
                               13.Search for a member
                               14.Search for a book
                               15.Exit
                               """);
            String selection = scanner.nextLine();
            switch (selection) {
                case "1" -> {
                    lms.addNewBook();
                }
                case "2" -> {
                    lms.displayAvailableBooksInfo();
                    }
                case "3" -> {
                    lms.displaySpecificBookInfo();
                }
                case "4" -> {
                    lms.modifyBookInfo();
                }
                case "5" -> {
                    lms.removeBook();
                }
                case "6" -> {
                    lms.addNewMember();
                }
                case "7" -> {
                    lms.displayMembersInfo();
                }
                case "8" -> {
                    lms.displayMemberWithHisBorrowedBooks();
                }
                case "9" -> {
                    lms.updateMemberInfo();
                }
                case "10" -> {
                    lms.borrowBook();
                }
                case "11" -> {
                    lms.returnBorrowedBook();
                }
                case "12" -> {
                    lms.removeMember();
                }
                case "13" -> {
                    lms.searchForMember();
                }
                case "14" -> {
                    lms.searchForBook();
                }
                case "15" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid Selection!\n");
                }
            }
        }
    }
}