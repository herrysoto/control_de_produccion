package com.eacorp.dao;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.bean.BeanOperacionServicio;

public interface ControldeProduccionDAO {

	public abstract ArrayList<BeanOperacionServicio> listarOperacionSerivicio(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarOrdenServicioCategoria(Map<String, Object> parametros) throws DataAccessException;
}
