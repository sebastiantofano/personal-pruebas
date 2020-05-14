package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Establecimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEstablecimiento;

@Controller
public class HomeControlador {

		
	private ServicioEstablecimiento servicioEstablecimiento;
		
	@Autowired
	public HomeControlador(ServicioEstablecimiento servicioEstablecimiento) {
		this.servicioEstablecimiento = servicioEstablecimiento;
	}
	
	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}	
	
	@RequestMapping(path = "/crear-establecimiento", method = RequestMethod.GET)
	public ModelAndView crearEstablecimiento(@RequestParam(name = "nombreEstablecimiento") String nombre) {
		
		Establecimiento miEstablecimiento = new Establecimiento();
		miEstablecimiento.setNombre(nombre);
		
		Long idGenerado = servicioEstablecimiento.crearEstablecimiento(miEstablecimiento); 
		
		return new ModelAndView("home");
	}
			
}
