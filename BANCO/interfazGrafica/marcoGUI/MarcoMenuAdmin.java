package interfazGrafica.marcoGUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.sun.awt.AWTUtilities;
import BASEDEDATOS.DBCliente;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
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
		setSize((int)(width/1.2),(int)(height/1.3));
		//System.out.println("x: "+(int)(width/1.2) +"y:"+(int)(height/1.2));
		setLocationRelativeTo(null);
		add(new LaminaMenuAdmin(MarcoMenuAdmin.this,dbCliente));
		Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
		AWTUtilities.setWindowShape(this, forma);
	}
}
