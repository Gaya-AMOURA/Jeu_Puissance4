import java.util.Random;
public class Computer extends Player{
    public Computer(char joueur){
        super("Computer", joueur);
    }

    /**
     * Cette méthode permet à l'ordinateur de jouer son coup et vérifier si ce dernier est valide
     * @param G La grille de la partie actuelle
     */
    public void play(Grille G) {
        boolean coupValide ;
        do {
            System.out.println("Joueur " + this.getName() + ", Donnez un numéro de colonne" +
                "  (entre 1 et " + G.getColonne() + ") : ");

            Random r = new Random(); 
            int c = r.nextInt(G.getColonne()+1); 
            c--;                                 

            coupValide = G.jouerCoup(c, this.getJoueur());
            if (coupValide == false) {
                System.out.println("Votre coup n'est pas valide!!");
            }
        } while (coupValide == false);

    }
}