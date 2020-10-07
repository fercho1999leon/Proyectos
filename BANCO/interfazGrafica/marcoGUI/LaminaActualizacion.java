package interfazGrafica.marcoGUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

import ADMINISTRATIVO.Autentificacion;
import ADMINISTRATIVO.CREACION.Cliente;
import ADMINISTRATIVO.CREACION.Cuenta;
import ADMINISTRATIVO.CREACION.GenerarTarjeta;
import ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS.Infcliente;
import ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS.Infcuenta;
import BASEDEDATOS.DBCliente;

public class LaminaActualizacion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cajaVertical,cajaHorizontal,lmaCambio;
	private Color color;
	private JTextField NumeroTarjeta,ClaveTarjeta,NumeroCuenta,NumeroCedula;
	private JPanel lmaPrincipal,lmaTarjeta,lmaCuenta, lmaCliente, lmaBTN;
	private JComboBox<String> tipoActualizacion;
	private JTextArea showInfo;
	private JButton btnUpdate,btnConsulta,btnCancelar;
	private JLabel lbUpdate,lbTitulo,lbConsultar,lbCancelar;
	private JScrollPane scrollMostrar;
	private static int anchoTxt = 12;
	private LMACcliente laminaCliente;
	private LMACcuenta laminaCuenta;
	private LMACtarjeta laminaTarjeta;
	final static String idTarjeta = "Tarjeta";
	final static String idCliente = "Cliente";
	final static String idCuenta = "Cuenta";
	final static String idLaminaTarjeta = "LaminaTarjeta";
	final static String idLaminaCliente = "LaminaCliente";
	final static String idLaminaCuenta = "LaminaCuenta";
	final static String idLaminaPresent = "LaminaPresent";
	public LaminaActualizacion() {
		laminaCliente = new LMACcliente();
		laminaCuenta = new LMACcuenta();
		laminaTarjeta = new LMACtarjeta();
		color = new Color(0, 39, 56);
		setBackground(color);
		setLayout(new BoxLayout(LaminaActualizacion.this,BoxLayout.X_AXIS));
		cajaVertical = new JPanel();
		cajaVertical.setLayout(new BoxLayout(cajaVertical,BoxLayout.Y_AXIS));
		cajaVertical.setBackground(color);
		cajaHorizontal = new JPanel();
		cajaHorizontal.setLayout(new BoxLayout(cajaHorizontal,BoxLayout.X_AXIS));
		cajaHorizontal.setBackground(color);
		lmaCambio = new JPanel();
		lmaCambio.setLayout(new CardLayout(0,0));
		lmaCambio.setBackground(color);
		showInfo = new JTextArea(20,50);
		showInfo.setEnabled(false);
		scrollMostrar = new JScrollPane(showInfo);
		btnUpdate = createBTN ("interfazGrafica/recursos/btnConsultar.png",50,50);
		btnUpdate.setVisible(false);
		btnUpdate.addActionListener(new oyenteBTNS());
		btnConsulta = createBTN ("interfazGrafica/recursos/btnConsultar.png",50,50);
		btnConsulta.addActionListener(new oyenteBTNS());
		btnCancelar = createBTN ("interfazGrafica/recursos/btnCancelar.png",50,50);
		btnCancelar.setVisible(false);
		btnCancelar.addActionListener(new oyenteBTNS());
		lbUpdate = createLabel (13);
		lbUpdate.setText("PRESIONE PARA ACTUALIZAR");
		lbTitulo = createLabel (13);
		lbTitulo.setText("ESTA SELECIONADO LA ELIMINACION DE CLIENTE");
		lbTitulo.setVisible(true);
		lbConsultar = createLabel (13);
		lbConsultar.setText("PRESIONE PARA CONSULTAR");
		lbConsultar.setVisible(true);
		lbCancelar = createLabel (13);
		lbCancelar.setText("PRESIONE PARA CANCELAR");
		
		lmaCambio.add(new JLabel(crearIcono("interfazGrafica/recursos/iconoPresent.png", 200 ,200)),idLaminaPresent);
		lmaCambio.add(laminaCliente,idLaminaCliente);
		lmaCambio.add(laminaCuenta,idLaminaCuenta);
		lmaCambio.add(laminaTarjeta,idLaminaTarjeta);
		
		lmaPrincipal = new JPanel();
		lmaPrincipal.setLayout(new CardLayout(0,0));
		lmaPrincipal.setBackground(color);
		lmaTarjeta = new JPanel();
		lmaTarjeta.setBackground(color);
		lmaCuenta = new JPanel(); 
		lmaCuenta.setBackground(color);
		lmaCliente = new JPanel();
		lmaCliente.setBackground(color);
		lmaBTN = new JPanel();
		lmaBTN.setBackground(color);
		
		NumeroTarjeta = new JTextField(anchoTxt);
		ClaveTarjeta = new JTextField(anchoTxt);
		NumeroCuenta = new JTextField(anchoTxt);
		NumeroCedula = new JTextField(anchoTxt);
		
		lmaTarjeta.setLayout(new FlowLayout(FlowLayout.LEFT));
		lmaTarjeta.add(addComponent ("INGRESE EL NUMERO DE TARJETA: ",NumeroTarjeta));
		lmaTarjeta.add(addComponent ("INGRESE LA CLAVE DE TARJETA: ",ClaveTarjeta));
		
		lmaCuenta.setLayout(new FlowLayout(FlowLayout.LEFT));
		lmaCuenta.add(addComponent ("INGRESE EL NUMERO DE CUENTA: ",NumeroCuenta));
		
		lmaCliente.setLayout(new FlowLayout(FlowLayout.LEFT));
		lmaCliente.add(addComponent ("INGRESE EL NUMERO DE CEDULA: ",NumeroCedula));
		
		lmaPrincipal.add(lmaCliente,idCliente);
		lmaPrincipal.add(lmaCuenta,idCuenta);
		lmaPrincipal.add(lmaTarjeta,idTarjeta);
		
		lmaBTN.setLayout(new BoxLayout(lmaBTN,BoxLayout.X_AXIS));
		lmaBTN.add(lbUpdate);
		lmaBTN.add(btnUpdate);
		lmaBTN.add(lbConsultar);
		lmaBTN.add(btnConsulta);
		lmaBTN.add(lbCancelar);
		lmaBTN.add(btnCancelar);
		
		tipoActualizacion = new JComboBox<String>();
		tipoActualizacion.addItem("CLIENTE");
		tipoActualizacion.addItem("CUENTA");
		tipoActualizacion.addItem("TARJETA");
		tipoActualizacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opc = tipoActualizacion.getSelectedIndex();
				CardLayout c1 = (CardLayout)lmaPrincipal.getLayout();
				CardLayout c2 = (CardLayout)lmaCambio.getLayout();
				if(opc == 0) {
					c1.show(lmaPrincipal,idCliente);
					c2.show(lmaCambio,idLaminaPresent);
					clear();
					lbTitulo.setText("ESTA SELECIONADO LA ACTUALIZACION DE CLIENTE");
				}else if(opc == 1) {
					c1.show(lmaPrincipal,idCuenta);
					c2.show(lmaCambio,idLaminaPresent);
					clear();
					lbTitulo.setText("ESTA SELECIONADO LA ACTUALIZACION DE CUENTA");
				}else if(opc == 2) {
					c1.show(lmaPrincipal,idTarjeta);
					c2.show(lmaCambio,idLaminaPresent);
					clear();
					lbTitulo.setText("ESTA SELECIONADO LA ACTUALIZACION DE TARJETA");
				}
			}
			
		});
		cajaVertical.add(new LogoPresentacion("ACTUALIZACION DE DATOS",100,100));
		cajaVertical.add(addComponent ("INGRESE EL TIPO DE ACTUALIZACION",null));
		cajaVertical.add(tipoActualizacion);
		cajaVertical.add(addComponent ("",lbTitulo));
		cajaVertical.add(lmaPrincipal);
		cajaHorizontal.add(lmaCambio);
		cajaHorizontal.add(Box.createHorizontalStrut(15));
		cajaHorizontal.add(scrollMostrar);
		cajaVertical.add(cajaHorizontal);
		cajaVertical.add(lmaBTN);
		add(Box.createHorizontalStrut(10));
		add(cajaVertical);
		add(Box.createHorizontalStrut(10));
	}
	private <T> JPanel addComponent (String name, T comp) {
		JPanel temp = new JPanel();
		temp.setLayout(new FlowLayout(FlowLayout.LEADING));
		JLabel lbTemp = new JLabel(name);
		lbTemp.setFont(new Font("Arial",Font.BOLD,15));
		lbTemp.setForeground(Color.WHITE);
		temp.setBackground(color);
		temp.add(lbTemp);
		if(comp != null) {
			temp.add((JComponent)comp);
		}
		return temp;
	}
	private JButton createBTN (String dir, int width, int height) {
		JButton btn = new JButton();
		btn.setIcon(crearIcono(dir, width ,height));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusable(false);
		return btn;
	}
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
	private JLabel createLabel (int t) {
		JLabel l = new JLabel();
		l.setVisible(false);
		l.setFont(new Font("Arial",Font.BOLD,15));
		l.setForeground(Color.WHITE);
		return l;
	}
	private class oyenteBTNS implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String nC = null, nDNI = null, nT = null, nClave = null;
			CardLayout c1 = (CardLayout)lmaCambio.getLayout();
			Cliente cliente = new Cliente();
			Cuenta cuenta = new Cuenta();
			GenerarTarjeta tarjeta;
			int opc = tipoActualizacion.getSelectedIndex();
			Autentificacion validacion = new Autentificacion();
			if(e.getSource()==btnConsulta) {
				DBCliente dbCliente = conectInput ();
				if(dbCliente!=null) {
					ArrayList<Cliente> db = dbCliente.getCliente();
					if(opc==0) {
						nDNI = NumeroCedula.getText();
						NumeroCedula.setEnabled(false);
						if(validacion.AutentificacionCedula(nDNI, db)) {
							Infcliente consulta = new Infcliente();
							showInfo.setText("");
							consulta.MostraDatos(nDNI, db, showInfo);
							cliente = validacion.getClienteDatos();
							lbUpdate.setVisible(true);
							btnUpdate.setVisible(true);
							lbConsultar.setVisible(false);
							btnConsulta.setVisible(false);
							lbCancelar.setVisible(true);
							btnCancelar.setVisible(true);
							c1.show(lmaCambio, idLaminaCliente);
						}else {
							c1.show(lmaCambio, idLaminaPresent);
							showInfo.setText("CLIENTE NO ENCONTRADO");
							NumeroCedula.setEnabled(true);
						}
					}else if(opc==1) {
						nC = NumeroCuenta.getText();
						NumeroCuenta.setEnabled(false);
						if(validacion.AutentificacionCuenta(nC, db, true)) {
							Infcuenta consulta = new Infcuenta();
							showInfo.setText("");
							consulta.MostraDatos(nC, db, showInfo);
							cuenta = validacion.getCuenta();
							cliente = validacion.getClienteDatos();
							lbUpdate.setVisible(true);
							btnUpdate.setVisible(true);
							lbConsultar.setVisible(false);
							btnConsulta.setVisible(false);
							lbCancelar.setVisible(true);
							btnCancelar.setVisible(true);
							c1.show(lmaCambio, idLaminaCuenta);
						}else {
							c1.show(lmaCambio, idLaminaPresent);
							showInfo.setText("CUENTA NO ENCONTRADA");
							NumeroCuenta.setEnabled(true);
						}
					}else if(opc==2) {
						nT = NumeroTarjeta.getText();
						nClave = ClaveTarjeta.getText();
						NumeroTarjeta.setEnabled(false);
						ClaveTarjeta.setEnabled(false);
						if(validacion.AutentificacionTarjeta(nT, nClave, db)) {
							Infcuenta consulta = new Infcuenta();
							showInfo.setText("");
							consulta.MostraDatos(nDNI, db, showInfo);
							tarjeta = validacion.getTarjeta();
							cuenta = validacion.getCuenta();
							cliente = validacion.getClienteDatos();
							lbUpdate.setVisible(true);
							btnUpdate.setVisible(true);
							lbConsultar.setVisible(false);
							btnConsulta.setVisible(false);
							lbCancelar.setVisible(true);
							btnCancelar.setVisible(true);
							c1.show(lmaCambio, idLaminaTarjeta);
						}else {
							c1.show(lmaCambio, idLaminaPresent);
							showInfo.setText("TARJETA NO ENCONTRADA");
							NumeroTarjeta.setEnabled(true);
							ClaveTarjeta.setEnabled(true);
						}
					}
				}
			}else if(e.getSource()==btnUpdate) {
				DBCliente dbCliente = conectInput ();
				if(dbCliente!=null) {
					ArrayList<Cliente> db = dbCliente.getCliente();
					if(opc==0) {
						nDNI = NumeroCedula.getText();
						if(validacion.AutentificacionCedula(nDNI, db)) {
							cliente = validacion.getClienteDatos();
							/*
							if(db.remove(cliente)) {
								conectOut(dbCliente);
								lbUpdate.setVisible(false);
								btnUpdate.setVisible(false);
								lbConsultar.setVisible(true);
								btnConsulta.setVisible(true);
								lbCancelar.setVisible(false);
								btnCancelar.setVisible(false);
								NumeroCedula.setEnabled(true);
							}*/
						}
					}else if(opc==1) {
						nC = NumeroCuenta.getText();
						if(validacion.AutentificacionCuenta(nC, db, true)) {
							cuenta = validacion.getCuenta();
							cliente = validacion.getClienteDatos();
							ArrayList<Cuenta> arrayCuentas = cliente.getCuentaDatos();
							/*if(arrayCuentas.remove(cuenta)) {
								cliente.updateCuentaDatos(arrayCuentas);
								conectOut(dbCliente);
								lbUpdate.setVisible(false);
								btnUpdate.setVisible(false);
								lbConsultar.setVisible(true);
								btnConsulta.setVisible(true);
								lbCancelar.setVisible(false);
								btnCancelar.setVisible(false);
								NumeroCuenta.setEnabled(true);
							}*/
						}
					}else if(opc==2) {
						nT = NumeroTarjeta.getText();
						nClave = ClaveTarjeta.getText();
						if(validacion.AutentificacionTarjeta(nT, nClave, db)) {
							tarjeta = validacion.getTarjeta();
							cuenta = validacion.getCuenta();
							cliente = validacion.getClienteDatos();
							ArrayList<GenerarTarjeta> arrayTarjetas = cuenta.getTarjeta();
							/*if(arrayTarjetas.remove(tarjeta)) {
								cuenta.updateTarjeta(arrayTarjetas);
								conectOut(dbCliente);
								lbUpdate.setVisible(false);
								btnUpdate.setVisible(false);
								lbConsultar.setVisible(true);
								btnConsulta.setVisible(true);
								lbCancelar.setVisible(false);
								btnCancelar.setVisible(false);
								NumeroTarjeta.setEnabled(true);
								ClaveTarjeta.setEnabled(true);
								
							}*/
						}
					}
					
				}
			}else if(e.getSource()==btnCancelar) {
				clear();
				c1.show(lmaCambio, idLaminaPresent);
			}
			
		}
		
	}
	public void clear() {
		lbUpdate.setVisible(false);
		btnUpdate.setVisible(false);
		lbConsultar.setVisible(true);
		btnConsulta.setVisible(true);
		lbCancelar.setVisible(false);
		btnCancelar.setVisible(false);
		NumeroTarjeta.setEnabled(true);
		ClaveTarjeta.setEnabled(true);
		NumeroCuenta.setEnabled(true);
		NumeroCedula.setEnabled(true);
		showInfo.setText("");
		NumeroTarjeta.setText("");
		ClaveTarjeta.setText("");
		NumeroCuenta.setText("");
		NumeroCedula.setText("");
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
