package ADMINISTRATIVO;
import ADMINISTRATIVO.CREACION.*;
import java.util.*;
public class Autentificacion{
	protected int Control;
	protected String DNI,NumeroCuenta,NumeroTarjeta,ClaveTarjeta;
	protected Cliente ClienteDatos;
	protected Cuenta cuenta;
	protected GenerarTarjeta tarjeta;
	
	public Autentificacion(){
		cuenta = new Cuenta();
		tarjeta = new GenerarTarjeta();
		DNI="0";
		NumeroCuenta="0";
		NumeroTarjeta="0";
		ClaveTarjeta="0";
		Control = 0;
		ClienteDatos = new Cliente();
	}
	
	
	
	public GenerarTarjeta getTarjeta() {
		return tarjeta;
	}



	public void setTarjeta(GenerarTarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}



	public Cuenta getCuenta() {
		return cuenta;
	}



	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}



	public Cliente getClienteDatos() {
		return ClienteDatos;
	}


	public void setClienteDatos(Cliente clienteDatos) {
		ClienteDatos = clienteDatos;
	}


	public Autentificacion(String DNI,String clave, String[][] DB){
		Administrador(DNI,clave,DB);
	}
	public Autentificacion(String DNI,ArrayList<Cliente> ClienteStatus){
		AutentificacionCedula (DNI,ClienteStatus);
	}
	public Autentificacion(String NumeroCuenta,ArrayList<Cliente> ClienteStatus,boolean MetodoAcceo){ //Sobre carga de constructores 
		AutentificacionCuenta(NumeroCuenta,ClienteStatus,MetodoAcceo);
	}
	public Autentificacion(String NumeroTarjeta, String ClaveTarjeta, ArrayList<Cliente> ClienteStatus){
		AutentificacionTarjeta(NumeroTarjeta,ClaveTarjeta,ClienteStatus);
	}
	
	
	public boolean Administrador(String DNI,String clave, String[][] DB){
		Control=0;
		if(DB==null) {
			return false;
		}
		while (!DB[Control][0].equals("*") && !DB[Control][1].equals("*")){
			if(DB[Control][0].equals(DNI) && DB[Control][1].equals(clave)){
				//System.out.println("Autentificacion del administrador correcta");
				return true;
			}
			Control++;
		}
		//System.out.println("El administrador no existe o la clave es incorrecta");
		return false;
	}
	public boolean AutentificacionCedula (String DNI,ArrayList<Cliente> ClienteStatus){
		this.DNI="0";
		for(Cliente a: ClienteStatus) {
			if(DNI.equals(a.getDNI())) {
				this.DNI=DNI;
				ClienteDatos=a;
				return true;
			}
		}
		return false;
	}
	public boolean AutentificacionCuenta(String NumeroCuenta,ArrayList<Cliente> ClienteStatus,boolean MetodoAcceo){ //Tiene que enviar true para ingresar por Numero de cuenta
		this.NumeroCuenta="0";
		this.DNI="0";
		if(MetodoAcceo==true){
			
			for (Cliente cliente : ClienteStatus) {
				ArrayList<Cuenta> dbcuenta = cliente.getCuentaDatos();
				for (Cuenta cuenta : dbcuenta) {
					if(NumeroCuenta.equals(cuenta.getNumeroCuenta())) {
						ClienteDatos = cliente;
						this.cuenta = cuenta;
						this.NumeroCuenta=NumeroCuenta;
						this.DNI=cliente.getDNI();
						return true;
					}
				}
				
			}
		}
		return false;
	}
	public boolean AutentificacionTarjeta(String NumeroTarjeta, String ClaveTarjeta, ArrayList<Cliente> ClienteStatus){
		this.NumeroTarjeta="0";
		this.ClaveTarjeta="0";
		this.DNI="0";
		
		for (Cliente cliente : ClienteStatus) {
			ArrayList<Cuenta> dbcuenta = cliente.getCuentaDatos();
			for (Cuenta cuenta :  dbcuenta) {
				ArrayList<GenerarTarjeta> dbTarjeta = cuenta.getTarjeta();
				for(GenerarTarjeta tarjeta : dbTarjeta) {
					if(NumeroTarjeta.equals(tarjeta.getNumeroTarjeta()) && ClaveTarjeta.equals(tarjeta.getClaveTarjeta())) {
						this.cuenta = cuenta;
						this.ClienteDatos = cliente;
						this.tarjeta = tarjeta;
						this.NumeroTarjeta=NumeroTarjeta;
						this.ClaveTarjeta=ClaveTarjeta;
						return true;
					}
				}
			}
		}
		return false;
	}
	
}