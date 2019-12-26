package com.rqr.project.home.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rqr.project.home.core.config.Paginas;
import com.rqr.project.home.core.model.Post;




@Controller
@RequestMapping("/tohol")
public class AccesController {
	
	public List<Post> getPost(){
		List<Post> post = new ArrayList<>();
		post.add(new Post(1,"El diseño web es una actividad que consiste en la planificación, diseño, implementación y mantenimiento de sitios web.","http://localhost:8384/img/web1.jpg",new Date(),"Desarrollo web Frond - End"));
		post.add(new Post(2,"El diseño web es una actividad que consiste en la planificación, diseño, implementación y mantenimiento de sitios web.","http://localhost:8384/img/web2.jpg",new Date(),"Desarrollo web"));
		post.add(new Post(3,"El diseño web es una actividad que consiste en la planificación, diseño, implementación y mantenimiento de sitios web.","http://localhost:8384/img/web1.jpg",new Date(),"Desarrollo web Banck - End"));
		post.add(new Post(4,"El diseño web es una actividad que consiste en la planificación, diseño, implementación y mantenimiento de sitios web.","http://localhost:8384/img/web1.jpg",new Date(),"Desarrollo web UX UI"));
		return post;
	}
	
	@GetMapping({"/","/login",""})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(Paginas.INICIO);
		modelAndView.addObject("posts", getPost());
		
		return modelAndView;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
		modelAndView.addObject("posts", getPost());
		
		return modelAndView;
	}
}
