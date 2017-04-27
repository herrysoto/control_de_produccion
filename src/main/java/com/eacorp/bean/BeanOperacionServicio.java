package com.eacorp.bean;

public class BeanOperacionServicio {
	private int numpreciosugerido;
	private String vchcodigooperacion;

	
	
	
	public BeanOperacionServicio() {
		super();
	}

	public int getNumpreciosugerido() {
		return numpreciosugerido;
	}

	public void setNumpreciosugerido(int numpreciosugerido) {
		this.numpreciosugerido = numpreciosugerido;
	}

	public String getVchcodigooperacion() {
		return vchcodigooperacion;
	}

	public void setVchcodigooperacion(String vchcodigooperacion) {
		this.vchcodigooperacion = vchcodigooperacion;
	}

	public BeanOperacionServicio(int numpreciosugerido,
			String vchcodigooperacion) {
		super();
		this.numpreciosugerido = numpreciosugerido;
		this.vchcodigooperacion = vchcodigooperacion;
	}

	@Override
	public String toString() {
		return "BeanOperacionServicio [numpreciosugerido=" + numpreciosugerido
				+ ", vchcodigooperacion=" + vchcodigooperacion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numpreciosugerido;
		result = prime
				* result
				+ ((vchcodigooperacion == null) ? 0 : vchcodigooperacion
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanOperacionServicio other = (BeanOperacionServicio) obj;
		if (numpreciosugerido != other.numpreciosugerido)
			return false;
		if (vchcodigooperacion == null) {
			if (other.vchcodigooperacion != null)
				return false;
		} else if (!vchcodigooperacion.equals(other.vchcodigooperacion))
			return false;
		return true;
	}

}
