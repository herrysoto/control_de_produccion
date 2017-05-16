package com.eacorp.dao;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.eacorp.bean.BeanControldeProduccion;


public interface ControldeProduccionDAO {

	public abstract ArrayList<BeanControldeProduccion> listarOrdenServicioCategoria(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarGrillaPorFecha(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarPorTecnico(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarPorOS(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarPorLlave(Map<String, Object> parametros) throws DataAccessException;
}
