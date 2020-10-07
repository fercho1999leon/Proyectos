package interfazGrafica.marcoGUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import BASEDEDATOS.DBCliente;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MarcoMenuAdmin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image miIcono;
	public MarcoMenuAdmin(DBCliente dbCliente) {
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
		System.out.println("x: "+(int)(width/1.2) +" y: "+(int)(height/1.2));
		setSize(1133,640);
		setLocationRelativeTo(null);
		add(new LaminaMenuAdmin(MarcoMenuAdmin.this,dbCliente));
	}
}
