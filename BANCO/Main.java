/*
	hugo cesar aguagallo carrillo
washington fernando leon boada
jaime eduardo alban marcillo
ramirez uruchima cristina nicole
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
		 
		//GitHub
		/*//Con arraylist
		DBAdministradores dbAD = new DBAdministradores();
		DBCliente dbCL = new DBCliente();
		String[][] TEMPad = dbAD.getAdministrador("GRUPO5","1234");
		ArrayList<Cliente> dbCliente = dbCL.getCliente("GRUPO5","1234",TEMPad);	
		
		Cliente temp = new Cliente();
		Cuenta tempCuenta = new Cuenta();
		GenerarTarjeta tempTarjeta = new GenerarTarjeta();
		
		tempTarjeta.setSerie("355");
		tempTarjeta.setFechaCaducidad("22/2025");
		tempTarjeta.setEstado("DESBLOQUEADA");
		tempTarjeta.setNumeroTarjeta("9999988886");
		
		tempCuenta.setNumeroCuenta("1111100000");
		tempCuenta.setEstado("ACTIVO");
		tempCuenta.setTipoCuenta("AHORROS");
		tempCuenta.setSaldo(100);
		
		tempCuenta.setTarjeta(tempTarjeta);
		
		temp.setNombre("FERNANDO");
		temp.setDNI("1234567890");
		temp.setDireccion("Guayas");
		temp.setTelefono("0999999999");
		temp.setCuentaDatos(tempCuenta);
		
		dbCliente.add(temp);
		
		
		Retiro r = new Retiro();
		r.Cajero("9999988886","1234",25,dbCliente); //Por tarjeta
		r.Directo("1111100000",15,dbCliente,true); //Por cuenta
		r.Directo("1234567890",15,dbCliente); //Por cedula
		System.out.println("------------> "+dbCliente.get(0).getCuentaDatos().get(0).getSaldo());
		
		Deposito d = new Deposito();
		d.Cajero("9999988886","1234",150,dbCliente);
		d.Directo("1111100000",15,dbCliente,true);
		d.Directo("1234567890",155,dbCliente);
		System.out.println("------------> "+dbCliente.get(0).getCuentaDatos().get(0).getSaldo());
		*/
		
		/*
		CreacionCliente[0].setNombre("FERNANDO");
		CreacionCliente[0].setDNI("1234567890");
		CreacionCliente[0].setDireccion("Guayas");
		CreacionCliente[0].setTelefono("0999999999");
		Cuenta[] c = CreacionCliente[0].getCuentaDatos();
		GenerarTarjeta[] t = c[0].getTarjeta();
		c[0].setNumeroCuenta("1010101010");
		c[0].setEstado("ACTIVO");
		c[0].setTipoCuenta("AHORROS");
		c[0].setSaldo(100);
		CreacionCliente[0].setCuentaDatos(c);
		//---------------------------------------------------------------
		CreacionCliente[1].setNombre("LEON");
		CreacionCliente[1].setDNI("0011001100");
		CreacionCliente[1].setDireccion("Guayas");
		CreacionCliente[1].setTelefono("0999999999");
		c = CreacionCliente[1].getCuentaDatos();
		
		c[0].setNumeroCuenta("1111100000");
		c[0].setEstado("ACTIVO");
		c[0].setTipoCuenta("AHORROS");
		c[0].setSaldo(100);
		t = c[0].getTarjeta();
		t[0].setSerie("355");
		t[0].setFechaCaducidad("22/2025");
		t[0].setEstado("DESBLOQUEADA");
		t[0].setNumeroTarjeta("9999988886");
		t[1].setSerie("888");
		t[1].setFechaCaducidad("22/2029");
		t[1].setEstado("BLOQUEADA   ");//AL PONER BLOQUEADA PORNER CON TRES ESPACIOS A IZQUIERDA
		t[1].setNumeroTarjeta("9999988885");
		
		c[0].setTarjeta(t);
		//----------------------------------------------------------------
		c[1].setNumeroCuenta("1112223335");
		c[1].setEstado("ACTIVO");
		c[1].setTipoCuenta("AHORROS");
		c[1].setSaldo(100);
		t = c[1].getTarjeta();
		t[0].setSerie("578");
		t[0].setFechaCaducidad("25/2022");
		t[0].setEstado("DESBLOQUEADA");
		t[0].setNumeroTarjeta("0988413329");
		t[1].setSerie("125");
		t[1].setFechaCaducidad("15/2021");
		t[1].setEstado("DESBLOQUEADA");
		t[1].setNumeroTarjeta("0988413854");
		
		c[1].setTarjeta(t);
		
		CreacionCliente[1].setCuentaDatos(c);
		
		
		Retiro r = new Retiro();
		r.Cajero("9999988885","1234",25,CreacionCliente); //Por tarjeta
		r.Directo("1111100000",15,CreacionCliente,true); //Por cuenta
		r.Directo("0011001100",15,CreacionCliente); //Por cedula
		Cuenta[] cuenta = CreacionCliente[0].getCuentaDatos();
		System.out.println("------------> "+cuenta[0].getSaldo());
		
		Deposito d = new Deposito();
		d.Cajero("9999988885","1234",150,CreacionCliente);
		d.Directo("1111100000",15,CreacionCliente,true);
		d.Directo("0011001100",155,CreacionCliente);
		System.out.println("------------> "+cuenta[0].getSaldo());
		
		
		Pagoserviciosbasicos s = new Pagoserviciosbasicos();
		s.Luz("9999988885","1234",50,CreacionCliente); //Por Tarjeta
		s.Agua("1111100000",15,CreacionCliente,true); //Por cuenta
		s.Internet("0011001100",10,CreacionCliente); //Por cedula
		
		
		TrasnferenciaInterbancaria TRANS=new TrasnferenciaInterbancaria();
		TrasnferenciaDirecta TRANSDIREC=new TrasnferenciaDirecta();
		TRANS.Trasnferencia("9999988885","1234",10,"0999999990",CreacionCliente);
		TRANSDIREC.Trasnferencia("9999988885","1234",10,"0988413854",CreacionCliente);
		
		
		Infcliente p1=new Infcliente();
		p1.MostraDatos("0011001100","GRUPO5","1234",TEMPad,CreacionCliente);
		
		
		Infcuenta InfC = new Infcuenta();
		InfC.MostraDatos("1111100000","GRUPO5","1234",TEMPad,CreacionCliente);
		
		//Interaccion con el usuario
		UpdateCliente UpdateC= new UpdateCliente();
		UpdateC.UpdateDatos("0011001100","GRUPO5","1234",TEMPad,CreacionCliente);
		
		//Interaccion con el usuario
		UpdateCuenta updatecuenta = new UpdateCuenta();
		updatecuenta.UpdateDatos("1111100000","GRUPO5","1234",TEMPad,CreacionCliente);
		Infcliente p2=new Infcliente();
		p2.MostraDatos("0011001100","GRUPO5","1234",TEMPad,CreacionCliente);
		*/
	}
}