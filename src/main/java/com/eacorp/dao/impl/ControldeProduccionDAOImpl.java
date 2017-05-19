package com.eacorp.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.eacorp.bean.BeanCliente;
import com.eacorp.bean.BeanClienteVehiculo;
import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.bean.BeanTecnico;
import com.eacorp.dao.ControldeProduccionDAO;
import com.eacorp.dao.sp.ListarClienteSP;
import com.eacorp.dao.sp.ListarClienteVehiculoSP;
import com.eacorp.dao.sp.ListarGrillaPorFechaSP;
import com.eacorp.dao.sp.ListarPorLlaveSP;
import com.eacorp.dao.sp.ListarPorOSSP;
import com.eacorp.dao.sp.ListarPorTecnicoSP;
import com.eacorp.dao.sp.ListarTecnicoSP;
import com.eacorp.dao.sp.Listar_ordenservicio_categorias;
import com.eacorp.system.MasterDBConnections;

@Service
public class ControldeProduccionDAOImpl extends MasterDBConnections implements ControldeProduccionDAO {


	@Override
	public ArrayList<BeanControldeProduccion> listarOrdenServicioCategoria(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Obtener datos de la grilla por la categoria de la orden de servicio");
		Listar_ordenservicio_categorias sp = new Listar_ordenservicio_categorias(getDsPrueba());
		return sp.executeProcedure(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarGrillaPorFecha(
			Map<String, Object> parametros) throws DataAccessException {
		System.out.println("Obtener datos de la grilla por fechas");
		// TODO Auto-generated method stub
		ListarGrillaPorFechaSP listgrilla = new ListarGrillaPorFechaSP(getDsPrueba());
		return listgrilla.executeProcedure(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarPorTecnico(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Obtener datos de la grilla por Nombre del técnico");
		ListarPorTecnicoSP listgrilla = new ListarPorTecnicoSP(getDsPrueba());
		return listgrilla.executeProcedure(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarPorOS(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Obtener datos de la grilla por Orden de Servicio");
		ListarPorOSSP listgrilla = new ListarPorOSSP(getDsPrueba());
		return listgrilla.executeProcedure(parametros);
	}

	@Override
	public ArrayList<BeanControldeProduccion> listarPorLlave(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Obtener datos de la grilla por Numero de llave");
		ListarPorLlaveSP listgrilla = new ListarPorLlaveSP(getDsPrueba());
		return listgrilla.executeProcedure(parametros);
	}

	@Override
	public ArrayList<BeanCliente> listarCliente(Map<String, Object> parametros)
			throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Obtener datos del cliente");
		ListarClienteSP cliente = new ListarClienteSP(getDsPrueba());
		return cliente.executeProcedure(parametros);
	}

	@Override
	public ArrayList<BeanClienteVehiculo> listarClienteVehiculo(
			Map<String, Object> parametros) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Obtener datos del cliente con el vehiculo");
		ListarClienteVehiculoSP clivehiculo = new ListarClienteVehiculoSP(getDsPrueba());
		return clivehiculo.executeProcedure(parametros);
	}

	@Override
	public ArrayList<BeanTecnico> listarTecnico(Map<String, Object> parametros)
			throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Obtener datos del tecnico");
		System.out.println(parametros.toString());
		ListarTecnicoSP tecnico = new ListarTecnicoSP(getDsPrueba());
		return tecnico.executeProcedure(parametros);
	}

}
