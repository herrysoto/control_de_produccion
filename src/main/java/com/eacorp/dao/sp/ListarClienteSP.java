package com.eacorp.dao.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import oracle.jdbc.internal.OracleTypes;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.eacorp.bean.BeanCliente;
import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.system.Constantes;

public class ListarClienteSP extends StoredProcedure{
	ArrayList<BeanCliente> lista = new ArrayList<BeanCliente>();
	String sql = Constantes.PAQUETE_CLIENTE+Constantes.LIS_CLIENTE;
	
	public ListarClienteSP(DataSource ds){
		setDataSource(ds);
		setSql(sql);
		declareParameter(new SqlOutParameter("c_cliente", OracleTypes.CURSOR,new RowMapper() { 
			public Object mapRow(ResultSet rs, int rowNum)throws SQLException {
				BeanCliente cliente = new BeanCliente();
				cliente.setCodigo(rs.getString("NUMCODIGOCLIENTE"));
 				 cliente.setNombre(rs.getString("VCHNOMBRE"));
 				 cliente.setDireccion(rs.getString(3));
 				 cliente.setFecNac(rs.getString(4));
 				 cliente.setCodTipoCliente(rs.getString(5));
 				 cliente.setCodDistrito(rs.getString(6));
 				 cliente.setDescDistrito(rs.getString(7));
 				 cliente.setDocumento(rs.getString(8));
 				 cliente.setApePat(rs.getString(9));
 				 cliente.setNombreCompleto(rs.getString(10));
 				 cliente.setTelefonos(rs.getString(11));       // TELEFONO
 				 cliente.setContacto(rs.getString(12));        // CONTACTO
 				 cliente.setClienteVehiculo(rs.getString(13)); // DATOS VEHICULO
 				 cliente.setNombreContacto(rs.getString(14));
 				 cliente.setTelefono1(rs.getString(15));   //------
 				 cliente.setTelefono2(rs.getString(16));   //------
 				 cliente.setFax(rs.getString(17));         //------
 				 cliente.setCodTipoCelularCliente(rs.getString(18)); //------
 				 cliente.setCelular(rs.getString(19));
 				 cliente.setNextel(rs.getString(20));
 				 cliente.setAnexo(rs.getString(21));
 				 cliente.setEmail1(rs.getString(22));
 				 cliente.setEmail2(rs.getString(23));
 		 		 cliente.setFechaModificacion(rs.getString(24));
 		 		 cliente.setDireccionTrabajo(rs.getString(25));
 		 		 cliente.setAnexoTrabajo(rs.getString(26));
 		 		 cliente.setCelularTrabajo(rs.getString(27));
 		 		 cliente.setCodEstadoCivil(rs.getString(28));
 		 		 cliente.setCodDistritoTrabajo(rs.getString(29));
 		 		 cliente.setCodTipoCelularOficina(rs.getString(30));
 		 		 cliente.setData(rs.getString(31)+"-"+rs.getString(32));
				 cliente.setEntrega(rs.getString(33));
				 cliente.setTelefonoEmpresa1(rs.getString(36));
				 cliente.setAnexoEmpresa1(rs.getString(37));
				 cliente.setFaxEmpresa1(rs.getString(38));
				 cliente.setAnexoEmpresa2(rs.getString(39));

//				
				 lista.add(cliente);
	            return lista;       
	           

	            }
			}));	
		declareParameter(new SqlParameter("p_opcion", OracleTypes.VARCHAR));
		declareParameter(new SqlParameter("nombreCompleto", OracleTypes.VARCHAR));
		declareParameter(new SqlParameter("documento", OracleTypes.VARCHAR));
		setFunction(true);
		compile();
	}
	
	public ArrayList<BeanCliente> executeProcedure(Map<String, Object> parametros){
		super.execute(parametros);
		return lista;
	}
}
