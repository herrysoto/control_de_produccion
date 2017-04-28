package com.eacorp.facade.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.dao.OperacionServicioDAO;
import com.eacorp.facade.OperacionServicioFacade;


@Service
public class OperacionServicioFacadeImpl implements OperacionServicioFacade{

	@Autowired
	private OperacionServicioDAO operacionServicioDAO;

	@Override
	public ArrayList<BeanOperacionServicio> listarOperacionSerivicio(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		return operacionServicioDAO.listarOperacionSerivicio(parametros);
	}
}
