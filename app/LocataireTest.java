import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LocataireTest {

    private Locataire locataire;
    private List<BulletinDeSalaire> bulletinsDeSalaire;

    @Before
    public void setUp() {
        bulletinsDeSalaire = new ArrayList<>();
        bulletinsDeSalaire.add(new BulletinDeSalaire(LocalDate.now().minusMonths(1), "Company A"));
        bulletinsDeSalaire.add(new BulletinDeSalaire(LocalDate.now().minusMonths(2), "Company B"));
        bulletinsDeSalaire.add(new BulletinDeSalaire(LocalDate.now().minusMonths(3), "Company C"));
        locataire = new Locataire("email@example.com", "John", "Doe", LocalDate.now().minusYears(25), "Engineer", bulletinsDeSalaire);
    }

    @Test
    public void testPeutLouerAppartement() {
        Assert.assertTrue(locataire.peutLouerAppartement());
    }

    @Test
    public void testNePeutPasLouerAppartementAge() {
        locataire.setDateDeNaissance(LocalDate.now().minusYears(20));
        Assert.assertFalse(locataire.peutLouerAppartement());
    }

    @Test
    public void testNePeutPasLouerAppartementMetier() {
        locataire.setMetier(null);
        Assert.assertFalse(locataire.peutLouerAppartement());
    }

    @Test
    public void testNePeutPasLouerAppartementBulletins() {
        locataire.getBulletinsDeSalaire().remove(0);
        Assert.assertFalse(locataire.peutLouerAppartement());
    }
}
