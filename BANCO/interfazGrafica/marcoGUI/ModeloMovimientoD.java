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
	private JPanel lmaPrincipal1,lmaPagoTarjeta1,lmaPagoCuenta1;
	final static String idPagoTarjeta = "PagoTarjeta";
	final static String idPagoCuenta = "PagoCuenta";
	private JTextField NumeroTarjeta1,ClaveTarjeta1,NumeroCuenta1;
	private static int anchoTxt = 12;
	private JComboBox<String> FormaMovimiento;
	private JLabel tituloR,lbDatCuenta,lbDatCantidadT;
	public ModeloMovimientoD(ActionListener oyente, String tituloP, String tituloTMovimiento) {
		color = new Color(0, 39, 56);
		setBackground(color);
		setLayout(new BoxLayout(ModeloMovimientoD.this,BoxLayout.Y_AXIS));
		cajaVerticalShow = new JPanel();
		cajaVerticalShow.setBackground(color);
		cajaVerticalShow.setLayout(new BoxLayout(cajaVerticalShow,BoxLayout.Y_AXIS));
		tituloR = createLabel (13);
		lbDatCuenta = createLabel (13);
		lbDatCantidadT = createLabel (13);
		cajaVerticalShow.add(tituloR);
		cajaVerticalShow.add(lbDatCuenta);
		cajaVerticalShow.add(lbDatCantidadT);
		
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
		add(new LogoPresentacion(tituloP,150,150));
		cajaVertical.add(addComponent ("MOVIMIENTO DE DINERO DEL CLIENTE", null));
		cajaVertical.add(FormaMovimiento);
		cajaVertical.add(lmaPrincipal1);
		cajaVertical.add(addComponent ("CANTIDAD DE DINERO A "+tituloTMovimiento, cantidad));
		btnAcion = createBtn("interfazGrafica/recursos/btnRDDienro.png",50 ,50);
		cajaVertical.add(addComponent (tituloTMovimiento, btnAcion));
		P.add(cajaVertical);
		P.add(Box.createHorizontalStrut(50));
		P.add(cajaVerticalShow);
		P.add(Box.createHorizontalStrut(50));
		add(P);
		btnAcion.addActionListener(oyente);
		
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
	private JLabel createLabel (int t) {
		JLabel l = new JLabel();
		l.setVisible(false);
		l.setForeground(new Color(255, 255, 255));
		l.setFont(new Font("Andale Mono", 1, t));
		return l;
	}
	private JButton createBtn(String ruta,int ancho, int alto) {
		JButton btn = new JButton();
		btn.setIcon(crearIcono(ruta,ancho,alto));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusable(false);
		return btn;
	}
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
	
	public JComboBox<String> getFormaMovimiento() {
		return FormaMovimiento;
	}
	public void setFormaMovimiento(JComboBox<String> formaMovimiento) {
		FormaMovimiento = formaMovimiento;
	}
	public JSpinner getCantidad() {
		return cantidad;
	}
	public void setCantidad(JSpinner cantidad) {
		this.cantidad = cantidad;
	}
	public JTextField getNumeroTarjeta1() {
		return NumeroTarjeta1;
	}
	public void setNumeroTarjeta1(JTextField numeroTarjeta1) {
		NumeroTarjeta1 = numeroTarjeta1;
	}
	public JTextField getClaveTarjeta1() {
		return ClaveTarjeta1;
	}
	public void setClaveTarjeta1(JTextField claveTarjeta1) {
		ClaveTarjeta1 = claveTarjeta1;
	}
	public JTextField getNumeroCuenta1() {
		return NumeroCuenta1;
	}
	public void setNumeroCuenta1(JTextField numeroCuenta1) {
		NumeroCuenta1 = numeroCuenta1;
	}
	public JLabel getTituloR() {
		return tituloR;
	}
	public void setTituloR(JLabel tituloR) {
		this.tituloR = tituloR;
	}
	public JLabel getLbDatCuenta() {
		return lbDatCuenta;
	}
	public void setLbDatCuenta(JLabel lbDatCuenta) {
		this.lbDatCuenta = lbDatCuenta;
	}
	public JLabel getLbDatCantidadT() {
		return lbDatCantidadT;
	}
	public void setLbDatCantidadT(JLabel lbDatCantidadT) {
		this.lbDatCantidadT = lbDatCantidadT;
	}
	
}
