package ADMINISTRATIVO.CREACION;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
    private String DNI;
    private String direccion;
    private String telefono;
    private ArrayList<Cuenta> CuentaDatos;
	
	public Cliente(){
		nombre=" ";
		DNI="0";
		direccion=" ";
		telefono=" ";
		CuentaDatos = new ArrayList<Cuenta>();
	}

    public Cliente(String nombre, String DNI, String direccion, String telefono) { //String nombre, String DNI, String direccion, String telefono,  ArrayList<Cuenta> cuenta
        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
        //this.cuenta = cuenta;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
	
    public ArrayList<Cuenta> getCuentaDatos() {
        return CuentaDatos;
    }
	
	public void setCuentaDatos(Cuenta cuenta) {
        for(Cuenta c : CuentaDatos) {
        	if (c.getNumeroCuenta()==cuenta.getNumeroCuenta()) {
        		CuentaDatos.remove(c);
        		CuentaDatos.add(cuenta);
        		return;
        	}
        }
        CuentaDatos.add(cuenta);
    }
	public void updateCuentaDatos(ArrayList<Cuenta> CuentaDatos) {
        this.CuentaDatos = CuentaDatos;
    }
	

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", DNI=" + DNI + ", direccion=" + direccion + ", telefono=" + telefono + "}";
    }
	

}
