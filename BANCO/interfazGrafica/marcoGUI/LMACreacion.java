package interfazGrafica.marcoGUI;
import java.awt.*;
import javax.swing.*;

import ADMINISTRATIVO.CREACION.Cliente;
import ADMINISTRATIVO.CREACION.Cuenta;
import ADMINISTRATIVO.CREACION.GenerarTarjeta;
import BASEDEDATOS.DBCliente;

import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class LMACreacion extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int Height = 10;
	private final int Width = 1;
	private JPanel cajaHorizontal;
	private JPanel cajaVertical;
	private LMACcliente LCliente;
	private LMACcuenta LCuenta;
	private LMACtarjeta LTarjeta;
	private JButton btnGuardar;
	DBCliente dbCliente;
	
	public LMACreacion(DBCliente dbCliente) {
		this.dbCliente = dbCliente;
		cajaHorizontal = new JPanel();
		cajaHorizontal.setBackground(new Color(7,115,157));
		cajaVertical = new JPanel();
		cajaVertical.setBackground(new Color(7,115,157));
		setOpaque(true);
		setBackground(new Color(7,115,157));
		LCliente = new LMACcliente();
		LCuenta = new LMACcuenta();
		LTarjeta  = new LMACtarjeta();
		btnGuardar = new JButton();
		btnGuardar.setIcon(crearIcono("interfazGrafica/recursos/btnGuardar.png",50,50));
		btnGuardar.setBorderPainted(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setFocusable(false);
		cajaHorizontal.setLayout(new BoxLayout(cajaHorizontal,BoxLayout.X_AXIS));
		cajaVertical.setLayout(new BoxLayout(cajaVertical,BoxLayout.Y_AXIS));
		cajaVertical.add(Box.createVerticalStrut(Height));
		cajaHorizontal.add(Box.createHorizontalStrut(Width));
		cajaHorizontal.add(LCliente);
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(LCuenta);
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(LTarjeta);
		JLabel titulo = new JLabel("BANCO UG",(crearIcono("interfazGrafica/recursos/presentacion.png",150,150)),JLabel.RIGHT);
		titulo.setFont(new Font("Arial",Font.BOLD,25));
		JPanel contTitulo = new JPanel();
		contTitulo.setOpaque(true);
		contTitulo.setBackground(new Color(7,115,157));
		contTitulo.add(titulo);
		cajaVertical.add(contTitulo);
		cajaVertical.add(Box.createGlue());
		cajaVertical.add(cajaHorizontal);
		cajaVertical.add(Box.createGlue());
		cajaVertical.add(btnGuardar);
		btnGuardar.addActionListener(new OyenteBtnGuardar());
		add(cajaVertical);
	}
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
	class OyenteBtnGuardar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Cliente> DBClientes = dbCliente.getCliente();
			Cliente tempCliente = new Cliente();
			Cuenta tempCuenta = new Cuenta();
			GenerarTarjeta tempTarjeta = new GenerarTarjeta();
			//TARJETA
			tempTarjeta.setNumeroTarjeta(LTarjeta.getTxtNunTarjeta().getText());
			tempTarjeta.setFechaCaducidad(LTarjeta.getTxtFechaCad().getText());
			tempTarjeta.setSerie(LTarjeta.getTxtNunSerie().getText());
			if(LTarjeta.getRdbDesblo().isSelected()) {
				tempTarjeta.setEstado("DESBLOQUEADO");
			}else {
				tempTarjeta.setEstado("BLOQUEADA   ");
			}
			//CUENTA
			tempCuenta.setNumeroCuenta(LCuenta.getTxtNumerCuenta().getText());
			if(LCuenta.geteActivo().isSelected()) {
				tempCuenta.setEstado("ACTIVO  ");
			}else {
				tempCuenta.setEstado("INACTIVO");
			}
			if(LCuenta.gettAhorro().isSelected()) {
				tempCuenta.setTipoCuenta("AHORRO   ");
			}else{
				tempCuenta.setTipoCuenta("CORRIENTE");
			}
			String saldo = LCuenta.getTxtSaldo().getText();
			if(!saldo.equals("")) {
				tempCuenta.setSaldo(Double.parseDouble(LCuenta.getTxtSaldo().getText()));
			}
			tempCuenta.setTarjeta(tempTarjeta);
			//Cliente
			tempCliente.setNombre(LCliente.getTxtNombre().getText());
			tempCliente.setDNI(LCliente.getTxtDNI().getText());
			tempCliente.setDireccion(LCliente.getTxtDireccion().getText());
			tempCliente.setTelefono(LCliente.getTxtTelefono().getText());
			tempCliente.setCuentaDatos(tempCuenta);
			DBClientes.add(tempCliente);
			dbCliente.setCliente(DBClientes);
			//Serializacion
			String direcciondbClientes = "archivosStream/dbClientes.dat";
			try {
				ObjectOutputStream OutStreamdbClientes = new ObjectOutputStream(new FileOutputStream(direcciondbClientes));
				OutStreamdbClientes.writeObject(dbCliente);
				OutStreamdbClientes.close();
				JOptionPane.showMessageDialog(null, "Su clave de tarjeta es: 1234");
				clearData ();
				System.out.println("Archivo Guardado");
			}catch(IOException i) {
				System.out.println("Error al guardar el archivo clientes.---" + i.getMessage());
			}
		}
		
	}
	public void clearData () {
		LTarjeta.getTxtNunTarjeta().setText("");
		LTarjeta.getTxtFechaCad().setText("");
		LTarjeta.getTxtNunSerie().setText("");
		LTarjeta.getRdbDesblo().setSelected(true);
		
		LCuenta.getTxtNumerCuenta().setText("");
		LCuenta.geteActivo().setSelected(true);
		LCuenta.gettAhorro().setSelected(true);
		LCuenta.getTxtSaldo().setText("");
		
		LCliente.getTxtNombre().setText("");
		LCliente.getTxtDNI().setText("");
		LCliente.getTxtDireccion().setText("");
		LCliente.getTxtTelefono().setText("");
	}
}
