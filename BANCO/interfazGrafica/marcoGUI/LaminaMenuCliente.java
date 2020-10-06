package interfazGrafica.marcoGUI;
import javax.swing.*;

import ADMINISTRATIVO.Autentificacion;
import ADMINISTRATIVO.CREACION.Cliente;
import BASEDEDATOS.DBCliente;
import CLIENTES.Deposito;
import CLIENTES.Retiro;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class LaminaMenuCliente extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LaminaMenuAdmin laminaTemp;
	private JButton btnTranfer;
	private JButton btnTDirecta;
	private JButton btnTInter;
	private JButton btnPagoServicio;
	private JButton btnRetiro;
	private JButton btnDeposito;
	private JButton btnAtras;
	private PagoServicios laminaServicio;
	private LPanelCentral laminaCentral;
	private ModeloTransfer lmaTDirecta,lmaTInterB;
	private ModeloMovimientoD laminaDeposito,laminaRetiro;
	final static String vtnServicio = "VtnServicio";
	final static String vtnPresentacion = "VtnPresentacion";
	final static String vtnTDirecta = "VtnTDirecta";
	final static String vtnTInterB = "VtnTInterB";
	final static String vtnMDeposito = "VtnMDeposito";
	final static String vtnMRetiro = "VtnMRetiro";
	
	public LaminaMenuCliente(JFrame marcoP) {
		laminaServicio = new PagoServicios();
		lmaTDirecta = new ModeloTransfer(new oyenteTDirecta(),"TRANSFERENCIA DIERECTA");
		lmaTInterB = new ModeloTransfer(new oyenteTInter(),"TRANSFERENCIA INTER BANCARIA");
		laminaDeposito = new ModeloMovimientoD(null,"DEPOSITO DE DINERO","DEPOSITAR");
		laminaRetiro = new ModeloMovimientoD(null,"RETIRO DE DINERO","RETIRAR");
		laminaCentral = new LPanelCentral();
		setLayout(new BorderLayout());
		laminaTemp = new LaminaMenuAdmin(marcoP,null);
		add(laminaTemp.getBarraTitulo(),BorderLayout.NORTH);
		add(new LPanelIzquierdo(),BorderLayout.WEST);
		add(laminaCentral,BorderLayout.CENTER);
		
	}
	
	private class LPanelIzquierdo extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Box cajaVertical;
		private JLabel jlTranfer;
		private JLabel jlTDirecta;
		private JLabel jlTInter;
		private JLabel jlPagoServicio;
		private JLabel jlRetiro;
		private JLabel jlDeposito;
		public LPanelIzquierdo() {
			setOpaque(true);
			jlTranfer = new JLabel();
			jlTDirecta = new JLabel();
			jlTInter = new JLabel();
			jlPagoServicio = new JLabel();
			jlRetiro = new JLabel();
			jlDeposito = new JLabel();
			

			jlTranfer.setText("TRANSFERENCIA");

			jlTDirecta.setText("DIRECTA");
			
			jlTInter.setText("INTER BANCARIA");

			jlPagoServicio.setText("PAGO DE SERVICIOS");

			jlRetiro.setText("RETIRO DE DINERO");

			jlDeposito.setText("DEPOSITO DE DINERO");
			
			cajaVertical = Box.createVerticalBox();
			btnTranfer = createBtn("interfazGrafica/recursos/btnTransfer.png",50 ,50);
			
			btnTDirecta = createBtn("interfazGrafica/recursos/btnDirecto.png",50 ,50);
			btnTDirecta.setVisible(false);
			
			btnTInter = createBtn("interfazGrafica/recursos/btnInter.png",50 ,50);
			btnTInter.setVisible(false);
			
			btnPagoServicio = createBtn("interfazGrafica/recursos/btnPagoS.png",50 ,50);

			btnRetiro = createBtn("interfazGrafica/recursos/btnRetiro.png",50 ,50);
			
			btnDeposito = createBtn("interfazGrafica/recursos/btnDeposito.png",50 ,50);
			
			btnAtras = createBtn("interfazGrafica/recursos/atras.png",35 ,35);
			
			//eventos
			btnPagoServicio.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,vtnServicio);
					
					
				}
				
			});
			btnAtras.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,vtnPresentacion);
					laminaServicio.clear();
					
				}
				
			});
			btnTDirecta.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,vtnTDirecta);
				}
				
			});
			btnTInter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,vtnTInterB);
				}
				
			});
			btnDeposito.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,vtnMDeposito);
				}
				
			});
			btnRetiro.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,vtnMRetiro);
				}
				
			});
			
			//Agrega componentes del panel izquierdo 
			JPanel panelBTNAtras = new JPanel();
			panelBTNAtras.setLayout(new FlowLayout(FlowLayout.LEFT));
			panelBTNAtras.setBackground(new Color(34, 79, 98));
			panelBTNAtras.add(btnAtras);
			btnAtras.addMouseListener(new oyentePanelI());
			panelBTNAtras.addMouseListener(new oyentePanelI());
			cajaVertical.add(panelBTNAtras);
			
			cajaVertical.add(aggComponent (btnTranfer, jlTranfer));
			Box cajaHorizontal = Box.createHorizontalBox();
			cajaHorizontal.add(Box.createHorizontalStrut(50));
			cajaHorizontal.add(aggComponent (btnTDirecta, jlTDirecta));
			cajaVertical.add(cajaHorizontal);
			
			cajaHorizontal = Box.createHorizontalBox();
			cajaHorizontal.add(Box.createHorizontalStrut(50));
			cajaHorizontal.add(aggComponent (btnTInter, jlTInter));
			cajaVertical.add(cajaHorizontal);
			
			cajaVertical.add(aggComponent (btnPagoServicio, jlPagoServicio));
			cajaVertical.add(aggComponent (btnRetiro, jlRetiro));
			cajaVertical.add(aggComponent (btnDeposito, jlDeposito));
			
			addMouseListener(new oyentePanelI());
			setBackground(new Color(34,79,98));
			add(cajaVertical);
		}
		class oyentePanelI extends MouseAdapter{
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTranfer.setFocusable(true);
				jlTranfer.setVisible(true);
				
				btnTDirecta.setVisible(true);
				jlTDirecta.setVisible(true);
				
				btnTInter.setVisible(true);
				jlTInter.setVisible(true);
				
				jlPagoServicio.setVisible(true);
				
				jlRetiro.setVisible(true);
				
				jlDeposito.setVisible(true);

			}
			public void mouseExited(MouseEvent e) {
				btnTranfer.setFocusable(false);
				jlTranfer.setVisible(false);
				
				btnTDirecta.setVisible(false);
				jlTDirecta.setVisible(false);
				
				btnTInter.setVisible(false);
				jlTInter.setVisible(false);
				
				jlPagoServicio.setVisible(false);
				
				jlRetiro.setVisible(false);
				
				jlDeposito.setVisible(false);
				
				
			}
		}
		private JPanel aggComponent (JButton btn, JLabel lb) {
			JPanel comp = new JPanel();
			comp.setLayout(new FlowLayout(FlowLayout.LEFT));
			comp.setBackground(new Color(34,79,98));
			btn.addMouseListener(new oyentePanelI());
			lb.setFont(new Font("Arial",Font.BOLD,15));
			lb.setForeground(Color.WHITE);
			lb.setVisible(false);
			comp.add(btn);
			comp.add(lb);
			return comp;
		}
	}
	private JButton createBtn(String ruta,int ancho, int alto) {
		JButton btn = new JButton();
		btn.setIcon(crearIcono(ruta,ancho,alto));
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
	private class LPanelCentral extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public LPanelCentral() {
			setOpaque(true);
			setBackground(new Color(7,115,157));
			setLayout(new CardLayout(0,0));
			add(new LMAPresentacion("interfazGrafica/recursos/presentacion.png",0, 39, 56),vtnPresentacion);
			add(laminaServicio,vtnServicio);
			add(lmaTDirecta,vtnTDirecta);
			add(lmaTInterB,vtnTInterB);
			add(laminaDeposito,vtnMDeposito);
			add(laminaRetiro,vtnMRetiro);

		}
	}
	private class oyenteTDirecta implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String nC1 = null, nC2 = null, nDNI = null, nT = null, nClave = null;
			DBCliente dbCliente = conectInput ();
			Autentificacion validacion = new Autentificacion();
			int opc1 = lmaTDirecta.getTipoPago1().getSelectedIndex();
			int cantidad = (int)lmaTDirecta.getCantidad().getValue();
			Retiro retiro = new Retiro();
			Deposito deposito = new Deposito();
			if(dbCliente != null) {
				ArrayList<Cliente> db = dbCliente.getCliente();
				if(opc1 == 0) {
					nC1 = lmaTDirecta.getNumeroCuenta1().getText();
					if(validacion.AutentificacionCuenta(nC1, db, true)) {
						if(retiro.Directo(nC1, cantidad, db, true)) {
							nC2 = lmaTDirecta.getNumeroCuenta2().getText();
							if(deposito.Directo(nC2, cantidad, db, true)) {
								dbCliente.setCliente(db);
								conectOut(dbCliente);
								lmaTDirecta.getLbDatOrigen().setVisible(true);
								lmaTDirecta.getLbDatOrigen().setText("CUENTA DE ORIGEN: "+nC1);
								lmaTDirecta.getLbDatDestino().setVisible(true);
								lmaTDirecta.getLbDatDestino().setText("CUENTA DE DESTINO: "+nC2);
								lmaTDirecta.getLbDatCantidadT().setVisible(true);
								lmaTDirecta.getLbDatCantidadT().setText("CANTIDAD TRANSFERIDA: "+String.valueOf(cantidad));
								JOptionPane.showMessageDialog(null, "TRANSFERENCIA EXITOSA");
							}else {
								lmaTDirecta.getLbDatOrigen().setVisible(false);
								lmaTDirecta.getLbDatDestino().setVisible(true);
								lmaTDirecta.getLbDatDestino().setText("ERROR EN LA CUENTA "+nC2);
								lmaTDirecta.getLbDatCantidadT().setVisible(false);
							}
						}else {
							lmaTDirecta.getLbDatOrigen().setVisible(false);
							lmaTDirecta.getLbDatDestino().setVisible(true);
							lmaTDirecta.getLbDatDestino().setText("SALDO INSUFICIENTE");
							lmaTDirecta.getLbDatCantidadT().setVisible(false);
						}
					}else {
						lmaTDirecta.getLbDatOrigen().setVisible(false);
						lmaTDirecta.getLbDatDestino().setVisible(true);
						lmaTDirecta.getLbDatDestino().setText("ERROR EN LA CUENTA "+nC1);
						lmaTDirecta.getLbDatCantidadT().setVisible(false);
					}
				}else if(opc1 == 1) {
					nT = lmaTDirecta.getNumeroTarjeta1().getText();
					nClave = lmaTDirecta.getClaveTarjeta1().getText();
					if(validacion.AutentificacionTarjeta(nT, nClave, db)) {
						if(retiro.Cajero(nT, nClave, cantidad, db)) {
							nC2 = lmaTDirecta.getNumeroCuenta2().getText();
							if(deposito.Directo(nC2, cantidad, db, true)) {
								dbCliente.setCliente(db);
								conectOut(dbCliente);
								lmaTDirecta.getLbDatOrigen().setVisible(true);
								lmaTDirecta.getLbDatOrigen().setText("TARJETA DE ORIGEN: "+nT);
								lmaTDirecta.getLbDatDestino().setVisible(true);
								lmaTDirecta.getLbDatDestino().setText("CUENTA DE DESTINO: "+nC2);
								lmaTDirecta.getLbDatCantidadT().setVisible(true);
								lmaTDirecta.getLbDatCantidadT().setText("CANTIDAD TRANSFERIDA: "+String.valueOf(cantidad));
								JOptionPane.showMessageDialog(null, "TRANSFERENCIA EXITOSA");
							}else {
								lmaTDirecta.getLbDatOrigen().setVisible(false);
								lmaTDirecta.getLbDatDestino().setVisible(true);
								lmaTDirecta.getLbDatDestino().setText("ERROR EN LA CUENTA "+nC2);
								lmaTDirecta.getLbDatCantidadT().setVisible(false);
							}
						}else {
							lmaTDirecta.getLbDatOrigen().setVisible(false);
							lmaTDirecta.getLbDatDestino().setVisible(true);
							lmaTDirecta.getLbDatDestino().setText("SALDO INSUFICIENTE");
							lmaTDirecta.getLbDatCantidadT().setVisible(false);
						}
					}else {
						lmaTDirecta.getLbDatOrigen().setVisible(false);
						lmaTDirecta.getLbDatDestino().setVisible(true);
						lmaTDirecta.getLbDatDestino().setText("ERROR EN LA CUENTA "+nC1);
						lmaTDirecta.getLbDatCantidadT().setVisible(false);
					}
				}else if(opc1 == 2){
					nDNI = lmaTDirecta.getNumeroCedula1().getText();
					if(validacion.AutentificacionCedula(nDNI, db)) {
						if(retiro.Directo(nDNI, cantidad, db)) {
							nC2 = lmaTDirecta.getNumeroCuenta2().getText();
							if(deposito.Directo(nC2, cantidad, db, true)) {
								dbCliente.setCliente(db);
								conectOut(dbCliente);
								lmaTDirecta.getLbDatOrigen().setVisible(true);
								lmaTDirecta.getLbDatOrigen().setText("DNI DE ORIGEN: "+nDNI);
								lmaTDirecta.getLbDatDestino().setVisible(true);
								lmaTDirecta.getLbDatDestino().setText("CUENTA DE DESTINO: "+nC2);
								lmaTDirecta.getLbDatCantidadT().setVisible(true);
								lmaTDirecta.getLbDatCantidadT().setText("CANTIDAD TRANSFERIDA: "+String.valueOf(cantidad));
								JOptionPane.showMessageDialog(null, "TRANSFERENCIA EXITOSA");
							}else {
								lmaTDirecta.getLbDatOrigen().setVisible(false);
								lmaTDirecta.getLbDatDestino().setVisible(true);
								lmaTDirecta.getLbDatDestino().setText("ERROR EN LA CUENTA "+nC2);
								lmaTDirecta.getLbDatCantidadT().setVisible(false);
							}
						}else {
							lmaTDirecta.getLbDatOrigen().setVisible(false);
							lmaTDirecta.getLbDatDestino().setVisible(true);
							lmaTDirecta.getLbDatDestino().setText("SALDO INSUFICIENTE");
							lmaTDirecta.getLbDatCantidadT().setVisible(false);
						}
					}else {
						lmaTDirecta.getLbDatOrigen().setVisible(false);
						lmaTDirecta.getLbDatDestino().setVisible(true);
						lmaTDirecta.getLbDatDestino().setText("ERROR EN LA CUENTA "+nC1);
						lmaTDirecta.getLbDatCantidadT().setVisible(false);
					}
				}
			}else {
				lmaTDirecta.getLbDatOrigen().setVisible(false);
				lmaTDirecta.getLbDatDestino().setVisible(true);
				lmaTDirecta.getLbDatDestino().setText("ERROR EN LA BASE DE DATOS");
				lmaTDirecta.getLbDatCantidadT().setVisible(false);
			}
			
		}
		
	}
	private class oyenteTInter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String nC1 = null, nC2 = null, nDNI = null, nT = null, nClave = null;
			DBCliente dbCliente = conectInput ();
			Autentificacion validacion = new Autentificacion();
			int opc1 = lmaTInterB.getTipoPago1().getSelectedIndex();
			int cantidad = (int)lmaTInterB.getCantidad().getValue();
			Retiro retiro = new Retiro();
			if(dbCliente != null) {
				ArrayList<Cliente> db = dbCliente.getCliente();
				if(opc1 == 0) {
					nC1 = lmaTInterB.getNumeroCuenta1().getText();
					if(validacion.AutentificacionCuenta(nC1, db, true)) {
						if(retiro.Directo(nC1, cantidad, db, true)) {
							dbCliente.setCliente(db);
							conectOut(dbCliente);
							nC2 = lmaTInterB.getNumeroCuenta2().getText();
							lmaTInterB.getLbDatOrigen().setVisible(true);
							lmaTInterB.getLbDatOrigen().setText("CUENTA DE ORIGEN: "+nC1);
							lmaTInterB.getLbDatDestino().setVisible(true);
							lmaTInterB.getLbDatDestino().setText("CUENTA DE DESTINO: "+nC2);
							lmaTInterB.getLbDatCantidadT().setVisible(true);
							lmaTInterB.getLbDatCantidadT().setText("CANTIDAD TRANSFERIDA: "+String.valueOf(cantidad));
							JOptionPane.showMessageDialog(null, "TRANSFERENCIA EXITOSA");
						}else {
							lmaTInterB.getLbDatOrigen().setVisible(false);
							lmaTInterB.getLbDatDestino().setVisible(true);
							lmaTInterB.getLbDatDestino().setText("SALDO INSUFICIENTE");
							lmaTInterB.getLbDatCantidadT().setVisible(false);
						}
					}else {
						lmaTInterB.getLbDatOrigen().setVisible(false);
						lmaTInterB.getLbDatDestino().setVisible(true);
						lmaTInterB.getLbDatDestino().setText("ERROR EN LA CUENTA "+nC1);
						lmaTInterB.getLbDatCantidadT().setVisible(false);
					}
				}else if(opc1 == 1) {
					nT = lmaTInterB.getNumeroTarjeta1().getText();
					nClave = lmaTInterB.getClaveTarjeta1().getText();
					if(validacion.AutentificacionTarjeta(nT, nClave, db)) {
						if(retiro.Cajero(nT, nClave, cantidad, db)) {
							dbCliente.setCliente(db);
							conectOut(dbCliente);
							nC2 = lmaTInterB.getNumeroCuenta2().getText();
							lmaTInterB.getLbDatOrigen().setVisible(true);
							lmaTInterB.getLbDatOrigen().setText("TARJETA DE ORIGEN: "+nT);
							lmaTInterB.getLbDatDestino().setVisible(true);
							lmaTInterB.getLbDatDestino().setText("CUENTA DE DESTINO: "+nC2);
							lmaTInterB.getLbDatCantidadT().setVisible(true);
							lmaTInterB.getLbDatCantidadT().setText("CANTIDAD TRANSFERIDA: "+String.valueOf(cantidad));
							JOptionPane.showMessageDialog(null, "TRANSFERENCIA EXITOSA");
						}else {
							lmaTInterB.getLbDatOrigen().setVisible(false);
							lmaTInterB.getLbDatDestino().setVisible(true);
							lmaTInterB.getLbDatDestino().setText("SALDO INSUFICIENTE");
							lmaTInterB.getLbDatCantidadT().setVisible(false);
						}
					}else {
						lmaTInterB.getLbDatOrigen().setVisible(false);
						lmaTInterB.getLbDatDestino().setVisible(true);
						lmaTInterB.getLbDatDestino().setText("ERROR EN LA TARJETA "+nT);
						lmaTInterB.getLbDatCantidadT().setVisible(false);
					}
				}else if(opc1 == 2) {
					nDNI = lmaTInterB.getNumeroCedula1().getText();
					if (validacion.AutentificacionCedula(nDNI, db)) {
						if (retiro.Directo(nDNI, cantidad, db)) {
							dbCliente.setCliente(db);
							conectOut(dbCliente);
							nC2 = lmaTInterB.getNumeroCuenta2().getText();
							lmaTInterB.getLbDatOrigen().setVisible(true);
							lmaTInterB.getLbDatOrigen().setText("DNI DE ORIGEN: " + nDNI);
							lmaTInterB.getLbDatDestino().setVisible(true);
							lmaTInterB.getLbDatDestino().setText("CUENTA DE DESTINO: " + nC2);
							lmaTInterB.getLbDatCantidadT().setVisible(true);
							lmaTInterB.getLbDatCantidadT().setText("CANTIDAD TRANSFERIDA: " + String.valueOf(cantidad));
							JOptionPane.showMessageDialog(null, "TRANSFERENCIA EXITOSA");
						}else {
							lmaTInterB.getLbDatOrigen().setVisible(false);
							lmaTInterB.getLbDatDestino().setVisible(true);
							lmaTInterB.getLbDatDestino().setText("SALDO INSUFICIENTE");
							lmaTInterB.getLbDatCantidadT().setVisible(false);
						}
					}else {
						lmaTInterB.getLbDatOrigen().setVisible(false);
						lmaTInterB.getLbDatDestino().setVisible(true);
						lmaTInterB.getLbDatDestino().setText("ERROR EN LA CEDULA "+nDNI);
						lmaTInterB.getLbDatCantidadT().setVisible(false);
					}
				}
			}else {
				lmaTInterB.getLbDatOrigen().setVisible(false);
				lmaTInterB.getLbDatDestino().setVisible(true);
				lmaTInterB.getLbDatDestino().setText("ERROR EN LA BASE DE DATOS");
				lmaTInterB.getLbDatCantidadT().setVisible(false);
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
