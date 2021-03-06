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
import com.rqr.project.home.core.error.GastoServicException;
import com.rqr.project.home.core.error.TipoGastoException;
import com.rqr.project.home.core.model.GastoModel;
import com.rqr.project.home.core.service.GastoService;
import com.rqr.project.home.core.service.TipoGastoService;

@Controller
@RequestMapping("/tohol/finanzas/config/gastos")
public class GastoController {
	@Autowired
	@Qualifier("gastoService")
	private GastoService gastoService;
	@Autowired
	@Qualifier("tipoGastoService")
	private TipoGastoService tipoGastoService;
	
	@GetMapping(path = {"/view","/"})
	public ModelAndView gastoHome(@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "15") int pageSize) {
		String sortBy ="nombre";
		ModelAndView modelAndView = new ModelAndView(Paginas.GASTO);
		
		try {
			modelAndView.addObject("msg", "");
			modelAndView.addObject("datList",gastoService.listarModels(pageNo, pageSize, sortBy));
			modelAndView.addObject("tiposGastos", tipoGastoService.listarModel(pageNo, pageSize, sortBy));
			modelAndView.addObject("obj",new GastoModel());
			
		} catch (TipoGastoException e) {
			modelAndView.addObject("msg", "Error al consultar los Tipos de Gastos:"+e.getMessage());
		} catch (GastoServicException e) {
			modelAndView.addObject("msg", "Error al consultar los Gastos:"+e.getMessage());
		} catch (Exception e) {
			modelAndView.addObject("msg", "Error al generar la pagina Inicial:"+e.getMessage());
		}
		
		return modelAndView;
	}
	
	@PostMapping(path = {"/view","/"})
	public ModelAndView crear(GastoModel gastoModel,@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "15") int pageSize) {
		String sortBy ="nombre";
		ModelAndView modelAndView = new ModelAndView(Paginas.GASTO);
		
		try {
			boolean edo = gastoService.crear(gastoModel);
			
			if(edo) {
				modelAndView.addObject("msg", "Gasto creado Exitosamente");
			} else {
				modelAndView.addObject("msg", "Error al crear el Gasto");
			}
			
			modelAndView.addObject("datList",gastoService.listarModels(pageNo, pageSize, sortBy));
			modelAndView.addObject("tiposGastos", tipoGastoService.listarModel(pageNo, pageSize, sortBy));
			modelAndView.addObject("obj",new GastoModel());
			
		} catch (TipoGastoException e) {
			modelAndView.addObject("msg", "Error al consultar los Tipos de Gastos:"+e.getMessage());
		} catch (GastoServicException e) {
			modelAndView.addObject("msg", "Error al crear los Gastos:"+e.getMessage());
		} catch (Exception e) {
			modelAndView.addObject("msg", "Error al generar la pagina Inicial:"+e.getMessage());
		}
		
		return modelAndView;
		
	}

}
