package Programme;

import Control.Controleur;
import modele.FabriqueFacadeApplicationMessagerie;
import View.FabriqueVues;
import View.Terminal.FabriqueVueTerminalImpl;
import modele.FabriqueFacadeApplicationMessagerie;
import modele.FacadeApplicationMessagerie;
import modele.FacadeApplicationMessagerieImpl;

public class Main {
    public static void main(String[] args){
        FabriqueVues fabriqueVues = new FabriqueVueTerminalImpl();
        FabriqueFacadeApplicationMessagerie facadeApplicationMessagerie = new FabriqueFacadeApplicationMessagerie() {
            @Override
            public FacadeApplicationMessagerie creer() {
                return new FacadeApplicationMessagerieImpl();
            }
        };

        Controleur controleur = new Controleur(facadeApplicationMessagerie, fabriqueVues);
        controleur.run();
    }
}
