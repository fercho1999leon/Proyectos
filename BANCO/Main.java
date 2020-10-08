/*
hugo cesar aguagallo carrillo
washington fernando leon boada
jaime eduardo alban marcillo
ramirez uruchima cristina nicole
ISAI ITALO RIVAS AVILA
Grupo 5
Entidad Bancaria
*/
import BASEDEDATOS.*;
import interfazGrafica.marcoGUI.*;
import java.io.*;

public class Main{
	public static void main(String[] arg){
		
		String direcciondbAdmin = "archivosStream/dbAdmin.dat";
		DBAdministradores dbAdmin = null;
		try {
			ObjectInputStream InStreamdbAdmin = new ObjectInputStream(new FileInputStream(direcciondbAdmin));
			dbAdmin = (DBAdministradores)InStreamdbAdmin.readObject();
			InStreamdbAdmin.close();
			System.out.println("Archivo encontrado");
		}catch(Exception e) {
			try {
				ObjectOutputStream OutStreamdbAdmin = new ObjectOutputStream(new FileOutputStream(direcciondbAdmin));
				dbAdmin = new DBAdministradores();
				OutStreamdbAdmin.writeObject(dbAdmin);
				OutStreamdbAdmin.close();
				System.out.println("Archivo nuevo");
			} catch (IOException e1) {
				dbAdmin = new DBAdministradores();
				System.out.println("Error al guardar el archivo.");
			}
		}
		
		MarcoPrincipal miMarco = new MarcoPrincipal(dbAdmin);
		miMarco.setVisible(true);
	}
}