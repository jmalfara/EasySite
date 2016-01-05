import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetVersion {
  
  /**
   * @param args the command line arguments
   */
  
  public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
    String UrlName = getUrlName("../text/appNameUrl.txt");
    rewriteUpdateFile(getVersionFromPlay(UrlName), "../text/currentVersion.txt");
  }
  
  public static String getUrlName(String fileName) throws IOException  {
    String xmlFileName;
    File file = new File(fileName);
    FileReader fw = new FileReader(file.getAbsoluteFile());
    try (BufferedReader bw = new BufferedReader(fw)) {
      return bw.readLine();
    }
  }
  
  public static void rewriteUpdateFile(String newVersion, String fileName) {
    try {      
      FileWriter fw = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(newVersion);
      
      bw.close();
      System.out.println("Done");
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
  
  public static String getVersionFromPlay(String xmlFileName) {
    String newVersion = "Version Varies By Device";
    try {
      Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en").get();
      Elements anchors = doc.select("[itemprop=softwareVersion]");
      for (Element data : anchors) {
        System.out.println(data.text());
        newVersion = data.text();
        System.out.println(newVersion);
      }      
    } catch (IOException ex) {
      // Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println("Error With URL");
      newVersion = "Version Varies By Device";
    }
    return newVersion;
  } 
}