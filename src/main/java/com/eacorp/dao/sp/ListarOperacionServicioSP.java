package com.eacorp.dao.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import oracle.jdbc.internal.OracleTypes;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.system.Constantes;

public class ListarOperacionServicioSP extends StoredProcedure {
	ArrayList<BeanOperacionServicio> lista = new ArrayList<BeanOperacionServicio>();
	String sql = Constantes.PAQUETE_OPERACIONSERVICIO + Constantes.LIS_OPSE;

	public ListarOperacionServicioSP(DataSource ds) {
		setDataSource(ds);
		setSql(sql);
		/*declareParameter( new SqlReturnResultSet("rs", new RowMapper() { 
			public Object mapRow(ResultSet rs, int rowNum)throws SQLException {
            BeanOperacionServicio ops = new BeanOperacionServicio();
            ops.setVchcodigooperacion(rs.getString("VCHCODIGOOPERACION"));
            ops.setNumpreciosugerido(rs.getInt("NUMPRECIOSUGERIDO"));
            System.out.println(ops.toString());
            lista.add(ops);
            return lista;       
           

            }
		}));*/
		
		
		declareParameter(new SqlParameter("P_OPS", OracleTypes.VARCHAR));
		declareParameter(new SqlOutParameter("C_OUT", OracleTypes.CURSOR,new RowMapper() { 
			public Object mapRow(ResultSet rs, int rowNum)throws SQLException {
	            BeanOperacionServicio ops = new BeanOperacionServicio();
	            ops.setVchcodigooperacion(rs.getString("VCHCODIGOOPERACION"));
	            ops.setNumpreciosugerido(rs.getInt("NUMPRECIOSUGERIDO"));
//	            System.out.println(ops.toString());
	            lista.add(ops);
	            return lista;       
	           

	            }
			}));		
		compile();
	}

	public ArrayList<BeanOperacionServicio> executeProcedure(
			Map<String, Object> parametros) {
		super.execute(parametros);
		return lista;
	}

}
