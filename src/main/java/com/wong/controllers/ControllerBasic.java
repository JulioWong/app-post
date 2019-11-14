package com.wong.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wong.configuration.Paginas;
import com.wong.entitys.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

	public List<Post> getPost() {
		List<Post> post = new ArrayList<>();
		post.add(new Post(1, "Desarrollo web es un término que define la creación de sitios web para Internet", "http://localhost:8080/img/test.jpeg", new Date(), "Desarrollo Web"));
		post.add(new Post(2, "Desarrollo web es un término que define la creación de sitios web para Internet", "http://localhost:8080/img/test.jpeg", new Date(), "Desarrollo Front-End"));
		post.add(new Post(3, "Desarrollo web es un término que define la creación de sitios web para Internet", "http://localhost:8080/img/test.jpeg", new Date(), "Desarrollo Backend"));
		post.add(new Post(4, "Desarrollo web es un término que define la creación de sitios web para Internet", "http://localhost:8080/img/test.jpeg", new Date(), "Desarrollo UX/UI"));
		return post;
	}
	
	@GetMapping(path = {"/post", "/"})
	public String saludar(Model model) {
		model.addAttribute("posts", this.getPost());
		return "index";
	}
	
	@GetMapping(path = "/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
		modelAndView.addObject("posts", this.getPost());
		return modelAndView;
	}
	
}
