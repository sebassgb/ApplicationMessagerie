package View.Terminal;

import Control.Controleur;
import View.Accueil;
import View.Menu;

import java.util.Scanner;

public class MenuTerminalImpl implements Menu {
    Controleur controleur;

    public MenuTerminalImpl(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void afficher() {
        Scanner scanner = new Scanner(System.in);
       int finish = -1;
        System.out.println("------------------Menu Principale------------------");
        do {
            System.out.println("1- Envoyer Message");
            System.out.println("2- Desconnexion");
            System.out.println("Choix?");
            finish = scanner.nextInt();
        } while (finish<0);

        controleur.validerMenu(finish);


    }


}
