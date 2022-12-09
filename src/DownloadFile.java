import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.logging.Logger;

public class DownloadFile extends DefaultHandler {
    private static final String CLASS_NAME = DownloadFile.class.getName();
    private final static Logger LOG = Logger.getLogger(CLASS_NAME);
    private SAXParser parser = null;
    private SAXParserFactory spf;

    public static void main(String[] args) throws IOException {

        URL url = new URL(args[0]);
        System.out.println("Conectándose a " + url);

        Path path = Paths.get("figuras.svg");
        try (InputStream inputStream = url.openStream()) {
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        }
        try {
            System.out.println("Abriendo el svg...");
            String dir = "C:\\Users\\jesus\\IdeaProjects\\rDS3\\figuras.svg";
            ProcessBuilder abre = new ProcessBuilder();
            abre.command("cmd.exe", "/c", dir);
            abre.start();
        } catch (IOException ex) {

        }
    }
}