package com.eacorp.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.dao.ControldeProduccionDAO;
import com.eacorp.dao.sp.ListarOperacionServicioSP;
import com.eacorp.dao.sp.Listar_ordenservicio_categorias;
import com.eacorp.system.MasterDBConnections;

@Service
public class ControldeProduccionDAOImpl extends MasterDBConnections implements ControldeProduccionDAO {


	public ArrayList<BeanOperacionServicio> listarOperacionSerivicio(Map<String, Object> parametros)
			throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("esta llegando al modelo de datos");
		ListarOperacionServicioSP sp = new ListarOperacionServicioSP(getDsPrueba());
		return sp.executeProcedure(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarOrdenServicioCategoria(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Obtener datos de la grilla por la categoria de la orden de servicio");
		Listar_ordenservicio_categorias sp = new Listar_ordenservicio_categorias(getDsPrueba());
		return sp.executeProcedure(parametros);
	}

}
