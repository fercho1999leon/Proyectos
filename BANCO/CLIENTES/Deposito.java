package CLIENTES;
import java.util.ArrayList;

import ADMINISTRATIVO.*;
import ADMINISTRATIVO.CREACION.*;
public class Deposito extends Autentificacion{
	double resultado;
	
	public Deposito(){
		super();
	}
	public boolean Cajero(String NumeroTarjeta, String ClaveTarjeta, double ValorDeposito,ArrayList<Cliente> ClienteStatus){
		if(AutentificacionTarjeta(NumeroTarjeta,ClaveTarjeta,ClienteStatus)){
			resultado=cuenta.getSaldo()+ValorDeposito;
			cuenta.setSaldo(resultado);
			//cliente[posCliente].setCuentaDatos(cuenta);
			System.out.println("Se ha depositado el valor de "+ValorDeposito+" en su cuenta "+cuenta.getNumeroCuenta()+" mediante tarjeta con numeracion "+NumeroTarjeta+" saldo total: "+cuenta.getSaldo());
			return true;
		}else{
			System.out.println("clave incorrecta");
			return false;
		}
	}
	
	public boolean Directo(String NumeroCuenta,double ValorDeposito,ArrayList<Cliente> ClienteStatus,boolean MetodoAcceso){ //Enviar true para el retiro por numero de cuenta
		if(AutentificacionCuenta(NumeroCuenta,ClienteStatus,MetodoAcceso)){
			resultado=cuenta.getSaldo()+ValorDeposito;
			cuenta.setSaldo(resultado);
			//cliente[posCliente].setCuentaDatos(cuenta);
			System.out.println("Se ha depositado el valor de "+ValorDeposito+" en su cuenta "+cuenta.getNumeroCuenta()+" saldo total: "+cuenta.getSaldo());
			return true;
		}else{
			System.out.println("Numero de cuenta no valido");
			return false;
		}
	}
	public boolean Directo(String DNI,double ValorDeposito,ArrayList<Cliente> ClienteStatus){
		if(AutentificacionCedula(DNI,ClienteStatus)){
			resultado=cuenta.getSaldo()+ValorDeposito;
			cuenta.setSaldo(resultado);
			//cliente[posCliente].setCuentaDatos(cuenta);
			System.out.println("Se ha depositado el valor de "+ValorDeposito+" en su cuenta "+cuenta.getNumeroCuenta()+" saldo total: "+cuenta.getSaldo());
			return true;
		}else{
			System.out.println("Numero de cedula no valido");
			return false;
		}
	}
	
}