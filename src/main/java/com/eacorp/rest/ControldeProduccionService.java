package com.eacorp.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eacorp.bean.BeanCliente;
import com.eacorp.bean.BeanClienteVehiculo;
import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.bean.BeanTecnico;
import com.eacorp.facade.ControldeProduccionFacade;
import com.eacorp.system.Constantes;
import com.eacorp.utils.Fecha;


@Controller
@RequestMapping("/api/v1")
public class ControldeProduccionService {

	@Autowired
	private ControldeProduccionFacade controldeProduccionFacade;

	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/ordenesservicio/{codestado}/{codsucursal}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanControldeProduccion> listarOrdendeServicios(@PathVariable String codestado,@PathVariable String codsucursal) throws Exception{
		Fecha fecha = new Fecha();
		String fechaInicial = fecha.getFecInicio();
		String fechaFinal = fecha.fechaActual();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codestado", codestado);
		parametros.put("fechaInicial", fechaInicial);
		parametros.put("fechaFinal", fechaFinal);
		parametros.put("codsucursal", codsucursal);
		ArrayList<BeanControldeProduccion> listaoperacion = controldeProduccionFacade.listarOrdenServicioCategoria(parametros);
		return listaoperacion;
	}
	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/grillaporfecha/{codsucursal}/{fechainicial}/{fechafinal}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanControldeProduccion> listarGrillaPorFecha(@PathVariable String codsucursal,@PathVariable String fechainicial,@PathVariable String fechafinal) throws Exception{
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codsucursal",  codsucursal);
		parametros.put("fechainicial",  fechainicial) ;
		parametros.put("fechafinal", fechafinal);
		
		ArrayList<BeanControldeProduccion> listagrillaxfecha = controldeProduccionFacade.listarGrillaPorFecha(parametros);
		
		return listagrillaxfecha;
	}
	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/grillaportecnico/{codsucursal}/{codnumtecnico}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanControldeProduccion> listarPorTecnico(@PathVariable String codsucursal,@PathVariable String codnumtecnico) throws Exception{
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codsucursal",  codsucursal);
		parametros.put("codnumtecnico",  codnumtecnico) ;
		ArrayList<BeanControldeProduccion> listagrillaxtecnico = controldeProduccionFacade.listarPorTecnico(parametros);
		
		return listagrillaxtecnico;
	}
	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/grillaporOS/{codsucursal}/{codigoOS}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanControldeProduccion> listarPorOS(@PathVariable String codsucursal,@PathVariable String codigoOS) throws Exception{
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codsucursal",  codsucursal);
		parametros.put("codigoOS",  codigoOS) ;
		ArrayList<BeanControldeProduccion> listagrillaxos = controldeProduccionFacade.listarPorOS(parametros);
		
		return listagrillaxos;
	}
	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/grillapornrollave/{codsucursal}/{nroLlave}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanControldeProduccion> listarPornroLlave(@PathVariable String codsucursal,@PathVariable Integer nroLlave) throws Exception{
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codsucursal",  codsucursal);
		parametros.put("nroLlave",  nroLlave) ;
		ArrayList<BeanControldeProduccion> listagrillaxllave = controldeProduccionFacade.listarPorLlave(parametros);
		
		return listagrillaxllave;
	}
	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/datoscliente/{documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanCliente> listarCliente(@PathVariable String documento) throws Exception{
		System.out.println(documento);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("p_opcion",  "DOCUMENTO");
		parametros.put("nombreCompleto",  "NADA") ;
		parametros.put("documento",  documento) ;
		ArrayList<BeanCliente> listacliente = controldeProduccionFacade.listarCliente(parametros);
		
		return listacliente;
	}
	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/datosclientevehiculo/{placa}/{chasis}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanClienteVehiculo> listarClienteVehiculo(@PathVariable String placa,@PathVariable String chasis) throws Exception{
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codVehiculo",  placa);
		parametros.put("vin",  chasis) ;
		parametros.put("perspectiva",  "TODO") ;
		ArrayList<BeanClienteVehiculo> listacliente = controldeProduccionFacade.listarClienteVehiculo(parametros);
		
		return listacliente;
	}
	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/datostecnico/{codSucursal}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanTecnico> listarTecnico(@PathVariable Integer codSucursal) throws Exception{

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codSucursal", codSucursal);
		ArrayList<BeanTecnico> listatecnico = controldeProduccionFacade.listarTecnico(parametros);
		return listatecnico;
	}
	
}
