import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our library!");
        LibraryService libraryService = new LibraryService();
        int option = 1;
        int bookId = 0, userId = 0;
        String title = "" , name = "", bookName = "", dateString = "";
        while (option != 0)
        {
            System.out.println("0 - Stop");
            System.out.println("1 - Add book");
            System.out.println("2 - Register user");
            System.out.println("3 - Rent book");
            System.out.println("4 - Return book");
            System.out.println("5 - Check all books");
            System.out.println("6 - Search for a certain book");
            option = scanner.nextInt(option);
            switch (option)
            {
                case 1:
                    System.out.println("Enter book id and title:");
                    bookId = scanner.nextInt(bookId);
                    title = scanner.next(title);
                    libraryService.addBook(bookId, title);
                    break;
                case 2:
                    System.out.println("Enter user id and name:");
                    userId = scanner.nextInt(userId);
                    name = scanner.next(name);
                    libraryService.registerUser(userId, name);
                    break;
                case 3:
                    System.out.println("Enter user id, book name and end date (dd/mm/yyyy):");
                    userId = scanner.nextInt(userId);
                    bookName = scanner.next(bookName);
                    dateString = scanner.next(dateString);
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date endDate = new Date();
                    try
                    {
                        endDate = formatter.parse(dateString);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Eroare");
                    }
                    libraryService.rentBook(userId, bookName, endDate);
                    break;
                case 4:
                    System.out.println("Enter user id and book name:");
                    userId = scanner.nextInt(userId);
                    bookName = scanner.next(bookName);
                    libraryService.returnBook(userId, bookName);
                    break;
                case 5:
                    Book[] books = libraryService.listAll();
                    for (int i = 0; i < books.length; i++)
                    {
                        System.out.println(books[i].getId());
                        System.out.println(books[i].getTitle());
                    }
                    break;
                case 6:
                    System.out.println("Enter title:");
                    bookName = scanner.next(bookName);
                    if (libraryService.existsByName(bookName) == -1)
                    {
                        System.out.println("The book doesn't exist");
                    }
                    else
                    {
                        System.out.println("The book exists");
                    }
                    break;
            }
        }
    }
}
