package com.wong.controllers;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wong.components.PostComponent;
import com.wong.configuration.Paginas;
import com.wong.entitys.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	@Autowired
	private PostComponent _postComponent;
	
	@GetMapping(path = {"/posts", "/"})
	public String saludar(Model model) {
		model.addAttribute("posts", this._postComponent.getPost());
		return "index";
	}
	
	@GetMapping(path = "/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
		modelAndView.addObject("posts", this._postComponent.getPost());
		return modelAndView;
	}
	
	@GetMapping(path = {"post/{post}"})
	public ModelAndView getPostIndividual(
			@PathVariable(required = true, name="post")
			int id
			) {
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		
		List<Post> postFiltrado = this._postComponent.getPost()
										.stream().filter( p -> {
											return p.getId() == id;
										}).collect(Collectors.toList());
		
		modelAndView.addObject("post", postFiltrado.get(0));
		return modelAndView;
	}
	
	@GetMapping(path = "/postNew")
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post", new Post());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model) {
		List<Post> posts = this._postComponent.getPost();
		posts.add(post);
		model.addAttribute("posts", posts);
		return "index";
		
	}
}
