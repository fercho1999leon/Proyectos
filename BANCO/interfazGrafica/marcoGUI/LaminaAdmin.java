package interfazGrafica.marcoGUI;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import BASEDEDATOS.DBAdministradores;
import java.io.*;
import java.awt.event.*;
public class LaminaAdmin extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	loginAdmin ventanaLogin;
	public LaminaAdmin(MarcoPrincipal contP,DBAdministradores dbAdmin) {
		setBackground(new Color(47,85,95));
		ventanaLogin = new loginAdmin(contP,dbAdmin);
		setLayout(null);
		setSize(230,230);
		oyenteAdmin click = new oyenteAdmin(contP);
		addMouseListener(click);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image iconAdmin = null;
		try {
			iconAdmin = ImageIO.read(new File("interfazGrafica/recursos/iconAdmin.png"));
		}catch(IOException e) {
			g.drawString("Image no encontrada", 10, 115);
		}
		if(iconAdmin!=null) {
			g.drawImage(iconAdmin, 10, 10, 230, 230, null);
		}
	}
	
	private class oyenteAdmin extends MouseAdapter {
		MarcoPrincipal m;
		public oyenteAdmin(MarcoPrincipal m) {
			this.m=m;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			//Pone a la escucha
			m.setVisible(false);
			ventanaLogin.setVisible(true);
		}
	}
}
