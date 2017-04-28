package com.eacorp.facade;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.dao.OperacionServicioDAO;


public interface OperacionServicioFacade {

	
	
	public abstract ArrayList<BeanOperacionServicio> listarOperacionSerivicio(Map<String,Object> parametros) throws DataAccessException;
	
}
