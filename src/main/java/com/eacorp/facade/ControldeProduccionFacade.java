package com.eacorp.facade;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.dao.ControldeProduccionDAO;


public interface ControldeProduccionFacade {

	
	
	public abstract ArrayList<BeanOperacionServicio> listarOperacionSerivicio(Map<String,Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarOrdenServicioCategoria(Map<String, Object> parametros) throws DataAccessException;
}
