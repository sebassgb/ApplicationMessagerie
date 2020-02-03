package View.Terminal;

import Control.Controleur;
import View.Connexion;

import java.util.Scanner;

public class ConnexionTerminalImpl implements Connexion {

    Controleur controleur;

    public ConnexionTerminalImpl(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void afficher(){
        Scanner scanner = new Scanner(System.in);
        String utilisateur = new String();
        String motdepasse = new String();
        int finish = -1;
        System.out.println("------------------Page de Connexion------------------");
        do {
            System.out.println("Tapez votre nom d'utilisateur");
            utilisateur = scanner.nextLine();
            System.out.println("Tapez votre mot de passe");
            motdepasse = scanner.nextLine();
        } while (utilisateur.length() <3 || motdepasse.length() < 3);

        controleur.validerConnexion(utilisateur,motdepasse);


    }

    @Override
    public void erreur(String s) {

    }
}
