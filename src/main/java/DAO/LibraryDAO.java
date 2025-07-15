
package DAO;

import java.sql.*;
import java.util.*;
import model.Library;

public class LibraryDAO {
    Connection con = DBConnection.getConnection();

    public int insertBook(Library lib) throws SQLException {
        String sql = "INSERT INTO  libinfo VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, lib.getId());
        ps.setString(2, lib.getBookName());
        ps.setString(3, lib.getAuthor());
        ps.setString(4, lib.getPublisher());
        ps.setString(5, lib.getCategory());
        ps.setDouble(6, lib.getPrice());
        ps.setInt(7, lib.getQuantity());
        ps.setString(8, lib.getRackNo());
        return ps.executeUpdate();
    }

    public int updateBook(Library lib) throws SQLException {
        String sql = "UPDATE libinfo SET book_name=?, author=?, publisher=?, category=?, price=?, quantity=?, rack_no=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, lib.getBookName());
        ps.setString(2, lib.getAuthor());
        ps.setString(3, lib.getPublisher());
        ps.setString(4, lib.getCategory());
        ps.setDouble(5, lib.getPrice());
        ps.setInt(6, lib.getQuantity());
        ps.setString(7, lib.getRackNo());
        ps.setInt(8, lib.getId());
        return ps.executeUpdate();
    }

    public int deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM libinfo WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    public List<Library> getAllBooks() throws SQLException {
        List<Library> list = new ArrayList<>();
        String sql = "SELECT * FROM libinfo";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Library lib = new Library();
            lib.setId(rs.getInt(1));
            lib.setBookName(rs.getString(2));
            lib.setAuthor(rs.getString(3));
            lib.setPublisher(rs.getString(4));
            lib.setCategory(rs.getString(5));
            lib.setPrice(rs.getDouble(6));
            lib.setQuantity(rs.getInt(7));
            lib.setRackNo(rs.getString(8));
            list.add(lib);
        }
        return list;
    }
}

