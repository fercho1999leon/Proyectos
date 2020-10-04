package ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS;
import java.util.ArrayList;

import ADMINISTRATIVO.*;
import ADMINISTRATIVO.CREACION.*;
public class Infcuenta extends Autentificacion{
	public Infcuenta(){
		super();
	}
	private void DibujarTabla(){
		int Cont = 1;
		ArrayList<GenerarTarjeta> dbTarjetas = cuenta.getTarjeta();
		System.out.println("***************************************************");
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
		
		/*
		System.out.println("***************************************************");
		System.out.println("1. Numero de cuenta: "+cuenta[posCuenta].getNumeroCuenta());
		System.out.println("   Saldo total de la cuenta: "+cuenta[posCuenta].getSaldo());
		System.out.println("2. Estado de la cuenta (ACTIVA/INACTIVA): "+cuenta[posCuenta].getEstado());
		System.out.println("3. Tipo de cuenta(AHORROS/CORRIENTE): "+cuenta[posCuenta].getTipoCuenta());
		System.out.println("Tarjeta que pertenece a esta cuenta.");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(" || Numero de tarjeta  |  Clave de seguridad  |  Serie  |  Fecha de caducidad  |  ESTADO DE TARJETA   || ");
		do{
			if(!"0".equalsIgnoreCase(tarjeta[Cont2].getNumeroTarjeta())){
				System.out.println(" || "+Cont2+"."+tarjeta[Cont2].getNumeroTarjeta()+"       |         "+tarjeta[Cont2].getClaveTarjeta()+"         |   "+tarjeta[Cont2].getSerie()+"   |        "+tarjeta[Cont2].getFechaCaducidad()+"       |      "+tarjeta[Cont2].getEstado()+"    ||");
				Cont2++;
			}
		}while(!"0".equalsIgnoreCase(tarjeta[Cont2].getNumeroTarjeta()));
		*/
		System.out.println("---------------------------------------------------------------------------------------------------------");
	}
	public void MostraDatos(String NumeroCuenta,String DNIadmin,String clave, String[][] DB,ArrayList<Cliente> ClienteStatus){ //Solo se consulta por cedula del cliente
		if(Administrador(DNIadmin,clave,DB)){
			if(AutentificacionCuenta(NumeroCuenta,ClienteStatus,true)){
				DibujarTabla();
			}else{
				System.out.println("ERROR. a autentificacion de la cuenta");
			}
		}else{
			System.out.println("ERROR. Inicial el administrador");
		}
	}
	
}