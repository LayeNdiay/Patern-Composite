public abstract class Composant {
    protected String name;

    public Composant(String name) {
        this.name = name;
    }

    public abstract String afficher(int position);

    public String getName() {
        return name;
    }

}
