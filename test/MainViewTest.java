import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainViewTest {

    private FrameFixture frame;

    @Before
    public void setUp() {
        // Inizializza e visualizza la finestra dell'interfaccia utente prima di ogni test
        MainView mainView = new MainView();
        frame = new FrameFixture(mainView);
        frame.show();
    }

    @After
    public void tearDown() {
        // Chiudi la finestra dell'interfaccia utente dopo ogni test
        frame.cleanUp();
    }

    @Test
    public void testInitialization() {
        // Verifica che gli elementi dell'interfaccia utente siano inizializzati correttamente
        assertTrue(frame.textBox("inputView1.jTextField1").isEnabled());
        assertTrue(frame.button("inputView1.jButton1").isEnabled());
        assertTrue(frame.panel("varView").isVisible());
        assertTrue(frame.panel("stackView").isVisible());
        assertTrue(frame.panel("infoView1").isVisible());
    }

    @Test
    public void testRecibeInput() {
        // Simula l'azione dell'utente inserendo un testo e premendo il pulsante Enter
        frame.textBox("inputView1.jTextField1").enterText("test input");
        frame.button("inputView1.jButton1").click();
        assertTrue(frame.textBox("inputView1.jTextField1").text().isEmpty());
    }

    @Test
    public void testConfirmExitMessage() {
        // Simula la chiusura della finestra principale e verifica il messaggio di conferma
        frame.close();
        assertTrue(frame.optionPane().text().contains("Are you sure you want to exit?"));
    }
}
