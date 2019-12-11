package com.rqr.project.home.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rqr.project.home.core.config.Paginas;
import com.rqr.project.home.core.error.IngresoServiceException;
import com.rqr.project.home.core.error.TipoIngresoServiceException;
import com.rqr.project.home.core.model.IngresoModel;
import com.rqr.project.home.core.service.IngresoService;
import com.rqr.project.home.core.service.TipoIngresoService;

@Controller
@RequestMapping("/home/finanzas/config/ingreso")
public class IngresoController {
	@Autowired
	@Qualifier("ingresoService")
	private IngresoService ingresoService;
	@Autowired
	@Qualifier("tipoIngresoService")
	private TipoIngresoService tipoIngresoService;
	
	@GetMapping(path = {"/view","/"})
	public ModelAndView ingreso(@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
		String sortBy ="nombre";
		ModelAndView modelAndView = new ModelAndView(Paginas.INGRESO);
		
		try {
			modelAndView.addObject("msg", "");
			modelAndView.addObject("datList", ingresoService.listarModels(pageNo, pageSize, sortBy));
			modelAndView.addObject("tiposIngresos", tipoIngresoService.listarAll(pageNo, pageSize, sortBy));
			modelAndView.addObject("ingreso",new IngresoModel());
			
		} catch (IngresoServiceException e) {
			modelAndView.addObject("msg", "Error al consultar los Ingresos:"+e.getMessage());
		} catch (Exception e) {
			modelAndView.addObject("msg", "Error en la en la consulta de la vista:"+e.getMessage());
		} 
		
		return modelAndView;
	}
	
	@PostMapping(path = {"/view","/"})
	public ModelAndView crear(IngresoModel ingresoModel,@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
		ModelAndView modelAndView = new ModelAndView(Paginas.INGRESO);
		String sortBy ="nombre";
		
		try {
			boolean edo = ingresoService.crear(ingresoModel);
			
			if(edo) {
				modelAndView.addObject("msg", "Se creo el igreso correctamente");
			} else {
				modelAndView.addObject("msg", "No se creo el igreso correctamente");
			}
			
			modelAndView.addObject("datList", ingresoService.listarModels(pageNo, pageSize, sortBy));
			modelAndView.addObject("tiposIngresos", tipoIngresoService.listarAll(pageNo, pageSize, sortBy));
			modelAndView.addObject("ingreso",new IngresoModel());
			
		} catch (TipoIngresoServiceException e) {
			modelAndView.addObject("msg", "Error al listar los tipos Ingresos:"+e.getMessage());
		} catch (IngresoServiceException e) {
			modelAndView.addObject("msg", "Error al consultar los Ingresos:"+e.getMessage());
		} catch (Exception e) {
			modelAndView.addObject("msg", "Error en la en la consulta de la vista:"+e.getMessage());
		} 
		
		return modelAndView;
	}

}
