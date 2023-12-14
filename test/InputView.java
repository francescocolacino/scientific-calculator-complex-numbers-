import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InputViewTest {

    private FrameFixture frame;

    @Before
    public void setUp() {
        // Inizializza e visualizza la finestra dell'interfaccia utente prima di ogni test
        InputView inputView = new InputView();
        frame = new FrameFixture(inputView);
        frame.show();
    }

    @After
    public void tearDown() {
        // Chiudi la finestra dell'interfaccia utente dopo ogni test
        frame.cleanUp();
    }

    @Test
    // Verifica che gli elementi dell'interfaccia utente siano inizializzati correttamente
    public void testInitialization() {
        assertNotNull(frame.textBox("jTextField1"));  // Sostituire "jTextField1" con l'ID effettivo del componente
        assertNotNull(frame.button("jButton1")); // Sostituire "jButton1" con l'ID effettivo del componente
    }

    @Test
    // Simula l'azione dell'utente sull'interfaccia utente (ad esempio, inserendo un testo e premendo il pulsante)
    public void testActionPerformed() {
        frame.textBox("jTextField1").enterText("test input");
        frame.button("jButton1").click();

        // Verifica che l'azione abbia avuto l'effetto desiderato (ad esempio, chiamando correttamente il metodo di ricezione dell'input)
        // In questo caso, verifichiamo che il testo del campo di input sia stato azzerato dopo l'azione.
        assertEquals("", frame.textBox("jTextField1").text());
    }

}
