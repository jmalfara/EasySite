
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import net.sf.image4j.codec.ico.ICOEncoder;
import java.awt.AlphaComposite;
import java.awt.Image;

public class ImageGet {

    //The url of the website. This is just an example
    private static String webSiteURL = "https://play.google.com/store/apps/details?id=com.jordorama.dodgewall&hl=en";

    //The path of the folder that you want to save the images to
    private static String folderPath = "../images/";    
    
    static String xmlFileName = "com.jordorama.dodgewall";
    static String fileNamePath = "../text/appNameUrl.txt";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        parseInName();       
        webSiteURL = "https://play.google.com/store/apps/details?id=" + xmlFileName + "&hl=en";
               
        deleteFolder(new File(folderPath));
        getIcon();
        getBanner();
        deleteFolder(new File(folderPath+"screenshots/"));
        getScreenShots();
        createFavicon(new File(folderPath + "image.jpg"));
    }

    private static void parseInName() throws IOException {
        File file = new File(fileNamePath);
        FileReader fw = new FileReader(file.getAbsoluteFile());
        try (BufferedReader bw = new BufferedReader(fw)) {
            xmlFileName = bw.readLine();
        }
    }
    
    private static void getImages(String src, String id) throws IOException {

        //Exctract the name of the image from the src attribute
        int indexname = src.lastIndexOf("/");

        if (indexname == src.length()) {
            src = src.substring(1, indexname);
        }

        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());

        //System.out.println(name);

        //Open a URL Stream
        URL url = new URL(src);
        InputStream in = url.openStream();

        OutputStream out = new BufferedOutputStream(new FileOutputStream(folderPath + id));

        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();
        checkThenRotate(folderPath + id);
    }
    
    private static void getIcon () {
        try {
            //Connect to the website and get the html
            Document doc = Jsoup.connect(webSiteURL).get();

            //Get all elements with img tag ,
            Elements img = doc.select("[alt=Cover art]");

            for (Element el : img) {

                //for each element get the srs url
                String src = el.absUrl("src");

                System.out.println("Image Found!");
               // System.out.println("src attribute is : " + src);

                getImages(src, "image.jpg");

            }

        } catch (IOException ex) {
            System.err.println("There was an error");
            Logger.getLogger(ImageGet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void getScreenShots() {
        int shotNumber = 1;
         System.out.println("Trying to find new image");
         try {
            //Connect to the website and get the html
            Document doc = Jsoup.connect(webSiteURL).get();

            //Get all elements with img tag ,
            Elements img = doc.getElementsByClass("screenshot");

            for (Element el : img) {

                //for each element get the srs url
                String src = el.absUrl("src");

                System.out.println("Image Found!");
               // System.out.println("src attribute is : " + src);

                getImages(src, "screenshots/screen" + shotNumber + ".jpg");
                shotNumber++;
            }

        } catch (IOException ex) {
            System.err.println("There was an error");
            Logger.getLogger(ImageGet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void getBanner() {
        boolean isOk = false;
        try {
            //Connect to the website and get the html
            Document doc = Jsoup.connect(webSiteURL).get();

            //Get all elements with img tag ,
            Elements img = doc.select("[class=\"background-image\"]");

            for (Element el : img) {
                //for each element get the srs url
                isOk = true;
                String src = el.absUrl("src");

                System.out.println("Banner Found!");
               // System.out.println("src attribute is : " + src);

                getImages(src, "banner.jpg");
            }

            if (!isOk) {
                System.err.println("No Banner found");
                OutputStream out = new BufferedOutputStream(new FileOutputStream(folderPath + "banner.jpg"));
                out.close();
            }
        } catch (IOException ex) {
            System.err.println("There was an error");
            Logger.getLogger(ImageGet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void checkThenRotate(String filename) throws IOException {
        BufferedImage bimg = ImageIO.read(new File(filename));
        int width          = bimg.getWidth();
        int height         = bimg.getHeight();        
        BufferedImage target = new BufferedImage(height, width, BufferedImage.TYPE_4BYTE_ABGR);
        
        if (height > width) {
            //System.out.println("Must Rotate 90 Degress");
            AffineTransform tx = new AffineTransform();
            Graphics2D tg = target.createGraphics();
            tx.rotate(Math.toRadians(90));
            tx.translate(0, -height);
            tg.drawImage(bimg, tx, null);
            
            File outputfile = new File(filename);
            ImageIO.write(target, "png", outputfile);
        }
    }

    private static void createFavicon(File f) {
        try {
            BufferedImage img = ImageIO.read(f); // load image
            BufferedImage scaledImg = createResizedCopy(img, 16, 16, true);
            ICOEncoder.write(scaledImg, new File(folderPath + "favicon.ico"));
            System.out.println("Creating favicon");
        } catch (IOException e) {
            System.out.println("favicon Error");
        }
    }

    private static BufferedImage createResizedCopy(Image originalImage, 
            int scaledWidth, int scaledHeight, 
            boolean preserveAlpha)
    {
        System.out.println("resizing...");
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
        g.dispose();
        return scaledBI;
    }
    
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