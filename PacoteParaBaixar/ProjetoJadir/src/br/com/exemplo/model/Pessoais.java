/*Nome: Vinicius Silva de Oliveira
 * RGM: 20710356 
 * Turma: 3°B
 * Período: Noturno
 */

package br.com.exemplo.model;

public class Pessoais {
	//atributos 
	
	private int rgm ;
	private String nome ;
	private String dataNascimento ;
	private String cpf ;
	private String email ;
	private String endereco ;
	private String municipio ;
	private String uf ;
	private String celular ;
	private String curso ;
	private String campus ;
	private String periodo ;
	
	public Pessoais() {
		
	} 
	
	public Pessoais(int rgm, String nome, String dataNascimento, String cpf, 
			String email, String endereco, String municipio, String uf, String celular, String curso, 
			String campus, String periodo ) {
		this.rgm = rgm ;
		this.nome = nome ;
		this.dataNascimento = dataNascimento ;
		this.cpf = cpf ;
		this.email = email ;
		this.endereco = endereco ;
		this.municipio = municipio ;
		this.uf = uf ;
		this.celular = celular ;
		this.curso = curso ;
		this.campus = campus ;
		this.periodo = periodo ;
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}