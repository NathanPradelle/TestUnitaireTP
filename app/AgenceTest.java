import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import exception.GlobalException;

import java.util.Arrays;
import java.util.List;

public class AgenceTest {

    private Agence agence;
    private Appartement appartementParis;
    private Appartement appartementAutreVille;

    @Before
    public void setUp() {
        appartementParis = Mockito.mock(Appartement.class);
        appartementAutreVille = Mockito.mock(Appartement.class);

        List<Appartement> appartements = Arrays.asList(appartementParis, appartementAutreVille);
        agence = new Agence(null, appartements);

        Adresse adresseParis = Mockito.mock(Adresse.class);
        Adresse adresseAutreVille = Mockito.mock(Adresse.class);

        Mockito.when(appartementParis.getAdresseAppartement()).thenReturn(adresseParis);
        Mockito.when(appartementAutreVille.getAdresseAppartement()).thenReturn(adresseAutreVille);

        Mockito.when(adresseParis.estDansLaVille("Paris")).thenReturn(true);
        Mockito.when(adresseAutreVille.estDansLaVille("Paris")).thenReturn(false);

        Mockito.when(appartementParis.estVide()).thenReturn(true);
        Mockito.when(appartementAutreVille.estVide()).thenReturn(true);
    }

    /** * Etant donné qu'il y a dans l'agence un appartement situé dans la ville de Paris
        * Et que cet appartement est vide * Et qu'il y a un autre appartement vide référencé par l'agence mais qui n'est pas dans la ville de Paris
        * Lorsque je veux proposer un appartement dans la ville de Paris
        * Alors je me vois proposer l'appartement qui est situé dans la ville de Paris */
    @Test
    public void testProposerAppartementDansLaBonneVille() throws GlobalException {
        Appartement result = agence.proposerAppartementDansLaBonneVille("Paris");
        Assert.assertEquals(appartementParis, result);
    }
}