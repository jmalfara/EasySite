import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.*;

import javax.xml.parsers.ParserConfigurationException;
import java.nio.file.Files;

/**
 *
 * @author Jordan
 */
public class ParseForName {

    public static void main(String[] args){
        String name;
        name = parseName("appData/AndroidManifest.xml");
        setAppName(name, new File("../text/appNameUrl.txt"));
       //setAppName(parseName("appData/AndroidManifest.xml"), new File("../text/appNameUrl.txt"));
       //deleteFolder(new File("appData"));
    }
    
    private static void parseInName() throws IOException {
        File file = new File("appData/AndroidManifest.xml");
        FileReader fw = new FileReader(file.getAbsoluteFile());
        try (BufferedReader bw = new BufferedReader(fw)) {
           System.out.println(bw.readLine());
        }
    }

    public static String parseName(String manifest) {
        String comName = "Error" ;
         // Gets the Android com.---.--- name from the manifest
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document document = db.parse(new File(manifest));
            NodeList name = document.getElementsByTagName("manifest");
            for (int x = 0, size = name.getLength(); x < size; x++) {
                System.out.println(name.item(x).getAttributes().getNamedItem("package").getNodeValue());
                comName = name.item(x).getAttributes().getNamedItem("package").getNodeValue();
            }
        } catch (IOException ex) {         
            System.out.println("ERROR");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ParseForName.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ParseForName.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comName;
    }
    
    public static void setAppName(String name, File f) {   
        FileWriter fw = null;
        try {
            fw = new FileWriter(f.getAbsoluteFile());
        } catch (IOException ex) {
            Logger.getLogger(ParseForName.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(name);
            System.out.println("Name: Done");
        } catch (IOException ex) {
            Logger.getLogger(ParseForName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // private static void renameApk (String appName, File f) {
    //     // Lists all files in folder
    //     File file = null;
    //     File fList[] = f.listFiles();
    //     // Searchs .lck
    //     for (int i = 0; i < fList.length; i++) {
    //         String pes = fList[i].getAbsolutePath();
    //         if (pes.endsWith(".apk")) {
    //             // and deletes
    //             System.out.println(fList[i].getAbsolutePath());
    //             file = new File(pes);
    //         }
    //     }

    //     try {
    //         appName = appName.replace(' ', '_');
    //         File newFile = new File(file.getParent(), appName+".apk");
    //         Files.move(file.toPath(), newFile.toPath());
    //     } catch (IOException e) {
    //         System.out.println("Error in Renaming file");
    //     }
    // }

    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if(files!=null) { //some JVMs return null for empty dirs
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
    }
}
