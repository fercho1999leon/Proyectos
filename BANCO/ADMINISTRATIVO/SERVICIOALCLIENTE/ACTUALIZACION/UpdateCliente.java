package ADMINISTRATIVO.SERVICIOALCLIENTE.ACTUALIZACION;
import ADMINISTRATIVO.CREACION.*;
import ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS.*;
import java.util.*;
public class UpdateCliente extends Infcliente{
	private Scanner in = new Scanner(System.in);
	private int OPC;
	private String cambio;
	public UpdateCliente(){
		super();
		OPC=0;
		cambio=" ";
	}
	public void UpdateDatos(String DNI,String DNIadmin,String clave, String[][] DB,ArrayList<Cliente> ClienteStatus){ //Solo se consulta por cedula del cliente
		if(Administrador(DNIadmin,clave,DB)){
			if(AutentificacionCedula (DNI,ClienteStatus)){
				MostraDatos(DNI,ClienteStatus,null);
				do{
					System.out.println("Ingrese el numero del dato que desea actualizar o 5 para salir");
					OPC = in.nextInt();
					switch (OPC){
						case 1:
							System.out.println("Nombre: "+ClienteDatos.getNombre());
							cambio=in.nextLine();
							System.out.print("Ingrese el nuevo nombre: ");
							cambio=in.nextLine();
							ClienteDatos.setNombre(cambio);
							
						break;
						case 2:
							System.out.println("Numero de cedula: "+ClienteDatos.getDNI());
							System.out.print("Ingrese el nuevo numero de cedula: ");
							cambio=in.nextLine();
							ClienteDatos.setDNI(cambio);
						break;
						case 3:
							System.out.println("Direccion domiciliaria: "+ClienteDatos.getDireccion());
							System.out.print("Ingrese la nueva diereccion: ");
							cambio=in.nextLine();
							ClienteDatos.setDireccion(cambio);
							
						break;
						case 4:
							System.out.println("Numero de telefono: "+ClienteDatos.getTelefono());
							System.out.print("Ingrese el nuevo numero de telefono: ");
							cambio=in.nextLine();
							ClienteDatos.setTelefono(cambio);
						break;
					}
				}while(OPC!=5);
				for(int i = 0;i<60;i++){System.out.println("");}
				MostraDatos(DNI,ClienteStatus,null);
			}else{
				System.out.println("ERROR. a autentificacion del cliente");
			}
		}else{
			System.out.println("ERROR. Inicial el administrador");
		}
	}
}