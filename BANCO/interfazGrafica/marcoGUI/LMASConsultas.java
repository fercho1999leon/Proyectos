package interfazGrafica.marcoGUI;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.*;
import ADMINISTRATIVO.CREACION.Cliente;
import ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS.Infcliente;
import ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS.Infcuenta;
import BASEDEDATOS.DBCliente;

public class LMASConsultas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String idLMACliente = "Cliente";
	final static String idLMACuenta = "Cuenta";
	LMAModeloConsulta lmaCliente;
	LMAModeloConsulta lmaCuenta;
	JPanel ShowLamina;
	private Color color;
	private JComboBox<String> FormaConsulta;
	public LMASConsultas() {
		color = new Color(7, 115, 157);
		setBackground(color);
		setLayout(new BoxLayout(LMASConsultas.this,BoxLayout.Y_AXIS));
		lmaCliente = new LMAModeloConsulta(new oyenteConsultaCliente(),"INGRESE EL NUMERO DE CEDULA ");
		lmaCuenta = new LMAModeloConsulta(new oyenteConsultaCuenta(),"INGRESE EL NUMERO DE CUENTA");
		ShowLamina = new JPanel();
		ShowLamina.setBounds(5, 300, 400, 100);
		ShowLamina.setLayout(new CardLayout(0,0));
		ShowLamina.setBackground(new Color(0, 39, 56));
		ShowLamina.add(lmaCliente,idLMACliente);
		ShowLamina.add(lmaCuenta,idLMACuenta);
		
		FormaConsulta = new JComboBox<String>();
		FormaConsulta.addItem("CLIENTE");
		FormaConsulta.addItem("CUENTA");
		FormaConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opc = FormaConsulta.getSelectedIndex();
				CardLayout c1 = (CardLayout)ShowLamina.getLayout();
				if(opc == 0) {
					c1.show(ShowLamina,idLMACliente);
				}else if(opc == 1) {
					c1.show(ShowLamina,idLMACuenta);
				}
			}
			
		});
		
		add(new LogoPresentacion("CONSULTAS DE INFORMACION"));
		add(FormaConsulta);
		add(Box.createVerticalStrut(10));
		add(ShowLamina);
		
		
	}
	private class LogoPresentacion extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public LogoPresentacion(String titulo) {
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
			temIcon.add(new JLabel(crearIcono("interfazGrafica/recursos/presentacion.png",150, 150)));
			add(temIcon);
		}
	}
	private class oyenteConsultaCliente implements ActionListener{
		private Infcliente consulta;
		private String nDNI;
		@Override
		public void actionPerformed(ActionEvent e) {
			consulta = new Infcliente();
			nDNI = lmaCliente.getTxtDatos().getText();
			DBCliente dbCliente = conectInput ();
			if(dbCliente!=null) {
				ArrayList<Cliente> db = dbCliente.getCliente();
				lmaCliente.getTxtMostrar().setText("");
				if(consulta.MostraDatos(nDNI, db, lmaCliente.getTxtMostrar())) {
					System.out.println("Consulta exitosa");
				}
			}
			
		}
		
	}
	private class oyenteConsultaCuenta implements ActionListener{
		private Infcuenta consulta;
		private String nC1;
		@Override
		public void actionPerformed(ActionEvent e) {
			consulta = new Infcuenta();
			nC1 = lmaCuenta.getTxtDatos().getText();
			DBCliente dbCliente = conectInput ();
			if(dbCliente!=null) {
				ArrayList<Cliente> db = dbCliente.getCliente();
				lmaCuenta.getTxtMostrar().setText("");
				if(consulta.MostraDatos(nC1, db, lmaCuenta.getTxtMostrar())) {
					System.out.println("Consulta exitosa");
				}
			}
			
		}
		
	}
	
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
	private DBCliente conectInput () {
		DBCliente dbCliente = null;
		String direcciondbClientes = "archivosStream/dbClientes.dat";
		try {
			ObjectInputStream InStreamdbClientes = new ObjectInputStream(new FileInputStream(direcciondbClientes));
			dbCliente = (DBCliente)InStreamdbClientes.readObject();
			InStreamdbClientes.close();
			System.out.println("Archivo cliente encontrado");
		}catch(Exception ex) {
			System.out.println("Archivo no encontrado");
		}
		return dbCliente;
	}
}
