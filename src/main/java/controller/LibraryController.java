package controller;

import model.Library;

import service.LibraryService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryController {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {
            System.out.println("\n1. Add Book\n2. Update Book\n3. Delete Book\n4. Show All Books\n5. Exit");
            System.out.print("Choose Option: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    Library lib = new Library();
                    System.out.print("ID: ");
                    lib.setId(sc.nextInt());
                    sc.nextLine(); // consume newline
                    System.out.print("Book Name: ");
                    lib.setBookName(sc.nextLine());
                    System.out.print("Author: ");
                    lib.setAuthor(sc.nextLine());
                    System.out.print("Publisher: ");
                    lib.setPublisher(sc.nextLine());
                    System.out.print("Category: ");
                    lib.setCategory(sc.nextLine());
                    System.out.print("Price: ");
                    lib.setPrice(sc.nextDouble());
                    System.out.print("Quantity: ");
                    lib.setQuantity(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Rack No: ");
                    lib.setRackNo(sc.nextLine());
                    System.out.println(service.addBook(lib));
                    break;

                case 2:
                    Library lib2 = new Library();
                    System.out.print("Enter Book ID to Update: ");
                    lib2.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("New Book Name: ");
                    lib2.setBookName(sc.nextLine());
                    System.out.print("New Author: ");
                    lib2.setAuthor(sc.nextLine());
                    System.out.print("New Publisher: ");
                    lib2.setPublisher(sc.nextLine());
                    System.out.print("New Category: ");
                    lib2.setCategory(sc.nextLine());
                    System.out.print("New Price: ");
                    lib2.setPrice(sc.nextDouble());
                    System.out.print("New Quantity: ");
                    lib2.setQuantity(sc.nextInt());
                    sc.nextLine();
                    System.out.print("New Rack No: ");
                    lib2.setRackNo(sc.nextLine());
                    System.out.println(service.modifyBook(lib2));
                    break;

                case 3:
                    System.out.print("Enter Book ID to Delete: ");
                    int id = sc.nextInt();
                    System.out.println(service.removeBook(id));
                    break;

//                case 4:
//                    List<Library> libaray = service.showAllBooks();
//           
//                    for (Library b : libaray) {
//                        System.out.println(b.getId() + " | " + b.getBookName() + " | " + b.getAuthor() + " | " + b.getPublisher() +
//                                " | " + b.getCategory() + " | " + b.getPrice() + " | " + b.getQuantity() + " | " + b.getRackNo());
//                    }
//                    break;

                case 4:
                    List<Library> libaray = service.showAllBooks();

                    if (libaray == null || libaray.isEmpty()) {
                        System.out.println("No books found in the library.");
                    } else {
                        for (Library b : libaray) {
                            System.out.println(b.getId() + " | " + b.getBookName() + " | " + b.getAuthor() + " | " + b.getPublisher() +
                                    " | " + b.getCategory() + " | " + b.getPrice() + " | " + b.getQuantity() + " | " + b.getRackNo());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
