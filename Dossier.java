import java.util.ArrayList;

public class Dossier extends Composant {
    private ArrayList<Composant> composants = new ArrayList<Composant>();

    public Dossier(String name) {
        super(name);
    }

    public void ajouter(Composant composant) {

        this.composants.add(composant);
    }

    public String afficher(int position) {
        String xml = "";
        for (int i = 0; i < position; i++) {

            xml = xml + "\t";
        }
        xml = xml + "<Directory name='" + this.getName() + "'>\n";
        for (Composant composant : this.composants) {
           xml = xml + composant.afficher(position + 1);
        }
        for (int i = 0; i < position; i++) {

            xml = xml + "\t";
        }
        xml = xml + "</Directory>\n";
        return xml;
    }
}