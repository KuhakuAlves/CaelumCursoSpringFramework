package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.alura.forum.model.topic.domain.Topic;

public interface TopicRepository extends Repository<Topic, Long>, JpaSpecificationExecutor<Topic> {

	@Query("select t from Topic t")
	List<Topic> list();
	
	List<Topic> findAll();
	//List<Topic> findByCourseName(String courseName);
	
	//List<Topic> findByCourseNameOrderByCreationInstantDesc(String courseName);
}