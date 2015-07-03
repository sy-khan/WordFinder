import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FindFiles {
	
	/*
	*A simple file searcher that will search for a given keyword in a file and, 
	*should it find it, write that line to a new output file.
	*/

	public static void find(File file){
		if (file.isDirectory()) {
			for (File file1: file.listFiles()){
				find(file1);
			}
		}
		else{
			try{
				Scanner in = new Scanner(file);
				PrintWriter out = new PrintWriter(new File("out.txt"));
				String searchFor = "keyword";
				while (in.hasNextLine()) {
					String tmp = in.nextLine();
					if (tmp.contains(searchFor)) {
						System.out.println(tmp);
						out.println(tmp);
					}
				}
				out.flush();
				in.close();
			} catch (FileNotFoundException e){
				System.err.println("FileNotFoundException: " + e.getMessage());
			}
		}
	}

	public static void main (String args[]){
		File file = new File("insert_path_here");
		find(file);
	}
}