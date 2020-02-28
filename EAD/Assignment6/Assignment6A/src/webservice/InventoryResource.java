package webservice;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
public class InventoryResource {
	
	InventoryRepository repo=new InventoryRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Inventory> getInventories()
	{
		return repo.getInventories();
	}

	@GET
	@Path("/{name}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Inventory getInventory(@PathParam("name") String name)
	{
		return repo.getInventory(name);
	}

	@POST
	public Inventory createInventory(Inventory a1)
	{
		repo.create(a1);
		return a1;
	}
	
	@PUT
	public List<Inventory> updateInventory(Inventory a1)
	{
		repo.update(a1);
		return repo.getInventories();
	}
	
	@PUT
	@Path("/{name}")
	public Inventory updateOneInventory(@PathParam("name") String name,Inventory a2)
	{
		Inventory a1=repo.updateOne(name,a2);
		return a1;
	}
	
	@DELETE
	public List<Inventory> deleteInventory()
	{
		repo.deleteAll();
		return repo.getInventories();
	}
	
	@DELETE
	@Path("/{name}")
	public Inventory deleteOneInventory(@PathParam("name") String name)
	{
		Inventory a=repo.getInventory(name);
		repo.deleteOne(name);
		return a;
	}

}
