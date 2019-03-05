import java.util.Date;
import java.util.Scanner;

public class LibraryService
{
    private User[] users = new User[50];
    private Book[] books = new Book[50];
    Reservation[] reservations = new Reservation[50];
    int reservationsCount = 0;
    int usersCount = 0;
    int booksCount = 0;

    Scanner scanner = new Scanner(System.in);

    public Book[] listAll()
    {
        return books;
    }

    public int existsByName(String bookName)
    {
        for (int i = 0; i < booksCount; i++)
        {
            if (books[i].getTitle().equals(bookName))
            {
                return i;
            }
        }
        return -1;
    }

    public void rentBook(int userId, String bookName, Date endDate)
    {
        int index = checkAvailability(bookName);
        if (index != -1)
        {
            Date startDate = new Date();
            reservations[reservationsCount] = new Reservation(users[userId], books[index], startDate, endDate);
            reservationsCount++;
        }
    }

    public void returnBook(int userId, String bookName)
    {
        for (int i = 0; i < reservationsCount; i++)
        {
            if (reservations[i].getUser().getId() == userId && reservations[i].getBook().getTitle().equals(bookName))
            {
                checkReturnDate(reservations[i]);
                for (int j = i; j < reservations.length - 1; j++)
                {
                    reservations[j] = reservations[j + 1];
                }
                reservationsCount--;
                System.out.println("Your book has been returned.");
            }
        }
    }

    public void checkReturnDate(Reservation reservation)
    {
        Date date = new Date();
        if (date.after(reservation.getEndDate()))
        {
            System.out.println("You're late!");
        }
        else
        {
            System.out.println("You're on time!");
        }
    }

    public int checkAvailability(String bookName)
    {
        int index = existsByName(bookName);
        if (index == -1)
        {
            System.out.println("This book doesn't exist in stock");
            return -1;
        }
        for (int i = 0; i < reservationsCount; i++)
        {
            if (reservations[i].getBook().equals(books[index]))
            {
                System.out.println("Book is not available");
                return -1;
            }
        }
        return index;
    }

    public void registerUser(int userId, String name)
    {
        users[usersCount] = new User(userId, name);
        usersCount++;
    }

    public void addBook(int bookId, String title)
    {
        books[booksCount] = new Book(bookId, title);
        booksCount++;
    }
}
