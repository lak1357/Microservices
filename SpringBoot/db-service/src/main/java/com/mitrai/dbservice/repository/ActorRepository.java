package com.mitrai.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrai.dbservice.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

	public List<Actor> findById(Integer id);

}
