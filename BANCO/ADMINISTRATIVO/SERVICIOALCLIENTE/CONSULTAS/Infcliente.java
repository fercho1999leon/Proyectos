package ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS;
import java.util.ArrayList;

import javax.swing.JTextArea;

import ADMINISTRATIVO.*;
import ADMINISTRATIVO.CREACION.*;
public class Infcliente extends Autentificacion{
	public Infcliente(){
		super();
	}
	private void DibujarTabla(JTextArea print){
		Control=0;
		ArrayList<Cuenta> dbCuentas = ClienteDatos.getCuentaDatos();
		for (Cuenta c :  dbCuentas) {
			print.append("\n**************************************************************");
			print.append("\nNumero de cuenta: "+c.getNumeroCuenta());
			print.append("\nTarjeta que pertenece a esta cuenta.");
			print.append("\n-------------------------------------------------------------");
			ArrayList<GenerarTarjeta> dbTarjetas = c.getTarjeta();
			int Cont = 1;
			for(GenerarTarjeta t : dbTarjetas) {
				print.append("\n ||      "+Cont+". Numero de tarjeta: "+t.getNumeroTarjeta()+"      ||");
				Cont++;
			}
			
			/*
			System.out.println("Numero de cuenta: "+c.getNumeroCuenta());
			System.out.println("Tarjeta que pertenece a esta cuenta.");
			System.out.println("--------------------------------------------------");
			ArrayList<GenerarTarjeta> dbTarjetas = c.getTarjeta();
			int Cont = 1;
			for(GenerarTarjeta t : dbTarjetas) {
				System.out.println(" ||      "+Cont+". Numero de tarjeta: "+t.getNumeroTarjeta()+"      ||");
				Cont++;
			}
			*/
		}
	}
	public boolean MostraDatos(String DNI,ArrayList<Cliente> ClienteStatus, JTextArea print){ //Solo se consulta por cedula del cliente
		if(AutentificacionCedula (DNI,ClienteStatus)){
			print.append("\n1. Nombre del cliente: "+ClienteDatos.getNombre());
			print.append("\n2. Numero de cedula: "+ClienteDatos.getDNI());
			print.append("\n3. Direccion domiciliaria: "+ClienteDatos.getDireccion());
			print.append("\n4. Numero de telefono: "+ClienteDatos.getTelefono());
			DibujarTabla(print);
			return true;
		}else{
			return false;
		}
	}
	
}