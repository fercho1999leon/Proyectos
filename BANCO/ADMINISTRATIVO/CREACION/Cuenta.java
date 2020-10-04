package ADMINISTRATIVO.CREACION;
import java.io.Serializable;
import java.util.*;
public class Cuenta implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NumeroCuenta;
    private String movimientoCuenta;
    private double Saldo;
    private String Estado;
    private String tipoCuenta;
	private ArrayList<GenerarTarjeta> Tarjeta;
	public Cuenta(){
		Tarjeta = new ArrayList<GenerarTarjeta>();
		Saldo=0;
		movimientoCuenta=" ";
		Estado=" ";
		tipoCuenta=" ";
	}

    public Cuenta(String NumeroCuenta, String movimientoCuenta, double Saldo, String Estado, String tipoCuenta) {
        this.NumeroCuenta = NumeroCuenta;
        this.movimientoCuenta = movimientoCuenta;
        this.Saldo = Saldo;
        this.Estado = Estado;
        this.tipoCuenta = tipoCuenta;
    }
    
	public ArrayList<GenerarTarjeta> getTarjeta(){
		return Tarjeta;
	}
	
	public void setTarjeta(GenerarTarjeta tarjeta){
		for(GenerarTarjeta t : Tarjeta) {
        	if (t.getNumeroTarjeta()==tarjeta.getNumeroTarjeta()) {
        		Tarjeta.remove(t);
        		Tarjeta.add(tarjeta);
        		return;
        	}
        }
		Tarjeta.add(tarjeta);
	}

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public String getMovimientoCuenta() {
        return movimientoCuenta;
    }

    public void setMovimientoCuenta(String movimientoCuenta) {
        this.movimientoCuenta = movimientoCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
	/*
    @Override
    public String toString() {
        return  " NUMERO DE CUENTA:  " +  NumeroCuenta  + " MOVIMIENTO CUENTA: " +  movimientoCuenta  + " SALDO " +  Saldo  + " ESTADO " +  Estado  + " TIPO DE CUENTA " + tipoCuenta ;
    }
    */
    
}