import java.util.ArrayList;

public class Interpretes {

    /**
     * Unique champ de la classe contenant les Interpretes
     */
    private ArrayList<String> listInterpretes;

    /**
     * Constructeur de la classe
     * Construit une liste vide
     */
    public Interpretes() {
        this.listInterpretes = new ArrayList<>();
    }

    /**
     * Ajoute un interprete a la liste des interpretes
     * Les doublons sont possibles
     *
     * @param inter
     * @return true comme specifie dans ArrayList.add(E e)
     */
    public boolean ajouterEnFin(String inter) {
        return this.listInterpretes.add(inter);
    }

    /**
     * Supprime tous les elements de la liste
     */
    public void nettoyer() {
        this.listInterpretes.clear();

    }

    /**
     * Return true si la liste contient l'element specifie et false sinon
     *
     * @param o
     * @return true si la liste contient l'element specifie
     */
    public boolean contient(Object o) {
        return this.listInterpretes.contains(o);
    }

    /**
     * Retourne l'interprete dont l'index est index
     * si l'index n'existe pas retourne null
     *
     * @param index
     * @return l'interprete si il existe et null si (index < 0||)
     */
    public String get(int index) {
        try {
            return this.listInterpretes.get(index);
        } catch (IndexOutOfBoundsException e1) {
            return null;
        }
    }

    /**
     * Test si la liste est vide
     *
     * @return true si la liste est vide
     */
    public boolean estVide() {
        return this.listInterpretes.isEmpty();
    }

    /**
     * Supprime un element de la liste celon son index
     *
     * @param index
     * @return l'element supprimer et une chaine vide sinon
     */
    public String supprimer(int index) {
        try {
            return this.listInterpretes.remove(index);
        } catch (IndexOutOfBoundsException e2) {
            return "";
        }
    }

}