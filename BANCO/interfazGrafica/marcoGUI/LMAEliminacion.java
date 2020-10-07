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
public class LMAEliminacion extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cajaVertical;
	private Color color;
	private JTextField NumeroTarjeta,ClaveTarjeta,NumeroCuenta,NumeroCedula;
	private JPanel lmaPrincipal,lmaTarjeta,lmaCuenta, lmaCliente, lmaBTN;
	private JComboBox<String> tipoEliminacion;
	private JTextArea showInfo;
	private JScrollPane scrollMostrar;
	private JButton btnConsulta,btnConfirmacion,btnCancelar;
	private JLabel lbConsultar,lbConfirEliminar,lbTitulo,lbCancelar;
	private static int anchoTxt = 12;
	final static String idTarjeta = "Tarjeta";
	final static String idCliente = "Cliente";
	final static String idCuenta = "Cuenta";
	public LMAEliminacion() {
		color = new Color(7, 115, 157);
		setBackground(color);
		setLayout(new BoxLayout(LMAEliminacion.this,BoxLayout.X_AXIS));
		cajaVertical = new JPanel();
		cajaVertical.setLayout(new BoxLayout(cajaVertical,BoxLayout.Y_AXIS));
		cajaVertical.setBackground(color);
		showInfo = new JTextArea(20,20);
		showInfo.setEnabled(false);
		scrollMostrar = new JScrollPane(showInfo);
		btnConsulta = createBTN ("interfazGrafica/recursos/btnConsultar.png",50,50);
		btnConfirmacion = createBTN ("interfazGrafica/recursos/btnBorrar.png",50,50);
		btnConfirmacion.setVisible(false);
		btnConsulta.addActionListener(new oyenteBTNS());
		btnConfirmacion.addActionListener(new oyenteBTNS());
		btnCancelar = createBTN ("interfazGrafica/recursos/btnCancelar.png",50,50);
		btnCancelar.setVisible(false);
		btnCancelar.addActionListener(new oyenteBTNS());
		lbConsultar = createLabel (13);
		lbConfirEliminar = createLabel (13);
		lbConsultar.setText("PRESIONE PARA BUSCAR");
		lbConsultar.setVisible(true);
		lbConfirEliminar.setText("PRESIONE PARA ELIMINAR");
		lbTitulo = createLabel (13);
		lbTitulo.setText("ESTA SELECIONADO LA ELIMINACION DE CLIENTE");
		lbTitulo.setVisible(true);
		lbCancelar = createLabel (13);
		lbCancelar.setText("PRESIONE PARA CANCELAR");
		lbCancelar.setVisible(false);
		
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
		lmaBTN.add(lbConsultar);
		lmaBTN.add(btnConsulta);
		lmaBTN.add(lbConfirEliminar);
		lmaBTN.add(btnConfirmacion);
		lmaBTN.add(lbCancelar);
		lmaBTN.add(btnCancelar);
		
		tipoEliminacion = new JComboBox<String>();
		tipoEliminacion.addItem("CLIENTE");
		tipoEliminacion.addItem("CUENTA");
		tipoEliminacion.addItem("TARJETA");
		tipoEliminacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opc = tipoEliminacion.getSelectedIndex();
				CardLayout c1 = (CardLayout)lmaPrincipal.getLayout();
				if(opc == 0) {
					c1.show(lmaPrincipal,idCliente);
					lbTitulo.setText("ESTA SELECIONADO LA ELIMINACION DE CLIENTE");
				}else if(opc == 1) {
					c1.show(lmaPrincipal,idCuenta);
					lbTitulo.setText("ESTA SELECIONADO LA ELIMINACION DE CUENTA");
				}else if(opc == 2) {
					c1.show(lmaPrincipal,idTarjeta);
					lbTitulo.setText("ESTA SELECIONADO LA ELIMINACION DE TARJETA");
				}
			}
			
		});
		
		cajaVertical.add(new LogoPresentacion("ELIMINACION DE DATOS"));
		cajaVertical.add(addComponent ("INGRESE EL TIPO DE ELIMINACION",null));
		cajaVertical.add(tipoEliminacion);
		cajaVertical.add(addComponent ("",lbTitulo));
		cajaVertical.add(lmaPrincipal);
		cajaVertical.add(scrollMostrar);
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
			Cliente cliente = new Cliente();
			Cuenta cuenta = new Cuenta();
			GenerarTarjeta tarjeta;
			int opc = tipoEliminacion.getSelectedIndex();
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
							lbConfirEliminar.setVisible(true);
							btnConfirmacion.setVisible(true);
							lbConsultar.setVisible(false);
							btnConsulta.setVisible(false);
							lbCancelar.setVisible(true);;
							btnCancelar.setVisible(true);;
						}else {
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
							lbConfirEliminar.setVisible(true);
							btnConfirmacion.setVisible(true);
							lbConsultar.setVisible(false);
							btnConsulta.setVisible(false);
							lbCancelar.setVisible(true);
							btnCancelar.setVisible(true);
						}else {
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
							lbConfirEliminar.setVisible(true);
							btnConfirmacion.setVisible(true);
							lbConsultar.setVisible(false);
							btnConsulta.setVisible(false);
							lbCancelar.setVisible(true);
							btnCancelar.setVisible(true);
						}else {
							showInfo.setText("TARJETA NO ENCONTRADA");
							NumeroTarjeta.setEnabled(true);
							ClaveTarjeta.setEnabled(true);
						}
					}
				}
			}else if(e.getSource()==btnConfirmacion) {
				DBCliente dbCliente = conectInput ();
				if(dbCliente!=null) {
					ArrayList<Cliente> db = dbCliente.getCliente();
					if(opc==0) {
						nDNI = NumeroCedula.getText();
						if(validacion.AutentificacionCedula(nDNI, db)) {
							cliente = validacion.getClienteDatos();
							if(db.remove(cliente)) {
								conectOut(dbCliente);
								lbConfirEliminar.setVisible(false);
								btnConfirmacion.setVisible(false);
								lbConsultar.setVisible(true);
								btnConsulta.setVisible(true);
								lbCancelar.setVisible(false);
								btnCancelar.setVisible(false);
								NumeroCedula.setEnabled(true);
							}
						}
					}else if(opc==1) {
						nC = NumeroCuenta.getText();
						if(validacion.AutentificacionCuenta(nC, db, true)) {
							cuenta = validacion.getCuenta();
							cliente = validacion.getClienteDatos();
							ArrayList<Cuenta> arrayCuentas = cliente.getCuentaDatos();
							if(arrayCuentas.remove(cuenta)) {
								cliente.updateCuentaDatos(arrayCuentas);
								conectOut(dbCliente);
								lbConfirEliminar.setVisible(false);
								btnConfirmacion.setVisible(false);
								lbConsultar.setVisible(true);
								btnConsulta.setVisible(true);
								lbCancelar.setVisible(false);
								btnCancelar.setVisible(false);
								NumeroCuenta.setEnabled(true);
							}
						}
					}else if(opc==2) {
						nT = NumeroTarjeta.getText();
						nClave = ClaveTarjeta.getText();
						if(validacion.AutentificacionTarjeta(nT, nClave, db)) {
							tarjeta = validacion.getTarjeta();
							cuenta = validacion.getCuenta();
							cliente = validacion.getClienteDatos();
							ArrayList<GenerarTarjeta> arrayTarjetas = cuenta.getTarjeta();
							if(arrayTarjetas.remove(tarjeta)) {
								cuenta.updateTarjeta(arrayTarjetas);
								conectOut(dbCliente);
								lbConfirEliminar.setVisible(false);
								btnConfirmacion.setVisible(false);
								lbConsultar.setVisible(true);
								btnConsulta.setVisible(true);
								lbCancelar.setVisible(false);
								btnCancelar.setVisible(false);
								NumeroTarjeta.setEnabled(true);
								ClaveTarjeta.setEnabled(true);
								
							}
						}
					}
					
				}
			}else if(e.getSource()==btnCancelar) {
				lbConfirEliminar.setVisible(false);
				btnConfirmacion.setVisible(false);
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
			
		}
		
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
