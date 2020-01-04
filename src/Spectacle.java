import java.util.*;

public class Spectacle {
    protected int idSpectacle;
    protected String titre;
    protected Interpretes lesInterpretes;

    protected SortedSet<Seance> GestionSeanceSpectacle;

    /**
     * Constructeur de la classe
     *
     * @param titre          le titre du spectacle
     * @param lesInterpretes la liste des interpretes du spectacle
     */
    public Spectacle(String titre, String... lesInterpretes) {
        this.titre = titre;
        this.lesInterpretes = new Interpretes();
        GestionSeanceSpectacle = new TreeSet<Seance>();

        for (String item :
                lesInterpretes) {
            this.lesInterpretes.ajouterEnFin(item);
        }
    }

    public int getIdSpectacle() {
        return idSpectacle;
    }

    public String getTitre() {
        return titre;
    }

    public Interpretes getLesInterpretes() {
        return lesInterpretes;
    }

    public SortedSet<Seance> getGestionSeanceSpectacle() {
        return GestionSeanceSpectacle;
    }

    /**
     *
     * @param jour
     * @param HoraireDebut
     * @return s, la séance correspondante si elle est présente
     */
    public Seance rechercheSeance(int jour, Horaire HoraireDebut) {
        for (Seance s : GestionSeanceSpectacle) {
            if ((s.leCreneau.getJour() == jour) && (s.leCreneau.getHeureDebut().equals(HoraireDebut))) {
                return s;
            }
        }
        return null;
    }

    /**
     *
     * @param jour
     * @return listeSeance , la liste des séance ppréente ce jour
     */
    public ArrayList<Seance> rechercheListeSeance(int jour) {
        ArrayList<Seance> listeSeances = new ArrayList<Seance>();
        for (Seance s : GestionSeanceSpectacle) {
            if (s.leCreneau.getJour() == jour) {
                listeSeances.add(s);
            }
        }
        return listeSeances;
    }

    public double tauxRemplissageMoyenSpectacle(){
        int cpt =0;
        double tauxRemplissage=0;
        Iterator<Seance> itSeance = GestionSeanceSpectacle.iterator();
        while (itSeance.hasNext()){
            cpt+=1;
            Seance s = itSeance.next();
            tauxRemplissage+= s.tauxRemplissage();

        }
        if (cpt!=0)
            return tauxRemplissage/cpt;
        else return 0;
    }

    public double ChiffreAffaire(){
        double chiffreAffaire=0;
        Iterator<Seance> itSeance = GestionSeanceSpectacle.iterator();
        while (itSeance.hasNext()){
            Seance s = itSeance.next();
            chiffreAffaire+= s.chiffreAffaire();

        }
        return chiffreAffaire;
    }

    @Override
    public String toString() {
        return "Spectacle{" +
                "idSpectacle=" + idSpectacle +
                ", titre='" + titre + '\'' +
                ", lesInterpretes=" + lesInterpretes +
                ", GestionSeanceSpectacle=" + GestionSeanceSpectacle +
                '}';
    }
}
