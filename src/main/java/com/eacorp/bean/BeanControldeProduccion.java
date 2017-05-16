package com.eacorp.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data public class BeanControldeProduccion {
	private String codigo;
	private int llave;
	private String fechacreacion;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String horacreacion;
	private String nombre;
	private String placa;
	private String vin;
	private String kilometraje;
	private String asesor;
	private String estado;
	private String carro;
	private int codcliente; 
	private Double total;
	private String colores;
	private String anio;
	private String observacion;
	private int segurosiniestro;
	private String clientesiniestro;
	private int codsucursal;
	private String codreclamo;
	private String placahistorial;
	private String valorizada;
	private String garantia;
	private int  codasesor;
	private String desmarca;
	private String doccliente;
	private String tipoestadoos;
	private String inicialesmarca;
	private String estope;
	private String desestope;
	private Date dtelavadoprevioinicio;
	private Date dtelavadopreviofin;
	private Date dtecontrolcalidadinicio;
	private Date dtecontrolcalidadfin;
	private Date dtelavadopreentregainicio;
	private Date dtelavadopreentregafin;
	private String nrobuffer;
            
         
  
}	
