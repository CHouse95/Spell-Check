import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileStorage {
	static int total_import = 0;
	static void importDictionary() {
		File file = new File("Dictionary1.txt");
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;
 
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            if(total_import == 0){
    			HashTable.HashTable(Integer.parseInt(reader.readLine()));
    		}
            // repeat until all lines are read
            while ((text = reader.readLine()) != null) {
                contents.append(text)
                        .append(System.getProperty(
                                "line.separator"));
                HashTable.Insert(text);
            }
            System.out.println("Total Collisions: " + HashTable.total_collisions);
            System.out.println("Longest Chain: " + HashTable.longest_chain);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        total_import++;
	}
	static void importText(String file_name){
		File file = new File(file_name);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNext()){
				String S = scanner.next();
				if(!HashTable.Contains(S)){
					HashTable.AddFlagged(S);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	    scanner.close();
	    }
}
