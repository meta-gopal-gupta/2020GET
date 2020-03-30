package cmd;

import java.util.Date;

/*
 * @author Gopal Gupta
 * 
 */

public class VirtualCMD {

	Directory root = new Directory(null, "R", new Date());
	String path = "R:";

	public void startCommandPrompt(String command) {
		String[] tokens = command.split(" ", 2);
		String cmd = tokens[0];
		String fileName = null;
		if (tokens.length > 1) {
			fileName = tokens[1];
		}
		switch (cmd) {
		case "mkdir":
			root.mkDir(fileName);
			break;

		case "cd":
			root = root.cd(fileName);
			if(root.getName().equals(fileName))
				path = path + "/" + fileName;
			break;

		case "ls": root.list();
			break;

		case "bk": root = root.back();
			if(path.indexOf("/") != -1)
				path = path.substring(0,path.lastIndexOf("/"));
			break;

		case "find": root.find(fileName, path);
			break;

		case "tree": root.tree(path);
			break;

		default:
			System.out.println("Enter Correct Command.");
		}
	}
}
