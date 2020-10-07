package ADMINISTRATIVO.SERVICIOALCLIENTE.ACTUALIZACION;
import ADMINISTRATIVO.CREACION.*;
import ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS.*;

import java.util.ArrayList;
import java.util.Scanner;
public class UpdateCuenta extends Infcuenta{
	private Scanner in = new Scanner(System.in);
	private int OPC;
	private String cambio;
	public UpdateCuenta(){
		super();
		OPC=0;
		cambio=" ";
	}
	public void UpdateDatos(String NumeroCuenta,String DNIadmin,String clave, String[][] DB,ArrayList<Cliente> ClienteStatus){ 
		if(Administrador(DNIadmin,clave,DB)){
			if(AutentificacionCuenta(NumeroCuenta,ClienteStatus,true)){
				MostraDatos(NumeroCuenta,ClienteStatus,null);
				do{
					System.out.println("Ingrese 4 para modificar el apartado de tarjeta");
					System.out.println("Ingrese el numero del dato que desea actualizar o 5 para salir");
					OPC = in.nextInt();
					switch (OPC){
						case 1:
							System.out.println("Numero de cuenta: "+cuenta.getNumeroCuenta());
							in.nextLine();
							System.out.print("Ingrese el nuevo numero de cuenta: ");
							cambio=in.nextLine();
							cuenta.setNumeroCuenta(cambio);
							
						break;
						case 2:
							System.out.println("Estado de la cuenta (ACTIVA/INACTIVA): "+cuenta.getEstado());
							in.nextLine();
							System.out.print("Ingrese el nuevo estado: ");
							cambio=in.nextLine();
							cuenta.setEstado(cambio);
						break;
						case 3:
							System.out.println("Tipo de cuenta(AHORROS/CORRIENTE): "+cuenta.getTipoCuenta());
							in.nextLine();
							System.out.print("Ingrese la nueva diereccion: ");
							cambio=in.nextLine();
							cuenta.setTipoCuenta(cambio);
							
						break;
						case 4:
							System.out.println("********************************************************************************");
							cambio=" ";
							in.nextLine();
							System.out.println("Ingrese el numero de tarjeta que desea modificar: ");
							NumeroTarjeta=in.nextLine();
							System.out.println("Ingrese la clave tarjeta: ");
							ClaveTarjeta=in.nextLine();
							if(AutentificacionTarjeta(NumeroTarjeta,ClaveTarjeta,ClienteStatus)){
								int OPC=0;
								do{
									System.out.println("1. Numero de tarjeta: "+tarjeta.getNumeroTarjeta());
									System.out.println("2. Clave de tarjeta: "+tarjeta.getClaveTarjeta());
									System.out.println("3. Codigo de serie: "+tarjeta.getSerie());
									System.out.println("4. Fecha de Caducidad: "+tarjeta.getFechaCaducidad());
									System.out.println("5. Estado de tarjeta: "+tarjeta.getEstado());
									System.out.println("6. PARA SALIR ");
									OPC=in.nextInt();
									System.out.println("********************************************************************************");
									switch(OPC){
										case 1:
											System.out.print("\nNumero de tarjeta: "+tarjeta.getNumeroTarjeta());
											in.nextLine();
											System.out.print("\nIngrese el nuevo Numero de tarjeta: ");
											cambio=in.nextLine();
											tarjeta.setNumeroTarjeta(cambio);
										break;
										case 2:
											System.out.print("\nClave de tarjeta: "+tarjeta.getClaveTarjeta());
											in.nextLine();
											System.out.print("\nIngrese la nueva Clave de tarjeta: ");
											cambio=in.nextLine();
											tarjeta.setClaveTarjeta(cambio);
										break;
										case 3:
											System.out.print("\nCodigo de serie: "+tarjeta.getSerie());
											in.nextLine();
											System.out.print("\nIngrese el nuevo Codigo de serie: ");
											cambio=in.nextLine();
											tarjeta.setSerie(cambio);
										break;
										case 4:
											System.out.print("\nFecha de Caducidad: "+tarjeta.getFechaCaducidad());
											in.nextLine();
											System.out.print("\nIngrese la nueva Fecha de Caducidad: ");
											cambio=in.nextLine();
											tarjeta.setFechaCaducidad(cambio);
										break;
										case 5:
											System.out.print("\nEstado de tarjeta: "+tarjeta.getEstado());
											in.nextLine();
											System.out.print("\nIngrese el nuevo Estado de tarjeta: ");
											cambio=in.nextLine();
											tarjeta.setEstado(cambio);
										break;
									}
								}while(OPC!=6);
								MostraDatos(cuenta.getNumeroCuenta(),ClienteStatus,null);
							}
						break;
					}
				}while(OPC!=5);
				for(int i = 0;i<60;i++){System.out.println("");}
				MostraDatos(cuenta.getNumeroCuenta(),ClienteStatus,null);
			}else{
				System.out.println("ERROR. a autentificacion del cuenta");
			}
		}else{
			System.out.println("ERROR. Inicial el administrador");
		}
	}
	
}