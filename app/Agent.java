import exception.GlobalException;

import java.time.LocalDate;
import java.util.List;

public class Agent extends User {

    private List<LocalDate> jourIndisponibles;

    public Agent(String email, String prenom, String nom, List<LocalDate> jourIndisponibles) {
        super(email, prenom, nom);
        this.jourIndisponibles = jourIndisponibles;
    }

    /**
     * Vérifie si l'agent est disponible pour une visite à la date fournie en paramètre
     */
    public boolean estDispoPourUneVisite(LocalDate dateDeVisitePotentielle) throws GlobalException {
        if (jourIndisponibles.contains(dateDeVisitePotentielle)) {
            throw new GlobalException("L'agent n'est pas disponible pour une visite à cette date");
        }
        return true;
    }

    /**
     * Propose la prochaine disponibilité de l'agent, à partir de demain.
     * Cette recherche ne se fait que sur les 30 prochains jours
     */
    public LocalDate prochaineDisponibiliteDuMois() {
        LocalDate dateDeVisitePotentielle = LocalDate.now().plusDays(1);
        int i = 0;
        while (i < 30) {
            if (!jourIndisponibles.contains(dateDeVisitePotentielle)) {
                return dateDeVisitePotentielle;
            }
            dateDeVisitePotentielle = dateDeVisitePotentielle.plusDays(1);
            i++;
        }
        return null;

    }

    public List<LocalDate> getJourIndisponibles() {
        return jourIndisponibles;
    }

    public void setJourIndisponibles(List<LocalDate> jourIndisponibles) {
        this.jourIndisponibles = jourIndisponibles;
    }
}
