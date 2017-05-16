package com.eacorp.facade.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.dao.ControldeProduccionDAO;
import com.eacorp.facade.ControldeProduccionFacade;


@Service
public class ControldeProduccionFacadeImpl implements ControldeProduccionFacade{

	@Autowired
	private ControldeProduccionDAO controldeProduccionDAO;


	@Override
	public ArrayList<BeanControldeProduccion> listarOrdenServicioCategoria(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		return controldeProduccionDAO.listarOrdenServicioCategoria(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarGrillaPorFecha(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		
		return controldeProduccionDAO.listarGrillaPorFecha(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarPorTecnico(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		return controldeProduccionDAO.listarPorTecnico(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarPorOS(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		return controldeProduccionDAO.listarPorOS(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarPorLlave(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		return controldeProduccionDAO.listarPorLlave(parametros);
	}
}
