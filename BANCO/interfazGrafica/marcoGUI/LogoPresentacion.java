package interfazGrafica.marcoGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LogoPresentacion extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	public LogoPresentacion(String titulo,int x,int y) {
		color = new Color(0, 39, 56);
		setBackground(color);
		setLayout(new BoxLayout(LogoPresentacion.this,BoxLayout.Y_AXIS));
		JPanel temText = new JPanel();
		temText.setBackground(color);
		JLabel temp = new JLabel(titulo);
		temp.setFont(new Font("Arial",Font.BOLD,20));
		temp.setForeground(Color.WHITE);
		temText.add(temp);
		add(temText);
		JPanel temIcon = new JPanel();
		temIcon.setBackground(color);
		temIcon.add(new JLabel(crearIcono("interfazGrafica/recursos/presentacion.png",x, y)));
		add(temIcon);
	}
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
}