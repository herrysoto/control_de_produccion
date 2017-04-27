package com.eacorp.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.facade.OperacionServicioFacade;

@Service
@RequestMapping("/api/v1")
public class OperacionServicioService {

	@Autowired
	private OperacionServicioFacade operacionServicioFacade;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{opsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<BeanOperacionServicio> listarOperacionesById(@PathVariable Integer opsId) throws Exception{
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("P_OPS", opsId);
		ArrayList<BeanOperacionServicio> lista = operacionServicioFacade.listarOperacionSerivicio(parametros);
		return lista;
	}
	
}
