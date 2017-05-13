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

import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.facade.ControldeProduccionFacade;
import com.eacorp.system.Constantes;
import com.eacorp.utils.Fecha;


@Controller
@RequestMapping("/api/v1")
public class ControldeProduccionService {

	@Autowired
	private ControldeProduccionFacade controldeProduccionFacade;

	@RequestMapping(method = RequestMethod.GET, value = "/{opsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanOperacionServicio> listarOperacionesById(@PathVariable String opsId) throws Exception{
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("P_OPS", opsId);
		ArrayList<BeanOperacionServicio> lista = controldeProduccionFacade.listarOperacionSerivicio(parametros);
		return lista;
	}
	
	@CrossOrigin(origins = Constantes.FE_URL)
	@RequestMapping(method = RequestMethod.GET, value = "/ordenesservicio/{codestado}/{codsucursal}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanControldeProduccion> listarOrdendeServicios(@PathVariable String codestado,String codsucursal) throws Exception{
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
	
}
