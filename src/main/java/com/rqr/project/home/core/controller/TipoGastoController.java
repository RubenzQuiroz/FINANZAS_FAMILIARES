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
import com.rqr.project.home.core.model.TipoGastoModel;
import com.rqr.project.home.core.service.TipoGastoService;

@Controller
@RequestMapping("/home/finanzas/config/tipogasto")
public class TipoGastoController {
	@Autowired
	@Qualifier("tipoGastoService")
	private TipoGastoService tipoGastoService;
	
	@GetMapping(path = {"/view","/"})
	public ModelAndView homeTipoGasto(@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
		ModelAndView modelAndView = new ModelAndView(Paginas.TIPO_GASTO);
		String sortBy ="nombre";
		
		try {
			modelAndView.addObject("msg", "");
			modelAndView.addObject("datList",tipoGastoService.listarModel(pageNo, pageSize, sortBy));
			modelAndView.addObject("obj",new TipoGastoModel());
			
		} catch (Exception e) {
			modelAndView.addObject("msg", "Error al consultar con lastipo gasto :"+e.getMessage());
		}
		
		return modelAndView;
	}
	
	@PostMapping(path = {"/view","/"})
	public ModelAndView crear(TipoGastoModel tipoGastoModel,@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
		ModelAndView modelAndView = new ModelAndView(Paginas.TIPO_GASTO);
		String sortBy ="nombre";
		
		try {
			tipoGastoService.crear(tipoGastoModel);
			modelAndView.addObject("msg", "");
			modelAndView.addObject("datList",tipoGastoService.listarModel(pageNo, pageSize, sortBy));
			modelAndView.addObject("obj",new TipoGastoModel());
			
		} catch (Exception e) {
			modelAndView.addObject("msg", "Error al consultar con lastipo gasto :"+e.getMessage());
		}
		
		return modelAndView;
	}

}
