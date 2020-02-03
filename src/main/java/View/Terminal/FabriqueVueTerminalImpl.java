package View.Terminal;

import Control.Controleur;
import View.*;

public class FabriqueVueTerminalImpl implements FabriqueVues {

    Controleur controleur;

    @Override
    public void setControleur(Controleur controleur){
        this.controleur= controleur;

    }

    public FabriqueVueTerminalImpl(){


    }

    @Override
    public Accueil creerAccueil() {
        return new AccueilTerminalImpl(controleur);
    }

    @Override
    public Inscription creerInscription() { return new InscriptionTerminalImpl(controleur); }


    @Override
    public Connexion creerConnexion() { return new ConnexionTerminalImpl(controleur); }

    @Override
    public Menu creerMenu() { return new MenuTerminalImpl(controleur); }

    @Override
    public EnvoiMessage creerEnvoiMessage() {
        return new EnvoiMessageTerminalImpl(controleur);
    }
}
