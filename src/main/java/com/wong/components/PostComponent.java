package com.wong.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wong.entitys.Post;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostComponent {
	
	public List<Post> getPost() {
		List<Post> post = new ArrayList<>();
		post.add(new Post(1, "Desarrollo web es un término que define la creación de sitios web para Internet", "http://localhost:8080/img/test.jpeg", new Date(), "Desarrollo Web"));
		post.add(new Post(2, "Desarrollo web es un término que define la creación de sitios web para Internet", "http://localhost:8080/img/test.jpeg", new Date(), "Desarrollo Front-End"));
		post.add(new Post(3, "Desarrollo web es un término que define la creación de sitios web para Internet", "http://localhost:8080/img/test.jpeg", new Date(), "Desarrollo Backend"));
		post.add(new Post(4, "Desarrollo web es un término que define la creación de sitios web para Internet", "http://localhost:8080/img/test.jpeg", new Date(), "Desarrollo UX/UI"));
		return post;
	}
	
}
