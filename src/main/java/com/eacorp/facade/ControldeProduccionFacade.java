package com.eacorp.facade;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanCliente;
import com.eacorp.bean.BeanClienteVehiculo;
import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.bean.BeanTecnico;
import com.eacorp.dao.ControldeProduccionDAO;


public interface ControldeProduccionFacade {

	public abstract ArrayList<BeanControldeProduccion> listarOrdenServicioCategoria(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarGrillaPorFecha(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarPorTecnico(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarPorOS(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanControldeProduccion> listarPorLlave(Map<String, Object> parametros) throws DataAccessException;
	
	public abstract ArrayList<BeanCliente> listarCliente(Map<String, Object> parametros) throws DataAccessException;
	
	public abstract ArrayList<BeanClienteVehiculo> listarClienteVehiculo(Map<String, Object> parametros) throws DataAccessException;
	public abstract ArrayList<BeanTecnico> listarTecnico(Map<String, Object> parametros) throws DataAccessException;
}
