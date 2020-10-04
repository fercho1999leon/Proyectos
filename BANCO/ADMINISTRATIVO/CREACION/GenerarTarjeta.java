package ADMINISTRATIVO.CREACION;

import java.io.Serializable;

public class GenerarTarjeta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NumeroTarjeta;
	private String ClaveTarjeta;
	private String Serie;
	private String FechaCaducidad;
	private String Estado;
	public GenerarTarjeta(){
		NumeroTarjeta=" ";
		ClaveTarjeta="1234";
		FechaCaducidad=" ";
		Serie=" ";
	}
	public String getNumeroTarjeta(){
		return NumeroTarjeta;

	}
    public String getClaveTarjeta(){
        return ClaveTarjeta;
    }
	
	public String getSerie(){
		return Serie;
	}
	
	public String getEstado(){
		return Estado;
	}
	
	public void setEstado(String Estado){
		this.Estado=Estado;
	}
	
	public String getFechaCaducidad(){
		return FechaCaducidad;
	}
	
	public void setFechaCaducidad(String FechaCaducidad){
		this.FechaCaducidad=FechaCaducidad;
	}
	
	public void setSerie(String Serie){
		this.Serie=Serie;
	}
	
	public void setClaveTarjeta(String ClaveTarjeta){
        this.ClaveTarjeta=ClaveTarjeta;
    }
	
	public void setNumeroTarjeta(String NumeroTarjeta){
		this.NumeroTarjeta=NumeroTarjeta;
	}
}