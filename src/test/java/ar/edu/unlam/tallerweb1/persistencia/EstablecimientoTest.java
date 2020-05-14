package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Establecimiento;

public class EstablecimientoTest extends SpringTest {

	@Test
	@Transactional
	@Rollback
	public void crearEstablecimiento() {
//		Preparacion
		Establecimiento miEstablecimiento = new Establecimiento();
		miEstablecimiento.setNombre("Nombre de Test");
		miEstablecimiento.setCapacidad(40);
		miEstablecimiento.setResponsable("Responsable Test");
		
//		Ejecucion
		final Session session = session();
		session().save(miEstablecimiento);
		Establecimiento establecimientoBuscado = session().get(Establecimiento.class,miEstablecimiento.getId());
		
//		Resultado
		assertThat(establecimientoBuscado).isNotNull();
		
	}

}
