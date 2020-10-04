package BASEDEDATOS;
import java.io.*;
public class DBAdministradores implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[][] administrador = new String[3][2];
	
	public DBAdministradores(){
		//Administrador maestro
		administrador[0][0]="GRUPO5";
		administrador[0][1]="1234";
		for(int i=1;i<3;i++){
			for(int j=0;j<2;j++){
				administrador[i][j]="*";
			}
		}
	}
	
	public String[][] getAdministrador(String DNI, String clave){
		for(int i=0;i<3;i++){
			if(administrador[i][0].equals(DNI) && administrador[i][1].equals(clave)){
				return administrador;
			}
		}
		System.out.println("Autentificacion Incorrecta.");
		String[][] error = null;
		return error;
	}
	
	public void addAdministrador(String DNI, String clave){
		for(int i=0;i<3;i++){
			if(administrador[i][0].equals("*") && administrador[i][1].equals("*")){
				administrador[i][0]=DNI;
				administrador[i][1]=clave;
				System.out.println("Se a agregado un Administrador con DNI: "+DNI+" y clave "+clave);
				return;
			}
		}
	}
	public void deleteAdministrador(String DNI, String clave,String administradorDNI){
		if(administrador[0][0].equals(DNI) && administrador[0][1].equals(clave)){
			for(int i=1;i<3;i++){
				if(administrador[i][0].equals(administradorDNI)){
					administrador[i][0]="*";
					administrador[i][1]="*";
					System.out.println("Se a eliminado un Administrador con DNI: "+DNI+" y clave "+clave);
					return;
				}
			}
			System.out.println("ERROR No se elimino ningun Administrador");
		}
	}
	
}