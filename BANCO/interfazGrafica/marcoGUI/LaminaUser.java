package interfazGrafica.marcoGUI;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
public class LaminaUser extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MarcoCliente marcoPCliente;
	MarcoPrincipal m;
	public LaminaUser(MarcoPrincipal m) {
		this.m = m;
		setBackground(new Color(47,85,95));
		setLayout(null);
		setSize(230,230);
		oyenteUser click = new oyenteUser();
		addMouseListener(click);
		marcoPCliente = new MarcoCliente(); 
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image iconAdmin = null;
		try {
			iconAdmin = ImageIO.read(new File("interfazGrafica/recursos/iconUsuario.png"));
		}catch(IOException e) {
			g.drawString("Image no encontrada", 10, 115);
		}
		if(iconAdmin!=null) {
			g.drawImage(iconAdmin, 10, 10, 230, 230, null);
		}
	}
	
	private class oyenteUser extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			m.setVisible(false);
			marcoPCliente.setVisible(true);
		}
	}
}