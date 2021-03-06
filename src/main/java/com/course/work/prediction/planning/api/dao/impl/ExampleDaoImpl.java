package com.course.work.prediction.planning.api.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.course.work.prediction.planning.api.dao.ExampleDao;
import com.course.work.prediction.planning.api.entity.Example;

@Repository
public class ExampleDaoImpl extends GenericDaoImpl<Example, Long> implements ExampleDao {

	@Override
	protected Class<Example> entityClass() {
		return Example.class;
	}

	@Override
	protected String getEntityName() {
		return "Example";
	}

	@Override
	public List<Example> unusedExamples(Long modelId) {
		return em.createQuery(
				"select e from Example e where e.exampleModel.modelId = :exampleModel and e.usedInPredictionApi = false",
				Example.class).setParameter("exampleModel", modelId).getResultList();
	}

}
