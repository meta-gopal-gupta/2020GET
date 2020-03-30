package cmd;

import java.util.ArrayList;
import java.util.Date;

/*
 * @author Gopal gupta
 * 
 */
public class Directory {
	private Directory parent;
	private String name;
	private Date created;
	private ArrayList<Directory> subDirs;
	
	public Directory(Directory parent, String name, Date created) {
		this.parent = parent;
		this.name = name;
		this.created = created;
		this.subDirs = new ArrayList<Directory>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public ArrayList<Directory> getSubDirs() {
		return subDirs;
	}
	public void setSubDirs(ArrayList<Directory> subDirs) {
		this.subDirs = subDirs;
	}
	
	/*function to check whether
	 * */
	public boolean hasSubDir() {
		if(subDirs.size() > 0)
			return true;
		return false;
	}

	/*function to check whether dictionary is present or not
	 * */
	public boolean isSubDirPresent(String name) {
		for(Directory subDir : subDirs) {
			if(name.equals(subDir.getName())){
				return true;
			}
		}
		return false;
	}
	
	/*function to get sub dictionary
	 * */
	public Directory getSubDir(String name) {
		for(Directory subDir: subDirs) {
			if(name.equalsIgnoreCase(subDir.name)) {
				return subDir;
			}
		}
		return null;
	}
	
	/*function to change dictionary
	 * */
	public Directory cd(String name) {
		if(isSubDirPresent(name)){
			return getSubDir(name);
		} else {
			System.out.println("Directory Not Present.");
			return this;
		}
	}
	
	/*function to create dictionary or check whether present or not
	 * */
	public void mkDir(String name) {
		if(isSubDirPresent(name)){
			System.out.println("Name Already Exist.");
			return;
		}
		subDirs.add(new Directory(this,name, new Date()));
	}
	
	public ArrayList<String> findAllPaths(Directory dir , String name , String path, ArrayList<String> paths) {
			for(Directory subDir: dir.getSubDirs()) {
				if(subDir.getName().contains(name)) {
					paths.add(path +"\\"+subDir.getName());
				}
				findAllPaths(subDir , name , path+"\\"+subDir.getName(),paths);
			}
		return paths;
	}

	/*Find a folder in current or subfolders 
	 * */
	public void find(String name , String path) {
		ArrayList<String> paths = findAllPaths(this, name, path,
				new ArrayList<String>());
		for(String filePath : paths) {
			System.out.println(filePath);
		}
	}
	
	/*function to move to parent dictionary
	 * */
	public Directory back() {
		if(this.parent != null) 
			return this.parent;
		System.out.println("you are at root dir.");
		return this;
	}
	
	public void list() {
		for(Directory subDir : this.subDirs) {
			System.out.println(subDir.getCreated() + " " +subDir.getName());
		}
		System.out.println("Total Folder : "+this.subDirs.size());
	}
	
	/*To display the complete directory structure
	 * */
	public void tree(String path) {
		path = path + "-------";
		for(Directory subDir: this.subDirs) {
			System.out.println(path+" "+subDir.getName());
			subDir.tree(path);
		}
		
	}

}
