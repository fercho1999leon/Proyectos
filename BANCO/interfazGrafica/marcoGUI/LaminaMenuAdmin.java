package interfazGrafica.marcoGUI;
import javax.swing.*;
import BASEDEDATOS.DBCliente;
import java.awt.*;
import java.awt.event.*;
/*
 * Tipo azul oscuro RGB : r34, g79, b98	HEX: 22F62
 * Tipo celeste claro RGB : r7, g115, b157  HEX: 2298CB
 * RGB Oscuro barra de titulo RGB : r0, g39, b56
 * 
 * */
public class LaminaMenuAdmin extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnCerrar;
	private JButton btnCrear;
	private JButton btnMax;
	private JButton btnMin;
	private JButton btnAtras;
	private JButton btnServicio;
	private LMACreacion LCreacion;
	private LPanelCentral laminaCentral;
	private LMASConsultas laminaConsulta;
	private LMAEliminacion laminaEliminacion;
	final static String v1 = "VtnCreacion";
	final static String v2 = "VtnPresentacion";
	final static String v3 = "VtnConsultas";
	final static String v4 = "VtnEliminacion";
	Dimension tamanoPantalla;
	JFrame marcoP;
	public LaminaMenuAdmin(JFrame marcoP,DBCliente dbCliente) {
		laminaConsulta = new LMASConsultas();
		laminaEliminacion = new LMAEliminacion();
		btnCrear = new JButton();
		btnServicio = new JButton();
		btnAtras = new JButton();
		this.marcoP=marcoP;
		setLayout(new BorderLayout());
		LCreacion = new LMACreacion(dbCliente);
		tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		laminaCentral = new LPanelCentral();
		add(new LBarraTitulo(),BorderLayout.NORTH);
		add(new LPanelIzquierdo(),BorderLayout.WEST);
		add(laminaCentral,BorderLayout.CENTER);
	}
	
	public JPanel getBarraTitulo () {
		JPanel obj = new LBarraTitulo();
		return obj;
	}
	
	class LBarraTitulo extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int x;
		private int y;
		private boolean control;

		public LBarraTitulo() {
			setOpaque(true);
			int ancho = (int)tamanoPantalla.getWidth();
			setLayout(new FlowLayout(FlowLayout.RIGHT));
			setSize((int)(ancho/1.2),20);
			setBackground(new Color(0,39,56));
			control = true;
			btnCerrar = new JButton();
			btnCerrar.setIcon(crearIcono("interfazGrafica/recursos/btnCerrar.png",15,15));
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setBorderPainted(false);
			btnCerrar.setFocusable(false);
			
			btnMax = new JButton();
			btnMax.setIcon(crearIcono("interfazGrafica/recursos/btnMax.png",15,15));
			btnMax.setContentAreaFilled(false);
			btnMax.setBorderPainted(false);
			btnMax.setFocusable(false);
			btnMax.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(control) {
						marcoP.setExtendedState(JFrame.MAXIMIZED_BOTH); 
						control = false;
					}else {
						marcoP.setExtendedState(JFrame.NORMAL); 
						control = true;
					}
				}
				
			});
			
			btnMin = new JButton();
			btnMin.setIcon(crearIcono("interfazGrafica/recursos/btnMin.png",15,15));
			btnMin.setContentAreaFilled(false);
			btnMin.setBorderPainted(false);
			btnMin.setFocusable(false);
			btnMin.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					marcoP.setExtendedState(Frame.ICONIFIED);
					
				}
				
			});
			
			btnCerrar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			add(btnMin);
			add(btnMax);
			add(btnCerrar);
			addMouseMotionListener(new oyenteVentana());
		}
		class oyenteVentana extends MouseAdapter{
			public void mouseDragged(MouseEvent e){
				marcoP.setLocation(marcoP.getLocation().x + e.getX() - x, marcoP.getLocation().y + e.getY() - y);
			}
			public void mousePressed(MouseEvent e){
				x = e.getX();
				y = e.getY();
			}
		}
	}
	private class LPanelIzquierdo extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Box cajaVertical;
		private JLabel jlCreacion;
		private JLabel jlServicio;
		public LPanelIzquierdo() {
			setOpaque(true);
			jlCreacion = new JLabel();
			jlServicio = new JLabel();
			jlCreacion.setFont(new Font("Arial",Font.BOLD,15));
			jlCreacion.setForeground(Color.WHITE);
			jlServicio.setFont(new Font("Arial",Font.BOLD,15));
			jlServicio.setForeground(Color.WHITE);
			
			btnServicio.setIcon(crearIcono("interfazGrafica/recursos/servicioCliente.png",50,50));
			btnServicio.setBorderPainted(false);
			btnServicio.setContentAreaFilled(false);
			btnServicio.setFocusable(false);
			
			btnCrear.setIcon(crearIcono("interfazGrafica/recursos/addUser.png",50,50));
			btnCrear.setBorderPainted(false);
			btnCrear.setContentAreaFilled(false);
			btnCrear.setFocusable(false);
			
			btnAtras.setIcon(crearIcono("interfazGrafica/recursos/atras.png",20,20));
			btnAtras.setBorderPainted(false);
			btnAtras.setContentAreaFilled(false);
			btnAtras.setFocusable(false);
			btnAtras.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,v2);
				}
			});
			
			cajaVertical = Box.createVerticalBox();
			int ancho = (int)tamanoPantalla.getWidth();
			setSize(20,(int)(ancho/1.2));
			
			btnCrear.addMouseListener(new oyentePanelI());
			btnServicio.addMouseListener(new oyentePanelI());
			btnCrear.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,v1);
					LCreacion.clearData();
				}
				
			});
			btnServicio.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)laminaCentral.getLayout();
					c1.show(laminaCentral,v4);
					//LCreacion.clearData();
				}
				
			});
			
			
			//Agrega componentes del panel izquierdo 
			JPanel comp = new JPanel();
			comp.setLayout(new FlowLayout(FlowLayout.LEFT));
			comp.setBackground(new Color(34,79,98));
			comp.add(btnAtras);
			cajaVertical.add(comp);
			cajaVertical.add(Box.createVerticalStrut(20));
			comp = new JPanel();
			comp.setLayout(new FlowLayout(FlowLayout.LEFT));
			comp.setBackground(new Color(34,79,98));
			comp.add(btnCrear);
			comp.add(jlCreacion);
			cajaVertical.add(comp);
			comp = new JPanel();
			comp.setBackground(new Color(34,79,98));
			comp.setLayout(new FlowLayout(FlowLayout.LEFT));
			comp.add(btnServicio);
			comp.add(jlServicio);
			cajaVertical.add(comp);
			
			addMouseListener(new oyentePanelI());
			setBackground(new Color(34,79,98));
			add(cajaVertical);
		}
		class oyentePanelI extends MouseAdapter{
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrear.setFocusable(true);
				btnServicio.setFocusable(true);
				jlCreacion.setText("CREACION DE NUEVO USUARIO");
				jlServicio.setText("SERVICIO AL CLIENTE");
			}
			public void mouseExited(MouseEvent e) {
				btnCrear.setFocusable(false);
				btnServicio.setFocusable(false);
				jlCreacion.setText("");
				jlServicio.setText("");
			}
		}
	}
	private class LPanelCentral extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public LPanelCentral() {
			setOpaque(true);
			setBackground(new Color(7,115,157));
			setLayout(new CardLayout(0,0));
			add(new LMAPresentacion("interfazGrafica/recursos/presentacion.png",7, 115, 157),v2);
			add(LCreacion,v1);
			add(laminaConsulta,v3);
			add(laminaEliminacion,v4);
		}
	}
	
	private ImageIcon crearIcono(String img, int width ,int height) {
		ImageIcon icon = new ImageIcon(img);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icono;
	}
}
