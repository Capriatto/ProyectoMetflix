package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaTecnicaEmpleado extends JFrame {
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ConsultaTecnicaEmpleado(Administrador admin) {
		getContentPane().setBackground(SystemColor.menu);
		setBackground(Color.WHITE);
		setBounds(100, 100, 388, 277);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("C�dula");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 53, 46, 14);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(78, 50, 279, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CONSULTA T�CNICA");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 13, 279, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConsulta.setBounds(20, 90, 56, 14);
		getContentPane().add(lblConsulta);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(78, 81, 279, 81);
		getContentPane().add(textArea);

		JButton btnEnviar = new JButton("Enviar ");
		btnEnviar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnEnviar.setBounds(266, 171, 91, 23);
		getContentPane().add(btnEnviar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.setBounds(157, 170, 97, 25);
		getContentPane().add(btnSalir);

	}

}
