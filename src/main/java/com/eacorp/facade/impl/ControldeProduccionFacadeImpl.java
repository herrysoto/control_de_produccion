package com.eacorp.facade.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.dao.ControldeProduccionDAO;
import com.eacorp.facade.ControldeProduccionFacade;


@Service
public class ControldeProduccionFacadeImpl implements ControldeProduccionFacade{

	@Autowired
	private ControldeProduccionDAO controldeProduccionDAO;

	@Override
	public ArrayList<BeanOperacionServicio> listarOperacionSerivicio(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		return controldeProduccionDAO.listarOperacionSerivicio(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarOrdenServicioCategoria(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		return controldeProduccionDAO.listarOrdenServicioCategoria(parametros);
	}
}
