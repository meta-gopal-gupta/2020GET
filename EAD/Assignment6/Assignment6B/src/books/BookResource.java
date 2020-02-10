package books;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.SqlOperation;

@Path("/books")
public class BookResource {
	
	SqlOperation sqlOperation = new SqlOperation();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Book> getBooks()
	{
		return sqlOperation.getBooks();
	}

	@GET
	@Path("/{title}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Book getBook(@PathParam("title") String title)
	{
		return sqlOperation.getBook(title);
	}

	@POST
	public Book createBook(Book a1)
	{
		sqlOperation.create(a1);
		return a1;
	}
	
	@PUT
	public void updateBook(Book a1)
	{
		sqlOperation.update(a1);

	}
	
	@DELETE
	public void deleteBooks()
	{
		sqlOperation.deleteAll();

	}
	
	@DELETE
	@Path("/{id}")
	public Book deleteOneBook(@PathParam("id") int id)
	{
		Book a=sqlOperation.getBookById(id);
		sqlOperation.deleteOne(id);
		return a;
	}
	


}