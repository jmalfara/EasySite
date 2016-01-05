
import java.io.*;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.nio.file.Files;

public class GetInfo {

    static String xmls;
    static String appName = "Name: Error";
    static String genre = "Genre: Error";
    static String rating = "Rating Error";
    static String publisher = "Publisher Error";
    static String xmlFileName = "com.jordorama.dodgewall";
    static String description = "Description: Error";
    static String fileNamePath = "../text/appNameUrl.txt";
    static String url = "URL Error";
    static String whatsNew = "Error";
    static String videoLink = "Error";
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {  
          
        if (args.length == 1) {
            parseInName();

            findWhatsNew();
            getVideoLink();
            findPublisher();
            findRating();
            findDescription();
            findGenre();
            findName();            
            url = "https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en";
            writeToFile();
            renameApk(new File("../" + args[0]));
            getLinks(new File("../../"));
           // createSiteMap(new File("../" + args[0]));
        } else {
           System.out.println("Args error");
        }
    }

    private static void getVideoLink() {
        try {
            Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en").get();
            Elements anchors = doc.select("span[data-video-url]");
            for (Element data : anchors) {
                // displays text
                videoLink = data.attr("data-video-url");
                System.out.println("Video Link: " + videoLink);
                //whatsNew = data.text() + "<br>";
            }

        } catch (IOException ex) {
            System.out.println("Error getting Whats New");
        }
    }

    private static void parseInName() throws IOException {
        File file = new File(fileNamePath);
        FileReader fw = new FileReader(file.getAbsoluteFile());
        try (BufferedReader bw = new BufferedReader(fw)) {
            xmlFileName = bw.readLine();
        }
    }
    
    private static void findDescription() {
        // finds the Description on google play
        try {
            Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en").get();
            Elements anchors = doc.getElementsByClass("show-more-content");
            for (Element data : anchors) {
                // displays text
                //System.out.println(data.text());
                description = data.text();
            }

        } catch (IOException ex) {
            // Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void findGenre() {
        // Finds Genre
        try {
            Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en").get();
            Elements anchors = doc.select("[itemprop=genre]");
            for (Element data : anchors) {
                // displays text
                System.out.println(data.text());
                genre = data.text();
            }

        } catch (IOException ex) {
            // Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void findName() {
       // Finds the Name of the game
        try {
            Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en").get();
            Elements anchors = doc.getElementsByClass("document-title");
            for (Element data : anchors) {
                // displays text
                System.out.println(data.text());
                appName = data.text();
            }

        } catch (IOException ex) {
            // Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void findPublisher() {
         // Finds the Publisher of the game
        try {
            Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en").get();
            Elements anchors = doc.select("span[itemprop=name]");
            for (Element data : anchors) {
                // displays text
                System.out.println("Publisher " + data.text());
                publisher = data.text();
            }

        } catch (IOException ex) {
            System.out.println("Error getting Publisher");
        }
    }

    private static void findWhatsNew() {
        // Finds the Publisher of the game
        try {
            Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en").get();
            Elements anchors = doc.select("div.recent-change");
            for (Element data : anchors) {
                // displays text
                System.out.println("Getting Whats New " + data.text());
                whatsNew = data.text() + "<br>";
            }

        } catch (IOException ex) {
            System.out.println("Error getting Whats New");
        }
    }

    private static void findRating() {
        try {
            Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en").get();
            Elements anchors = doc.select("div.score");
            for (Element data : anchors) {
                // displays text
                System.out.println("Rating " + data.text());
                rating = data.text();
            }

        } catch (IOException ex) {
            System.out.println("Error getting Rating");
        }
    }
    
    private static void writeToFile() throws IOException {
        File file = new File("../text/AppInfo.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(description);
            System.out.println("Description: Done");
        }

        
        file = new File("../text/AppName.txt");
        fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(appName);
            System.out.println("Name: Done");
        }
        
        file = new File("../text/AppGenre.txt");
        fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(genre);
            System.out.println("Genre: Done");
        }

        file = new File("../text/Rating.txt");
        fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(rating);
            System.out.println("Rating: Done");
        }

        file = new File("../text/Publisher.txt");
        fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(publisher);
            System.out.println("Publisher: Done");
        }

        file = new File("../text/Url.txt");
        fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(url);
            System.out.println("Url: Done");
        }

        file = new File("../text/WhatsNew.txt");
        fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(whatsNew);
            System.out.println("WhatsNew: Done");
        }

        file = new File("../text/videoLink.txt");
        fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(videoLink);
            System.out.println("videoLink: Done");
        }
    }

    private static void renameApk (File f) {
        // Lists all files in folder
        File file = null;
        File fList[] = f.listFiles();
        // Searchs .lck
        for (int i = 0; i < fList.length; i++) {
            String pes = fList[i].getAbsolutePath();
            if (pes.endsWith(".apk")) {
                // and deletes
                System.out.println(fList[i].getAbsolutePath());
                file = new File(pes);
            }
        }

        try {
            appName = appName.replace(' ', '_');
            File newFile = new File(file.getParent(), appName+".apk");
            Files.move(file.toPath(), newFile.toPath());
        } catch (IOException e) {
            System.out.println("Error in Renaming file");
        }
    }

    private static void createSiteMap(File file) throws IOException {
        System.out.println("Creating new sitemap @ " + file.getName());
        File newFile = new File(file.getAbsolutePath(), "sitemap.xml");

        FileWriter fw = new FileWriter(newFile);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
           bw.write("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd\">");
           bw.write("<url><loc>http://" + file.getName() + "/</loc></url>");
           bw.write("<url><loc>http://" + file.getName() + "/index.php</loc></url>");
           bw.write("<url><loc>http://" + file.getName() + "/cracked.php</loc></url></urlset>");

           System.out.println("Sitemap: Done");
        } catch (IOException e) {
            System.out.println("Error in Sitemap");
        }
    }

    private static void getLinks(File folder) throws IOException {
        File fList[] = folder.listFiles();
        File file = null;

        file = new File("../text/links.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < fList.length; i++) {
                String pes = fList[i].getName();
                if (!(pes.equals("Updater"))) {
                    System.out.println("Finding folders " + pes);
                    bw.write(pes + "\n");
                }
            }   
            System.out.println("Links: Done");
        } catch (IOException e) {
            System.out.println("Error in linking");
        }
    }
}