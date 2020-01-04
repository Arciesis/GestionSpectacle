import java.util.Iterator;

public class PieceTheatre extends Spectacle {

    //Champs de la classe
    /**
     * le metteur en scene de la piece
     */
    private String metteurEnScene;

    /**
     * est utilise pour l'incrementation de l'id
     */
    private static int idPieceTheatreSuivant;

    /**
     * L'id de la piece de theatre
     */
    private int idPieceTheatre;


    /**
     * le nombre d'entractes de la piece de theatre
     */
    private int entractes;

    /**
     * Constructeur de la classe PieceTheatre
     *
     * @param titre          le titre du spectacle
     * @param lesInterpretes la liste des interpretes du spectacle
     * @param metteurEnScene le metteur en scene de la piece de theatre
     */
    public PieceTheatre(String titre, String metteurEnScene, int entractes,String... lesInterpretes) {
        super(titre, lesInterpretes);
        this.metteurEnScene = metteurEnScene;
        this.entractes=entractes;
    }

    // Blocs d'initialisation de l'id de la piece de thetare
    // Commence a 1000 et s'incremente de 1
    static {
        idPieceTheatreSuivant = 1000;
    }

    {
        idSpectacle=idPieceTheatreSuivant;
        this.idPieceTheatre = idSpectacle;
        idPieceTheatreSuivant += 1;
    }

    /**
     * @return le metteur en scene de la piece de theatre
     */
    public String getMetteurEnScene() {
        return metteurEnScene;
    }

    /**
     * @return l'id de la piece de theatre
     */
    public int getIdPieceTheatre() {
        return idPieceTheatre;
    }

    /**
     * @return le titre de la piece de theatre
     */
    public String getTitre(){
       return this.titre;
    }

    /**
     * @return le nombre d'entractes de la piece de theatre
     */
    public int getEntractes(){
        return this.entractes;
    }

    /**
     *
     * @param s
     * @return true si l'on peut ajouter la séance de théatre (1 seule par jour) false sinon
     */
    public boolean ajouterSeanceTheatre (SeanceTheatre s) {
        try{
            Iterator<Seance> itSeanceSpectacle = super.GestionSeanceSpectacle.iterator();
            while(itSeanceSpectacle.hasNext()) {
                SeanceTheatre unqique = (SeanceTheatre) itSeanceSpectacle.next();
                int idSalle = unqique.getLaSalleTheatre().numéro;
                if (unqique.leCreneau.getJour() == s.leCreneau.getJour()){
                    if (unqique.getLaSalleTheatre().getNuméro()== s.getLaSalleTheatre().getNuméro()) {
                        return false;
                    }
                }
            }

            s.getLaSalleTheatre().ajouterCreneau(s.leCreneau);
            super.GestionSeanceSpectacle.add(s);
        }catch (ClassCastException | NullPointerException e1){
            e1.getMessage();
        }
        return false;
    }


    @Override
    public String toString() {
        return "PieceTheatre{" +
                "metteurEnScene='" + metteurEnScene + '\'' +
                ", idPieceTheatre=" + idPieceTheatre +
                ", entractes=" + entractes +
                ", titre='" + titre + '\'' +
                ", lesInterpretes=" + lesInterpretes +
                ", GestionSeanceSpectacle=" + GestionSeanceSpectacle +
                '}';
    }
}






