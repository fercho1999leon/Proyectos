package interfazGrafica.marcoGUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
public class LMACtarjeta extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int Width = 15;
	private JTextField txtNunTarjeta;
	private JRadioButton rdbDesblo;
	private JRadioButton rdbBlo;
	private JTextField txtFechaCad;
	private JTextField txtNunSerie;
	private ButtonGroup btngEstado;
	protected Box cajaVertical;
	public LMACtarjeta () {
		setOpaque(true);
		setBackground(new Color(7,115,157));
		txtNunTarjeta = new JTextField(Width);
		rdbDesblo = new JRadioButton("DESBLOQUEADO");
		rdbBlo = new JRadioButton("BLOQUEADO");
		btngEstado = new ButtonGroup();
		rdbDesblo.setSelected(true);
		btngEstado.add(rdbDesblo);
		btngEstado.add(rdbBlo);
		txtFechaCad = new JTextField(Width);
		txtNunSerie = new JTextField(Width);
		cajaVertical = Box.createVerticalBox();
		setBorder(BorderFactory.createTitledBorder("Datos de la tarjeta"));
		Agregar ("Numero tarjeta: ",txtNunTarjeta);
		Agregar ("Fecha caducidad: ",txtFechaCad);
		Agregar ("Numero serie: ",txtNunSerie);
		agregarR(new JLabel("ESTADO DE TARJETA"),10);
		agregarR(rdbDesblo,10);
		agregarR(rdbBlo,10);
		add(cajaVertical);
		
	}
	protected <T> void Agregar (String n,T comp) {
		Box cajaHorizontal = Box.createHorizontalBox();
		JPanel j1 = new JPanel();
		JPanel j2 = new JPanel();
		JLabel titulo = new JLabel(n);
		titulo.setFont(new Font("Arial",Font.BOLD,15));
		titulo.setForeground(Color.WHITE);
		j1.setBackground(new Color(7,115,157));
		j2.setBackground(new Color(7,115,157));
		j1.setLayout(new FlowLayout(FlowLayout.LEFT));
		j2.setLayout(new FlowLayout(FlowLayout.LEFT));
		j1.add(titulo);
		j2.add((Component) comp);
		cajaHorizontal.add(j1);
		cajaHorizontal.add(j2);
		cajaVertical.add(cajaHorizontal);
	}
	private <T> void agregarR(T comp,int tamano) {
		((JComponent) comp).setFont(new Font("Arial",Font.BOLD,tamano));
		((JComponent) comp).setForeground(Color.WHITE);
		((JComponent) comp).setBackground(new Color(7,115,157));
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(7,115,157));
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(((JComponent) comp));
		cajaVertical.add(p1);
	}
	public JTextField getTxtNunTarjeta() {
		return txtNunTarjeta;
	}
	public void setTxtNunTarjeta(JTextField txtNunTarjeta) {
		this.txtNunTarjeta = txtNunTarjeta;
	}
	public JRadioButton getRdbDesblo() {
		return rdbDesblo;
	}
	public void setRdbDesblo(JRadioButton rdbDesblo) {
		this.rdbDesblo = rdbDesblo;
	}
	public JRadioButton getRdbBlo() {
		return rdbBlo;
	}
	public void setRdbBlo(JRadioButton rdbBlo) {
		this.rdbBlo = rdbBlo;
	}
	public JTextField getTxtFechaCad() {
		return txtFechaCad;
	}
	public void setTxtFechaCad(JTextField txtFechaCad) {
		this.txtFechaCad = txtFechaCad;
	}
	public JTextField getTxtNunSerie() {
		return txtNunSerie;
	}
	public void setTxtNunSerie(JTextField txtNunSerie) {
		this.txtNunSerie = txtNunSerie;
	}
	public ButtonGroup getBtngEstado() {
		return btngEstado;
	}
	public void setBtngEstado(ButtonGroup btngEstado) {
		this.btngEstado = btngEstado;
	}
}
