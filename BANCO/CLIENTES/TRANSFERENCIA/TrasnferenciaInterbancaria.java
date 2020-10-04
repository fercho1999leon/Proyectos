package CLIENTES.TRANSFERENCIA;
import CLIENTES.*;

import java.util.ArrayList;

import ADMINISTRATIVO.CREACION.*;
public class TrasnferenciaInterbancaria extends Retiro{
	Retiro retiro = new Retiro();
	Deposito deposito = new Deposito();
	public boolean Trasnferencia(String NumeroTarjeta, String ClaveTarjeta, double ValorTransferir,String NumeroCuentaBenificiario,ArrayList<Cliente> ClienteStatus){
		if(Cajero(NumeroTarjeta,ClaveTarjeta,ValorTransferir,ClienteStatus)){
			System.out.println("Se realizado la transferencia Interbancaria de "+ValorTransferir+" al numero de cuenta "+NumeroCuentaBenificiario);
			return true;
		}
		return false;
	}
}