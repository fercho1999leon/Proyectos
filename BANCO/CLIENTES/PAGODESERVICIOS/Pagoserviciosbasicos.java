package CLIENTES.PAGODESERVICIOS;
import CLIENTES.*;

import java.util.ArrayList;

import ADMINISTRATIVO.CREACION.*;
public class Pagoserviciosbasicos extends Retiro{ //Que las clases hijas estén en distintos paquetes que las clases padres
	
	public void Luz(String NumeroTarjeta, String ClaveTarjeta, double ValorPagar,ArrayList<Cliente> ClienteStatus){
		if(Cajero(NumeroTarjeta,ClaveTarjeta,ValorPagar,ClienteStatus)){
			System.out.println("Se a realizado el pago del servicio de Luz.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	public void Luz(String NumeroCuenta,double ValorPagar,ArrayList<Cliente> ClienteStatus,boolean MetodoAcceso){ //Sobrecarga de metodos 
		if(Directo(NumeroCuenta,ValorPagar,ClienteStatus,MetodoAcceso)){
			System.out.println("Se a realizado el pago del servicio de Luz.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	public void Luz(String DNI,double ValorPagar,ArrayList<Cliente> ClienteStatus){
		if(Directo(DNI,ValorPagar,ClienteStatus)){
			System.out.println("Se a realizado el pago del servicio de Luz.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Agua(String NumeroTarjeta, String ClaveTarjeta, double ValorPagar,ArrayList<Cliente> ClienteStatus){
		if(Cajero(NumeroTarjeta,ClaveTarjeta,ValorPagar,ClienteStatus)){
			System.out.println("Se a realizado el pago del servicio de Agua.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Agua(String NumeroCuenta,double ValorPagar,ArrayList<Cliente> ClienteStatus,boolean MetodoAcceso){
		if(Directo(NumeroCuenta,ValorPagar,ClienteStatus,MetodoAcceso)){
			System.out.println("Se a realizado el pago del servicio de Agua.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Agua(String DNI,double ValorPagar,ArrayList<Cliente> ClienteStatus){
		if(Directo(DNI,ValorPagar,ClienteStatus)){
			System.out.println("Se a realizado el pago del servicio de Agua.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Internet(String NumeroTarjeta, String ClaveTarjeta, double ValorPagar,ArrayList<Cliente> ClienteStatus){
		if(Cajero(NumeroTarjeta,ClaveTarjeta,ValorPagar,ClienteStatus)){
			System.out.println("Se a realizado el pago del servicio de Internet.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Internet(String NumeroCuenta,double ValorPagar,ArrayList<Cliente> ClienteStatus,boolean MetodoAcceso){
		if(Directo(NumeroCuenta,ValorPagar,ClienteStatus,MetodoAcceso)){
			System.out.println("Se a realizado el pago del servicio de Internet.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Internet(String DNI,double ValorPagar,ArrayList<Cliente> ClienteStatus){
		if(Directo(DNI,ValorPagar,ClienteStatus)){
			System.out.println("Se a realizado el pago del servicio de Internet.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Telefono(String NumeroTarjeta, String ClaveTarjeta, double ValorPagar,ArrayList<Cliente> ClienteStatus){
		if(Cajero(NumeroTarjeta,ClaveTarjeta,ValorPagar,ClienteStatus)){
			System.out.println("Se a realizado el pago del servicio de Telefono.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Telefono(String NumeroCuenta,double ValorPagar,ArrayList<Cliente> ClienteStatus,boolean MetodoAcceso){
		if(Directo(NumeroCuenta,ValorPagar,ClienteStatus,MetodoAcceso)){
			System.out.println("Se a realizado el pago del servicio de Telefono.");
		}else{
			System.out.println("El pago fallo");
		}
	}
	
	public void Telefono(String DNI,double ValorPagar,ArrayList<Cliente> ClienteStatus){
		if(Directo(DNI,ValorPagar,ClienteStatus)){
			System.out.println("Se a realizado el pago del servicio de Telefono.");
		}else{
			System.out.println("El pago fallo");
		}
	}
}
