import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class AppartementTest {

    private Appartement appartement;
    private Locataire locataire;

    @Before
    public void setUp() {
        locataire = Mockito.mock(Locataire.class);
        appartement = new Appartement(locataire, null, new Adresse("1 rue de la Paix", "Paris", "75000"));
    }

    @Test
    public void testEstVide() {
        Mockito.when(locataire.peutLouerAppartement()).thenReturn(false);
        Assert.assertTrue(appartement.estVide());
    }

    @Test
    public void testEstPasVide() {
        Mockito.when(locataire.peutLouerAppartement()).thenReturn(true);
        Assert.assertFalse(appartement.estVide());
    }

    @Test
    public void testEstBientotVide() {
        Mockito.when(locataire.peutLouerAppartement()).thenReturn(true);
        appartement.setDateDeSortieDuLocataire(LocalDate.now().plusDays(10));
        Assert.assertTrue(appartement.estBientotVide());
    }

    @Test
    public void testEstPasBientotVideSansDateDeSortie() {
        Mockito.when(locataire.peutLouerAppartement()).thenReturn(true);
        Assert.assertFalse(appartement.estBientotVide());
    }

    @Test
    public void testPeutEtreVisiteQuandVide() {
        Mockito.when(locataire.peutLouerAppartement()).thenReturn(false);
        Assert.assertTrue(appartement.peutEtreVisite());
    }

    @Test
    public void testPeutEtreVisiteQuandBientotVide() {
        Mockito.when(locataire.peutLouerAppartement()).thenReturn(true);
        appartement.setDateDeSortieDuLocataire(LocalDate.now().plusDays(10));
        Assert.assertTrue(appartement.peutEtreVisite());
    }

    @Test
    public void testPeutPasEtreVisiteQuandOccupe() {
        Mockito.when(locataire.peutLouerAppartement()).thenReturn(true);
        Assert.assertFalse(appartement.peutEtreVisite());
    }
}