package interfazGrafica.marcoGUI;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
public class LMAModeloConsulta extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cajaHorizontal,cajaVertical;
	private JButton btnConsulta;
	private JTextArea txtMostrar;
	private JScrollPane scrollMostrar;
	private JTextField txtDatos;
	private Color color;
	private static int anchoTxt = 12;
	public LMAModeloConsulta(ActionListener oyente ,String tituloLb) {
		color = new Color(7, 115, 157);
		setBackground(color);
		setLayout(new BoxLayout(LMAModeloConsulta.this,BoxLayout.X_AXIS));
		cajaVertical = new JPanel();
		cajaVertical.setLayout(new BoxLayout(cajaVertical,BoxLayout.Y_AXIS));
		cajaVertical.setBackground(color);
		cajaHorizontal = new JPanel();
		cajaHorizontal.setLayout(new BoxLayout(cajaHorizontal,BoxLayout.X_AXIS));
		txtMostrar = new JTextArea(14,20);
		scrollMostrar = new JScrollPane(txtMostrar);
		txtDatos = new JTextField(anchoTxt);
		JLabel lb = new JLabel(tituloLb);
		lb.setForeground(new Color(255, 255, 255));
		lb.setFont(new Font("Andale Mono", 1, 13));
		cajaHorizontal.add(lb);
		cajaHorizontal.add(txtDatos);
		cajaHorizontal.setBackground(color);
		cajaVertical.add(cajaHorizontal);
		cajaVertical.add(Box.createVerticalStrut(10));
		cajaVertical.add(scrollMostrar);
		btnConsulta = createBtn("interfazGrafica/recursos/btnShow.png",50,50);
		btnConsulta.addActionListener(oyente);
		cajaVertical.add(btnConsulta);
		add(Box.createHorizontalStrut(50));
		add(cajaVertical);
		add(Box.createHorizontalStrut(50));
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
	public JTextArea getTxtMostrar() {
		return txtMostrar;
	}
	public void setTxtMostrar(JTextArea txtMostrar) {
		this.txtMostrar = txtMostrar;
	}
	public JTextField getTxtDatos() {
		return txtDatos;
	}
	public void setTxtDatos(JTextField txtDatos) {
		this.txtDatos = txtDatos;
	}
}
