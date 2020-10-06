package interfazGrafica.marcoGUI;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ADMINISTRATIVO.SERVICIOALCLIENTE.CONSULTAS.Infcliente;

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
		lmaCuenta = new LMAModeloConsulta(null,"INGRESE EL NUMERO DE CUENTA");
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
		public oyenteConsultaCliente() {
			consulta = new Infcliente();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
}
