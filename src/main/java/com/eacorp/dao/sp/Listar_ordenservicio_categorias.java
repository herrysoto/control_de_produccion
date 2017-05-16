package com.eacorp.dao.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import oracle.jdbc.internal.OracleTypes;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.eacorp.utils.Fecha;

import com.eacorp.bean.BeanControldeProduccion;
import com.eacorp.system.Constantes;



public class Listar_ordenservicio_categorias extends StoredProcedure{
	ArrayList<BeanControldeProduccion> listcontenidos = new ArrayList<BeanControldeProduccion>();
	String sql = Constantes.PAQUETE_CONTROLDEPRODUCCION+Constantes.LIS_OS_CAT;
		
		
		public Listar_ordenservicio_categorias(DataSource ds){
			setDataSource(ds);
			setSql(sql);
			declareParameter(new SqlParameter("codestado", OracleTypes.VARCHAR));
			declareParameter(new SqlParameter("fechaInicial", OracleTypes.VARCHAR));
			declareParameter(new SqlParameter("fechaFinal", OracleTypes.VARCHAR));
			declareParameter(new SqlParameter("codsucursal", OracleTypes.VARCHAR));
			declareParameter(new SqlOutParameter("C_OUT", OracleTypes.CURSOR,new RowMapper() { 
				public Object mapRow(ResultSet rs, int rowNum)throws SQLException {
					BeanControldeProduccion op = new BeanControldeProduccion();
					op.setCodigo(rs.getString("CODIGO"));
					op.setLlave(rs.getInt("LLAVE"));
					op.setFechacreacion(rs.getString("FECHACREACION"));
					op.setHoracreacion(rs.getString("HORACREACION").substring(0,5)+" "+rs.getString("HORACREACION").substring(9,11));
					op.setNombre(rs.getString("NOMBRE"));
					op.setAsesor(rs.getString("ASESOR"));
					op.setCarro(rs.getString("CARRO"));
					op.setColores(rs.getString("COLORES"));
					op.setAnio(rs.getString("ANIO"));
					op.setPlaca(rs.getString("PLACA"));
					op.setVin(rs.getString("VIN"));
					op.setKilometraje(rs.getString("KILOMETRAJE"));
					op.setObservacion(rs.getString("OBSERVACION"));
					op.setGarantia(rs.getString("GARANTIA"));
					op.setTotal(rs.getDouble("TOTAL"));
					op.setDesestope(rs.getString("DESESTOPE"));
					op.setClientesiniestro(rs.getString("CLIENTESINIESTRO"));
					op.setSegurosiniestro(rs.getInt("SEGUROSINIESTRO"));
					op.setEstope(rs.getString("ESTOPE"));
					op.setEstado(rs.getString("ESTADO"));
					op.setTipoestadoos(rs.getString("TIPOESTADOOS"));
					op.setCodcliente(rs.getInt("CODCLIENTE"));
					op.setDoccliente(rs.getString("DOCCLIENTE"));
					op.setCodreclamo(rs.getString("CODRECLAMO"));
					op.setPlacahistorial(rs.getString("PLACAHISTORIAL"));
					op.setValorizada(rs.getString("VALORIZADA"));
					op.setDtecontrolcalidadinicio(rs.getDate("DTECONTROLCALIDADINICIO"));
					op.setDtelavadopreentregainicio(rs.getDate("DTELAVADOPREENTREGAINICIO"));
					op.setNrobuffer(rs.getString("NROBUFFER"));
//		            System.out.println(op.toString());
		            listcontenidos.add(op);
		            return listcontenidos;       
		           

		            }
				}));		
			compile();
		}
		
		public ArrayList<BeanControldeProduccion> executeProcedure(Map<String, Object> parametros){
			super.execute(parametros);
			return listcontenidos;
		}
}
