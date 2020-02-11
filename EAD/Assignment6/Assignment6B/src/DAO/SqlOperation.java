package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import books.Book;

public class SqlOperation {
	List<Book> books;
	Connection con = null;
	Statement stmt = null;
	
	public SqlOperation(){
		try {
			con = SqlConnection.sqlConnect("booksystem", "root",
					"1234");
			stmt = con.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void createTable() {
		try {
			stmt.executeUpdate("CREATE TABLE if not exists Book (id int(5) primary key AUTO_INCREMENT, title varchar(40), writer varchar(40),publisher varchar(20),PUBLISHEDYEAR int(25))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Book> getBooks(){
		List<Book> books = new ArrayList<>();
		ResultSet result;
		try {
			result = stmt.executeQuery("SELECT * FROM book");
			while (result.next()) {
				Book book = new Book();
				book.setId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setWriter(result.getString(3));
				book.setPublisher(result.getString(4));
				book.setPublishedYear(result.getInt(5));

				books.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public Book getBook(String title){
		Book book = null;
		ResultSet result;
		try {
			
			result = stmt.executeQuery(String.format("SELECT * FROM book WHERE title = '%s'",title));
			if (result.next()) {
				book = new Book();
				book.setId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setWriter(result.getString(3));
				book.setPublisher(result.getString(4));
				book.setPublishedYear(result.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}

	public Book getBookById(int id){
		Book book = new Book();
		ResultSet result;
		try {
			result = stmt.executeQuery(String.format("SELECT * FROM book WHERE id = %d",id));
			if (result.next()) {
				book.setId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setWriter(result.getString(3));
				book.setPublisher(result.getString(4));
				book.setPublishedYear(result.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;

	}

	public void create(Book book) {
		try {
			stmt.executeUpdate(String
					.format("insert into Book values(%d,'%s','%s','%s',%d)",
							book.getId(),book.getTitle(), book.getWriter(), book.getPublisher(),
							book.getPublishedYear()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Book book) {	
		try {
			stmt.executeUpdate(String.format("UPDATE Book SET title='%s', PUBLISHEDYEAR=%d WHERE id=%d",
					book.getTitle(),book.getPublishedYear(), book.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAll(){
		try {
			stmt.executeUpdate("DELETE FROM BOOK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteOne(int id) {
		try {
			stmt.executeUpdate(String.format("DELETE FROM BOOK WHERE id=%d",
				id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
