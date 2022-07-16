import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Demo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Dossier doc = Fabrique.creerComposant("../");
        String xml = doc.afficher(0);
        System.out.println(xml);
        System.out.println("-------------------------");
        Dossier comp = Fabrique.convertion(xml);
        System.out.println(comp.afficher(0));
    }
}