package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fpcolacino
 */

public class InfoViewTest {
 
          
    public InfoViewTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        calcStack = new CalcStack<>();
    }
    
    @AfterEach
    public void tearDown() {
    }

@Test
    // Verifica che gli elementi dell'interfaccia utente siano inizializzati correttamente
    public void testInitialization() {
        assertNotNull(frame.label("idcomponente"));  
        assertNotNull(frame.button("idcomponente"));
    }
