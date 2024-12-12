import exception.GlobalException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdresseTest {

    private Adresse adresse;

    @Before
    public void setUp() {
        adresse = new Adresse("1 rue de la paix", "75001", "Paris");
    }


    /**
     * Etant donné que la voie de l'adresse contient la valeur "1 rue de la paix"
     * Et que le code postal de l'adresse contient la valeur "75001"
     * Et que le ville de l'adresse contient la valeur "Paris"
     * Lorsque je regarde si cette adresse est valide
     * Alors je vois qu'elle est effectivement valide
     */
    @Test
    public void testAdresseNominal() throws GlobalException {
        Assert.assertTrue(adresse.estValide());
    }

    /**
     * Etant donné que la voie de l'adresse contient la valeur "1 rue de la paix"
     * Et que le code postal de l'adresse est vide
     * Et que le ville de l'adresse contient la valeur "Paris"
     * Lorsque je regarde si cette adresse est valide
     * Alors je vois qu'elle n'est pas valide
     */
    @Test
    public void testMauvaiseAdresse() throws GlobalException {
        adresse.setCodePostal("");
        Assert.assertFalse(adresse.estValide());
    }

    /**
     * Etant donné que la ville de l'adresse est Paris
     * Lorsque je regarde si cette adresse est dans la ville de Paris
     * Alors je vois qu'elle y est bien
     */
    @Test
    public void testEstDansLaVilleNominal() throws GlobalException {
        Assert.assertTrue(adresse.estDansLaVille("Paris"));
    }

    /**
     * Etant donné que la ville de l'adresse est Paris
     * Lorsque je regarde si cette adresse est dans la ville de Pau
     * Alors je vois qu'elle y est bien
     */
    @Test
    public void testEstPasDansLaVille() throws GlobalException {
        Assert.assertFalse(adresse.estDansLaVille("Pau"));
    }
}
