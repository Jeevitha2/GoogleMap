import java.io.IOException;
 
public class HttpDownloader {
 
    public static void main(String[] args) {
    	String fileURL = "https://alvinalexander.com/blog/post/java/java-how-read-from-url-string-text";
    	//String fileURL = "file:/C:/Users/HACKATHON/Downloads/Jeevitha/New%20folder/takeout-20180728T052655Z-001/Takeout/index.html";
        String saveDir = "C:/Users/HACKATHON/Downloads/Jeevitha/Workspace/GoogleMap/src/resources";

        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}