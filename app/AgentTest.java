import exception.GlobalException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AgentTest {

    private Agent agent;
    private List<LocalDate> joursIndisponibles;

    @Before
    public void setUp() {
        joursIndisponibles = new ArrayList<>();
        joursIndisponibles.add(LocalDate.now().plusDays(1));
        joursIndisponibles.add(LocalDate.now().plusDays(2));
        agent = new Agent("email@example.com", "Jane", "Doe", joursIndisponibles);
    }

    @Test
    public void testEstDispoPourUneVisite() throws GlobalException {
        Assert.assertTrue(agent.estDispoPourUneVisite(LocalDate.now().plusDays(3)));
    }

    @Test(expected = GlobalException.class)
    public void testEstPasDispoPourUneVisite() throws GlobalException {
        agent.estDispoPourUneVisite(LocalDate.now().plusDays(1));
    }

    @Test
    public void testProchaineDisponibiliteDuMois() {
        LocalDate expectedDate = LocalDate.now().plusDays(3);
        Assert.assertEquals(expectedDate, agent.prochaineDisponibiliteDuMois());
    }
}