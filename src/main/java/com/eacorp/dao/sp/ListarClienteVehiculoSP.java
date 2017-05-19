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




import com.eacorp.bean.BeanClienteVehiculo;
import com.eacorp.system.Constantes;

public class ListarClienteVehiculoSP extends StoredProcedure {
	ArrayList<BeanClienteVehiculo> lista = new ArrayList<BeanClienteVehiculo>();
	String sql = Constantes.PAQUETE_VEHICULO+Constantes.LIS_CLIENTEVEHICULO;
	String[] arrayFormaPago = new String[1];
    String[] arrayTipoTarjeta = new String[1];
    String[] arrayKitSeguridad = new String[1];
	
	public ListarClienteVehiculoSP(DataSource ds){
		setDataSource(ds);
		setSql(sql);
		declareParameter(new SqlOutParameter("c_findVehiculos", OracleTypes.CURSOR,new RowMapper() { 
			public Object mapRow(ResultSet rs, int rowNum)throws SQLException {
				BeanClienteVehiculo cliVehiculo = new BeanClienteVehiculo();
				cliVehiculo = new BeanClienteVehiculo();
				 cliVehiculo.setCodigoCli(rs.getString(1));
				 cliVehiculo.setNombre(rs.getString(2));
				 cliVehiculo.setDireccion(rs.getString(3));
				 cliVehiculo.setDocumento(rs.getString(4));
				 cliVehiculo.setUbigeo(rs.getString(5));
				 cliVehiculo.setTelefonos(rs.getString(6));
				 cliVehiculo.setContactos(rs.getString(7));
				 cliVehiculo.setVehiculo(rs.getString(8));
				 cliVehiculo.setPlaca(rs.getString(9));
				 cliVehiculo.setVin(rs.getString(10));
				 cliVehiculo.setMotor(rs.getString(11));
				 cliVehiculo.setUsuario(rs.getString(12));
				 cliVehiculo.setColor(rs.getString(13));
				 cliVehiculo.setAnio(rs.getString(14));
				 cliVehiculo.setCodigos(rs.getString(15));
				 cliVehiculo.setCodSeguro(rs.getString(16));
				 cliVehiculo.setCodMarca(rs.getString(17));
				 cliVehiculo.setCodColor2(rs.getString(18));
				 cliVehiculo.setNombreFabrica(rs.getString(19));
 				 cliVehiculo.setCodFabrica(rs.getString(21));
 				 cliVehiculo.setUsuNom(rs.getString(22));
 				 cliVehiculo.setUsuCorreo(rs.getString(23));
 				 cliVehiculo.setPlanMantenimiento(rs.getString(24));
 				 cliVehiculo.setGradoAceite(rs.getString(25));
 				 cliVehiculo.setDescPlanMantenimiento(rs.getString(26));
 				 cliVehiculo.setEmail1Cli(rs.getString(27));
 				 cliVehiculo.setEmail2Cli(rs.getString(28));
 				 cliVehiculo.setCodLinea(rs.getString(29));
 				 cliVehiculo.setFlagKitSeguro(rs.getString(30));
 				 cliVehiculo.setDescKitSeguro(rs.getString(31));
 				 arrayKitSeguridad[0] = rs.getString(32)==null?"0,0,0":rs.getString(32);
 				 cliVehiculo.setArrayKitSeguridad(arrayKitSeguridad);
 				 cliVehiculo.setCodSeguroSoat(rs.getString(33));
 				 cliVehiculo.setFechaSeguro(rs.getString(34));
 				 cliVehiculo.setFechaSeguroSoat(rs.getString(35));
 				 cliVehiculo.setApePat(rs.getString(36)); ///----
 				 cliVehiculo.setFecNac(rs.getString(37));
 				 cliVehiculo.setCodTipCli(rs.getString(38));
 				 cliVehiculo.setCodEstadoCivil(rs.getString(39));
 				 cliVehiculo.setCodTipoCelular(rs.getString(40));
 				 cliVehiculo.setCelular(rs.getString(41));
 				 cliVehiculo.setTelefono1(rs.getString(42));
 				 cliVehiculo.setDireccionTrabajo(rs.getString(43));
 				 cliVehiculo.setTelefono1Trabajo(rs.getString(44));
 				 cliVehiculo.setTelefono2Trabajo(rs.getString(45));
 				 cliVehiculo.setAnexo1Trabajo(rs.getString(46));
 				 cliVehiculo.setFax(rs.getString(47));
 				 cliVehiculo.setAnexo2Trabajo(rs.getString(48));
 				 cliVehiculo.setCelularTrabajo(rs.getString(49));
 				 cliVehiculo.setCodDistritoCliente(rs.getString(50));
 				 cliVehiculo.setCodDistritoTrabajo(rs.getString(51));
 				 cliVehiculo.setEntrega(rs.getString(52));
 				 arrayFormaPago[0] = rs.getString(53);
 				 arrayTipoTarjeta[0] = rs.getString(54); 		
 				 cliVehiculo.setDescSeguro(rs.getString(55));
 				 cliVehiculo.setDescSeguroSoat(rs.getString(56));
 				 cliVehiculo.setNombreCompleto(rs.getString(57));
 				 cliVehiculo.setEmailContacto(rs.getString(58));
 				 cliVehiculo.setTelefonoEmpresa1(rs.getString(59));
 				 cliVehiculo.setAnexoEmpresa1(rs.getString(60));
 				 cliVehiculo.setFaxEmpresa1(rs.getString(61));
 				 cliVehiculo.setAnexoEmpresa2(rs.getString(62));
 				 cliVehiculo.setCodUbigeoUsuario(rs.getString(63));
 				 cliVehiculo.setDescLinea(rs.getString(64));
 				 cliVehiculo.setCodEvo2(rs.getString(65));
 				 cliVehiculo.setUsuApe(rs.getString(66));
 				 cliVehiculo.setContactoApe(rs.getString(67));
 				 cliVehiculo.setArrayFormaPago(arrayFormaPago);     
 				 cliVehiculo.setArrayTipoTarjeta(arrayTipoTarjeta);
 				 //-----------------------------------------------
 				 String cadFP = cliVehiculo.getArrayFormaPago()[0];
 				 String cadTT = cliVehiculo.getArrayTipoTarjeta()[0];
  				 String[] v_arrayFormaPago = new String[cadFP.length()];
 		         String[] v_arrayTipoTarjeta = new String[cadTT.length()];
 				 for(int i=0;i<cadFP.length();i++){ v_arrayFormaPago[i] = String.valueOf(cadFP.charAt(i)); }
 				 for(int i=0;i<cadTT.length();i++){ v_arrayTipoTarjeta[i] = String.valueOf(cadTT.charAt(i)); }
 				 cliVehiculo.setArrayFormaPago(v_arrayFormaPago);
 				 cliVehiculo.setArrayTipoTarjeta(v_arrayTipoTarjeta);
 				 
//				
				 lista.add(cliVehiculo);
	            return lista;       
	           

	            }
			}));	
		declareParameter(new SqlParameter("codVehiculo", OracleTypes.CHAR)); //placa
		declareParameter(new SqlParameter("vin", OracleTypes.VARCHAR));  //chasis
		declareParameter(new SqlParameter("perspectiva", OracleTypes.VARCHAR));
		setFunction(true);
		compile();
		
	}
	
	public ArrayList<BeanClienteVehiculo> executeProcedure(Map<String, Object> parametros){
		super.execute(parametros);
		return lista;
	}
}
