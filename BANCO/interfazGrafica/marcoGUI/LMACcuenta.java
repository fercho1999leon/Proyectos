package interfazGrafica.marcoGUI;
import java.awt.*;
import javax.swing.*;
public class LMACcuenta extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final int tamanoTextF = 15;
	private JTextField txtNumerCuenta;
	private JTextField txtSaldo;
	private ButtonGroup bgEstado;
	private ButtonGroup bgTipo;
	private JRadioButton eInactivo;
	private JRadioButton eActivo;
	private JRadioButton tAhorro;
	private JRadioButton tCorriente;
	protected Box cajaVertical;
	public LMACcuenta() {
		setOpaque(true);
		setBackground(new Color(7,115,157));
		cajaVertical = Box.createVerticalBox();
		setBorder(BorderFactory.createTitledBorder("Datos cuenta"));
		txtNumerCuenta = new JTextField(tamanoTextF);
		txtSaldo = new JTextField(tamanoTextF);
		bgEstado = new ButtonGroup();
		bgTipo = new ButtonGroup();
		eActivo = new JRadioButton("ACTIVO");
		eActivo.setSelected(true);
		eInactivo = new JRadioButton("INACTIVO");
		tAhorro = new JRadioButton("AHORRO");
		tCorriente = new JRadioButton("CORRIENTE");
		tAhorro.setSelected(true);
		bgEstado.add(eActivo);
		bgEstado.add(eInactivo);
		bgTipo.add(tAhorro);
		bgTipo.add(tCorriente);
		Agregar("Numero de cuenta:  ",txtNumerCuenta);
		agregarR(new JLabel("ESTADO DE CUENTA"),10);
		agregarR(eActivo,10);
		agregarR(eInactivo,10);
		agregarR(new JLabel("TIPO DE CUENTA"),10);
		agregarR(tAhorro,10);
		agregarR(tCorriente,10);
		Agregar("Saldo de cuenta:  ",txtSaldo);
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
	public JTextField getTxtNumerCuenta() {
		return txtNumerCuenta;
	}
	public void setTxtNumerCuenta(JTextField txtNumerCuenta) {
		this.txtNumerCuenta = txtNumerCuenta;
	}
	public JTextField getTxtSaldo() {
		return txtSaldo;
	}
	public void setTxtSaldo(JTextField txtSaldo) {
		this.txtSaldo = txtSaldo;
	}
	public JRadioButton geteInactivo() {
		return eInactivo;
	}
	public void seteInactivo(JRadioButton eInactivo) {
		this.eInactivo = eInactivo;
	}
	public JRadioButton geteActivo() {
		return eActivo;
	}
	public void seteActivo(JRadioButton eActivo) {
		this.eActivo = eActivo;
	}
	public JRadioButton gettAhorro() {
		return tAhorro;
	}
	public void settAhorro(JRadioButton tAhorro) {
		this.tAhorro = tAhorro;
	}
	public JRadioButton gettCorriente() {
		return tCorriente;
	}
	public void settCorriente(JRadioButton tCorriente) {
		this.tCorriente = tCorriente;
	}
}
