/*Nome: Vinicius Silva de Oliveira
 * RGM: 20710356 
 * Turma: 3°B
 * Período: Noturno
 */

package br.com.exemplo.model;

public class NotaFaltas {
	
	private int rgmNotas ;
	private String disciplina ;
	private String semestre ;
	private String nota ;
	private String faltas ;
	
	public NotaFaltas() {
		
	}
	
	public NotaFaltas(int rgmNotas, String disciplina, String semestre, String nota, String faltas) {
		this.rgmNotas = rgmNotas ;
		this.disciplina = disciplina ;
		this.semestre = semestre ;
		this.nota = nota ;
		this.faltas = faltas ;
	}

	public NotaFaltas(int rgm, String disciplina2, String nota2, String faltas2) {
		this.rgmNotas = rgm ;
		this.disciplina = disciplina2 ;
		this.nota = nota2 ;
		this.faltas = faltas2 ;
	}

	public int getRgmNotas() {
		return rgmNotas;
	}

	public void setRgmNotas(int rgmNotas) {
		this.rgmNotas = rgmNotas;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getFaltas() {
		return faltas;
	}

	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}
}
