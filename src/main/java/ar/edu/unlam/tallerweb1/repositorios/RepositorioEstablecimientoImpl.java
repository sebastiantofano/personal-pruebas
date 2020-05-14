package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Establecimiento;



@Repository
public class RepositorioEstablecimientoImpl implements RepositorioEstablecimiento{

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioEstablecimientoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long crearEstablecimiento(Establecimiento establecimiento) {
		final Session session = sessionFactory.getCurrentSession();
		
		return (Long) session.save(establecimiento);
	}
	
	
	
}
