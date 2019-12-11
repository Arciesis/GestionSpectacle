public class Main {
    public static void main(String args[]){
        // write your code here
        Creneau c = new Creneau(1,new Horaire(22,55),new Horaire(0,30));
        System.out.println(c.calculerDuree());
    }

}
