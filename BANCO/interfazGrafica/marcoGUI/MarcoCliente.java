package interfazGrafica.marcoGUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MarcoCliente extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image miIcono;
	public MarcoCliente() {
		setUndecorated(true);
		setOpacity(0.98f);
		try {
			miIcono = ImageIO.read(new File("interfazGrafica/recursos/icon.png"));
		}catch(IOException e) {
			setTitle("Error en el icono");
		}
		setIconImage(miIcono);
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		int height = (int)miPantalla.getScreenSize().getHeight();
		int width = (int)miPantalla.getScreenSize().getWidth();
		System.out.println("x: "+(int)(width/1.4) +" y: "+(int)(height/1.45));
		setSize(971,529);
		setLocationRelativeTo(null);
		add(new LaminaMenuCliente(MarcoCliente.this));
		//PONE LA VENTANA CON BORDES REDONDEADOS
	}
}
