import java.util.Scanner;

public class Console {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Test si une String ne comporte seulement des entiers
     *
     * @param str La String à tester
     * @return Vrai si la String ne comporte que des entiers, faux sinon
     */
    public static boolean estUneEntreeEntiere(String str) {
        if (str == null || str.trim().equalsIgnoreCase(""))
            return false;

        // Construit un tableau de tous les caractere de la String
        char c[] = str.toCharArray();
        // Test si tous les caracteres sont des entiers
        for (int i = 0; i < c.length; i++) {
            if (c[i] < '0' || c[i] > '9')
                return false;
        }
        return true;
    }

    /**
     * Permet d'obtenir avec certitude un entier lors de la saisie clavier
     * -
     *
     * @return L'entier saisie par le joueur
     */
    public static int validInteger() {
        String str = null;
        do {
            str = sc.nextLine();
        } while (!estUneEntreeEntiere(str));
        return Integer.parseInt(str);
    }

    /**
     * Affiche le menu des choix
     */
    public static void affMenu() {
        System.out.println("0 : Reinitialiser programmation");
        System.out.println("1 : ajouter un film");
        System.out.println("2 : ajouter une piece de theatre");
        System.out.println("3 : ajouter un nom d'interprete a un spectacle");
        System.out.println("4 : ajouter une seance pour un film");
        System.out.println("5 : ajouter une seance pour une piece de theatre");
        System.out.println("6 : vendre des places pour un film");
        System.out.println("7 : vendre des places pour une piece de theatre");
        System.out.println("8 : consulter le chiffre d'affaires et le taux de remplissage d'un spectacle");
        System.out.println("9 : quitter");
    }

    /**
     * methide de verification de l'entree saisie par l'utilisateur
     * @param question la question qui doit etre posee a l'utilisateur
     * @return le choix de l'utilisateur
     */
    public static String saisieUtilisateur(String question) {
        String choixUtilisateur = "";
        String validation = "";
        do {
            System.out.println(question);
            if (sc.hasNext()) {
                choixUtilisateur = sc.nextLine();
                System.out.println("vaildez vous ce choix ? (o/n)");
                if (sc.hasNext()) {
                    validation = sc.nextLine();
                }
            }
        } while (!validation.equalsIgnoreCase("o"));
        return choixUtilisateur;
    }

    /**
     * methide de verification que l'entree saisie par l'utilisateur est une entree numerique
     * @param question la question qui doit etre posee a l'utilisateur
     * @return le choix de l'utilisateur
     */
    public static int saisieUtilisateurNumeric(String question) {
        String choixUtilisateur = "";
        String validation = "";
        int choixDefinitif = -1;
        boolean estValide = false;
        do {
            System.out.println(question);
            if (sc.hasNext()) {
                choixUtilisateur = sc.nextLine();
                estValide = estUneEntreeEntiere(choixUtilisateur);
                if (estValide)
                    choixDefinitif = Integer.parseInt(choixUtilisateur);
                System.out.println("vaildez vous ce choix ? (o/n)");
                if (sc.hasNext()) {
                    validation = sc.nextLine();
                }
            }
        } while (!validation.equalsIgnoreCase("o") && estValide);
        return choixDefinitif;
    }

    /**
     * Verification qu'il existe des seances de films et affiche le bon message en consequant
     * @param gps GestionProgrammationSemaine
     * @return true si il existe des seances et false sinon
     */
    public static boolean affAjouterSeanceFilm(GestionProgrammationSemaine gps) {
        if (!gps.lesFilms().equalsIgnoreCase("Les films présents sont : { }")) {
            System.out.println(gps.lesFilms());
            return true;
        } else {
            System.out.println("Aucun film");
            return false;
        }
    }

    /**
     * Verification qu'il existe des seances de piece de theatre et affiche le bon message en consequant
     * @param gps GestionProgrammationSemaine
     * @return true si il existe des seances et false sinon
     */
    public static boolean affAjouterSeancePieceTheatre(GestionProgrammationSemaine gps){
        if (!gps.lesPieces().equalsIgnoreCase("Les Pièces de théatre présentes sont : { }")){
            System.out.println(gps.lesPieces());
            return true;
        } else {
            System.out.println("Aucune piece de theatre");
            return false;
        }
    }
}
