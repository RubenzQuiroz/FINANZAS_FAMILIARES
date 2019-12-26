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
import com.rqr.project.home.core.error.TipoIngresoConverterError;
import com.rqr.project.home.core.error.TipoIngresoServiceException;
import com.rqr.project.home.core.model.TipoIngresoModel;
import com.rqr.project.home.core.service.TipoIngresoService;

@Controller
@RequestMapping("/tohol/finanzas/config/tipoingreso")
public class TipoIngresoController {
	@Autowired
	@Qualifier("tipoIngresoService")
	private TipoIngresoService tipoIngresoService;
	
	
	@GetMapping(path = {"/view","/"})
	public ModelAndView tipoIngreso(@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
		ModelAndView modelAndView = new ModelAndView(Paginas.TIPO_INGRESO);
		String sortBy ="nombre";
		
		try {
			//System.out.println("Tamanio "+ tipoIngresoService.listarAll(pageNo, pageSize, sortBy).size());
			modelAndView.addObject("tipoIngresoList",tipoIngresoService.listarAll(pageNo, pageSize, sortBy));
			modelAndView.addObject("msg", "");
			modelAndView.addObject("tipoIngreso", new TipoIngresoModel());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
		
		return modelAndView;
	}
	
	@PostMapping(path = {"/view","/"})
	public ModelAndView crear(TipoIngresoModel tipoIngresoModel,
			@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
		String sortBy ="nombre";
		ModelAndView modelAndView = new ModelAndView(Paginas.TIPO_INGRESO);
		
		try {
			
			boolean edo = tipoIngresoService.crateTipoIngreso(tipoIngresoModel);
			
			if(edo) {
				modelAndView.addObject("msg", "Se realizo el registro correctamente");
			} else {
				modelAndView.addObject("msg", "No se realizo el registro correctamente");
			}
				
		} catch (TipoIngresoConverterError e) {
			modelAndView.addObject("msg", "Error al obtener los parametros a guardar Error:"+e.getMessage());
		} catch (TipoIngresoServiceException e) {
			modelAndView.addObject("msg", "Error al guardar Error:"+e.getMessage());
		} catch (Exception e) {
			modelAndView.addObject("msg", "Error en el proceso de guardar el tipo ingreso Error:"+e.getMessage());
		} finally {
			modelAndView.addObject("tipoIngreso", new TipoIngresoModel());
			modelAndView.addObject("tipoIngresoList",tipoIngresoService.listarAll(pageNo, pageSize, sortBy));
		}
		
		return modelAndView;
	}

}
