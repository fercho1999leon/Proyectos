package interfazGrafica.marcoGUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import BASEDEDATOS.DBAdministradores;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class loginAdmin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image miIcono = null;
	public loginAdmin(MarcoPrincipal m,DBAdministradores dbAdmin) {
		setSize(400,200);
		setLocationRelativeTo(null);
		try {
			miIcono = ImageIO.read(new File("interfazGrafica/recursos/icon.png"));
		}catch(IOException e) {
			setTitle("Error en el icono");
		}
		if(miIcono!=null) {
			setIconImage(miIcono);
			setTitle("Ventana login de administracion.");
		}
		oyenteWindowClose oyenteClose = new oyenteWindowClose(m);
		addWindowListener(oyenteClose);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(new LaminaLoginAdmin(dbAdmin,loginAdmin.this));
		
	}
	private class oyenteWindowClose extends WindowAdapter{
		MarcoPrincipal m;
		public oyenteWindowClose(MarcoPrincipal m) {
			this.m=m;
		}
		@Override
		public void windowClosing(WindowEvent e) {
			m.setVisible(true);
		}
	} 
	
}
