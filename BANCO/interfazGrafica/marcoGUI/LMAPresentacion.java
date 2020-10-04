package interfazGrafica.marcoGUI;
import java.awt.*;
import javax.swing.*;
public class LMAPresentacion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LMAPresentacion (String icono,int r ,int g,int b) {
		setOpaque(true);
		setBackground(new Color(r,g,b));
		setLayout(new BorderLayout());
		JLabel titulo = new JLabel(crearIcono(icono,350,350));
		JPanel contTitulo = new JPanel();
		contTitulo.add(titulo);
		contTitulo.setBackground(new Color(r,g,b));
		add(contTitulo,BorderLayout.CENTER);
	}
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
}
