package com.eacorp.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.dao.OperacionServicioDAO;
import com.eacorp.dao.sp.ListarOperacionServicioSP;
import com.eacorp.system.MasterDBConnections;

@Service
public class OperacionServicioDAOImpl extends MasterDBConnections implements OperacionServicioDAO {


	public ArrayList<BeanOperacionServicio> listarOperacionSerivicio(Map<String, Object> parametros)
			throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("esta llegando al modelo de datos");
		ListarOperacionServicioSP sp = new ListarOperacionServicioSP(getDsPrueba());
		return sp.executeProcedure(parametros);
	}

}
