package com.eacorp.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;




public class Fecha {
	
	/** Patrón [dd-MM-yyyy] que devuelve la fecha (ejemplo) [05-12-2011]*/
	public final static String DATETIME_PATTERN_dd_MM_yyyy = "dd-MM-yyyy";

	/** Patrón [dd/MM/yyyy] que devuelve la fecha (ejemplo) [05/12/2011]*/
	public final static String DATETIME_PATTERN_SLASH_dd_MM_yyyy = "dd/MM/yyyy";
	public static final String[] meses = {"Enero", "Febrero", "Marzo","Abril", "Mayo", "Junio",
		"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre","Diciembre"};
	Date fecha = new Date();
	public static int[] anios = {2010,2011,2012,2013,2014,2015};
	
	public String fechaActual(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zona = TimeZone.getTimeZone("America/Lima");
        //TimeZone.setDefault(zona);
		sdf.setTimeZone(zona);
		return sdf.format(fecha);
	}
	
	public String getFechaActualPatron(String patron){
		SimpleDateFormat sdf = new SimpleDateFormat(patron);
		TimeZone zona = TimeZone.getTimeZone("America/Lima");
        //TimeZone.setDefault(zona);
		sdf.setTimeZone(zona);
		return sdf.format(fecha);
	}

	public String mesAnio() {
		System.out.println("Fecha Incial: "+fecha);
		//fecha = new Date("01/02/06");
		SimpleDateFormat sdf =  new SimpleDateFormat("MMMMM yyyy");
		return sdf.format(fecha);
	}

	public String dia() {
		SimpleDateFormat sdf =  new SimpleDateFormat("dd");
		return sdf.format(fecha);
	}

	public String mes(){
		SimpleDateFormat sdf =  new SimpleDateFormat("MM");
		return sdf.format(fecha);
	}

	public String anio() {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy");
		return sdf.format(fecha);
	}

	public String año() {
		SimpleDateFormat sdf =  new SimpleDateFormat("yy");
		return sdf.format(fecha);
	}

	public String getAyer(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zona = TimeZone.getTimeZone("America/Lima");
        //TimeZone.setDefault(zona);
		sdf.setTimeZone(zona);
    	Date ayer = new Date(fecha.getTime()-86400000);
		return sdf.format(ayer);
	}

	public String getFecInicio(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zona = TimeZone.getTimeZone("America/Lima");
        //TimeZone.setDefault(zona);
		sdf.setTimeZone(zona);
    	Date fecIni = new Date(fecha.getTime()-(86400000*4));
		return sdf.format(fecIni);
	}

	public String getUntil2Day(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zona = TimeZone.getTimeZone("America/Lima");
        //TimeZone.setDefault(zona);
		sdf.setTimeZone(zona);
    	Date until2Day = new Date(fecha.getTime()-86400000*2);
		return sdf.format(until2Day);
	}

	
	/**
	 * Método que recibe una fecha en String con un patrón adecuado y lo retorna con un patrón diferente
	 * @param strDate fecha en cadena
	 * @param currentPattern actual patrón de la fecha
	 * @param toPattern patrón en el cual se desea la fecha
	 * @return
	 */
	static public String formatTimeByPattern(String strDate, String currentPattern, String toPattern) {
		if (strDate != null) {
			SimpleDateFormat dsReceived = new SimpleDateFormat(currentPattern);
			SimpleDateFormat ds = new SimpleDateFormat(toPattern);
			Date d = null;
			
			try {
				d = dsReceived.parse(strDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ds.format(d);
		} else
			return null;
	}
	
	static public String getFechaActual(){
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone tz = TimeZone.getTimeZone("America/Lima");
		sdf.setTimeZone(tz);
		return sdf.format(d);
	}

	public String getFechaInDays(int dias, String accion){
		int v_dias = dias;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zona = TimeZone.getTimeZone("America/Lima");
		sdf.setTimeZone(zona);
		Date v_fecha = new Date();
		
		//AVANZA O RETROCEDE (n DIAS)
		//En caso sea sabado avanza a lunes
		if(accion.equals("FORWARD")){
		    Calendar cumpleCal = Calendar.getInstance();
			cumpleCal.setTime(v_fecha);
			int horas = cumpleCal.get(Calendar.HOUR_OF_DAY); //set horas
			int minutos = cumpleCal.get(Calendar.MINUTE);
			int dia = cumpleCal.get(Calendar.DAY_OF_WEEK);			
			
			//-- System.out.println("Dia: "+ dia + " Son las "+ horas+ ":"+minutos);
			if(dia!=1){ // si no es domingo
				if(dia==7) v_dias += 1;  // si es sabado, avanza a lunes
				else if(dia==6){ if((horas == 17 && minutos >= 30) || horas > 17) v_dias += 2;} // si es viernes y mas de las 5:30 pm, avanzara a lunes
				else if((horas == 17 && minutos >= 30) || horas > 17) v_dias += 1; // el resto de dias de la semana despues de las 5:30 pm, avanzara un dia	
			}
			
			//-- System.out.println(" v_dias " +  v_dias);
			v_fecha = new Date(fecha.getTime() + (86400000 * v_dias));
				
		}else if((accion.equals("BACK")))
			v_fecha = new Date(fecha.getTime() - (86400000 * dias));
		
		return sdf.format(v_fecha);
	}
	

	public Calendar getFechaHoy(){
		return Calendar.getInstance();
	}
	
	
	static public Date getFecha(String date) throws Exception {
		DateFormat df = new SimpleDateFormat(DATETIME_PATTERN_SLASH_dd_MM_yyyy);
		return df.parse(date);
	}
	
	public static String getFecha(Date date, String patron) throws Exception {
		DateFormat df = new SimpleDateFormat(patron);
		return df.format(date);
	}
	
	public static String getMonthYearNow(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone tz = TimeZone.getTimeZone("America/Lima");
		sdf.setTimeZone(tz);
		return sdf.format(d);
	}
	
	public String getMMYYYY(String p_indicador){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		TimeZone zona = TimeZone.getTimeZone("America/Lima");
		sdf.setTimeZone(zona);
		Calendar cumpleCal = Calendar.getInstance();
		if(p_indicador.equalsIgnoreCase("ONE_YEAR_AGO")){
			cumpleCal.add(Calendar.YEAR, -1);
		}
		return sdf.format(cumpleCal.getTime());
	}
	
//	public ArrayList<BeanComboBox> getLastYears(int nroYears){
//		ArrayList<BeanComboBox> listCombo = new ArrayList<BeanComboBox>();
//		Date v_fecha = new Date();
//		BeanComboBox bean = null;
//		Calendar cumpleCal = Calendar.getInstance();
//		cumpleCal.setTime(v_fecha);
//		int v_anio = cumpleCal.get(Calendar.YEAR);
//		
//		for(int i=0; i < nroYears; i++){
//			bean = new BeanComboBox(); 
//			bean.setCodigo((v_anio - i)+"");
//			bean.setNombre((v_anio - i)+"");
//			listCombo.add(bean);
//		}
//		
//		//-- Años Anteriores
//		bean = new BeanComboBox(); 
//		bean.setCodigo("OTROS");
//		bean.setNombre("Años Anteriores");
//		listCombo.add(bean);
//		
//		return listCombo;
//	} 
	// Inicio IV-09/05/2016
	static public String getMes(int mes){
		
		if(mes >= 1){
			return meses[mes-1];
		}else {
			return "";
		}
		
	}// Fin IV-09/05/2016
	static public String intervaloMeses(int mes){
		StringBuffer meses = new StringBuffer();
		for(int i=1 ; i<=mes ; i++){
			if(i==mes){	
				if(i>9){
					meses.append(Integer.toString(i));
				}else{
					meses.append("0");
					meses.append(Integer.toString(i));
				}
			}else{
				if(i>9){
					meses.append(Integer.toString(i));
					meses.append(",");
				}else{
				meses.append("0");
				meses.append(Integer.toString(i));
				meses.append(",");
				}
			}
		}
		return meses.toString();
	}
}
