import java.security.InvalidParameterException;

public class Horaire {

    /**
     * Champ minutes de la classe Horaire representant les minutes de l'Horaire
     */
    private int minutes;

    /**
     * Champ minutes de la classe Horaire representant les heures de l'Horaire
     */
    private int heures;

    /**
     * Constructeur de la classe
     *
     * @throws InvalidParameterException Si les minutes ou les heures ne sont pas au format 24h/60min
     */
    public Horaire(int heures, int minutes) throws InvalidParameterException {
        if ((minutes >= 0 && 59 >= minutes) && (heures >= 0 && 23 >= heures)) {
            this.minutes = minutes;
            this.heures = heures;
        } else {
            throw new InvalidParameterException("Heures ou minutes invalide");
        }
    }

    /**
     * getter des minutes
     *
     * @return les minutes de l'horaire
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * getter des heures
     *
     * @return les heures de l'horaire
     */
    public int getHeures() {
        return heures;
    }


    @Override
    public String toString() {
        return "Horaire{" +
                "heures=" + heures +
                " minutes=" + minutes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horaire horaire = (Horaire) o;
        return minutes == horaire.minutes &&
                heures == horaire.heures;
    }

    public Horaire add(int duree) {


        int totalminutes=this.getHeures()*60 + this.getMinutes() + duree;
        // redecomposer en hm
        int m = (totalminutes % 60);
        int h = (int)(totalminutes / 60.0);
        if (h>23)
            h-=24;

        return new Horaire(h, m);
    }

}
