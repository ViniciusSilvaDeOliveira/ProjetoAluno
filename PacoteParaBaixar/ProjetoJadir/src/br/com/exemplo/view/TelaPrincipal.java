/*Nome: Vinicius Silva de Oliveira
 * RGM: 20710356 
 * Turma: 3°B
 * Período: Noturno
 */

package br.com.exemplo.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.exemplo.dao.NotaFaltasDao;
import br.com.exemplo.dao.PessoaisDao;
import br.com.exemplo.model.NotaFaltas;
import br.com.exemplo.model.Pessoais;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JSeparator separator;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_9;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtData;
	private JLabel lblNewLabel_3;
	private JTextField txtCpf;
	private JLabel lblNewLabel_4;
	private JTextField txtEmail;
	private JLabel lblNewLabel_5;
	private JTextField txtRgmDadosPessoais;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JComboBox cmbUf;
	private JLabel lblNewLabel_8;
	private JTextField txtCelular;
	private JPanel panel_1;
	private JLabel lblNewLabel_9;
	private JComboBox cmbCurso;
	private JLabel lblNewLabel_10;
	private JComboBox cmbCampus;
	private JLabel lblNewLabel_11;
	private JRadioButton chkMatutino;
	private JRadioButton chkVespertino;
	private JRadioButton chkNoturno;
	private JButton btnSalvarCurso;
	private JButton btnAlterarCurso;
	private JButton btnExcluirCurso;
	private JButton btnSairCurso;
	private JPanel panel_2;
	private JLabel lblNewLabel_12;
	private JTextField txtRgmNotas;
	private JLabel lblCursoNotas;
	private JLabel lblNewLabel_15;
	private JComboBox cmbDisciplina;
	private JLabel lblNewLabel_16;
	private JComboBox cmbSemestre;
	private JLabel lblNewLabel_17;
	private JComboBox cmbNota;
	private JLabel lblNewLabel_18;
	private JTextField txtFaltas;
	private JButton btnSalvarNotas;
	private JButton btnAlterarNotas;
	private JButton btnExcluirNotas;
	private JButton btnConsultarNotas;
	private JButton btnSairNotas;
	private final ButtonGroup grupoPeriodo = new ButtonGroup();
	private JPanel panel_3;
	private JLabel lblNewLabel_19;
	private JTextField txtRgmBoletim;
	private JLabel lblCursoBoletim;
	private JButton btnConsultar;
	private JButton btnConsultarCurso;
	private TextArea txtArea;
	private PessoaisDao dao ;
	private NotaFaltasDao daoNotas ;
	private JLabel lblAluno;
	private JComboBox cmbMunicipio;
	private JLabel lblNotas;
	private JButton btnLimpar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 376);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //===================>>>
				
				try {
					// criei o objeto leitor paar pegar os dados da tela 
					Pessoais pessoais = new Pessoais() ;
					pessoais.setRgm(Integer.parseInt(txtRgmDadosPessoais.getText()));
					pessoais.setNome(txtNome.getText());
					pessoais.setDataNascimento(txtData.getText());
					pessoais.setCpf(txtCpf.getText());
					pessoais.setEmail(txtEmail.getText());
					pessoais.setEndereco(txtEndereco.getText());
					pessoais.setMunicipio((String) cmbMunicipio.getSelectedItem());
					pessoais.setUf((String) cmbUf.getSelectedItem());
					pessoais.setCelular(txtCelular.getText());
					pessoais.setCurso((String) cmbCurso.getSelectedItem());
					String curso = pessoais.getCurso();
					if(curso.equals("Selecione o Curso")) {
						lblAluno.setText("Selecione o curso para salvar");
					} else {
						
					pessoais.setCampus((String) cmbCampus.getSelectedItem());
					String campus = pessoais.getCampus();
					if(campus.equals("Selecione o Campus")) {
						lblAluno.setText("Selecione o campus para salvar");
					} else {
						
					if(chkMatutino.isSelected()) {
						pessoais.setPeriodo("Matutino");
						//abrir a conexão
						dao = new PessoaisDao() ;
						// salvar
						dao.salvar(pessoais);
						lblAluno.setText("Salvo com sucesso");
					}
					else if(chkVespertino.isSelected()) {
						pessoais.setPeriodo("Vespertino");
						//abrir a conexão
						dao = new PessoaisDao() ;
						// salvar
						dao.salvar(pessoais);
						lblAluno.setText("Salvo com sucesso");
					}
					else if(chkNoturno.isSelected()) {
						pessoais.setPeriodo("Noturno");
						//abrir a conexão
						dao = new PessoaisDao() ;
						// salvar
						dao.salvar(pessoais);
						lblAluno.setText("Salvo com sucesso");
					}
					else {
						lblAluno.setText("Selecione o período para salvar.");
					}
					
					}
				}
				}catch(Exception e1) {
					lblAluno.setText("Erro ao salvar");
				}
				
				//===================>>>
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================>>
				try {
					Pessoais pessoais = new Pessoais() ;
					pessoais.setRgm(Integer.parseInt(txtRgmDadosPessoais.getText()));
					pessoais.setNome(txtNome.getText());
					pessoais.setDataNascimento(txtData.getText());
					pessoais.setCpf(txtCpf.getText());
					pessoais.setEmail(txtEmail.getText());
					pessoais.setEndereco(txtEndereco.getText());
					pessoais.setMunicipio((String) cmbMunicipio.getSelectedItem());
					pessoais.setUf((String) cmbUf.getSelectedItem());
					pessoais.setCelular(txtCelular.getText());
					pessoais.setCurso((String) cmbCurso.getSelectedItem());
					String curso = pessoais.getCurso();
					if(curso.equals("Selecione o Curso")) {
						lblAluno.setText("Selecione o curso para alterar.");
					} else {
						
					pessoais.setCampus((String) cmbCampus.getSelectedItem());
					String campus = pessoais.getCampus();
					if(campus.equals("Selecione o Campus")) {
						lblAluno.setText("Selecione o campus para alterar.");
					} else {
					if(chkMatutino.isSelected()) {
						pessoais.setPeriodo("Matutino");
						dao = new PessoaisDao() ;
						dao.alterar(pessoais);
						lblAluno.setText("Alterado com sucesso");
					}
					else if(chkVespertino.isSelected()) {
						pessoais.setPeriodo("Vespertino");
						dao = new PessoaisDao() ;
						dao.alterar(pessoais);
						lblAluno.setText("Alterado com sucesso");
					}
					else if(chkNoturno.isSelected()) {
						pessoais.setPeriodo("Noturno");
						dao = new PessoaisDao() ;
						dao.alterar(pessoais);
						lblAluno.setText("Alterado com sucesso");
					}
					else {
						lblAluno.setText("Selecione o período para alterar.");
					}
					
				}
			}	
				}catch(Exception e1) {
					lblAluno.setText("Erro ao alterar");
				}
				//====================>>
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             //========================>>
				
				try {
					dao = new PessoaisDao() ;
					int rgm = Integer.parseInt(txtRgmDadosPessoais.getText()) ;
					Pessoais pessoais = dao.consultar(rgm) ;
					txtNome.setText(pessoais.getNome());
					txtData.setText(pessoais.getDataNascimento());
					txtCpf.setText(pessoais.getCpf());
					txtEmail.setText(pessoais.getEmail());
					txtEndereco.setText(pessoais.getEndereco());
					String municipio = pessoais.getMunicipio() ;
					if(municipio.equals("São Paulo")) {
						cmbMunicipio.setSelectedIndex(0);
					}
					else if(municipio.equals("Rio de Janeiro")) {
						cmbMunicipio.setSelectedIndex(1);
					}
					String uf = pessoais.getUf() ;
					if(uf.equals("SP")) {
						cmbUf.setSelectedIndex(0);
					}
					else if(uf.equals("RJ")) {
						cmbUf.setSelectedIndex(1) ;
					}
					txtCelular.setText(pessoais.getCelular());
					String curso = pessoais.getCurso() ;
					if(curso.equals("Análise e Desenvolvimento de Sistemas")) {
						cmbCurso.setSelectedIndex(1);
					}
					else if(curso.equals("Redes de Computadores")) {
						cmbCurso.setSelectedIndex(2);
					}
					else if(curso.equals("Ciência da Computação")) {
						cmbCurso.setSelectedIndex(3);
					}
					
					String campus = pessoais.getCampus() ;
					if(campus.equals("Selecione o Campus")) {
						cmbCampus.setSelectedIndex(0);
					}
					else if(campus.equals("Anália Franco")) {
						cmbCampus.setSelectedIndex(1);
					}
					else {
						cmbCampus.setSelectedIndex(2);
					}
					
					String periodo = pessoais.getPeriodo();
					if(periodo.equals("Matutino")) {
						chkMatutino.setSelected(true);
					}
					else if(periodo.equals("Vespertino")) {
						chkVespertino.setSelected(true);
					}
					else if(periodo.equals("Noturno")) {
						chkNoturno.setSelected(true);
					}
					lblAluno.setText("Consultado com sucesso");				
					
				} catch (Exception e1) {
					lblAluno.setText("Erro ao Consultar");
				}
				
				//========================>>
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 //=======================>>
				
				try {
					dao = new PessoaisDao() ;
					int rgm = Integer.parseInt(txtRgmDadosPessoais.getText()) ;
					dao.excluir(rgm);
					lblAluno.setText("Excluido com sucesso");
				}
				catch(Exception e1) {
					lblAluno.setText("Erro ao excluir");
				}
				
				//=======================>>
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		separator = new JSeparator();
		mnNewMenu.add(separator);
		
		mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=================>>
				
				System.exit(0);
				
				//=================>>
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		mnNewMenu_1 = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_5 = new JMenuItem("Salvar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========================>>
				try {
					// criei o objeto leitor paar pegar os dados da tela 
					NotaFaltas notaFaltas = new NotaFaltas() ;
					notaFaltas.setRgmNotas(Integer.parseInt(txtRgmNotas.getText()));
					notaFaltas.setDisciplina((String) cmbDisciplina.getSelectedItem());
					String disciplina = notaFaltas.getDisciplina();
					if(disciplina.equals("Selecione a Disciplina")) {
						lblNotas.setText("Selecione a disciplina para salvar");
					} else {
					
					notaFaltas.setSemestre((String) cmbSemestre.getSelectedItem());
					notaFaltas.setNota((String) cmbNota.getSelectedItem());
					notaFaltas.setFaltas(txtFaltas.getText());
					String faltas = notaFaltas.getFaltas() ;
					if (faltas.equals("")) {
						lblNotas.setText("Informe as faltas para salvar.");
					}
					else {
						daoNotas = new NotaFaltasDao() ;
						// salvar
						daoNotas.salvar(notaFaltas);
						lblNotas.setText("Salvo com sucesso");
					}
					
					}
				}catch(Exception e1) {
					lblNotas.setText("Erro ao salvar");
				}				
				//==========================>>
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_6 = new JMenuItem("Alterar");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================>>
				try {
					NotaFaltas notaFaltas = new NotaFaltas() ;
					notaFaltas.setRgmNotas(Integer.parseInt(txtRgmNotas.getText()));
					notaFaltas.setDisciplina((String) cmbDisciplina.getSelectedItem());
					String disciplina = notaFaltas.getDisciplina();
					if(disciplina.equals("Selecione a Disciplina")) {
						lblNotas.setText("Selecione a disciplina para alterar");
					} else {
					notaFaltas.setSemestre((String) cmbSemestre.getSelectedItem());
					notaFaltas.setNota((String) cmbNota.getSelectedItem());
					notaFaltas.setFaltas(txtFaltas.getText());
					String faltas = notaFaltas.getFaltas() ;
					if (faltas.equals("")) {
						lblNotas.setText("Preencha as faltas para alterar.");
					}
					else {
						daoNotas = new NotaFaltasDao() ;
						
						daoNotas.alterar(notaFaltas);
						
						lblNotas.setText("Alterado com sucesso");
					}
				}	
			}catch(Exception e1) {
					lblNotas.setText("Erro ao alterar");
					System.out.println(e1.getMessage());
				}
							
				//====================>>
			}
		});
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		mntmNewMenuItem_7 = new JMenuItem("Excluir");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              //=======================>>
				
				try {
					daoNotas = new NotaFaltasDao() ;
					int rgmNotas = Integer.parseInt(txtRgmNotas.getText()) ;
					String disciplina = (String) cmbDisciplina.getSelectedItem() ;
					daoNotas.excluir(rgmNotas, disciplina);
					lblNotas.setText("Excluido com sucesso");
				}
				catch(Exception e1) {
					lblNotas.setText("Erro ao excluir");
					System.out.println(e1.getMessage());
				}
				
				//=======================>>
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		mntmNewMenuItem_8 = new JMenuItem("Consultar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//======================>>
				try {
					dao = new PessoaisDao() ;
					int rgm = Integer.parseInt(txtRgmNotas.getText()) ;
					Pessoais pessoais = dao.consultar(rgm) ;
					lblNotas.setText(pessoais.getNome());
				
					String curso = pessoais.getCurso() ;
					if(curso.equals("Análise e Desenvolvimento de Sistemas")) {
						cmbCurso.setSelectedIndex(1);
					}
					else if(curso.equals("Redes de Computadores")) {
						cmbCurso.setSelectedIndex(2);
					}
					else if(curso.equals("Ciência da Computação")) {
						cmbCurso.setSelectedIndex(3);
					}
					lblCursoNotas.setText(curso);
					lblNotas.setText("Consultado com sucesso");
				}
				catch(Exception e1) {
					lblNotas.setText("Erro ao Consultar");
				}
				
				try {
					daoNotas = new NotaFaltasDao() ;
					int rgmNotas = Integer.parseInt(txtRgmNotas.getText()) ;
					String disciplina = (String) cmbDisciplina.getSelectedItem() ;
					
					if(disciplina.equals("Análise e Projeto deSistemas")) {
						cmbDisciplina.setSelectedIndex(1);
					}
					else if(disciplina.equals("Banco de Dados")) {
						cmbDisciplina.setSelectedIndex(2);
					}
					else if(disciplina.equals("Fundamentos de Estrutura de Dados")) {
						cmbDisciplina.setSelectedIndex(3);
					}
					else if(disciplina.equals("Programação Orientada a Objeto")) {
						cmbDisciplina.setSelectedIndex(4);
					}
					else if(disciplina.equals("Técnicas de Programação")) {
						cmbDisciplina.setSelectedIndex(5);
					}
					
					NotaFaltas notaFaltas = daoNotas.consulta(rgmNotas, disciplina) ;
					
					//String disciplina1 = notaFaltas.getDisciplina() ;
					
					
					String semestre = notaFaltas.getSemestre() ;
					if(semestre.equals("2019-1")) {
						cmbSemestre.setSelectedIndex(0);
					}
					else if(semestre.equals("2019-2")) {
						cmbSemestre.setSelectedIndex(1);
					}
					else if(semestre.equals("2020-1")) {
						cmbSemestre.setSelectedIndex(2);
					}
					
					String nota = notaFaltas.getNota() ;
					if(nota.equals("0,0")) {
						cmbNota.setSelectedIndex(0);
					}
					else if(nota.equals("0,5")) {
						cmbNota.setSelectedIndex(1);
					}
					else if(nota.equals("1,0")) {
						cmbNota.setSelectedIndex(2);
					}
					else if(nota.equals("1,5")) {
						cmbNota.setSelectedIndex(3);
					}
					else if(nota.equals("2,0")) {
						cmbNota.setSelectedIndex(4);
					}
					else if(nota.equals("2,5")) {
						cmbNota.setSelectedIndex(5);
					}
					else if(nota.equals("3,0")) {
						cmbNota.setSelectedIndex(6);
					}
					else if(nota.equals("3,5")) {
						cmbNota.setSelectedIndex(7);
					}
					else if(nota.equals("4,0")) {
						cmbNota.setSelectedIndex(8);
					}
					else if(nota.equals("4,5")) {
						cmbNota.setSelectedIndex(9);
					}
					else if(nota.equals("5,0")) {
						cmbNota.setSelectedIndex(10);
					}
					else if(nota.equals("5,5")) {
						cmbNota.setSelectedIndex(11);
					}
					else if(nota.equals("6,0")) {
						cmbNota.setSelectedIndex(12);
					}
					else if(nota.equals("6,5")) {
						cmbNota.setSelectedIndex(13);
					}
					else if(nota.equals("7,0")) {
						cmbNota.setSelectedIndex(14);
					}
					else if(nota.equals("7,5")) {
						cmbNota.setSelectedIndex(15);
					}
					else if(nota.equals("8,0")) {
						cmbNota.setSelectedIndex(16);
					}
					else if(nota.equals("8,5")) {
						cmbNota.setSelectedIndex(17);
					}
					else if(nota.equals("9,0")) {
						cmbNota.setSelectedIndex(18);
					}
					else if(nota.equals("9,5")) {
						cmbNota.setSelectedIndex(19);
					}
					else if(nota.equals("10,0")) {
						cmbNota.setSelectedIndex(20);
					}
					
					txtFaltas.setText(notaFaltas.getFaltas());
					
					lblNotas.setText("Consultado com sucesso");				
					
				} catch (Exception e1) {
					lblNotas.setText("Erro ao Consultar");
				}
				
				//======================>>
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		mnNewMenu_2 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_9 = new JMenuItem("Sobre");
		mnNewMenu_2.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 27, 485, 275);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		panel.setToolTipText("");
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("RGM:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 30, 36, 19);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(179, 30, 44, 19);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Data de Nascimento:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 65, 139, 19);
		panel.add(lblNewLabel_2);
		
		
		txtData = new JFormattedTextField(new MaskFormatter(" ##/##/####"));
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtData.setBounds(161, 64, 96, 20);
		panel.add(txtData);
		txtData.setColumns(10);
		
		lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(267, 65, 30, 19);
		panel.add(lblNewLabel_3);
		
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCpf.setBounds(307, 64, 163, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 99, 40, 19);
		panel.add(lblNewLabel_4);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(56, 98, 414, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Endere\u00E7o:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 134, 65, 19);
		panel.add(lblNewLabel_5);
		
		txtRgmDadosPessoais = new JTextField();
		txtRgmDadosPessoais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRgmDadosPessoais.setBounds(53, 31, 116, 20);
		panel.add(txtRgmDadosPessoais);
		txtRgmDadosPessoais.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNome.setBounds(233, 31, 237, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEndereco.setBounds(85, 135, 385, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Munic\u00EDpio:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 170, 65, 19);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("UF:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(211, 170, 23, 19);
		panel.add(lblNewLabel_7);
		
		cmbUf = new JComboBox();
		cmbUf.setModel(new DefaultComboBoxModel(new String[] {"SP", "RJ"}));
		cmbUf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbUf.setBounds(244, 168, 44, 22);
		panel.add(cmbUf);
		
		lblNewLabel_8 = new JLabel("Celular:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(295, 170, 49, 19);
		panel.add(lblNewLabel_8);
		
		txtCelular = new JFormattedTextField(new MaskFormatter("(##)#########"));
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCelular.setBounds(354, 169, 116, 20);
		panel.add(txtCelular);
		txtCelular.setColumns(10);
		
		cmbMunicipio = new JComboBox();
		cmbMunicipio.setModel(new DefaultComboBoxModel(new String[] {"S\u00E3o Paulo", "Rio de Janeiro"}));
		cmbMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbMunicipio.setBounds(85, 170, 116, 22);
		panel.add(cmbMunicipio);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel_9 = new JLabel("Curso:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(10, 25, 42, 19);
		panel_1.add(lblNewLabel_9);
		
		cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Selecione o Curso", "An\u00E1lise e Desenvolvimento de Sistemas", "Redes de Computadores", "Ci\u00EAncia da Computa\u00E7\u00E3o"}));
		cmbCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbCurso.setBounds(62, 25, 408, 22);
		panel_1.add(cmbCurso);
		
		lblNewLabel_10 = new JLabel("Campus:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(10, 62, 58, 19);
		panel_1.add(lblNewLabel_10);
		
		cmbCampus = new JComboBox();
		cmbCampus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Selecione o Campus", "An\u00E1lia Franco", "Tatuap\u00E9"}));
		cmbCampus.setBounds(78, 62, 392, 22);
		panel_1.add(cmbCampus);
		
		lblNewLabel_11 = new JLabel("Per\u00EDodo:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(10, 97, 53, 19);
		panel_1.add(lblNewLabel_11);
		
		chkMatutino = new JRadioButton("Matutino");
		grupoPeriodo.add(chkMatutino);
		chkMatutino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkMatutino.setBounds(78, 93, 83, 27);
		panel_1.add(chkMatutino);
		
		chkVespertino = new JRadioButton("Vespertino");
		grupoPeriodo.add(chkVespertino);
		chkVespertino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkVespertino.setBounds(163, 93, 95, 27);
		panel_1.add(chkVespertino);
		
		chkNoturno = new JRadioButton("Noturno");
		grupoPeriodo.add(chkNoturno);
		chkNoturno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkNoturno.setBounds(260, 93, 77, 27);
		panel_1.add(chkNoturno);
		
		btnSalvarCurso = new JButton("");
		btnSalvarCurso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//===================>>>
				
				try {
					// criei o objeto leitor paar pegar os dados da tela 
					Pessoais pessoais = new Pessoais() ;
					pessoais.setRgm(Integer.parseInt(txtRgmDadosPessoais.getText()));
					pessoais.setNome(txtNome.getText());
					pessoais.setDataNascimento(txtData.getText());
					pessoais.setCpf(txtCpf.getText());
					pessoais.setEmail(txtEmail.getText());
					pessoais.setEndereco(txtEndereco.getText());
					pessoais.setMunicipio((String) cmbMunicipio.getSelectedItem());
					pessoais.setUf((String) cmbUf.getSelectedItem());
					pessoais.setCelular(txtCelular.getText());
					pessoais.setCurso((String) cmbCurso.getSelectedItem());
					String curso = pessoais.getCurso();
					if(curso.equals("Selecione o Curso")) {
						lblAluno.setText("Selecione o curso para salvar");
					} else {
						
					pessoais.setCampus((String) cmbCampus.getSelectedItem());
					String campus = pessoais.getCampus();
					if(campus.equals("Selecione o Campus")) {
						lblAluno.setText("Selecione o campus para salvar");
					} else {
						
					if(chkMatutino.isSelected()) {
						pessoais.setPeriodo("Matutino");
						//abrir a conexão
						dao = new PessoaisDao() ;
						// salvar
						dao.salvar(pessoais);
						lblAluno.setText("Salvo com sucesso");
					}
					else if(chkVespertino.isSelected()) {
						pessoais.setPeriodo("Vespertino");
						//abrir a conexão
						dao = new PessoaisDao() ;
						// salvar
						dao.salvar(pessoais);
						lblAluno.setText("Salvo com sucesso");
					}
					else if(chkNoturno.isSelected()) {
						pessoais.setPeriodo("Noturno");
						//abrir a conexão
						dao = new PessoaisDao() ;
						// salvar
						dao.salvar(pessoais);
						lblAluno.setText("Salvo com sucesso");
					}
					else {
						lblAluno.setText("Selecione o período para salvar.");
					}
					
					}
				}
				}catch(Exception e1) {
					lblAluno.setText("Erro ao salvar");
				}
				
				//===================>>>
			}
		});
		btnSalvarCurso.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\salve- (1).png"));
		btnSalvarCurso.setBounds(10, 127, 83, 73);
		panel_1.add(btnSalvarCurso);
		
		btnAlterarCurso = new JButton("");
		btnAlterarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================>>
				try {
					Pessoais pessoais = new Pessoais() ;
					pessoais.setRgm(Integer.parseInt(txtRgmDadosPessoais.getText()));
					pessoais.setNome(txtNome.getText());
					pessoais.setDataNascimento(txtData.getText());
					pessoais.setCpf(txtCpf.getText());
					pessoais.setEmail(txtEmail.getText());
					pessoais.setEndereco(txtEndereco.getText());
					pessoais.setMunicipio((String) cmbMunicipio.getSelectedItem());
					pessoais.setUf((String) cmbUf.getSelectedItem());
					pessoais.setCelular(txtCelular.getText());
					pessoais.setCurso((String) cmbCurso.getSelectedItem());
					String curso = pessoais.getCurso();
					if(curso.equals("Selecione o Curso")) {
						lblAluno.setText("Selecione o curso para alterar.");
					} else {
						
					pessoais.setCampus((String) cmbCampus.getSelectedItem());
					String campus = pessoais.getCampus();
					if(campus.equals("Selecione o Campus")) {
						lblAluno.setText("Selecione o campus para alterar.");
					} else {
					if(chkMatutino.isSelected()) {
						pessoais.setPeriodo("Matutino");
						dao = new PessoaisDao() ;
						dao.alterar(pessoais);
						lblAluno.setText("Alterado com sucesso");
					}
					else if(chkVespertino.isSelected()) {
						pessoais.setPeriodo("Vespertino");
						dao = new PessoaisDao() ;
						dao.alterar(pessoais);
						lblAluno.setText("Alterado com sucesso");
					}
					else if(chkNoturno.isSelected()) {
						pessoais.setPeriodo("Noturno");
						dao = new PessoaisDao() ;
						dao.alterar(pessoais);
						lblAluno.setText("Alterado com sucesso");
					}
					else {
						lblAluno.setText("Selecione o período para alterar.");
					}
					
				}
			}	
				}catch(Exception e1) {
					lblAluno.setText("Erro ao alterar");
				}
				
				
				
				//====================>>
			}
		});
		btnAlterarCurso.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\troca.png"));
		btnAlterarCurso.setBounds(103, 127, 83, 73);
		panel_1.add(btnAlterarCurso);
		
		btnExcluirCurso = new JButton("");
		btnExcluirCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=======================>>
				try {
					dao = new PessoaisDao() ;
					int rgm = Integer.parseInt(txtRgmDadosPessoais.getText()) ;
					dao.excluir(rgm);
					lblAluno.setText("Excluido com sucesso");
				}
				catch(Exception e1) {
					lblAluno.setText("Erro ao excluir");
				}
				//=======================>>
			}
		});
		btnExcluirCurso.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\excluir.png"));
		btnExcluirCurso.setBounds(196, 127, 83, 73);
		panel_1.add(btnExcluirCurso);
		
		btnSairCurso = new JButton("");
		btnSairCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===========>>>
				
				System.exit(0);
				
				//===========>>>
			}
		});
		btnSairCurso.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\sair.png"));
		btnSairCurso.setBounds(382, 127, 83, 73);
		panel_1.add(btnSairCurso);
		
		btnConsultarCurso = new JButton("");
		btnConsultarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//========================>>
				
				try {
					dao = new PessoaisDao() ;
					int rgm = Integer.parseInt(txtRgmDadosPessoais.getText()) ;
					Pessoais pessoais = dao.consultar(rgm) ;
					txtNome.setText(pessoais.getNome());
					txtData.setText(pessoais.getDataNascimento());
					txtCpf.setText(pessoais.getCpf());
					txtEmail.setText(pessoais.getEmail());
					txtEndereco.setText(pessoais.getEndereco());
					String municipio = pessoais.getMunicipio() ;
					if(municipio.equals("São Paulo")) {
						cmbMunicipio.setSelectedIndex(0);
					}
					else if(municipio.equals("Rio de Janeiro")) {
						cmbMunicipio.setSelectedIndex(1);
					}
					String uf = pessoais.getUf() ;
					if(uf.equals("SP")) {
						cmbUf.setSelectedIndex(0);
					}
					else if(uf.equals("RJ")) {
						cmbUf.setSelectedIndex(1) ;
					}
					txtCelular.setText(pessoais.getCelular());
					String curso = pessoais.getCurso() ;
					if(curso.equals("Análise e Desenvolvimento de Sistemas")) {
						cmbCurso.setSelectedIndex(1);
					}
					else if(curso.equals("Redes de Computadores")) {
						cmbCurso.setSelectedIndex(2);
					}
					else if(curso.equals("Ciência da Computação")) {
						cmbCurso.setSelectedIndex(3);
					}
					
					String campus = pessoais.getCampus() ;
					if(campus.equals("Selecione o Campus")) {
						cmbCampus.setSelectedIndex(0);
					}
					else if(campus.equals("Anália Franco")) {
						cmbCampus.setSelectedIndex(1);
					}
					else {
						cmbCampus.setSelectedIndex(2);
					}
					
					String periodo = pessoais.getPeriodo();
					if(periodo.equals("Matutino")) {
						chkMatutino.setSelected(true);
					}
					else if(periodo.equals("Vespertino")) {
						chkVespertino.setSelected(true);
					}
					else if(periodo.equals("Noturno")) {
						chkNoturno.setSelected(true);
					}
					lblAluno.setText("Consultado com sucesso");				
					
				} catch (Exception e1) {
					lblAluno.setText("Erro ao Consultar");
				}
				
				//========================>>
			}
		});
		btnConsultarCurso.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\lupa.png"));
		btnConsultarCurso.setBounds(289, 127, 83, 73);
		panel_1.add(btnConsultarCurso);
		
		lblAluno = new JLabel("");
		lblAluno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.RED, Color.BLUE));
		lblAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAluno.setBounds(10, 211, 460, 25);
		panel_1.add(lblAluno);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblNewLabel_12 = new JLabel("RGM:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(10, 29, 36, 19);
		panel_2.add(lblNewLabel_12);
		
		txtRgmNotas = new JTextField();
		txtRgmNotas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRgmNotas.setBounds(56, 30, 107, 20);
		panel_2.add(txtRgmNotas);
		txtRgmNotas.setColumns(10);
		
		JLabel lblNomeNotas = new JLabel("");
		lblNomeNotas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeNotas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.RED, Color.BLUE));
		lblNomeNotas.setBounds(185, 29, 285, 18);
		panel_2.add(lblNomeNotas);
		
		lblCursoNotas = new JLabel("");
		lblCursoNotas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCursoNotas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.RED, Color.BLUE));
		lblCursoNotas.setBounds(10, 59, 460, 18);
		panel_2.add(lblCursoNotas);
		
		lblNewLabel_15 = new JLabel("Disciplina:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_15.setBounds(10, 88, 65, 19);
		panel_2.add(lblNewLabel_15);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setModel(new DefaultComboBoxModel(new String[] {"Selecione a Disciplina", "An\u00E1lise e Projeto de Sistemas", "Banco de Dados", "Fundamentos de Estrutura de Dados", "Programa\u00E7\u00E3o Orientada a Objeto", "T\u00E9cnicas de Programa\u00E7\u00E3o"}));
		cmbDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbDisciplina.setBounds(85, 88, 385, 22);
		panel_2.add(cmbDisciplina);
		
		lblNewLabel_16 = new JLabel("Semestre:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_16.setBounds(10, 121, 67, 19);
		panel_2.add(lblNewLabel_16);
		
		cmbSemestre = new JComboBox();
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"2019-1", "2019-2", "2020-1"}));
		cmbSemestre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbSemestre.setBounds(85, 121, 78, 22);
		panel_2.add(cmbSemestre);
		
		lblNewLabel_17 = new JLabel("Nota:");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17.setBounds(185, 121, 36, 19);
		panel_2.add(lblNewLabel_17);
		
		cmbNota = new JComboBox();
		cmbNota.setModel(new DefaultComboBoxModel(new String[] {"0,0", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0", "3,5", "4,0", "4,5", "5,0", "5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10,0"}));
		cmbNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbNota.setBounds(233, 121, 60, 22);
		panel_2.add(cmbNota);
		
		lblNewLabel_18 = new JLabel("Faltas:");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18.setBounds(303, 121, 44, 19);
		panel_2.add(lblNewLabel_18);
		
		txtFaltas = new JTextField();
		txtFaltas.setBounds(357, 122, 113, 20);
		panel_2.add(txtFaltas);
		txtFaltas.setColumns(10);
		
		btnSalvarNotas = new JButton("");
		btnSalvarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========================>>
				try {
					// criei o objeto leitor paar pegar os dados da tela 
					NotaFaltas notaFaltas = new NotaFaltas() ;
					notaFaltas.setRgmNotas(Integer.parseInt(txtRgmNotas.getText()));
					notaFaltas.setDisciplina((String) cmbDisciplina.getSelectedItem());
					String disciplina = notaFaltas.getDisciplina();
					if(disciplina.equals("Selecione a Disciplina")) {
						lblNotas.setText("Selecione a disciplina para salvar");
					} else {
					
					notaFaltas.setSemestre((String) cmbSemestre.getSelectedItem());
					notaFaltas.setNota((String) cmbNota.getSelectedItem());
					notaFaltas.setFaltas(txtFaltas.getText());
					String faltas = notaFaltas.getFaltas() ;
					if (faltas.equals("")) {
						lblNotas.setText("Informe as faltas para salvar.");
					}
					else {
						daoNotas = new NotaFaltasDao() ;
						// salvar
						daoNotas.salvar(notaFaltas);
						lblNotas.setText("Salvo com sucesso");
					}
					
					}
				}catch(Exception e1) {
					lblNotas.setText("Erro ao salvar");
				}				
				//==========================>>
			}
		});
		btnSalvarNotas.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\salve- (1).png"));
		btnSalvarNotas.setBounds(10, 151, 83, 68);
		panel_2.add(btnSalvarNotas);
		
		btnAlterarNotas = new JButton("");
		btnAlterarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================>>
				try {
					NotaFaltas notaFaltas = new NotaFaltas() ;
					notaFaltas.setRgmNotas(Integer.parseInt(txtRgmNotas.getText()));
					notaFaltas.setDisciplina((String) cmbDisciplina.getSelectedItem());
					String disciplina = notaFaltas.getDisciplina();
					if(disciplina.equals("Selecione a Disciplina")) {
						lblNotas.setText("Selecione a disciplina para alterar");
					} else {
					notaFaltas.setSemestre((String) cmbSemestre.getSelectedItem());
					notaFaltas.setNota((String) cmbNota.getSelectedItem());
					notaFaltas.setFaltas(txtFaltas.getText());
					String faltas = notaFaltas.getFaltas() ;
					if (faltas.equals("")) {
						lblNotas.setText("Preencha as faltas para alterar.");
					}
					else {
						daoNotas = new NotaFaltasDao() ;
						
						daoNotas.alterar(notaFaltas);
						
						lblNotas.setText("Alterado com sucesso");
					}
				}	
			}catch(Exception e1) {
					lblNotas.setText("Erro ao alterar");
					System.out.println(e1.getMessage());
				}
							
				//====================>>
			}
		});
		btnAlterarNotas.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\troca.png"));
		btnAlterarNotas.setBounds(103, 151, 83, 68);
		panel_2.add(btnAlterarNotas);
		
		btnExcluirNotas = new JButton("");
		btnExcluirNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=======================>>
				
				try {
					daoNotas = new NotaFaltasDao() ;
					int rgmNotas = Integer.parseInt(txtRgmNotas.getText()) ;
					String disciplina = (String) cmbDisciplina.getSelectedItem() ;
					
					if(disciplina.equals("Selecione a Disciplina")) {
						lblNotas.setText("Erro ao excluir, selecione a disciplina");
					}
					else {
						daoNotas.excluir(rgmNotas, disciplina);
						lblNotas.setText("Excluido com sucesso");
					}
					
				}
				catch(Exception e1) {
					lblNotas.setText("Erro ao excluir");
					System.out.println(e1.getMessage());
				}
				
				//=======================>>
			}
		});
		btnExcluirNotas.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\excluir.png"));
		btnExcluirNotas.setBounds(195, 151, 83, 68);
		panel_2.add(btnExcluirNotas);
		
		btnConsultarNotas = new JButton("");
		btnConsultarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//======================>>
				try {
					dao = new PessoaisDao() ;
					int rgm = Integer.parseInt(txtRgmNotas.getText()) ;
					Pessoais pessoais = dao.consultar(rgm) ;
					lblNomeNotas.setText(pessoais.getNome());
				
					String curso = pessoais.getCurso() ;
					if(curso.equals("Análise e Desenvolvimento de Sistemas")) {
						cmbCurso.setSelectedIndex(1);
					}
					else if(curso.equals("Redes de Computadores")) {
						cmbCurso.setSelectedIndex(2);
					}
					else if(curso.equals("Ciência da Computação")) {
						cmbCurso.setSelectedIndex(3);
					}
					lblCursoNotas.setText(curso);
					lblNotas.setText("Consultado com sucesso");
				}
				catch(Exception e1) {
					lblNotas.setText("Erro ao Consultar");
				}
				
				try {
					daoNotas = new NotaFaltasDao() ;
					int rgmNotas = Integer.parseInt(txtRgmNotas.getText()) ;
					String disciplina = (String) cmbDisciplina.getSelectedItem() ;
					
					if(disciplina.equals("Análise e Projeto deSistemas")) {
						cmbDisciplina.setSelectedIndex(1);
					}
					else if(disciplina.equals("Banco de Dados")) {
						cmbDisciplina.setSelectedIndex(2);
					}
					else if(disciplina.equals("Fundamentos de Estrutura de Dados")) {
						cmbDisciplina.setSelectedIndex(3);
					}
					else if(disciplina.equals("Programação Orientada a Objeto")) {
						cmbDisciplina.setSelectedIndex(4);
					}
					else if(disciplina.equals("Técnicas de Programação")) {
						cmbDisciplina.setSelectedIndex(5);
					}
					
					NotaFaltas notaFaltas = daoNotas.consulta(rgmNotas, disciplina) ;
					
					//String disciplina1 = notaFaltas.getDisciplina() ;
					
					
					String semestre = notaFaltas.getSemestre() ;
					if(semestre.equals("2019-1")) {
						cmbSemestre.setSelectedIndex(0);
					}
					else if(semestre.equals("2019-2")) {
						cmbSemestre.setSelectedIndex(1);
					}
					else if(semestre.equals("2020-1")) {
						cmbSemestre.setSelectedIndex(2);
					}
					
					String nota = notaFaltas.getNota() ;
					if(nota.equals("0,0")) {
						cmbNota.setSelectedIndex(0);
					}
					else if(nota.equals("0,5")) {
						cmbNota.setSelectedIndex(1);
					}
					else if(nota.equals("1,0")) {
						cmbNota.setSelectedIndex(2);
					}
					else if(nota.equals("1,5")) {
						cmbNota.setSelectedIndex(3);
					}
					else if(nota.equals("2,0")) {
						cmbNota.setSelectedIndex(4);
					}
					else if(nota.equals("2,5")) {
						cmbNota.setSelectedIndex(5);
					}
					else if(nota.equals("3,0")) {
						cmbNota.setSelectedIndex(6);
					}
					else if(nota.equals("3,5")) {
						cmbNota.setSelectedIndex(7);
					}
					else if(nota.equals("4,0")) {
						cmbNota.setSelectedIndex(8);
					}
					else if(nota.equals("4,5")) {
						cmbNota.setSelectedIndex(9);
					}
					else if(nota.equals("5,0")) {
						cmbNota.setSelectedIndex(10);
					}
					else if(nota.equals("5,5")) {
						cmbNota.setSelectedIndex(11);
					}
					else if(nota.equals("6,0")) {
						cmbNota.setSelectedIndex(12);
					}
					else if(nota.equals("6,5")) {
						cmbNota.setSelectedIndex(13);
					}
					else if(nota.equals("7,0")) {
						cmbNota.setSelectedIndex(14);
					}
					else if(nota.equals("7,5")) {
						cmbNota.setSelectedIndex(15);
					}
					else if(nota.equals("8,0")) {
						cmbNota.setSelectedIndex(16);
					}
					else if(nota.equals("8,5")) {
						cmbNota.setSelectedIndex(17);
					}
					else if(nota.equals("9,0")) {
						cmbNota.setSelectedIndex(18);
					}
					else if(nota.equals("9,5")) {
						cmbNota.setSelectedIndex(19);
					}
					else if(nota.equals("10,0")) {
						cmbNota.setSelectedIndex(20);
					}
					
					txtFaltas.setText(notaFaltas.getFaltas());
					
					lblNotas.setText("Consultado com sucesso");				
					
				} catch (Exception e1) {
					lblNotas.setText("Erro ao Consultar");
				}
				
				//======================>>
			}
		});
		btnConsultarNotas.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\lupa.png"));
		btnConsultarNotas.setBounds(288, 151, 83, 68);
		panel_2.add(btnConsultarNotas);
		
		btnSairNotas = new JButton("");
		btnSairNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===========================>>
				
				System.exit(0);
				
				//===========================>>
			}
		});
		btnSairNotas.setIcon(new ImageIcon("C:\\Users\\55119\\Desktop\\\u00CDcones Java\\sair.png"));
		btnSairNotas.setBounds(381, 151, 83, 68);
		panel_2.add(btnSairNotas);
		
		lblNotas = new JLabel("");
		lblNotas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.RED, Color.BLUE));
		lblNotas.setBounds(10, 222, 460, 14);
		panel_2.add(lblNotas);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		lblNewLabel_19 = new JLabel("RGM:");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_19.setBounds(10, 11, 36, 19);
		panel_3.add(lblNewLabel_19);
		
		txtRgmBoletim = new JTextField();
		txtRgmBoletim.setBounds(56, 12, 96, 20);
		panel_3.add(txtRgmBoletim);
		txtRgmBoletim.setColumns(10);
		
		JLabel lblNomeBoletim = new JLabel("");
		lblNomeBoletim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.RED, Color.BLUE));
		lblNomeBoletim.setBounds(10, 41, 460, 28);
		panel_3.add(lblNomeBoletim);
		
		lblCursoBoletim = new JLabel("");
		lblCursoBoletim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCursoBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.RED, Color.BLUE));
		lblCursoBoletim.setBounds(10, 80, 460, 28);
		panel_3.add(lblCursoBoletim);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=============================>>
				try {
					dao = new PessoaisDao() ;
					int rgm = Integer.parseInt(txtRgmBoletim.getText()) ;
					Pessoais pessoais = dao.consultar(rgm) ;
					lblNomeBoletim.setText(pessoais.getNome());
				
					String curso = pessoais.getCurso() ;
					if(curso.equals("Análise e Desenvolvimento de Sistemas")) {
						cmbCurso.setSelectedIndex(0);
					}
					else if(curso.equals("Redes de Computadores")) {
						cmbCurso.setSelectedIndex(1);
					}
					else if(curso.equals("Ciência da Computação")) {
						cmbCurso.setSelectedIndex(2);
					}
					lblCursoBoletim.setText(curso);
				}
				catch(Exception e1) {
					lblAluno.setText("Erro ao Consultar");
				}
				
				try {
					List<NotaFaltas> lista = new ArrayList<NotaFaltas>();
							daoNotas = new NotaFaltasDao();
					int rgm = Integer.parseInt(txtRgmBoletim.getText()) ;
					lista = daoNotas.listarNotas(rgm); 
					for(NotaFaltas aluno : lista) {
						txtArea.append((String)"Disciplina..." + aluno.getDisciplina()+"\n");
						txtArea.append((String)"Notas..." + aluno.getNota()+"\n");
						txtArea.append((String)"Faltas..." + aluno.getFaltas()+"\n\n");
				}
				}catch(Exception e3) {
					System.out.println(e3.getMessage());
				}			
				
		        //==============================>>		
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsultar.setBounds(349, 11, 121, 25);
		panel_3.add(btnConsultar);
		
		txtArea = new TextArea();
		txtArea.setBounds(10, 114, 460, 123);
		panel_3.add(txtArea);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=======================>>
				
				txtRgmBoletim.setText(null);
				txtArea.setText(" ");
				lblNomeBoletim.setText(null);
				lblCursoBoletim.setText(null);
				
				//=======================>>
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBounds(218, 11, 121, 25);
		panel_3.add(btnLimpar);
	}
}
