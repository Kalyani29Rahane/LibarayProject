
package service;

import DAO.LibraryDAO;
import model.Library;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;


public class LibraryService {
    LibraryDAO dao = new LibraryDAO();

    public String addBook(Library lib) {
        try {
            int res = dao.insertBook(lib);
            return res > 0 ? "Book Added!" : "Failed to Add!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String modifyBook(Library lib) {
        try {
            int res = dao.updateBook(lib);
            return res > 0 ? "Book Updated!" : "Update Failed!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String removeBook(int id) {
        try {
            int res = dao.deleteBook(id);
            return res > 0 ? "Book Deleted!" : "Delete Failed!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    public List<Library> showAllBooks() throws SQLException {
        List<Library> list = dao.getAllBooks(); // or however you're fetching data
        if (list == null) {
            return new ArrayList<>(); // return empty list instead of null
        }
        return list;
    }


//    public List<Library> showAllBooks() {
//        try {
//            return dao.getAllBooks();
//        } catch (Exception e) {
//            return null;
//        }
    }


