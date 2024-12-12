import exception.GlobalException;

import java.time.LocalDate;
import java.util.List;

public class Agence {

    List<Agent> agents;
    List<Appartement> appartements;

    public Agence(List<Agent> agents, List<Appartement> appartements) {
        this.agents = agents;
        this.appartements = appartements;
    }

    /**
     * Une visite peut se faire au jour fourni en paramètre si au moins un agent est disponible,
     * que l'appartement est vide / bientôt vide
     * et que le locataire est en capacité de louer un appartement
     */
    public boolean visitePeutSeFaire(LocalDate dateVisite, Appartement appartement, Locataire locataire) throws GlobalException {
        for (Agent agent : agents) {
            if (agent.estDispoPourUneVisite(dateVisite) && (appartement.estVide() || appartement.estBientotVide()) && locataire.peutLouerAppartement()) {
                return true;
            }
        }
        throw new GlobalException("La visite ne peut pas se faire");
    }

    /**
     * Cherche dans la liste des appartements référencés dans l'agence,
     * afin d'en proposer un vide ou bientôt vide, dans la ville fournie en paramètre
     */
    public Appartement proposerAppartementDansLaBonneVille(String ville) throws GlobalException {
        for (Appartement appartement : appartements) {
            if ((appartement.estVide() || appartement.estBientotVide()) && appartement.getAdresseAppartement().estDansLaVille(ville)) {
                return appartement;
            }
        }
        throw new GlobalException("Aucun appartement disponible dans la ville spécifiée");

    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public List<Appartement> getAppartements() {
        return appartements;
    }

    public void setAppartements(List<Appartement> appartements) {
        this.appartements = appartements;
    }
}