package ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS;
import java.util.ArrayList;

import javax.swing.JTextArea;

import ADMINISTRATIVO.*;
import ADMINISTRATIVO.CREACION.*;
public class Infcuenta extends Autentificacion{
	public Infcuenta(){
		super();
	}
	private void DibujarTabla(JTextArea print){
		int Cont = 1;
		ArrayList<GenerarTarjeta> dbTarjetas = cuenta.getTarjeta();
		/*System.out.println("***************************************************");
		System.out.println("1. Numero de cuenta: "+cuenta.getNumeroCuenta());
		System.out.println("   Saldo total de la cuenta: "+cuenta.getSaldo());
		System.out.println("2. Estado de la cuenta (ACTIVA/INACTIVA): "+cuenta.getEstado());
		System.out.println("3. Tipo de cuenta(AHORROS/CORRIENTE): "+cuenta.getTipoCuenta());
		System.out.println("Tarjeta que pertenece a esta cuenta.");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(" || Numero de tarjeta  |  Clave de seguridad  |  Serie  |  Fecha de caducidad  |  ESTADO DE TARJETA   || ");
		for (GenerarTarjeta t : dbTarjetas) {
			System.out.println(" || "+Cont+"."+t.getNumeroTarjeta()+"       |         "+t.getClaveTarjeta()+"         |   "+t.getSerie()+"   |        "+t.getFechaCaducidad()+"       |      "+t.getEstado()+"    ||");
			Cont++;
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");
		*/
		
		print.append("\n**********************************************************************************************************************************");
		print.append("\n1. Numero de cuenta: "+cuenta.getNumeroCuenta());
		print.append("\n   Saldo total de la cuenta: "+cuenta.getSaldo());
		print.append("\n2. Estado de la cuenta (ACTIVA/INACTIVA): "+cuenta.getEstado());
		print.append("\n3. Tipo de cuenta(AHORROS/CORRIENTE): "+cuenta.getTipoCuenta());
		print.append("\nTarjeta que pertenece a esta cuenta.");
		print.append("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		print.append("\n || Numero de tarjeta  |  Clave de seguridad  |  Serie  |  Fecha de caducidad  |  ESTADO DE TARJETA   || ");
		for (GenerarTarjeta t : dbTarjetas) {
			print.append("\n || "+Cont+"."+t.getNumeroTarjeta()+"        |               "+t.getClaveTarjeta()+"                |   "+t.getSerie()+"   |              "+t.getFechaCaducidad()+"            |      "+t.getEstado()+"      ||");
			Cont++;
		}
		print.append("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	public boolean MostraDatos(String NumeroCuenta,ArrayList<Cliente> ClienteStatus, JTextArea print){ //Solo se consulta por cedula del cliente
		if(AutentificacionCuenta(NumeroCuenta,ClienteStatus,true)){
			DibujarTabla(print);
			return true;
		}else{
			System.out.println("ERROR. a autentificacion de la cuenta");
			return false;
		}
	}
	
}