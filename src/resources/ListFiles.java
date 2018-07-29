package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ListFiles {
	private static final int BUFFER_SIZE = 4096;
    public static void main(String[] args) {
	      File folder = new File("C:\\Users\\HACKATHON\\Downloads\\Jeevitha\\New folder\\takeout-20180728T052655Z-001\\Takeout\\New folder");
	      ListFiles listFiles = new ListFiles();
	      System.out.println("reading files - Using listFiles() method");
	      listFiles.listAllFiles(folder);
     }
     // Uses listFiles method  
     public void listAllFiles(File folder){
         System.out.println("In listAllfiles(File) method");
         File[] fileNames = folder.listFiles();
         for(File file : fileNames){
             // if directory call the same method again
             if(file.isDirectory()){
                 listAllFiles(file);
             }else{
                 try {
                     readContent(file);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
     public void readContent(File file) throws IOException{
    	 String path = file.getPath();
         System.out.println("path -- " + file.getPath());
         String userName = path.substring(path.lastIndexOf("\\") +1, path.length());
         System.out.println("userName -- " +userName);
         try(BufferedReader br  = new BufferedReader(new FileReader(file))){
               String strLine;
              /* Read lines from the file, returns null when end of stream is reached */              
               while((strLine = br.readLine()) != null){
                System.out.println(strLine);
               }
               /*To write the data with file name as per userName*/
               writeContent(br,userName);
         }
     }
     public void writeContent(BufferedReader content,String userName) {
    	FileOutputStream fop = null;
 		File file;

 		try {
 			file = new File("C:/Users/HACKATHON/Downloads/Jeevitha/Workspace/GoogleMap/src/resources/" + userName+".txt");
 			fop = new FileOutputStream(file);

 			// if file doesnt exists, then create it
 			if (!file.exists()) {
 				file.createNewFile();
 			}
 			FileOutputStream outputStream = new FileOutputStream(file);
	 			
            while ((content.readLine()) != null) {
                outputStream.write(content.read());
            }
 			fop.flush();
 			fop.close();
 			outputStream.close();
 			System.out.println("Done");

 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally {
 			try {
 				if (fop != null) {
 					fop.close();
 				}
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 		}

     }
}