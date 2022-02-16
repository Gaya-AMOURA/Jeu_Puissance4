import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Grille{

    private int colonne;
    private int ligne;
    private char[][] MatJeu;//'-' = case non jouée, 'X' = case jouée par le joueur 1, 'O' = case jouée par l'ordinateur ou joueur 2

    public Grille(int colonne,int ligne){
        this.colonne=colonne;
        this.ligne=ligne;
        MatJeu = new char[colonne][ligne];
        for (int col = 0; col < colonne; col++) {
            for (int line = 0; line < ligne; line++) {
                MatJeu[col][line] = '-';
            }
        }
    }

    public int getColonne(){ 
        return this.colonne;
    }

    public int getLigne(){
        return this.ligne;
    }

    public void setColonne(int colonne){
        this.colonne = colonne;
    }

    public void setLigne(int ligne){
        this.ligne = ligne;
    }
    /**
     * Cette méthode permet de vérifier si le coup est valide.
     * @param col la colonne dans laquelle le pion va etre placé
     * @param joueur le joueur qui doit jouer('X' ou 'O')
     * @return true si le coup à jouer est valide
     */
    public boolean jouerCoup(int col, char joueur)  {
        if ((col < 0) || (col >= colonne)) {
            return false;
        }

        for (int l = 0; l < ligne; l++) {
            if (MatJeu[col][l] == '-') {
                MatJeu[col][l] = joueur;
                return true;
            }
        }

        return false;
    }

    /** 
     * Cette méthode permet de savoir si la matrice de jeu est pleine
     * @return true si la matrice est pleine
     */
    public boolean estPlein() {

        for (int col = 0; col < colonne; col++) {
            for (int l = 0; l < ligne; l++) {
                if (MatJeu[col][l] == '-') {
                    return false;
                }
            }
        }

        return true;
    }
<<<<<<< HEAD

=======
>>>>>>> d6dd46d8c232144e962a0a61506e627e981eaf67
    /**
     * Cette méthode permet de chercher un vainqueur à chaque coup
     * @return true si un vainqueur est detecté
     */
    public boolean cherchervainqueur() {
        // Permet de vérifier les horizentales
        for (int l = 0; l < ligne; l++) {
            if (cherche4alignes(0, l, 1, 0)) {
                return true;
            }
        }

        // Permet de vérifier les verticales
        for (int c = 0; c < colonne; c++) {
            if (cherche4alignes(c, 0, 0, 1)) {
                return true;
            }
        }

        // Permet de vérifier les diagonales
        for (int c = 0; c < colonne; c++) {

            if (cherche4alignes(c, 0, 1, 1)) {
                return true;
            }

            if (cherche4alignes(c, 0, -1, 1)) {
                return true;
            }
        }

        // Diagonales (cherche depuis les colonnes gauches et droites)
        for (int l = 0; l < ligne; l++) {

            if (cherche4alignes(0, l, 1, 1)) {
                return true;
            }

            if (cherche4alignes(ligne - 1, l, -1, 1)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Cette méthode permet de vérifier si 4 pions du meme joueur sont allignés 
     * @param Col   Colonne d'origine de la recherche
     * @param Line Ligne d'origine de la recherche
     * @param deltaCol   Delta de deplacement sur une colonne
     * @param deltaLigne Delta de deplacement sur une ligne
     * @return true si on trouve un alignement
     */
    private boolean cherche4alignes(int Col, int Line, int deltaCol, int deltaLine) {
        char joueur = '-';
        int compteur = 0;

        int C = Col;
        int R = Line;

        while ((C >= 0) && (C < colonne-1) && (R >= 0) && (R < ligne-1)) {
            if (MatJeu[R][C] != joueur) {
                joueur = MatJeu[R][C];
                compteur = 1;
            } else {
                compteur++;
            }
            if ((joueur != '-') && (compteur == 4)) {
                return true;
            }

            C += deltaCol;

            R += deltaLine;
        }

        return false;
    }

    /**
     * Cette méthode permet d'afficher la matrice de jeu et son évolution depuis le début de la partie
     * Cette méthode permet aussi d'enregistrer la partie si le joueur le décide
     */
    public void grille() {
<<<<<<< HEAD

=======
       
>>>>>>> d6dd46d8c232144e962a0a61506e627e981eaf67
        for (int i = 0; i <= colonne; ++i) {
            System.out.print("**");
        }
        System.out.println();
        for (int l = ligne-1; l >= 0; --l) {    
            for (int col = 0; col < colonne; col++) {
                switch (MatJeu[col][l]) {
                    case '-':
                    System.out.print('|');
                    System.out.print('-');
                    break;
                    case 'X':
                    System.out.print('|');
                    System.out.print('X');
                    break;
                    case 'O':
                    System.out.print('|');
                    System.out.print('O');
                    break;
                }
            }
            System.out.println("|*");
        }
<<<<<<< HEAD

        for (int i = 0; i <= colonne; ++i) {
            System.out.print("**");
        }

        System.out.println();

=======
        
        for (int i = 0; i <= colonne; ++i) {
            System.out.print("**");
        }
        
        System.out.println();
        
>>>>>>> d6dd46d8c232144e962a0a61506e627e981eaf67
        Scanner sc = new Scanner(System.in);
        System.out.println(" Voulez-vous enregistrer la partie? 1/0");  	
        int c = sc.nextInt();
        if(c==1) 
        {	
            Scanner ff = new Scanner(System.in);
            System.out.println("Veuillez nommer votre fichier avant la sauvegarde!!");
            String file = ff.nextLine();
            File f = new File(file+".txt");
            this.Sauvegarder(f);  
            System.exit(-1);
        }

    }

    /**
     * Cette méthode est la méthode principale de sauvegarde d'une partie de Jeu
     * @param f Fichier dans lequel on sauvegardera la partie de jeu en fichier txt
     */
    public void Sauvegarder( File f)
    { 

        try {
            FileWriter fw = new FileWriter(f);  
            BufferedWriter out =  new BufferedWriter (fw);
            out.write(this.ligne+" ");
            out.write(this.colonne+" ");
            for(int c = 0; c < colonne-1;c++)
            {
                for(int l = 0; l < ligne-1 ;l++)
                {
                    if(MatJeu[l][c]!='-') 
                    {
                        if(MatJeu[l][c]=='X')
                        {out.write('X');
                        }
                        else if(MatJeu[l][c]=='O'){
                            out.write('O');
                        }
                    } 

                }
                out.write(" ");
            }
            out.close();		
        } catch (IOException e) { 
        }
    }

    /**
     * Cette méthode permet de charger une partie
     * @param f Fichier à partir du quel on va charger la partie
     */
    public void Charger( File f)
    {

        try {
            Reader fr = new FileReader(f);  
            BufferedReader out=  new BufferedReader (fr);
            String line = out.readLine();
            StringTokenizer s = new StringTokenizer(line); 	
            int ligne=Integer.parseInt(s.nextToken());
            int colonne=Integer.parseInt(s.nextToken());
            int c = colonne;
            Grille g = new Grille(colonne,ligne);
            for(int l = ligne-1; l >=0;l--)
            {
                while(c>=0){

                
                }

                out.close();		
            } 
        }catch (IOException e) {
        }  
    }

}
