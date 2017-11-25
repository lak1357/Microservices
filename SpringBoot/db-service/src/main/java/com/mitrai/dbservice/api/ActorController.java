package com.mitrai.dbservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mitrai.dbservice.model.Actor;
import com.mitrai.dbservice.repository.ActorRepository;

@RestController
@RequestMapping("/db")
public class ActorController {

	@Autowired
	private ActorRepository actorRepository;

	@GetMapping("actors")
	public List<Actor> getActors() {

		System.out.println("actors");
		return actorRepository.findAll();

	}

	@GetMapping("actors/{id}")
	public List<Actor> getActor(@PathVariable("id") final Integer id) {

		System.out.println("actor");
		return actorRepository.findById(id);

	}

}
