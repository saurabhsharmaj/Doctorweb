package com.mahdidoc.service;

import java.util.List;

import com.mahdidoc.exception.DocException;




public interface IService<T> {
	
	public int insertRow(T t) throws DocException;

	
	public List<T> getList() throws DocException ;

	
	public T getRowById(int id) throws DocException;

	
	T getRowByName(String columnName, String value);
	
	
	public int updateRow(T t) throws DocException ;

	
	public int deleteRow(int id) throws DocException;

}
