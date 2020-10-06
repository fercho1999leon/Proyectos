package interfazGrafica.marcoGUI;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ModeloMovimientoD extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cajaVertical,cajaVerticalShow;
	private JButton btnAcion;
	private JSpinner cantidad;
	static int ancho = 10;
	private Color color;
	JPanel lmaPrincipal1,lmaPagoTarjeta1,lmaPagoCuenta1;
	final static String idPagoTarjeta = "PagoTarjeta";
	final static String idPagoCuenta = "PagoCuenta";
	private JTextField NumeroTarjeta1,ClaveTarjeta1,NumeroCuenta1;
	private static int anchoTxt = 12;
	private JComboBox<String> FormaMovimiento;
	private JLabel lbDatOrigen,lbDatDestino,lbDatCantidadT;
	public ModeloMovimientoD(ActionListener oyente, String tituloP, String tituloTMovimiento) {
		color = new Color(0, 39, 56);
		setBackground(color);
		setLayout(new BoxLayout(ModeloMovimientoD.this,BoxLayout.Y_AXIS));
		cajaVerticalShow = new JPanel();
		cajaVerticalShow.setBackground(color);
		cajaVerticalShow.setLayout(new BoxLayout(cajaVerticalShow,BoxLayout.Y_AXIS));
		createLabel (lbDatOrigen, 13 ,cajaVerticalShow);
		createLabel (lbDatDestino, 13 ,cajaVerticalShow);
		createLabel (lbDatCantidadT, 13 ,cajaVerticalShow);
		
		lmaPrincipal1 = new JPanel();
		lmaPrincipal1.setBounds(5, 300, 400, 100);
		lmaPrincipal1.setLayout(new CardLayout(0,0));
		lmaPrincipal1.setBackground(new Color(0, 39, 56));
		lmaPagoTarjeta1 = new JPanel();
		lmaPagoTarjeta1.setBackground(new Color(0, 39, 56));
		lmaPagoCuenta1 = new JPanel(); 
		lmaPagoCuenta1.setBackground(new Color(0, 39, 56));
		
		add(lmaPrincipal1);
		
		NumeroTarjeta1 = new JTextField(anchoTxt);
		ClaveTarjeta1 = new JTextField(anchoTxt);
		NumeroCuenta1 = new JTextField(anchoTxt);
		
		JLabel tituloTarjeta = new JLabel() , tituloClave = new JLabel();
		tituloTarjeta.setText("INGRESE EL NUMERO DE TARJETA");
		tituloClave.setText("INGRESE LA CLAVE");
		tituloTarjeta.setForeground(new Color(255, 255, 255));
		tituloTarjeta.setFont(new Font("Andale Mono", 1, 13));
		tituloClave.setForeground(new Color(255, 255, 255));
		tituloClave.setFont(new Font("Andale Mono", 1, 13));
		lmaPagoTarjeta1.setLayout(new FlowLayout(FlowLayout.LEFT));
		lmaPagoTarjeta1.add(tituloTarjeta);
		lmaPagoTarjeta1.add(NumeroTarjeta1);
		lmaPagoTarjeta1.add(tituloClave);
		lmaPagoTarjeta1.add(ClaveTarjeta1);
		
		JLabel tituloCuenta = new JLabel("INGRESE EL NUMERO DE CUENTA");
		tituloCuenta.setForeground(new Color(255, 255, 255));
		tituloCuenta.setFont(new Font("Andale Mono", 1, 13));
		lmaPagoCuenta1.setLayout(new FlowLayout(FlowLayout.LEFT));
		lmaPagoCuenta1.add(tituloCuenta);
		lmaPagoCuenta1.add(NumeroCuenta1);
		

		lmaPrincipal1.add(lmaPagoCuenta1,idPagoCuenta);
		lmaPrincipal1.add(lmaPagoTarjeta1,idPagoTarjeta);
		
		FormaMovimiento = new JComboBox<String>();
		FormaMovimiento.addItem("CUENTA");
		FormaMovimiento.addItem("TARJETA");
		FormaMovimiento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opc = FormaMovimiento.getSelectedIndex();
				CardLayout c1 = (CardLayout)lmaPrincipal1.getLayout();
				if(opc == 0) {
					c1.show(lmaPrincipal1,idPagoCuenta);
				}else if(opc == 1) {
					c1.show(lmaPrincipal1,idPagoTarjeta);
				}
			}
			
		});
		
		JPanel P = new JPanel();
		P.setLayout(new BoxLayout(P,BoxLayout.X_AXIS));
		P.setBackground(color);
		cajaVertical = new JPanel();
		cajaVertical.setBackground(color);
		cajaVertical.setLayout(new BoxLayout(cajaVertical,BoxLayout.Y_AXIS));
		cantidad = new JSpinner();
		cantidad.addMouseListener(new oyenteSpinne());
		add(new LogoPresentacion(tituloP));
		cajaVertical.add(addComponent ("MOVIMIENTO DE DINERO DEL CLIENTE", null));
		cajaVertical.add(FormaMovimiento);
		cajaVertical.add(lmaPrincipal1);
		cajaVertical.add(addComponent ("CANTIDAD DE DINERO A "+tituloTMovimiento, cantidad));
		btnAcion = createBtn("interfazGrafica/recursos/btnRDDienro.png",50 ,50);
		btnAcion.addActionListener(oyente);
		cajaVertical.add(addComponent (tituloTMovimiento, btnAcion));
		P.add(cajaVertical);
		P.add(Box.createHorizontalStrut(50));
		P.add(cajaVerticalShow);
		P.add(Box.createHorizontalStrut(50));
		add(P);
		
	}
	class oyenteSpinne extends  MouseAdapter{
		public void mousePressed(MouseEvent e) {
			cantidad.setVisible(false);
			cantidad.setVisible(true);
		}
		public void mouseEntered(MouseEvent e) {
			cantidad.setVisible(false);
			cantidad.setVisible(true);
		}
		public void mouseExited(MouseEvent e) {
			cantidad.setVisible(false);
			cantidad.setVisible(true);
		}
		
	}
	private <T> JPanel addComponent (String name, T comp) {
		JPanel temp = new JPanel();
		temp.setLayout(new FlowLayout(FlowLayout.LEADING));
		JLabel lbTemp = new JLabel(name);
		lbTemp.setFont(new Font("Arial",Font.BOLD,15));
		lbTemp.setForeground(Color.WHITE);
		temp.setBackground(color);
		temp.add(lbTemp);
		if(comp != null) {
			temp.add((JComponent)comp);
		}
		return temp;
	}
	private void createLabel (JLabel l, int t, JPanel p) {
		l = new JLabel();
		l.setVisible(false);
		l.setForeground(new Color(255, 255, 255));
		l.setFont(new Font("Andale Mono", 1, t));
		p.add(l);
	}
	private JButton createBtn(String ruta,int ancho, int alto) {
		JButton btn = new JButton();
		btn.setIcon(crearIcono(ruta,ancho,alto));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusable(false);
		return btn;
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
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
}
