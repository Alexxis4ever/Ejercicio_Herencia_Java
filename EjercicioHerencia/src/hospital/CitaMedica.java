package hospital;

import hospital.personas.Medico;
import hospital.personas.Paciente;

public class CitaMedica {
	
	private String servicio;
	private Paciente paciente;
	private Medico medico;
	private String fecha;
	private String hora;
	private Integer cantCitas;
	

	/**
	* @return the servicio
	*/
	public String getServicio() {
		return servicio;
	}
	/**
	* @param servicio the servicio to set
	*/
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	/**
	* @return the paciente
	*/
	public Paciente getPaciente() {
		return paciente;
	}
	/**
	* @param paciente the paciente to set
	*/
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	/**
	* @return the medico
	*/
	public Medico getMedico() {
		return medico;
	}
	/**
	* @param medico the medico to set
	*/
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	/**
	* @return the fecha
	*/
	public String getFecha() {
		return fecha;
	}
	/**
	* @param fecha the fecha to set
	*/
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	* @return the hora
	*/
	public String getHora() {
		return hora;
	}
	/**
	* @param hora the hora to set
	*/
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getCantCitas() {
		return cantCitas;
	}
	public void setCantCitas(Integer catCitas) {
		this.cantCitas = catCitas;
	}


}