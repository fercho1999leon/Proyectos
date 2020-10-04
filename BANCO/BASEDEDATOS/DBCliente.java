package BASEDEDATOS;
import ADMINISTRATIVO.*;
import ADMINISTRATIVO.CREACION.*;
import java.util.*;
import java.io.*;
public class DBCliente extends Autentificacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> cliente;
	
	public DBCliente() {
		cliente = new ArrayList<Cliente>();
	}
	
	public ArrayList<Cliente> getCliente(){
		System.out.println("Enviando Base de datos de los clientes.");
		return cliente;
	}
	public void setCliente (ArrayList<Cliente> cliente){
		System.out.println("Escribiendo Base de datos de los clientes.");
		this.cliente=cliente;
	}
}