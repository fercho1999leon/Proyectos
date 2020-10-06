package interfazGrafica.marcoGUI;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import BASEDEDATOS.DBAdministradores;;
public class MarcoPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image miIcono;
	public MarcoPrincipal(DBAdministradores dbAdmin) {
		setBackground(new Color(47,85,95));
		setLayout(new GridLayout(1,2));
		setSize(500,300);
		setLocationRelativeTo(null);
		try {
			miIcono = ImageIO.read(new File("interfazGrafica/recursos/icon.png"));
		}catch(IOException e) {
			setTitle("Error en el icono");
		}
		if(miIcono!=null) {setIconImage(miIcono);setTitle("BANCO");}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//---------------------------------------------------------------------------
		JPanel marcoAdmin = new LaminaAdmin(MarcoPrincipal.this,dbAdmin);
		marcoAdmin.setBorder(BorderFactory.createTitledBorder("Administracion"));
		add(marcoAdmin);
		//---------------------------------------------------------------------------
		JPanel marcoUser = new LaminaUser(MarcoPrincipal.this);
		marcoUser.setBorder(BorderFactory.createTitledBorder("Usuarios"));
		add(marcoUser);
		
	}
}
