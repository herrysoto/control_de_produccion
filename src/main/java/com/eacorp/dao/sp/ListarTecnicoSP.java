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

import com.eacorp.bean.BeanTecnico;
import com.eacorp.system.Constantes;

public class ListarTecnicoSP extends StoredProcedure{
	ArrayList<BeanTecnico> lista = new ArrayList<BeanTecnico>();
	String sql = Constantes.PAQUETE_GENERAL+Constantes.LIS_TECNICO;
	
	public ListarTecnicoSP(DataSource ds){
		setDataSource(ds);
		setSql(sql);
		declareParameter(new SqlOutParameter("c_lstTecnico", OracleTypes.CURSOR,new RowMapper() { 
			public Object mapRow(ResultSet rs, int rowNum)throws SQLException {
				BeanTecnico tecnico = new BeanTecnico();
				tecnico.setCodigo(rs.getString(1));
				tecnico.setNombre(rs.getString(2));
				 lista.add(tecnico);
	            return lista;       
	           

	            }
			}));	
		
		declareParameter(new SqlParameter("codSucursal", OracleTypes.NUMBER));
		setFunction(true);
		compile();
		
	}
	
	public ArrayList<BeanTecnico> executeProcedure(Map<String, Object> parametros){
		super.execute(parametros);
		return lista;
	}
}
