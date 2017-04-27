package com.eacorp.facade.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;

import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.dao.OperacionServicioDAO;
import com.eacorp.facade.OperacionServicioFacade;

public class OperacionServicioFacadeImpl implements OperacionServicioFacade{

	@Autowired
	@Qualifier(value ="osDAO")
	private OperacionServicioDAO operacionServicioDAO;

	@Override
	public ArrayList<BeanOperacionServicio> listarOperacionSerivicio(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		return operacionServicioDAO.listarOperacionSerivicio(parametros);
	}
}
