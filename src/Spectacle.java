public abstract class Spectacle {
    protected int idSpectacle;
    protected String titre;
    protected Interpretes lesInterpretes;

    /**
     * Constructeur de la classe
     * @param titre le titre du spectacle
     * @param lesInterpretes la liste des interpretes du spectacle
     */
    public Spectacle(String titre, String...lesInterpretes) {
        this.titre = titre;
        this.lesInterpretes = new Interpretes();

        for (String item :
                lesInterpretes) {
            this.lesInterpretes.ajouterEnFin(item);
        }
    }

    public Spectacle(String titre) {
        this.titre = titre;
    }
}
