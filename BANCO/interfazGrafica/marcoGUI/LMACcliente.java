package interfazGrafica.marcoGUI;
import java.awt.*;
import javax.swing.*;
public class LMACcliente extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final int tamanoTextF = 15;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextArea txtDireccion;
	private JTextField txtTelefono;
	protected Box cajaVertical;
	private Color color;
	public LMACcliente() {
		color = new Color(0, 39, 56);
		setOpaque(true);
		setBackground(color);
		cajaVertical = Box.createVerticalBox();
		setBorder(BorderFactory.createTitledBorder("Datos cliente"));
		txtNombre = new JTextField(tamanoTextF);
		txtDNI = new JTextField(tamanoTextF);
		txtDireccion = new JTextArea(3,tamanoTextF);
		txtTelefono = new JTextField(tamanoTextF);
		txtDireccion.setLineWrap(true);
		JScrollPane direccion = new JScrollPane(txtDireccion);
		Agregar("Nombre:  ",txtNombre);
		Agregar("Cedula:   ",txtDNI);
		Agregar("Dierccion:",direccion);
		Agregar("Telefono:  ",txtTelefono);
		add(cajaVertical);
		
	}
	protected <T> void Agregar (String n,T comp) {
		Box cajaHorizontal = Box.createHorizontalBox();
		JPanel j1 = new JPanel();
		JPanel j2 = new JPanel();
		JLabel titulo = new JLabel(n);
		titulo.setFont(new Font("Arial",Font.BOLD,15));
		titulo.setForeground(Color.WHITE);
		j1.setBackground(color);
		j2.setBackground(color);
		j1.setLayout(new FlowLayout(FlowLayout.LEFT));
		j2.setLayout(new FlowLayout(FlowLayout.LEFT));
		j1.add(titulo);
		j2.add((Component) comp);
		cajaHorizontal.add(j1);
		cajaHorizontal.add(j2);
		cajaVertical.add(cajaHorizontal);
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtDNI() {
		return txtDNI;
	}
	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}
	public JTextArea getTxtDireccion() {
		return txtDireccion;
	}
	public void setTxtDireccion(JTextArea txtDireccion) {
		this.txtDireccion = txtDireccion;
	}
	public JTextField getTxtTelefono() {
		return txtTelefono;
	}
	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
}
