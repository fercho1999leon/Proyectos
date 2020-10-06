package ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS;
import java.util.ArrayList;

import ADMINISTRATIVO.*;
import ADMINISTRATIVO.CREACION.*;
public class Infcliente extends Autentificacion{
	public Infcliente(){
		super();
	}
	private void DibujarTabla(){
		Control=0;
		ArrayList<Cuenta> dbCuentas = ClienteDatos.getCuentaDatos();
		for (Cuenta c :  dbCuentas) {
			System.out.println("Numero de cuenta: "+c.getNumeroCuenta());
			System.out.println("Tarjeta que pertenece a esta cuenta.");
			System.out.println("--------------------------------------------------");
			ArrayList<GenerarTarjeta> dbTarjetas = c.getTarjeta();
			int Cont = 1;
			for(GenerarTarjeta t : dbTarjetas) {
				System.out.println(" ||      "+Cont+". Numero de tarjeta: "+t.getNumeroTarjeta()+"      ||");
				Cont++;
			}
		}
	}
	public void MostraDatos(String DNI,ArrayList<Cliente> ClienteStatus){ //Solo se consulta por cedula del cliente
		if(AutentificacionCedula (DNI,ClienteStatus)){
			System.out.println("1. Nombre del cliente: "+ClienteDatos.getNombre());
			System.out.println("2. Numero de cedula: "+ClienteDatos.getDNI());
			System.out.println("3. Direccion domiciliaria: "+ClienteDatos.getDireccion());
			System.out.println("4. Numero de telefono: "+ClienteDatos.getTelefono());
			DibujarTabla();
		}else{
			System.out.println("ERROR. a autentificacion del cliente");
		}
	}
	
}