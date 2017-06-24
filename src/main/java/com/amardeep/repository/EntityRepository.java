package com.amardeep.repository;

public interface EntityRepository<T>{
	public T getEntity(long id);
	
	public T createEntity(T entity);
	
	public boolean updateEntity(T entity);
	
	public boolean deleteEntity(long id);
}
