public class Fichier extends Composant{
    public Fichier(String name) {
        super(name);
    }
    public String afficher(int position) {
        String xml="";
        for (int i = 0; i < position; i++) {
            xml = xml +"\t";
        }
        xml = xml +"<File name='"+this.getName()+"' />\n";
        return xml;
    }
}
