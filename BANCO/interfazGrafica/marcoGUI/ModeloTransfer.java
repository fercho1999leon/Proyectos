package interfazGrafica.marcoGUI;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ModeloTransfer extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cajaVertical,cajaVerticalShow;
	private JButton btnTransferir;
	private JSpinner cantidad;
	static int ancho = 10;
	private Color color;
	JPanel lmaPrincipal1,lmaPrincipal2,lmaPagoTarjeta1,lmaPagoCuenta1, lmaPagoCedula1,lmaPagoTarjeta2,lmaPagoCuenta2, lmaPagoCedula2;
	final static String idPagoTarjeta = "PagoTarjeta";
	final static String idPagoCedula = "PagoCedula";
	final static String idPagoCuenta = "PagoCuenta";
	private JTextField NumeroTarjeta1,ClaveTarjeta1,NumeroCuenta1,NumeroCedula1,NumeroCuenta2;
	private static int anchoTxt = 12;
	private JComboBox<String> tipoPago1;
	private JLabel lbDatOrigen,lbDatDestino,lbDatCantidadT;
	
	public ModeloTransfer(ActionListener oyente,String titulo){
		lbDatOrigen = new JLabel();
		lbDatOrigen.setVisible(false);
		lbDatOrigen.setForeground(new Color(255, 255, 255));
		lbDatOrigen.setFont(new Font("Andale Mono", 1, 13));
		lbDatDestino = new JLabel();
		lbDatDestino.setVisible(false);
		lbDatDestino.setForeground(new Color(255, 255, 255));
		lbDatDestino.setFont(new Font("Andale Mono", 1, 13));
		lbDatCantidadT = new JLabel();
		lbDatCantidadT.setVisible(false);
		lbDatCantidadT.setForeground(new Color(255, 255, 255));
		lbDatCantidadT.setFont(new Font("Andale Mono", 1, 13));
		cajaVerticalShow = new JPanel();
		cajaVerticalShow.setLayout(new BoxLayout(cajaVerticalShow,BoxLayout.Y_AXIS));
		cajaVerticalShow.add(lbDatOrigen);
		cajaVerticalShow.add(lbDatDestino);
		cajaVerticalShow.add(lbDatCantidadT);
		cajaVerticalShow.setBackground(color);
		
		lmaPrincipal1 = new JPanel();
		lmaPrincipal1.setBounds(5, 300, 400, 100);
		lmaPrincipal1.setLayout(new CardLayout(0,0));
		lmaPrincipal1.setBackground(new Color(0, 39, 56));
		lmaPagoTarjeta1 = new JPanel();
		lmaPagoTarjeta1.setBackground(new Color(0, 39, 56));
		lmaPagoCuenta1 = new JPanel(); 
		lmaPagoCuenta1.setBackground(new Color(0, 39, 56));
		lmaPagoCedula1 = new JPanel();
		lmaPagoCedula1.setBackground(new Color(0, 39, 56));
		
		add(lmaPrincipal1);
		
		NumeroTarjeta1 = new JTextField(anchoTxt);
		ClaveTarjeta1 = new JTextField(anchoTxt);
		NumeroCuenta1 = new JTextField(anchoTxt);
		NumeroCedula1 = new JTextField(anchoTxt);
		
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
		
		JLabel tituloCedula = new JLabel("INGRESE EL NUMERO DE CEDULA");
		tituloCedula.setForeground(new Color(255, 255, 255));
		tituloCedula.setFont(new Font("Andale Mono", 1, 13));
		lmaPagoCedula1.setLayout(new FlowLayout(FlowLayout.LEFT));
		lmaPagoCedula1.add(tituloCedula);
		lmaPagoCedula1.add(NumeroCedula1);
		
		lmaPrincipal1.add(lmaPagoCuenta1,idPagoCuenta);
		lmaPrincipal1.add(lmaPagoTarjeta1,idPagoTarjeta);
		lmaPrincipal1.add(lmaPagoCedula1,idPagoCedula);	
		
		//-------------------------------------------------------------------------------------
		lmaPrincipal2 = new JPanel();
		lmaPrincipal2.setBounds(5, 300, 400, 100);
		lmaPrincipal2.setLayout(new CardLayout(0,0));
		lmaPrincipal2.setBackground(new Color(0, 39, 56));
		lmaPagoCuenta2 = new JPanel(); 
		lmaPagoCuenta2.setBackground(new Color(0, 39, 56));
		
		add(lmaPrincipal2);

		NumeroCuenta2 = new JTextField(anchoTxt);
		
		JLabel tituloCuenta2 = new JLabel("INGRESE EL NUMERO DE CUENTA");
		tituloCuenta2.setForeground(new Color(255, 255, 255));
		tituloCuenta2.setFont(new Font("Andale Mono", 1, 13));
		lmaPagoCuenta2.setLayout(new FlowLayout(FlowLayout.LEFT));
		lmaPagoCuenta2.add(tituloCuenta2);
		lmaPagoCuenta2.add(NumeroCuenta2);

		
		lmaPrincipal2.add(lmaPagoCuenta2,idPagoCuenta);

		//-------------------------------------------------------------------------------------
		tipoPago1 = new JComboBox<String>();
		tipoPago1.addItem("CUENTA");
		tipoPago1.addItem("TARJETA");
		tipoPago1.addItem("CEDULA");
		tipoPago1.setBounds(5, 250, 100, 30);
		tipoPago1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opc = tipoPago1.getSelectedIndex();
				CardLayout c1 = (CardLayout)lmaPrincipal1.getLayout();
				if(opc == 0) {
					c1.show(lmaPrincipal1,idPagoCuenta);
				}else if(opc == 1) {
					c1.show(lmaPrincipal1,idPagoTarjeta);
				}else {
					c1.show(lmaPrincipal1,idPagoCedula);
				}
				
			}
			
		});
		
		color = new Color(0, 39, 56);
		setBackground(color);
		JPanel P = new JPanel();
		setLayout(new BoxLayout(ModeloTransfer.this,BoxLayout.Y_AXIS));
		P.setLayout(new BoxLayout(P,BoxLayout.X_AXIS));
		P.setBackground(color);
		cajaVertical = new JPanel();
		cajaVertical.setBackground(color);
		cajaVertical.setLayout(new BoxLayout(cajaVertical,BoxLayout.Y_AXIS));
		cantidad = new JSpinner();
		cantidad.setValue(100);
		add(new LogoPresentacion(titulo));
		cajaVertical.add(addComponent ("CLIENTE DE ORIGEN", null));
		cajaVertical.add(tipoPago1);
		cajaVertical.add(lmaPrincipal1);
		cajaVertical.add(addComponent ("CLIENTE DE DESTINO", null));
		cajaVertical.add(lmaPrincipal2);
		cajaVertical.add(addComponent ("CANTIDAD DE DINERO A RETIRAR", cantidad));
		btnTransferir = createBtn("interfazGrafica/recursos/btnRealizarT.png",50 ,50);
		btnTransferir.addActionListener(oyente);
		cajaVertical.add(addComponent ("TRASNFERIR", btnTransferir));
		P.add(cajaVertical);
		P.add(Box.createHorizontalStrut(50));
		P.add(cajaVerticalShow);
		P.add(Box.createHorizontalStrut(50));
		add(P);
		
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
	public JTextField getNumeroCedula1() {
		return NumeroCedula1;
	}
	public void setNumeroCedula1(JTextField numeroCedula1) {
		NumeroCedula1 = numeroCedula1;
	}
	public JTextField getNumeroCuenta2() {
		return NumeroCuenta2;
	}
	public void setNumeroCuenta2(JTextField numeroCuenta2) {
		NumeroCuenta2 = numeroCuenta2;
	}
	public JSpinner getCantidad() {
		return cantidad;
	}
	public void setCantidad(JSpinner cantidad) {
		this.cantidad = cantidad;
	}
	public JComboBox<String> getTipoPago1() {
		return tipoPago1;
	}
	public void setTipoPago1(JComboBox<String> tipoPago1) {
		this.tipoPago1 = tipoPago1;
	}
	public JLabel getLbDatOrigen() {
		return lbDatOrigen;
	}
	public void setLbDatOrigen(JLabel lbDatOrigen) {
		this.lbDatOrigen = lbDatOrigen;
	}
	public JLabel getLbDatDestino() {
		return lbDatDestino;
	}
	public void setLbDatDestino(JLabel lbDatDestino) {
		this.lbDatDestino = lbDatDestino;
	}
	public JLabel getLbDatCantidadT() {
		return lbDatCantidadT;
	}
	public void setLbDatCantidadT(JLabel lbDatCantidadT) {
		this.lbDatCantidadT = lbDatCantidadT;
	}
}
