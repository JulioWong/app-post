package com.wong.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wong.entitys.Post;
import com.wong.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	public List<Post> validationId(List<Post> posts) {
		for (Post post : posts) {
			if (post.getTitulo() == null) {
				throw new NullPointerException("El titulo esta nulo");
			}
		}
		return posts;
	}
	
}
