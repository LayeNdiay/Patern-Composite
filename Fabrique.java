import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class Fabrique {
    public static Dossier creerComposant(String path) {
        File folder = new File(path);
        Dossier d = new Dossier(folder.getName());
        File files[] = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            File fic = new File(files[i].getAbsolutePath());
            Composant composite = null;
            if (fic.isDirectory()) {
                composite = creerComposant(fic.getAbsolutePath());
            } else {
                composite = new Fichier(fic.getName());
            }
            d.ajouter(composite);
        }
        return d;
    }

    public static Dossier convertion(String xml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder(); 
        StringBuilder xmlStringBuilder = new StringBuilder();
        xmlStringBuilder.append("<?xml version ='1.0'?>" + xml);
        ByteArrayInputStream input = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));
        Document doc = builder.parse(input);
        Element element = doc.getDocumentElement();
        Dossier parent =  creerComposantAvecElement(element);
        return parent;
    }
    public static Dossier creerComposantAvecElement(Element element) {
        Dossier dossier = new Dossier(element.getAttribute("name"));
        NodeList liste = element.getChildNodes();
        for (int i = 0; i < liste.getLength(); i++) {
            Node node = liste.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Composant composants = null;
                Element el = (Element) node;
                if (el.getNodeName().equals("File")) {
                    composants = new Fichier(el.getAttribute("name"));
                }
                else{
                    composants = creerComposantAvecElement(el);
                }
                dossier.ajouter(composants);
            }

        }
        return dossier;
    }
    
}
