package CLIENTES;
import java.util.ArrayList;

import ADMINISTRATIVO.*;
import ADMINISTRATIVO.CREACION.*;
public class Retiro extends Autentificacion{ //Herencia se realiza para la autentificacion de credenciales 
	private double resultado;
	
	public Retiro(){
		super(); //Que incorpore los objetos super = se utiliza para hacer llamado al constructor 
	}
	public boolean Cajero(String NumeroTarjeta, String ClaveTarjeta, double ValorRetiro,ArrayList<Cliente> ClienteStatus){
		if(AutentificacionTarjeta(NumeroTarjeta,ClaveTarjeta,ClienteStatus)){
		    if(cuenta.getSaldo()>=ValorRetiro){
				resultado=cuenta.getSaldo()-ValorRetiro;
				cuenta.setSaldo(resultado);
				//cliente[posCliente].setCuentaDatos(cuenta);
				System.out.println("Se ha retirado el valor de "+ValorRetiro+" de su cuenta "+cuenta.getNumeroCuenta()+" mediante tarjeta con numeracion "+NumeroTarjeta+" saldo restante: "+cuenta.getSaldo());
				return true;
			}
			else {
				System.out.println("saldo insuficiente");
			}
		}else{
			System.out.println("clave incorrecta");
		}
		return false;
	}
	public boolean Directo(String NumeroCuenta,double ValorRetiro,ArrayList<Cliente> ClienteStatus,boolean MetodoAcceso){ //Enviar true para el retiro por numero de cuenta
		if(AutentificacionCuenta(NumeroCuenta,ClienteStatus,MetodoAcceso)){
		    if(cuenta.getSaldo()>=ValorRetiro){
				resultado=cuenta.getSaldo()-ValorRetiro;
				cuenta.setSaldo(resultado);
				//cliente[posCliente].setCuentaDatos(cuenta);
				System.out.println("Se ha retirado el valor de "+ValorRetiro+" de su cuenta "+cuenta.getNumeroCuenta()+" saldo restante: "+cuenta.getSaldo());
				return true;
			}
			else {
				System.out.println("saldo insuficiente");
			}
		}else{
			System.out.println("Numero de cuenta no valido");
		}
		return false;
	}
	public boolean Directo(String DNI,double ValorRetiro,ArrayList<Cliente> ClienteStatus){
		if(AutentificacionCedula(DNI,ClienteStatus)){
			ArrayList<Cuenta> tempCuentas = ClienteDatos.getCuentaDatos();
			for(Cuenta c : tempCuentas) {
				if(c.getSaldo()>=ValorRetiro){
					resultado=c.getSaldo()-ValorRetiro;
					c.setSaldo(resultado);
					//cliente[posCliente].setCuentaDatos(cuenta);
					System.out.println("Se ha retirado el valor de "+ValorRetiro+" de su cuenta "+c.getNumeroCuenta()+" saldo restante: "+c.getSaldo());
					return true;
				}
			}
		}else{
			System.out.println("Numero de cedula no valido");
		}
		return false;
	}
}