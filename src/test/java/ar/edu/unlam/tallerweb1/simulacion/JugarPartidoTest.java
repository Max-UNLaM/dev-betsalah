package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.SpringTest;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class JugarPartidoTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void cargarGolesDevuelveResultado() {

    }
}
