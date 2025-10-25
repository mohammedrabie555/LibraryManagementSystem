package librarymanagementsystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    BookDataBase bookDataBase = new BookDataBase(); // to access all book types in data base
    Scanner s = new Scanner(System.in);
    List <Member> member = new ArrayList<>();
    
    /*
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
    */
    
    // #1
    void addNewBook(){
        while(true){
            System.out.println("""
                           Select Category in which you want to add the new book:
                           1. Religious
                           2. Historical
                           3. Cultural
                           4. Dramatic
                           5. Comedy
                           6. Action
                           7. Tragedy
                           8. Return to the main menu
                           """);
            String category = s.nextLine();
            switch(category){
                case "1" -> {
                    add(bookDataBase.religiousBook, new ReligiousBook());
                }
                case "2" -> {
                    add(bookDataBase.historicalBook, new HistoricalBook());
                }
                case "3" -> {
                    add(bookDataBase.culturalBook, new CulturalBook());
                }
                case "4" -> {
                    add(bookDataBase.dramaticBook, new DramaticBook());
                }
                case "5" -> {
                    add(bookDataBase.comedyBook, new ComedyBook());
                }
                case "6" -> {
                    add(bookDataBase.actionBook, new ActionBook());
                }
                case "7" -> {
                    add(bookDataBase.tragedyBook, new TragedyBook());
                }
                case "8" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid Category!\n");
                }
            }
        }
    }
    <T> void add(List <T> b, Book book){
        int c;
        while(true){
            System.out.print("Enter the book name: ");
            char [] name = s.nextLine().trim().toCharArray();
            if(name.length == 0){
                continue;
            }
            c = 0;
            for (int i = 0; i < name.length; i++) {
                if(!((name[i] >= 65 && name[i] <= 90) || 
                    (name[i] >= 97 && name[i] <= 122) || 
                    (name[i] >= 48 && name[i] <= 57) ||
                     name[i] == 32)){
                    c++;
                    break;
                }
            }
            if(c == 0){
                String bookName = String.valueOf(name);
                book.setBookName(bookName);
                break;
            }
            else{
                System.out.println("Special characters are not allowed here!");
            }
        }
        
        while(true){
            System.out.print("Enter the book ISBN: ");
            char [] isbn = s.nextLine().trim().toCharArray();
            if(isbn.length == 0){
                continue;
            }
            c = 0;
            for (int i = 0; i < isbn.length; i++) {
                if(!(isbn[i] >= 48 && isbn[i] <= 57)){
                    c++;
                    break;
                }
            }
            if(c != 0){
                System.out.println("Special characters, spaces or letters are not allowed here!");
            }
            else{
                String ISBN = String.valueOf(isbn);
                book.setISBN(ISBN);
                break;
            }
        }

        int publicationYear;
        while(true){
            System.out.print("Enter the publication year: ");
            char[]pubYear = s.nextLine().trim().toCharArray();
            if(pubYear.length == 0){
                continue;
            }
            for (int i = 0; i < pubYear.length; i++) {
                if(!(pubYear[i] >= 48 && pubYear[i] <= 57 )||( pubYear[i] == 0)){
                    c++;
                    break;
                }
            }
            if(c != 0){
                System.out.println("Special characters, spaces or letters are not allowed here!");
            }
            else{
                String publication = String.valueOf(pubYear);
                publicationYear = Integer.parseInt(publication);
                
                if(publicationYear >= 0){
                    book.setPublicationYear(publicationYear);
                    break;
                }
                else{
                    System.out.println("Invalid Year!");
                }
            }
        }
        
        b.add((T)book);
        System.out.println("\nThe book has been added!\n");
    }
    
    // #2
    void displayAvailableBooksInfo(){
        while(true){
        
            System.out.println("""
                               Select the Category you want to display its books: 
                               1. Religious
                               2. Historical
                               3. Cultural
                               4. Dramatic
                               5. Comedy
                               6. Action
                               7. Tragedy
                               8. Return to the main menu
                               """);
            String category = s.nextLine();
            switch(category){
                case "1" -> {
                    if(!bookDataBase.religiousBook.isEmpty()){
                        System.out.println("This is the Religious books category ");
                        display(bookDataBase.religiousBook);
                    }
                    else{
                        System.out.println("""
                            No books found in this category, Select another one or return to the main menu to add new books to this category
                            """);
                    }
                }
                case "2" -> {
                    if(!bookDataBase.historicalBook.isEmpty()){
                        display(bookDataBase.historicalBook);
                    }
                    else{
                        System.out.println("""
                            No books found in this category, Select another one or return to the main menu to add new books to this category
                            """);
                    }
                }
                case "3" -> {
                    if(!bookDataBase.culturalBook.isEmpty()){
                        display(bookDataBase.culturalBook);
                    }
                    else{
                        System.out.println("""
                            No books found in this category, Select another one or return to the main menu to add new books to this category
                            """);
                    }
                }
                case "4" -> {
                    if(!bookDataBase.dramaticBook.isEmpty()){
                        display(bookDataBase.dramaticBook);
                    }
                    else{
                        System.out.println("""
                            No books found in this category, Select another one or return to the main menu to add new books to this category
                            """);
                    }
                }
                case "5" -> {
                    if(!bookDataBase.comedyBook.isEmpty()){
                        display(bookDataBase.comedyBook);
                    }
                    else{
                        System.out.println("""
                            No books found in this category, Select another one or return to the main menu to add new books to this category
                            """);
                    }
                }
                case "6" -> {
                    if(!bookDataBase.actionBook.isEmpty()){
                        display(bookDataBase.actionBook);
                    }
                    else{
                        System.out.println("""
                            No books found in this category, Select another one or return to the main menu to add new books to this category
                            """);
                    }
                }
                case "7" -> {
                    if(!bookDataBase.tragedyBook.isEmpty()){
                        display(bookDataBase.tragedyBook);
                    }
                    else{
                        System.out.println("""
                            No books found in this category, Select another one or return to the main menu to add new books to this category
                            """);
                    }
                }
                case "8" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid Category!");
                }
            }
        }
    }
    <T> void display(List <T> b){
        int numberOfBooks = b.size();
        System.out.println("Number of books: " + numberOfBooks + 
                "\n--------------------------\n");
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.print((i+1)+". "+b.get(i));
            System.out.println("\n--------------------------");
        }
        System.out.println();
    }
    
    // #3
    void displaySpecificBookInfo(){
        while(true){
            System.out.println("""
                           Select Category you want to display a specific book info from it:
                           1. Religious
                           2. Historical
                           3. Cultural
                           4. Dramatic
                           5. Comedy
                           6. Action
                           7. Tragedy
                           8. Return to the main menu
                           """);
            String category = s.nextLine();
            switch(category){
                case "1" -> {
                    System.out.println("This is the Religious books category: ");
                    displaySpecific(bookDataBase.religiousBook);
                }
                case "2" -> {
                    System.out.println("This is the Historical books category: ");
                    displaySpecific(bookDataBase.historicalBook);
                }
                case "3" -> {
                    System.out.println("This is the Cultural books category: ");
                    displaySpecific(bookDataBase.culturalBook);
                }
                case "4" -> {
                    System.out.println("This is the Dramatic books category: ");
                    displaySpecific(bookDataBase.dramaticBook);
                }
                case "5" -> {
                    System.out.println("This is the Comedy books category: ");
                    displaySpecific(bookDataBase.comedyBook);
                }
                case "6" -> {
                    System.out.println("This is the Action books category: ");
                    displaySpecific(bookDataBase.actionBook);
                }
                case "7" -> {
                    System.out.println("This is the Tragedy books category: ");
                    displaySpecific(bookDataBase.tragedyBook);
                }
                case "8" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid Category!");
                }
            }
        }
    }
    <T> void displaySpecific(List <T> b){
        int numberOfBooks = b.size();
        int selectedBook;

        if(!b.isEmpty()){
            System.out.println("Number of books in this Category is: "+ numberOfBooks +"\n");
            int c;
            while(true){
                System.out.print("Select a book you want to display its information: \n");    
                char[]s_book = s.nextLine().trim().toCharArray();
                if(s_book.length == 0){
                    continue;
                }
                c = 0;
                for (int i = 0; i < s_book.length; i++) {
                    if(!(s_book[i] >= 48 && s_book[i] <= 57)){
                        c++;
                        break;
                    }
                }
                if(c != 0){
                    System.out.println("Only numbers are allowed here. Special character, spaces or letters are not allowed!");
                }
                else{
                    String select = String.valueOf(s_book);
                    selectedBook = Integer.parseInt(select);
                    
                    if(selectedBook > 0 && selectedBook <= numberOfBooks){
                        System.out.println(b.get(selectedBook - 1));
                        System.out.println("---------------------------------\n");
                        break;
                    }
                    else{
                        System.out.println("Invalid book, Select a valid book!\n");
                    }
                }
            }
        }
        else{
            System.out.println("No books found in this category!");
        }
    }
    
    // #4
    void modifyBookInfo(){
        int selection;
        while(true){
            System.out.println("""
                           Select Category:
                           1. Religious
                           2. Historical
                           3. Cultural
                           4. Dramatic
                           5. Comedy
                           6. Action
                           7. Tragedy
                           8. Return to the main menu
                           """);
            String category = s.nextLine();
            switch(category){
                case "1" -> {
                    if(bookDataBase.religiousBook.isEmpty()){
                        System.out.println("No books found in Religious category! Select another category");
                    }
                    else{
                        selection = selectedBook(bookDataBase.religiousBook);
                        modify(bookDataBase.religiousBook.get(selection - 1));
                    }
                }
                case "2" -> {
                    if(bookDataBase.historicalBook.isEmpty()){
                        System.out.println("No books found in Historical category! Select another category");
                    }
                    else{
                        selection = selectedBook(bookDataBase.historicalBook);
                        modify(bookDataBase.historicalBook.get(selection - 1));
                    }
                    
                }
                case "3" -> {
                    if(bookDataBase.culturalBook.isEmpty()){
                        System.out.println("No books found in Cultural category! Select another category");
                    }
                    else{
                        selection = selectedBook(bookDataBase.culturalBook);
                        modify(bookDataBase.culturalBook.get(selection - 1));
                    }
                    
                }
                case "4" -> {
                    if(bookDataBase.dramaticBook.isEmpty()){
                        System.out.println("No books found in Dramatic category! Select another category");
                    }
                    else{
                        selection = selectedBook(bookDataBase.dramaticBook);
                        modify(bookDataBase.dramaticBook.get(selection - 1));
                    }
                }
                case "5" -> {
                    if(bookDataBase.comedyBook.isEmpty()){
                        System.out.println("No books found in Comedy category! Select another category");
                    }
                    else{
                        selection = selectedBook(bookDataBase.comedyBook);
                        modify(bookDataBase.comedyBook.get(selection - 1));
                    }
                }
                case "6" -> {
                    if(bookDataBase.actionBook.isEmpty()){
                        System.out.println("No books found in Action category! Select another category");
                    }
                    else{
                        selection = selectedBook(bookDataBase.actionBook);
                        modify(bookDataBase.actionBook.get(selection - 1));
                    }
                }
                case "7" -> {
                    if(bookDataBase.actionBook.isEmpty()){
                        System.out.println("No books found in Tragedy category! Select another category");
                    }
                    else{
                        selection = selectedBook(bookDataBase.actionBook);
                        modify(bookDataBase.tragedyBook.get(selection - 1));
                    }
                }
                case "8" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid Category!");
                }
            }
        }
    }
    void modify(Book b){
//        boolean flag = true;
        int c;
        while(true){
            System.out.println("""
                                   Select what to modify: 
                                   1. Book name
                                   2. ISBN
                                   3. Publication Year
                                   4. Go to previous menu
                                   """);
            String op = s.nextLine();
            switch(op){
                case "1" -> {
                    System.out.println("The old book name: " + 
                            b.getBookName());

                    while(true){
                        System.out.print("Enter the new name: ");
                        char [] name = s.nextLine().trim().toCharArray();
                        if(name.length == 0){
                            continue;
                        }
                        c = 0;
                        for (int i = 0; i < name.length; i++) {
                            if(!((name[i] >= 65 && name[i] <= 90) || 
                                (name[i] >= 97 && name[i] <= 122) || 
                                (name[i] >= 48 && name[i] <= 57) ||
                                 name[i] == 32)){
                                c++;
                                break;
                            }
                        }
                        if(c == 0){
                            String newBookName = String.valueOf(name);
                            b.setBookName(newBookName);
                            break;
                        }
                        else{
                            System.out.println("Special characters are not allowed here!");
                        }
                    }

                    System.out.println("The new book name is: "+
                            b.getBookName());
                    System.out.println("-------------------------");
                }
                case "2" -> {
                    System.out.println("The old ISBN for this book is: " + 
                            b.getISBN());

                    while(true){
                        System.out.print("Enter the new ISBN: ");
                        char [] isbn = s.nextLine().trim().toCharArray();
                        if(isbn.length == 0){
                            continue;
                        }
                        c = 0;
                        for (int i = 0; i < isbn.length; i++) {
                            if(!(isbn[i] >= 48 && isbn[i] <= 57)){
                                c++;
                                break;
                            }
                        }
                        if(c == 0){
                            String newISBN = String.valueOf(isbn);
                            b.setISBN(newISBN);
                            break;
                        }
                        else{
                            System.out.println("Special characters, spaces or letters are not allowed here!");
                        }
                    }

                    System.out.println("The new ISBN is: "+
                            b.getISBN());
                    System.out.println("-------------------------");
                }
                case "3" -> {
                    System.out.println("The old book publication year: " + 
                            b.getPublicationYear());
                    while(true){
                        System.out.print("Enter the new book publication year: ");
                        char [] pub_year = s.nextLine().trim().toCharArray();
                        if(pub_year.length == 0){
                            continue;
                        }
                        c = 0;
                        
                        for (int i = 0; i < pub_year.length; i++) {
                            if(!(pub_year[i] >= 48 && pub_year[i] <= 57)){
                                c++;
                                break;
                            }
                        }
                        
                        if(c == 0){
                            String pubYear = String.valueOf(pub_year);
                            int newPubYear = Integer.parseInt(pubYear);
                            b.setPublicationYear(newPubYear);
                            break;
                        }
                        else{
                            System.out.println("Special characters, spaces or letters are not allowed here!");
                        }
                    }
                    System.out.println("The new book publication year is: "+
                            b.getPublicationYear());
                    System.out.println("-------------------------");
                }
                case "4" -> {
//                    flag = false;
                    return ;
                }
                default -> {
                    System.out.println("Invalid option!");
                }
            }
        }
    }
    <T> int selectedBook(List <T> b){
        int c = 0;
        int numberOfBooks = b.size();
        int selectedBook;
        display(b);
        
        while(true){
            System.out.print("Which book you want to update/modify its infotmation: ");
            char [] selected_book = s.nextLine().trim().toCharArray();
                if(selected_book.length == 0){
                    continue;
                }
            for (int i = 0; i < selected_book.length; i++) {
                if(!(selected_book[i] >= 48 && selected_book[i] <= 57)){
                    c++;
                    break;
                }
            }
                
            if(c != 0){
                System.out.println("Only numbers are allowed here. Special character, spaces or letters are not allowed!\n");
            }
            else{
                String selected = String.valueOf(selected_book);
                selectedBook = Integer.parseInt(selected);
                    
                if(selectedBook > 0 && selectedBook <= numberOfBooks){
                    return selectedBook;
                }
                else{
                    System.out.println("Invalid Book, Enter a valid book!\n");
                }
            }
        }
    }
    
    // #5
    void removeBook(){
        while(true){
            System.out.println("""
                           Select Category you want to remove a book from it:
                           1. Religious
                           2. Historical
                           3. Cultural
                           4. Dramatic
                           5. Comedy
                           6. Action
                           7. Tragedy
                           8. Return to the main menu
                           """);
            String category = s.nextLine();
            switch(category){
                case "1" -> {
                    System.out.println("This is the Religious books category: ");
                    remove(bookDataBase.religiousBook);
                }
                case "2" -> {
                    System.out.println("This is the Historical books category: ");
                    remove(bookDataBase.historicalBook);
                }
                case "3" -> {
                    System.out.println("This is the Cultural books category: ");
                    remove(bookDataBase.culturalBook);
                }
                case "4" -> {
                    System.out.println("This is the Dramatic books category: ");
                    remove(bookDataBase.dramaticBook);
                }
                case "5" -> {
                    System.out.println("This is the Comedy books category: ");
                    remove(bookDataBase.comedyBook);
                }
                case "6" -> {
                    System.out.println("This is the Action books category: ");
                    remove(bookDataBase.actionBook);
                }
                case "7" -> {
                    System.out.println("This is the Tragedy books category: ");
                    remove(bookDataBase.tragedyBook);
                }
                case "8" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid Category!");
                }
            }
        }
    }
    <T> void remove (List <T> b) {
        int c = 0;
        int numberOfBooks = b.size();
        if(!b.isEmpty()){
            display(b);
            int selectedBook;
            
            System.out.println("Which book you want to remove: select number");
            while(true){
                char[]s_book = s.nextLine().trim().toCharArray();
                if(s_book.length == 0){
                    continue;
                }
                for (int i = 0; i < s_book.length; i++) {
                    if(!(s_book[i] >= 48 && s_book[i] <= 57)){
                        c++;
                        break;
                    }
                }
                if(c != 0){
                    System.out.println("Only numbers are allowed here. Special character, spaces or letters are not allowed!\n");
                }
                else{
                    String select = String.valueOf(s_book);
                    selectedBook = Integer.parseInt(select);
                    
                    if(selectedBook > 0 && selectedBook <= numberOfBooks){
                        b.remove(selectedBook - 1);
                        System.out.println("\nThe selected book has been removed!\n");
                        break;
                    }
                    else{
                        System.out.println("Invalid book!\n");
                    }
                }
            }
        }
        else{
            System.out.println("\nNo books found in this category!\n");
        }
    }
    
    // #6
    void addNewMember(){
        int c;
        int memberAge = 0;
        String memberFirstName;
        String memberLastName;
        String memberAddress;
        String jobTitle;
        boolean flag = true;
        
        do{
            while(true){
                System.out.print("Enter member first name: ");
                char [] memberFname = s.nextLine().trim().toCharArray();
                if(memberFname.length == 0){
                    continue;
                }
                c = 0;
                for (int i = 0; i < memberFname.length; i++) {
                    if(!((memberFname[i] >= 65 && memberFname[i] <= 90) || 
                        (memberFname[i] >= 97 && memberFname[i] <= 122) ||
                         memberFname[i] == 32)){
                        c++;
                        break;
                    }
                }
                if(c == 0){
                    memberFirstName = String.valueOf(memberFname);
                    break;
                }
                else{
                    System.out.println("Special characters or numbers are not allowed here!\n");
                }
            }
            
            while(true){
                System.out.print("Enter member last name: ");
                char [] memberLname = s.nextLine().trim().toCharArray();
                if(memberLname.length == 0){
                    continue;
                }
                c = 0;
                for (int i = 0; i < memberLname.length; i++) {
                    if(!((memberLname[i] >= 65 && memberLname[i] <= 90) || 
                        (memberLname[i] >= 97 && memberLname[i] <= 122) ||
                         memberLname[i] == 32)){
                        c++;
                        break;
                    }
                }
                if(c == 0){
                    memberLastName = String.valueOf(memberLname);
                    break;
                }
                else{
                    System.out.println("Special characters or numbers are not allowed here!\n");
                }
            }
            
            while(true){
                c = 0;
                
                System.out.print("Enter member age: ");
                char [] charAge = s.nextLine().trim().toCharArray();
                if(charAge.length == 0){
                    continue;
                }
                for (int i = 0; i < charAge.length; i++) {
                    if(!(charAge[i] >= 48 && charAge[i] <= 57)){
                        c++;
                        break;
                    }
                }
                
                if(c != 0){
                    System.out.println("Only numbers are allowed here. Special character, spaces or letters are not allowed!\n");
                }
                else{
                    String age = String.valueOf(charAge);
                    memberAge = Integer.parseInt(age);
                    break;
                }
            }
            
            System.out.print("Enter member address: ");
            memberAddress = s.nextLine().trim();
            
            while(true){
                System.out.print("Enter member job title: ");
                char [] job = s.nextLine().trim().toCharArray();
                if(job.length == 0){
                    continue;
                }
                c = 0;
                for (int i = 0; i < job.length; i++) {
                    if(!((job[i] >= 65 && job[i] <= 90) || 
                        (job[i] >= 97 && job[i] <= 122) ||
                         job[i] == 32)){
                        c++;
                        break;
                    }
                }
                if(c != 0){
                    System.out.println("Special characters or numbers are not allowed here!");
                }
                else{
                    jobTitle = String.valueOf(job);
                    break;
                }
            }
            
            member.add(new Member(memberFirstName, memberLastName, memberAge, memberAddress, jobTitle));
            System.out.println("\nNew member has been added!\n");
            
            System.out.println("Do you want to add another member ? \n1. Yes\n2. No");
            while(true){
                    String op = s.nextLine();
                    switch(op){
                        case "1" -> {
                            flag = true;
                        }
                        case "2" -> {
                            flag = false;
                        }
                        default -> {
                            System.out.println("Invalid Selection!");
                            continue;
                        }
                    }
                break;
            }
            System.out.println();
        }while(flag);
    }
    
    // #7
    void displayMembersInfo(){
        int numberOfMembers = member.size();
        if(!member.isEmpty()){
            System.out.println("Number of members in the library data base: " + numberOfMembers + "\n");
            for(int i = 0; i < numberOfMembers; i++){
                System.out.print((i+1)+". ");
                member.get(i).display();
                System.out.println("-----------------------------");
            }
            System.out.println();
        }
        else{
            System.out.println("No member found, please add new members from the main menu.");
        }
    }
    
    // #8
    void displayMemberWithHisBorrowedBooks(){
        int numberOfMembers = member.size();
        
        if(!member.isEmpty()){
            System.out.println("Number of members in the library data base: " + numberOfMembers + "\n");
            
            for(int i = 0; i < numberOfMembers; i++){
                System.out.print((i+1)+". ");
                member.get(i).display();
                
                if(member.get(i).book.isEmpty()){
                    System.out.println("Borrowed book(s): No Borrowed Book(s)");
                }
                
                else{
                    System.out.println("Borrowed book(s): \n");
                    
                    for (int j = 0; j < member.get(i).book.size(); j++) {
                        System.out.println((j+1) + ". ");
                        member.get(i).book.get(j).displayBookInfo();
                        System.out.println();
                    }
                    
                }
                System.out.println("-----------------------------");
            }
            System.out.println();
        }
        else{
            System.out.println("No member found, please add new members from the main menu.");
        }
    }
    
    // #9
    void updateMemberInfo() {
        while(true){
            displayMembersInfo();
            int numberOfMembers = member.size();
            int selectedMember;

            while(true){
                int c = 0;
                System.out.println("Select the member you want to modify his information: ");
                char [] s_member = s.nextLine().trim().toCharArray();
                if(s_member.length == 0){
                    continue;
                }
                for (int i = 0; i < s_member.length; i++) {
                    if(!(s_member[i] >= 48 && s_member[i] <= 57)){
                        c++;
                        break;
                    }
                }
                
                if(c != 0){
                    System.out.println("Only numbers are allowed here. Special character, spaces or letters are not allowed!\n");
                }
                else{
                    String selected = String.valueOf(s_member);
                    selectedMember = Integer.parseInt(selected);
                    
                    if(selectedMember > 0 && selectedMember <= numberOfMembers){
                        break;
                    }
                    else{
                        System.out.println("Invalid member, Select a valid member!\n");
                    }
                }
            }
            boolean flag = true;
            while(flag){
                System.out.println("""

                                   Select what to modify: 
                                   1. First name.
                                   2. Last name.
                                   3. Age.
                                   4. Address.
                                   5. Job title
                                   6. Select another member
                                   7. Return to the main menu
                                   """);
                String op = s.nextLine();
                int c;
                switch (op) {
                    case "1" -> {
                        //before
                        System.out.println("The old first name is: "+
                                member.get(selectedMember -1).getMemberFirstName()+" "+
                                member.get(selectedMember -1).getMemberLastName());

                        //Modifying
                        while(true){
                            System.out.print("Enter the new first name: ");
                            char [] fname = s.nextLine().trim().toCharArray();
                            if(fname.length == 0){
                                continue;
                            }
                            c = 0;
            
                            for (int i = 0; i < fname.length; i++) {
                                if(!((fname[i] >= 65 && fname[i] <= 90) || 
                                    (fname[i] >= 97 && fname[i] <= 122) ||
                                     fname[i] == 32)){
                                    c++;
                                    break;
                                }
                            }
                            if(c == 0){
                                String newMemberFirstName = String.valueOf(fname);
                                member.get(selectedMember -1).setMemberFirstName(newMemberFirstName);
                                break;
                            }
                            else{
                                System.out.println("Special characters or numbers are not allowed here!");
                            }
                        }                

                        //after
                        System.out.println("\nThe new name after modifying first name is: "+
                                member.get(selectedMember -1).getMemberFirstName()+" "+
                                member.get(selectedMember -1).getMemberLastName());
                    }
                    case "2" -> {
                        //before
                        System.out.println("The old last name is: "+
                                member.get(selectedMember -1).getMemberFirstName()+" "+
                                member.get(selectedMember -1).getMemberLastName());

                        //modifying
                        while(true){
                            System.out.print("Enter the new last name: ");
                            char [] lname = s.nextLine().trim().toCharArray();
                            if(lname.length == 0){
                                continue;
                            }
                            c = 0;
            
                            for (int i = 0; i < lname.length; i++) {
                                if(!((lname[i] >= 65 && lname[i] <= 90) || 
                                    (lname[i] >= 97 && lname[i] <= 122) ||
                                     lname[i] == 32)){
                                    c++;
                                    break;
                                }
                            }
                            if(c == 0){
                                String newMemberLastName = String.valueOf(lname);
                                member.get(selectedMember -1).setMemberLastName(newMemberLastName);
                                break;
                            }
                            else{
                                System.out.println("Special characters or numbers are not allowed here!");
                            }
                        }

                        //after
                        System.out.println("\nThe new name after modifying last name is: "+
                                member.get(selectedMember -1).getMemberFirstName()+" "+
                                member.get(selectedMember -1).getMemberLastName());
                    }
                    case "3" -> {
                        //before
                        System.out.println("The age of this member before modifying is: "+
                                member.get(selectedMember -1).getMemberAge());
                        
                        //modifying
                        while(true){
                            c = 0;
                            int newAge;
                            System.out.print("Enter the new age: ");
                            char [] charAge = s.nextLine().trim().toCharArray();
                            if(charAge.length == 0){
                                continue;
                            }
                            for (int i = 0; i < charAge.length; i++) {
                                if(!(charAge[i] >= 48 && charAge[i] <= 57)){
                                    c++;
                                    break;
                                }
                            }
                            if(c != 0){
                                System.out.println("Only numbers are allowed here. Special character, spaces or letters are not allowed!");
                            }
                            else{
                                String age = String.valueOf(charAge);
                                newAge = Integer.parseInt(age);
                                member.get(selectedMember - 1).setMemberAge(newAge);
                                break;
                            }
                        }
                        //after
                        System.out.println("The age of this member after modifying is: "+
                                member.get(selectedMember - 1).getMemberAge());
                    }
                    case "4" -> {
                        //before
                        System.out.println("The old address of this member is: "+
                                member.get(selectedMember - 1).getMemberAddress());

                        //modifying
                        System.out.println("Enter the new Address: ");
                        member.get(selectedMember - 1).setMemberAddress(s.nextLine().trim());

                        //after
                        System.out.println("Then new address of this member is: "+
                                member.get(selectedMember - 1).getMemberAddress());
                    }
                    case "5" -> {
                        //before
                        System.out.println("The old job title of this member is: "+
                                member.get(selectedMember - 1).getJobTitle());

                        //modifying
                        while(true){
                            System.out.print("Enter the new job title: ");
                            char [] job = s.nextLine().trim().toCharArray();
                            if(job.length == 0){
                                continue;
                            }
                            c = 0;
            
                            for (int i = 0; i < job.length; i++) {
                                if(!((job[i] >= 65 && job[i] <= 90) || 
                                    (job[i] >= 97 && job[i] <= 122) ||
                                     job[i] == 32)){
                                    c++;
                                    break;
                                }
                            }
                            if(c == 0){
                                String newMemberJobTitle = String.valueOf(job);
                                member.get(selectedMember - 1).setJobTitle(newMemberJobTitle);
                                break;
                            }
                            else{
                                System.out.println("Special characters or numbers are not allowed here!");
                            }
                        }

                        //after
                        System.out.println("Then new job title of this member is: "+
                                member.get(selectedMember - 1).getJobTitle());
                    }
                    case "6" -> {
                        flag = false;
                    }
                    case "7" -> {
                        return;
                    }
                    default->{
                        System.out.print("invalid selection! select again: ");
                    }
                }
            }
        }
    }
    
    // #10
    void borrowBook(){
        boolean flag = true;
        do{
            System.out.println("""
                            Select your favorite book category: 
                            1. Religious
                            2. Historical
                            3. Cultural
                            4. Dramatic
                            5. Comedy
                            6. Action
                            7. Tragedy
                            8. Go to the main menu
                            """);
            String cat = s.nextLine();
            switch(cat){
                case "1" -> {
                    borrow(bookDataBase.religiousBook, member);
                }
                case "2" -> {
                    borrow(bookDataBase.historicalBook, member);
                }
                case "3" -> {
                    borrow(bookDataBase.culturalBook, member);
                }
                case "4" -> {
                    borrow(bookDataBase.dramaticBook, member);
                }
                case "5" -> {
                    borrow(bookDataBase.comedyBook, member);
                }
                case "6" -> {
                    borrow(bookDataBase.actionBook, member);
                }
                case "7" -> {
                    borrow(bookDataBase.tragedyBook, member);
                }
                case "8" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid category! Select again: ");
                }
            }
            
            System.out.println("Do you want to continue the borrowing process ?\n1. Yes\n2. No\n");
            while(true){
                String op = s.nextLine();
                switch(op){
                    case "1" -> {
                        flag = true;
                    }
                    case "2" -> {
                        flag = false;
                    }
                    default -> {
                        System.out.println("Invalid Selection!");
                        continue;
                    }
                }
                break;
            }
        }while(flag);
    }
    <T> void borrow(List <T> b, List <Member> m){
        int numberOfMembers = member.size();
        int numberOfBooks = b.size();
        int selectedMember;
        int selectedBook;
        int c = 0;
        
        if(!b.isEmpty()){
            if(!m.isEmpty()){
                displayMembersInfo();
                while(true){
                    System.out.println("Select a member you want to borrow a book for him: ");
                    char[]s_member = s.nextLine().trim().toCharArray();
                    if(s_member.length == 0){
                        continue;
                    }
                    for(int i = 0; i < s_member.length; i++){
                        if(s_member[i] >= 48 && s_member[i] <= 57){
                            c++;
                            break;
                        }
                    }
                    if(c != 0){
                        System.out.println("Only numbers are allowed here. Special character, spaces or letters are not allowed!\n");
                    }
                    else{
                        String select = String.valueOf(s_member);
                        selectedMember = Integer.parseInt(select);
                        
                        if(selectedMember > 0 && selectedMember <= numberOfMembers){
                            break;
                        }
                        else{
                            System.out.println("Invalid Member, Select a valid member!\n");
                        }
                    }
                }
                
                display(b);
                
                
                while(true){
                    System.out.println("Select a book form your favorite category: ");
                    char[]s_book = s.nextLine().trim().toCharArray();
                    if(s_book.length == 0){
                        continue;
                    }
                    for(int i = 0; i < s_book.length; i++){
                        if(s_book[i] >= 48 && s_book[i] <= 57){
                            c++;
                            break;
                        }
                    }
                    if(c != 0){
                        System.out.println("Only numbers are allowed here. Special character, spaces or letters are not allowed!\n");
                    }
                    else{
                        String select = String.valueOf(s_book);
                        selectedBook = Integer.parseInt(select);
                        
                        if(selectedBook > 0 && selectedBook <= numberOfBooks){
                            break;
                        }
                        else{
                            System.out.println("Invalid Book, Select a valid Book!\n");
                        }
                    }
                }
                    
                for (int i = 0; i < m.get(selectedMember - 1).book.size(); i++) {
                        
                    if(((Book)b.get(selectedBook - 1)).getISBN().equalsIgnoreCase
                        (m.get(selectedMember - 1).book.get(i).getISBN()) 
                        &&
                        ((Book)b.get(selectedBook - 1)).getBookName().equalsIgnoreCase
                        (m.get(selectedMember - 1).book.get(i).getBookName())
                       ){
                            System.out.println("\n"+
                                m.get(selectedMember - 1).getMemberFirstName()+" "+ 
                                m.get(selectedMember - 1).getMemberLastName() + 
                                " has already borrowed this book! \n"
                            );
                    }
                }
                    
                    //adding the book to the selected member
                    m.get(selectedMember - 1).book.add((Book)b.get(selectedBook - 1));   
                    
                    
                    System.out.println(
                        m.get(selectedMember - 1).getMemberFirstName()+" "+ 
                        m.get(selectedMember - 1).getMemberLastName() + " has borrowed \""+
                        ((Book)b.get(selectedBook - 1)).getBookName() + "\" book.\n"
                    );
                    
                    //removing the book from the selected category in library database
                    b.remove(selectedBook - 1);
            }
            else{
                System.out.println("No members found in the data base!");
            }
        }
        else{
            System.out.println("No books found in this category!");
        }
    }
    
    // #11
    void returnBorrowedBook(){
        int c;
        int numberOfBorrowedBooks;
        int numberOfMembers = member.size();
//            boolean flag1 = true;
        boolean flag = true;
//        do{
        do{
            c = 0;
            displayMembersInfo();
            int selectedMember;
                
            while(true){
                System.out.println("\nSelect a member you want to return of his borrowed books: ");
                char[]s_member = s.nextLine().trim().toCharArray();
                if(s_member.length == 0){
                    continue;
                }
                for (int i = 0; i < s_member.length; i++) {
                    if(!(s_member[i] >= 48 && s_member[i] <= 57)){
                        c++;
                        break;
                    }
                }
                if(c != 0){
                    System.out.print("\nOnly numbers are allowed here. Special character, spaces or letters are not allowed!\n");
                }
                else{
                    String select = String.valueOf(s_member);
                    selectedMember = Integer.parseInt(select);
                    
                    if(selectedMember > 0 && selectedMember <= numberOfMembers){
                        break;
                    }
                    else{
                        System.out.println("Invalid member, Select a valid member!\n");
                    }
                }
            }
            if(member.get(selectedMember - 1).book.isEmpty()){
                System.out.println("\nNo borrowed books for "+
                    member.get(selectedMember - 1).getMemberFirstName()+" "+
                    member.get(selectedMember - 1).getMemberLastName()+"\n");
                break;
            }
            
            numberOfBorrowedBooks = member.get(selectedMember - 1).book.size();
            
            System.out.println(
                    member.get(selectedMember - 1).getMemberFirstName()+" "+
                    member.get(selectedMember - 1).getMemberLastName()+" has borrowed: ");
            display(member.get(selectedMember - 1).book);
            
            int selectedBook;
            while(true){
                System.out.println("\nSelect the book you want to return: ");
                char[]s_book = s.nextLine().trim().toCharArray();
                if(s_book.length == 0){
                    continue;
                }
                for (int i = 0; i < s_book.length; i++) {
                    if(!(s_book[i] >= 48 && s_book[i] <= 57)){
                        c++;
                        break;
                    }
                }
                if(c != 0){
                    System.out.print("Only numbers are allowed here. Special character, spaces or letters are not allowed!\n");
                }
                else{
                    String select = String.valueOf(s_book);
                    selectedBook = Integer.parseInt(select);
                    
                    if(selectedBook > 0 && selectedBook <= numberOfBorrowedBooks){
                        break;
                    }
                    else{
                        System.out.println("Invalid book, Select a valid book!\n");
                    }
                }
            }     
            //adding the book to the library database
            if(member.get(selectedMember - 1).book.get(selectedBook - 1).getBookCategory()
                .equalsIgnoreCase("religious")){
                bookDataBase.religiousBook.add((ReligiousBook)member.get(selectedMember - 1).book.get(selectedBook - 1));
            }
            else if(member.get(selectedMember - 1).book.get(selectedBook - 1).getBookCategory()
                .equalsIgnoreCase("historical")){
                bookDataBase.historicalBook.add((HistoricalBook)member.get(selectedMember - 1).book.get(selectedBook - 1));
            }
            else if(member.get(selectedMember - 1).book.get(selectedBook - 1).getBookCategory()
                .equalsIgnoreCase("cultural")){
                bookDataBase.culturalBook.add((CulturalBook)member.get(selectedMember - 1).book.get(selectedBook - 1));
            }
            else if(member.get(selectedMember - 1).book.get(selectedBook - 1).getBookCategory()
                .equalsIgnoreCase("dramatic")){
                bookDataBase.dramaticBook.add((DramaticBook)member.get(selectedMember - 1).book.get(selectedBook - 1));
            }
            else if(member.get(selectedMember - 1).book.get(selectedBook - 1).getBookCategory()
                .equalsIgnoreCase("comedy")){
                bookDataBase.comedyBook.add((ComedyBook)member.get(selectedMember - 1).book.get(selectedBook - 1));
            }
            else if(member.get(selectedMember - 1).book.get(selectedBook - 1).getBookCategory()
                .equalsIgnoreCase("action")){
                bookDataBase.actionBook.add((ActionBook)member.get(selectedMember - 1).book.get(selectedBook - 1));
            }
            else{
                bookDataBase.tragedyBook.add((TragedyBook)member.get(selectedMember - 1).book.get(selectedBook - 1));
            }
              
                
            //returning the book to the library
            member.get(selectedMember - 1).book.remove(selectedBook - 1);
            System.out.println("The selected book has been returned to the Library. \n");
            
            System.out.println("Do you want to return more books ? \n1. Yes\n2. No, Return to the main menu.");
            while(true){
                String op = s.nextLine();
                switch(op){
                    case "1" -> {
                        flag = true;
                    }
                    case "2" -> {
                        flag = false;
                    }
                    default -> {
                        System.out.println("Invalid Selection!");
                        continue;
                    }
                }
                break;
            }
            System.out.println();
        }while(flag);
        
            /*System.out.println("""
                               Do you want to return to the main menu ? 
                               1. Yes, Return to the main menu
                               2. No, Continue the book returning operation
                               """);
                while(true){
                    String op = s.nextLine();
                    switch(op){
                        case "1" -> {
                            flag1 = false;
                        }
                        case "2" -> {
                            flag1 = true;
                        }
                        default -> {
                            System.out.println("Invalid Selection!");
                            continue;
                        }
                    }
                break;
            }
        }while(flag1);*/
    }
    
    // #12
    void removeMember(){
        int numberOfMembers = member.size();
        if(!member.isEmpty()){
            displayMembersInfo();
            System.out.println();
            while(true){
                System.out.println("Which member you want to remove: select a number");
                try{
                    int selectedMember = s.nextInt();
                    s.nextLine();
                    if(!(selectedMember > 0 && selectedMember <= numberOfMembers)){
                        System.out.println("Invalid member, Select another one");
                    }
                    else{
                        if(member.get(selectedMember - 1).book.isEmpty()){
                            member.remove(selectedMember - 1);
                            System.out.println("\nThe selected member has been removed\n");
                            break;
                        }
                        else{
                            System.out.println("The member "+member.get(selectedMember-1).getMemberFirstName()+" "+
                                    member.get(selectedMember - 1).getMemberFirstName()+
                                    ", ID: "+ member.get(selectedMember - 1).getMemberID()+
                                    " still has borrowed book(s), "+
                                    "\nPlease return these books from the main menu, then you can remove him.\n");
                            return;
                        }
                    }
                }
                catch(InputMismatchException e){
                    System.out.print("Only number are allowed here! Enter a valid member: ");
                    s.nextLine();
                }
            }
        }
        else{
            System.out.println("\nNo member found, please add new members from the main menu.\n");
        }
    }

    // #13
    void searchForMember() {
        int memberCount;
        int c;
        if(!member.isEmpty()){
            do{
                System.out.println("""
                                   Search by: 
                                   1. First name.
                                   2. Last name.
                                   3. ID
                                   4. Return to the main menu

                                   """);
                String op = s.nextLine();
                switch(op){
                    case "1" -> {
                        String memberFirstName;
                        memberCount = 0;
                        
                        while(true){
                            System.out.print("Enter the first name of the member to search: ");
                            char [] fname = s.nextLine().trim().toCharArray();
                            if(fname.length == 0){
                                continue;
                            }
                            c = 0;
            
                            for (int i = 0; i < fname.length; i++) {
                                if(!((fname[i] >= 65 && fname[i] <= 90) || 
                                    (fname[i] >= 97 && fname[i] <= 122) ||
                                        fname[i] == 32)){
                                    c++;
                                    break;
                                }
                            }
                            if(c == 0){
                                memberFirstName = String.valueOf(fname);
                                break;
                            }
                            else{
                                System.out.println("Special characters or numbers are not allowed here!");
                            }
                        }
                        
                        for (int i = 0; i < member.size(); i++) {
                            if(memberFirstName.equalsIgnoreCase(member.get(i).getMemberFirstName())){
                                System.out.println((memberCount+1)+". "+
                                            member.get(i).getMemberFirstName()+" "+
                                            member.get(i).getMemberLastName()
                                );
                                memberCount++;
                            }
                        }
                        System.out.println(memberCount + " name(s) found.\n");
                    }
                    case "2" -> {
                        String memberLastName;
                        memberCount = 0;
                        
                        while(true){
                            System.out.print("Enter the last name of the member to search: ");
                            char [] lname = s.nextLine().trim().toCharArray();
                            if(lname.length == 0){
                                continue;
                            }
                            c = 0;
            
                            for (int i = 0; i < lname.length; i++) {
                                if(!((lname[i] >= 65 && lname[i] <= 90) || 
                                    (lname[i] >= 97 && lname[i] <= 122) ||
                                        lname[i] == 32)){
                                    c++;
                                    break;
                                }
                            }
                            if(c == 0){
                                memberLastName = String.valueOf(lname);
                                break;
                            }
                            else{
                                System.out.println("Special characters or numbers are not allowed here!");
                            }
                        }
                        
                        for (int i = 0; i < member.size(); i++) {
                            if(memberLastName.equalsIgnoreCase(member.get(i).getMemberLastName())){
                                System.out.println((memberCount+1)+". "+
                                            member.get(i).getMemberFirstName()+" "+
                                            member.get(i).getMemberLastName()
                                );
                                memberCount++;
                            }
                        }
                        System.out.println(memberCount + " name(s) found.\n");
                    }
                    case "3" -> {
                        String memberID;
                        memberCount = 0;
                        
                        while(true){
                            System.out.print("Enter the ID of the member to search: ");
                            char [] id = s.nextLine().trim().toCharArray();
                            if(id.length == 0){
                                continue;
                            }
                            c = 0;
            
                            for (int i = 0; i < id.length; i++) {
                                if(!(id[i] >= 48 && id[i] <= 57)){
                                    c++;
                                    break;
                                }
                            }
                            if(c == 0){
                                memberID = String.valueOf(id);
                                break;
                            }
                            else{
                                System.out.println("Special characters, spaces or letters are not allowed here!");
                            }
                        }
                        
                        for (int i = 0; i < member.size(); i++) {
                            if(memberID.equalsIgnoreCase(member.get(i).getMemberID())){
                                System.out.println((memberCount+1)+". "+
                                            member.get(i).getMemberFirstName()+" "+
                                            member.get(i).getMemberLastName()
                                );
                                System.out.println("---------------------------");
                                memberCount++;
                            }
                        }
                        System.out.println(memberCount + " name(s) found.\n");
                    }
                    case "4" -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid selection! Select again: \n");
                    }
                }
            }while(true);
        }
        else{
            System.out.println("No members in Data base, Add new members from main menu.");
        }
    }
    
    // #14
    void searchForBook() {
        while(true){
            System.out.println("""
                               Select the Category to search for a book: 
                               1. Religious
                               2. Historical
                               3. Cultural
                               4. Dramatic
                               5. Comedy
                               6. Action
                               7. Tragedy
                               8. Return to the main menu

                               """);
            String category = s.nextLine();
            switch(category){
                case "1" -> {
                    search(bookDataBase.religiousBook);
                }
                case "2" -> {
                    search(bookDataBase.historicalBook);
                }
                case "3" -> {
                    search(bookDataBase.culturalBook);
                }
                case "4" -> {
                    search(bookDataBase.dramaticBook);
                }
                case "5" -> {
                    search(bookDataBase.comedyBook);
                }
                case "6" -> {
                    search(bookDataBase.actionBook);
                }
                case "7" -> {
                    search(bookDataBase.tragedyBook);
                }
                case "8" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid category! Select again: ");
                }
            }
        }
    }
    <T> void search(List <T> b){
        int bookCount;
        int c;
        boolean flag = true;
                    
        while(flag){
            System.out.println("""
                               Search by: 
                               1. Book name
                               2. Book ISBN
                               3. Return to the previous menu

                               """);
            String selection = s.nextLine();
            switch(selection){
                case "1" -> {
                    bookCount = 0;
                    String bookName;
                    
                    while(true){
                        System.out.print("Enter the book name you want to search for: ");
                        char [] bname = s.nextLine().trim().toCharArray();
                        if(bname.length == 0){
                            continue;
                        }
                        c = 0;
                        
                        for (int i = 0; i < bname.length; i++) {
                            if(!((bname[i] >= 65 && bname[i] <= 90) || 
                                (bname[i] >= 97 && bname[i] <= 122) || 
                                (bname[i] >= 48 && bname[i] <= 57) ||
                                 bname[i] == 32)){
                                c++;
                                break;
                            }
                        }

                        if(c == 0){
                            bookName = String.valueOf(bname);
                            break;
                        }
                        else{
                            System.out.println("Special characters are not allowed here!");
                        }
                    }
                    
                    for (int i = 0; i < b.size(); i++) {
                        //casting the object to Book, and receive any type of list
                        if(bookName.equalsIgnoreCase(((Book)b.get(i)).getBookName())){
                            System.out.println("\n"+(bookCount+1)+". "+b.get(i));
                            bookCount++;
                        } 
                        System.out.println("---------------------------");
                    }
                    
                    System.out.println("\n"+ bookCount + " book(s) found.\n");
                }
                case "2" -> {
                    bookCount = 0;
                    String isbn;
                    
                    while(true){
                            System.out.print("Enter the book ISBN you want to search for: ");
                            char [] isbnChar = s.nextLine().trim().toCharArray();
                            if(isbnChar.length == 0){
                                continue;
                            }
                            c = 0;
            
                            for (int i = 0; i < isbnChar.length; i++) {
                                if(!(isbnChar[i] >= 48 && isbnChar[i] <= 57)){
                                    c++;
                                    break;
                                }
                            }
                            if(c == 0){
                                isbn = String.valueOf(isbnChar);
                                break;
                            }
                            else{
                                System.out.println("Special characters, spaces or letters are not allowed here!");
                            }
                        }
                    
                    for (int i = 0; i < b.size(); i++) {
                        //casting the object to Book, and receive any type of list    
                        if(isbn.equalsIgnoreCase(((Book)b.get(i)).getISBN())){
                            System.out.println("\n"+ (bookCount+1) + ". " + b.get(i));
                            bookCount++;
                        } 
                        System.out.println("---------------------------");
                    }
                    
                    System.out.println("\n"+ bookCount + " book(s) found.\n");
                }
                case "3" -> {
                    flag = false;
                }
                default -> {
                    System.out.println("Invalid Selection! Select again: ");
                }
            }
        }
    }
}