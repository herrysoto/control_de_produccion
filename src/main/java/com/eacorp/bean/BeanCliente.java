package com.eacorp.bean;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;



@Data public class BeanCliente {
//	private int numcodigocliente;
//	private String vchnombre;
//	private String vchdireccion;
//	private Date dtenacimiento;
//	private Date dtecreacion;
//	private int numtipocliente;
//	private int numcodigoclasificacioncliente;
//	private Date dtemodificacion;
//	private String chrcodigoubigeo;
//	private int numcodigousuariocreacion;
//	private int numcodigousuariomodificacion;
//	private int numcodigotipodocumento;
//	private String vchdocumento;
//	private String vchapellidomaterno;
//	private String vchapellidopaterno;
//	private String vchnombrecompleto;
//	private String chrestado;
//	private String vchdireccion2;
//	private int numcodigoestadocivil;
//	private String chrcodigoubigeo2;
//	private String chrinfoempresa;
//	private String chrinfocliente;
//	private String chrinfoentregadomicilio;
//	private String chrformapago;
//	private String chtarjeta;
            
	private String codigo;
	private String codTipoCliente; // ComboBox (value)
	private String nombre;         // Si el Cliente es Empresa, no debe llenar apePat
	private String apePat;
	private String apeMat;
	private String nombreCompleto;
	private String direccion;
	private String fecNac;
	private String documento;
    private String codDistrito;         
    private String descDistrito;
	private String fechaModificacion;
	private String data;
	private String entrega;
	private String[] arrayFormaPago;
	private String[] arrayTipoTarjeta;
	private String codUsuarioCreacion;
	private String codUsuarioModificacion;
	
	//--- TELEFONOS / EMAIL
    private String telefono1;
    private String telefono2;
    private String telefonoEmpresa1;  //Telefono Empresa 1
    private String anexoEmpresa1;     //Anexo Empresa 1
    private String faxEmpresa1;       //Fax Empresa 
    private String anexoEmpresa2;     //Anexo Empresa 2
    private String fax;
	private String codTipoCelularCliente; // ComboBox (value)
	private String celular;
	private String nextel;
	private String anexo;
	private String email1;
	private String email2;
	private String telefonos;
	private String contacto;
	private String clienteVehiculo;
	//--- TRABAJO u OFICINA
	private String direccionTrabajo;
	private String codEstadoCivil;
	private String anexoTrabajo;
	private String celularTrabajo;
    private String codDistritoTrabajo;  
    private String codTipoCelularOficina;
	
	/// CLIENTEDETALLE
	// POSICION => (1,2,3) (PARA SABER LA POSICION, EN CASO NO LLENEN LOS TELEFONOS)
	/// Registro 1 => telefono1, email1 ,1
	/// Registro 2 => telefono2, email2 ,2
	/// Registro 3 => fax, tipocelular, celular, nextel, anexo, 3

	//Contacto
	private String nombreContacto;
    private String telefonoContacto;
    private String codTipoCelularContacto; // ComboBox (value)
    private String celularContacto;
    private String nextelContacto;
	private String cargoContacto;
   
}
