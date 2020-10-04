package interfazGrafica.marcoGUI;

import javax.swing.*;

import ADMINISTRATIVO.Autentificacion;
import ADMINISTRATIVO.CREACION.Cliente;
import BASEDEDATOS.DBCliente;
import CLIENTES.Retiro;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PagoServicios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label1, label2, label3, label4, labelf, labelf1, labelf2, labelf3;
	private JButton boton1;
	private JComboBox<String> op1 ,tipoPago;
	private JSpinner spCantidad;
	private JTextField NumeroTarjeta,ClaveTarjeta,NumeroCuenta,NumeroCedula;
	JPanel lmaPrincipal,lmaPagoTarjeta,lmaPagoCuenta, lmaPagoCedula;
	final static String idPagoTarjeta = "PagoTarjeta";
	final static String idPagoCedula = "PagoCedula";
	final static String idPagoCuenta = "PagoCuenta";
	private JLabel t1,t2,t3;
	private static int anchoTxt = 12;
	private JButton btnLimpiar;
	public PagoServicios() {
		setLayout(null);
		setBackground(new Color(0, 39, 56));
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(280, 400, 100, 30);
		btnLimpiar.setBackground(new Color(255, 255, 255));
		btnLimpiar.setFont(new Font("Andale Mono", 1, 14));
		btnLimpiar.setForeground(new Color(0, 0, 0));
		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clear();
				
			}
			
		});
		add(btnLimpiar);
		
		t1 = new JLabel();
		t1.setForeground(new Color(255, 255, 255));
		t1.setFont(new Font("Andale Mono", 1, 13));
		t1.setBounds(560, 180, 260, 100);
		t2 = new JLabel();
		t2.setForeground(new Color(255, 255, 255));
		t2.setFont(new Font("Andale Mono", 1, 13));
		t2.setBounds(560, 200, 260, 100);
		t3 = new JLabel();
		t3.setForeground(new Color(255, 255, 255));
		t3.setFont(new Font("Andale Mono", 1, 13));
		t3.setBounds(560, 220, 260, 100);
		
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		
		add(t1);
		add(t2);
		add(t3);
		
		lmaPrincipal = new JPanel();
		lmaPrincipal.setBounds(5, 300, 400, 100);
		lmaPrincipal.setLayout(new CardLayout(0,0));
		lmaPrincipal.setBackground(new Color(0, 39, 56));
		lmaPagoTarjeta = new JPanel();
		lmaPagoTarjeta.setBackground(new Color(0, 39, 56));
		lmaPagoCuenta = new JPanel(); 
		lmaPagoCuenta.setBackground(new Color(0, 39, 56));
		lmaPagoCedula = new JPanel();
		lmaPagoCedula.setBackground(new Color(0, 39, 56));
		add(lmaPrincipal);
		NumeroTarjeta = new JTextField(anchoTxt);
		ClaveTarjeta = new JTextField(anchoTxt);
		NumeroCuenta = new JTextField(anchoTxt);
		NumeroCedula = new JTextField(anchoTxt);
		
		JLabel tituloTarjeta = new JLabel() , tituloClave = new JLabel();
		tituloTarjeta.setText("INGRESE EL NUMERO DE TARJETA");
		tituloClave.setText("INGRESE LA CLAVE");
		tituloTarjeta.setForeground(new Color(255, 255, 255));
		tituloTarjeta.setFont(new Font("Andale Mono", 1, 13));
		tituloClave.setForeground(new Color(255, 255, 255));
		tituloClave.setFont(new Font("Andale Mono", 1, 13));
		lmaPagoTarjeta.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lmaPagoTarjeta.add(tituloTarjeta);
		lmaPagoTarjeta.add(NumeroTarjeta);
		lmaPagoTarjeta.add(tituloClave);
		lmaPagoTarjeta.add(ClaveTarjeta);
		
		JLabel tituloCuenta = new JLabel("INGRESE EL NUMERO DE CUENTA");
		tituloCuenta.setForeground(new Color(255, 255, 255));
		tituloCuenta.setFont(new Font("Andale Mono", 1, 13));
		lmaPagoCuenta.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lmaPagoCuenta.add(tituloCuenta);
		lmaPagoCuenta.add(NumeroCuenta);
		
		JLabel tituloCedula = new JLabel("INGRESE EL NUMERO DE CEDULA");
		tituloCedula.setForeground(new Color(255, 255, 255));
		tituloCedula.setFont(new Font("Andale Mono", 1, 13));
		lmaPagoCedula.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lmaPagoCedula.add(tituloCedula);
		lmaPagoCedula.add(NumeroCedula);
		
		lmaPrincipal.add(lmaPagoCuenta,idPagoCuenta);
		lmaPrincipal.add(lmaPagoTarjeta,idPagoTarjeta);
		lmaPrincipal.add(lmaPagoCedula,idPagoCedula);		
		
		label1 = new JLabel("BIENVENIDO AL SISTEMA DE  ");
		label1.setBounds(80, 10, 300, 30);
		label1.setFont(new Font("Andale Mono", 3, 18));
		label1.setForeground(new Color(255, 255, 255));
		add(label1);
		label2 = new JLabel("PAGOS DE SERVICIOS BASICOS ");
		label2.setBounds(80, 40, 300, 30);
		label2.setFont(new Font("Andale Mono", 3, 18));
		label2.setForeground(new Color(255, 255, 255));
		add(label2);

		ImageIcon imagen = new ImageIcon("interfazGrafica/recursos/luz.png");
		labelf = new JLabel(imagen);
		labelf.setBounds(15, 80, 120, 100);
		add(labelf);

		ImageIcon imagen1 = new ImageIcon("interfazGrafica/recursos/agua.png");
		labelf1 = new JLabel(imagen1);
		labelf1.setBounds(120, 90, 115, 100);
		add(labelf1);

		ImageIcon imagen2 = new ImageIcon("interfazGrafica/recursos/internet.png");
		labelf2 = new JLabel(imagen2);
		labelf2.setBounds(150, 80, 260, 100);
		add(labelf2);
		ImageIcon imagen3 = new ImageIcon("interfazGrafica/recursos/telefono.png");
		labelf3 = new JLabel(imagen3);
		labelf3.setBounds(250, 80, 260, 100);
		add(labelf3);
		label3 = new JLabel("Selecione Servicio a Pagar");
		label3.setBounds(5, 212, 200, 30);
		label3.setForeground(new Color(255, 255, 255));
		label3.setFont(new Font("Andale Mono", 1, 13));
		
		add(label3);
		op1 = new JComboBox<String>();
		op1.addItem("LUZ");
		op1.addItem("AGUA");
		op1.addItem("INTERNET");
		op1.addItem("TELEFONIA FIJA");
		op1.setBackground(new Color(255, 255, 255));
		op1.setBounds(190, 212, 120, 30);
		add(op1);
		label4 = new JLabel("Valor");
		label4.setBounds(330, 212, 100, 30);
		label4.setForeground(new Color(255, 255, 255));
		label4.setFont(new Font("Andale Mono", 1, 13));
		add(label4);
		spCantidad = new JSpinner();
		spCantidad.setBounds(370, 212, 100, 30);
		add(spCantidad);

		tipoPago = new JComboBox<String>();
		tipoPago.addItem("CUENTA");
		tipoPago.addItem("TARJETA");
		tipoPago.addItem("CEDULA");
		tipoPago.setBounds(5, 250, 100, 30);
		tipoPago.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opc = tipoPago.getSelectedIndex();
				CardLayout c1 = (CardLayout)lmaPrincipal.getLayout();
				if(opc == 0) {
					c1.show(lmaPrincipal,idPagoCuenta);
				}else if(opc == 1) {
					c1.show(lmaPrincipal,idPagoTarjeta);
				}else {
					c1.show(lmaPrincipal,idPagoCedula);
				}
				
			}
			
		});
		add(tipoPago);

		boton1 = new JButton("Pagar");
		boton1.setBounds(80, 400, 100, 30);
		boton1.setBackground(new Color(255, 255, 255));
		boton1.setFont(new Font("Andale Mono", 1, 14));
		boton1.setForeground(new Color(0, 0, 0));
		boton1.addActionListener(new oyente());
		add(boton1);
	}
	private class oyente implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String nC1 = null, nDNI = null, nT = null, nClave = null;
			DBCliente dbCliente = conectInput ();
			Autentificacion validacion = new Autentificacion();
			int opc1 = tipoPago.getSelectedIndex();
			int cantidad = (int)spCantidad.getValue();
			Retiro retiro = new Retiro();
			if(dbCliente != null) {
				ArrayList<Cliente> db = dbCliente.getCliente();
				if(opc1 == 0) {
					nC1 = NumeroCuenta.getText();
					if(validacion.AutentificacionCuenta(nC1, db, true)) {
						if(retiro.Directo(nC1, cantidad, db, true)) {
							dbCliente.setCliente(db);
							conectOut(dbCliente);
							t1.setText("SE A REALIZADO EL PAGO CON EXITO");
							t2.setText("DE LA CUENTA "+nC1);
							t3.setText("SERVICIO PAGADO DE "+op1.getSelectedItem());
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
						}else {
							t1.setVisible(false);
							t2.setVisible(true);
							t2.setText("SALDO INSUFICIENTE.");
							t3.setVisible(false);
						}
					}else {
						t1.setVisible(false);
						t2.setVisible(true);
						t2.setText("NO SE ENCUENTRA LA CUENTA "+nC1);
						t3.setVisible(false);
					}
				}else if(opc1 == 1) {
					nT = NumeroTarjeta.getText();
					nClave = ClaveTarjeta.getText();
					if(validacion.AutentificacionTarjeta(nT, nClave, db)) {
						if(retiro.Cajero(nT, nClave, cantidad, db)) {
							dbCliente.setCliente(db);
							conectOut(dbCliente);
							t1.setText("SE A REALIZADO EL PAGO CON EXITO");
							t2.setText("DE LA TARJETA "+nT);
							t3.setText("SERVICIO PAGADO DE "+op1.getSelectedItem());
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
						}else {
							t1.setVisible(false);
							t2.setVisible(true);
							t2.setText("SALDO INSUFICIENTE.");
							t3.setVisible(false);
						}
					}else {
						t1.setVisible(false);
						t2.setVisible(true);
						t2.setText("NO SE ENCUENTRA LA TARJETA "+nT);
						t3.setVisible(false);
					}
				} else {
					nDNI = NumeroCedula.getText();
					if (validacion.AutentificacionCedula(nDNI, db)) {
						if (retiro.Directo(nDNI, cantidad, db)) {
							dbCliente.setCliente(db);
							conectOut(dbCliente);
							t1.setText("SE A REALIZADO EL PAGO CON EXITO");
							t2.setText("DEL CLIENTE CON DNI "+nDNI);
							t3.setText("SERVICIO PAGADO DE "+op1.getSelectedItem());
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
						}else {
							t1.setVisible(false);
							t2.setVisible(true);
							t2.setText("SALDO INSUFICIENTE.");
							t3.setVisible(false);
						}
					}else {
						t1.setVisible(false);
						t2.setVisible(true);
						t2.setText("NO SE ENCUENTRA EL CLIENTE "+nDNI);
						t3.setVisible(false);
					}
				}
			}else {
				t1.setVisible(false);
				t2.setVisible(true);
				t2.setText("ERROR EN LA BASE DE DATOS");
				t3.setVisible(false);
			}
			
		}
		
	}
	public void clear() {
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		NumeroTarjeta.setText("");
		ClaveTarjeta.setText("");
		NumeroCedula.setText("");
		NumeroCuenta.setText("");
		spCantidad.setValue(0);
		tipoPago.setSelectedIndex(0);
		op1.setSelectedIndex(0);
	}
	private DBCliente conectInput () {
		DBCliente dbCliente = null;
		String direcciondbClientes = "archivosStream/dbClientes.dat";
		try {
			ObjectInputStream InStreamdbClientes = new ObjectInputStream(new FileInputStream(direcciondbClientes));
			dbCliente = (DBCliente)InStreamdbClientes.readObject();
			InStreamdbClientes.close();
			System.out.println("Archivo cliente encontrado");
		}catch(Exception ex) {
			System.out.println("Archivo no encontrado");
		}
		return dbCliente;
	}
	private void conectOut(DBCliente db) {
		String direcciondbClientes = "archivosStream/dbClientes.dat";
		try {
			ObjectOutputStream OutStreamdbClientes = new ObjectOutputStream(new FileOutputStream(direcciondbClientes));
			OutStreamdbClientes.writeObject(db);
			OutStreamdbClientes.close();
			System.out.println("Archivo Guardado");
		}catch(IOException i) {
			System.out.println("Error al guardar el archivo clientes.---" + i.getMessage());
		}
	}
	

}