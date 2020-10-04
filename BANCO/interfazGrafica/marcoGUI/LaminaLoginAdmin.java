package interfazGrafica.marcoGUI;
import javax.swing.*;
import ADMINISTRATIVO.Autentificacion;
import BASEDEDATOS.DBAdministradores;
import BASEDEDATOS.DBCliente;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class LaminaLoginAdmin extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Box miCajaVertical;
	private Box miCajaHorizontal;
	private JTextField txtFUsuario;
	private JTextField txtFContrasena;
	private JButton btnLogin;
	private DBAdministradores dbAdmin;
	private JFrame marcoLogin;
	public LaminaLoginAdmin(DBAdministradores dbAdmin,JFrame marcoLogin) {
		this.marcoLogin=marcoLogin;
		this.dbAdmin = dbAdmin;
		JPanel arreglo = new JPanel();
		txtFUsuario = new JTextField(15);
		txtFContrasena = new JTextField(15);
		miCajaVertical = Box.createVerticalBox();
		miCajaHorizontal = Box.createHorizontalBox();
		
		Box cajaIcono = Box.createVerticalBox();
		cajaIcono.add(Box.createVerticalStrut(10));
		JLabel l = new JLabel();
		l.setIcon(crearIcono("interfazGrafica/recursos/icon_Login.png",100,100));
		cajaIcono.add(l);
		miCajaHorizontal.add(cajaIcono);
		miCajaHorizontal.add(Box.createHorizontalStrut(20));
		
		arreglo.add(new JLabel("Usuario: "));
		arreglo.add(txtFUsuario);
		miCajaVertical.add(arreglo);
		
		arreglo = new JPanel();
		arreglo.add(new JLabel("Contraseña: "));
		arreglo.add(txtFContrasena);
		miCajaVertical.add(arreglo);
		
		arreglo = new JPanel();
		btnLogin = new JButton();
		btnLogin.setIcon(crearIcono("interfazGrafica/recursos/Login_100.png",50,50));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		oyenteLogin oyenteBtnLogin = new oyenteLogin();
		btnLogin.addActionListener(oyenteBtnLogin);
		arreglo.add(btnLogin);
		miCajaVertical.add(arreglo);
		
		miCajaHorizontal.add(miCajaVertical);
		add(miCajaHorizontal);
		
		
		
	}
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
	private class oyenteLogin implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String usuario = txtFUsuario.getText();
			String contrasena = txtFContrasena.getText();
			Autentificacion validacion = new Autentificacion();
			if(validacion.Administrador(usuario, contrasena, dbAdmin.getAdministrador(usuario, contrasena))) {
				String direcciondbClientes = "archivosStream/dbClientes.dat";
				DBCliente dbCliente = null;
				try {
					System.out.println("");
					ObjectInputStream InStreamdbClientes = new ObjectInputStream(new FileInputStream(direcciondbClientes));
					dbCliente = (DBCliente)InStreamdbClientes.readObject();
					InStreamdbClientes.close();
					System.out.println("Archivo cliente encontrado");
				}catch(Exception ex) {
					try {
						dbCliente = new DBCliente();
						ObjectOutputStream OutStreamdbClientes = new ObjectOutputStream(new FileOutputStream(direcciondbClientes));
						OutStreamdbClientes.writeObject(dbCliente);
						OutStreamdbClientes.close();
						System.out.println("Archivo cliente nuevo");
					}catch(Exception i) {
						dbCliente = new DBCliente();
						System.out.println("Error al guardar el archivo clientes.");
					}
				}
				MarcoMenuAdmin marcomenuadministardor = new MarcoMenuAdmin(dbCliente);
				marcomenuadministardor.setVisible(true);
				marcomenuadministardor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				marcoLogin.dispose();
			}
		}
	}
}
