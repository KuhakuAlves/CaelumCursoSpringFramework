package br.com.alura.forum.controller.dto.input;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.model.topic.domain.TopicStatus;

public class TopicSearchInputDto {
	
	private TopicStatus status;
	
	private String categoryName;

	public TopicStatus getStatus() {
		return status;
	}

	public void setStatus(TopicStatus status) {
		this.status = status;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Specification<Topic> toSpecification(){
		return (root, criteriaQuery, criteriaBuilder) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if(status != null) {
				predicates.add(criteriaBuilder.equal(root.get("status"), status));
			}
			
			if(categoryName != null ) {
				predicates.add(criteriaBuilder.equal(
						root.get("course")
						    .get("subcategory")
						    .get("category")
						    .get("name") ,
                        categoryName));
			}
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}

}
