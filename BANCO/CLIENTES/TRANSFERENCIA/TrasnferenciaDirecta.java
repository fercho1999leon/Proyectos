package CLIENTES.TRANSFERENCIA;
import CLIENTES.*;
import ADMINISTRATIVO.CREACION.*;

import java.util.ArrayList;

import ADMINISTRATIVO.*;
public class TrasnferenciaDirecta extends Autentificacion{
	Retiro retiro = new Retiro();
	Deposito deposito = new Deposito();
	public boolean Trasnferencia(String NumeroTarjeta, String ClaveTarjeta, double ValorTransferir,String NumeroCuentaBenificiario,ArrayList<Cliente> cliente){
		if(AutentificacionCuenta(NumeroCuentaBenificiario,cliente,true)){
			if(retiro.Cajero(NumeroTarjeta,ClaveTarjeta,ValorTransferir,cliente)){
				deposito.Directo(NumeroCuentaBenificiario,ValorTransferir,cliente,true);
				System.out.println("Se realizado la transferencia directa de "+ValorTransferir+" al numero de cuenta "+NumeroCuentaBenificiario);
				return true;
			}
		}else{
			System.out.println("No existe el benificiario en el banco.");
		}
		return false;
	}
}