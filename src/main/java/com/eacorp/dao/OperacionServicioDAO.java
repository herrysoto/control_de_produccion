package com.eacorp.dao;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.eacorp.bean.BeanOperacionServicio;

public interface OperacionServicioDAO {

	
	public abstract ArrayList<BeanOperacionServicio> listarOperacionSerivicio(Map<String,Object> parametros) throws DataAccessException;
}
