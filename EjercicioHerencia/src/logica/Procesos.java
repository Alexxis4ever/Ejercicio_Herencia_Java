package logica;

import hospital.CitaMedica;
import hospital.personas.EmpleadoEventual;
import hospital.personas.EmpleadoPlanilla;
import hospital.personas.Medico;
import hospital.personas.Paciente;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author Jackson Londo�o
 *
 */
public class Procesos {
	
	
	
	/**
	 * Se crea el metodo constructor para instanciar una clase
	 */
	CitaMedica intCita = new CitaMedica();
	
	
	
	String dni,nombre,apellido,fechaNacimiento,direccion,ciudad,codEmpleado,numHorasExt, fechaIngreso, area,cargo;
	
	ArrayList<Paciente> arrayPacientes = new ArrayList<Paciente>();
	ArrayList<EmpleadoPlanilla> arrayEmpleadosPlanilla = new ArrayList<EmpleadoPlanilla>();
	ArrayList<EmpleadoEventual> arrayEmpleadosEventual = new ArrayList<EmpleadoEventual>();
	ArrayList<Medico> arrayMedicos = new ArrayList<Medico>();
	
	ArrayList<CitaMedica> arrayCitas = new ArrayList<CitaMedica>();
	
	
	
	int cantCitas=0;
	
	
	
	/**
	 * Se crea el metodo procesos para pedir la cantidad de citas necesarias
	 */
	public Procesos(){
		
		int numCitas = 0;
		
		try {
			
			numCitas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de citas medicas por dia"));
			
			if(numCitas<0) {
				
				throw new Exception("No es un dato positivo");
				
			}else {
				intCita.setCantCitas(numCitas);
				
				arrayCitas.add(intCita);
				
				presentarMenu();
			}
			
		} catch (Exception e) {
//			e.printStackTrace();
		
			JOptionPane.showMessageDialog(null, "No es un dato valido\n" +"Ocurrio este error: "+e.getMessage(),"Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
			
	}
	
	/**
	 * Por medio del metodo presentarMenu se presenta el menu con el sistema hospitalario
	 */
	private void presentarMenu(){
		
		int opc;
		
		String cad="SISTEMA HOSPITALARIO \nRegistro\n\n";
		cad+="1. Registrar Usuarios\n";
		cad+="2. Registrar Cita Medica\n";
		cad+="3. Imprimir Datos\n";
		cad+="4. Salir\n\n";
		
		do {
		opc=Integer.parseInt(JOptionPane.showInputDialog(cad+"Ingrese una opcion"));

		switch (opc) {
		case 1:
			cargarMenuRegistro();
			break;
		case 2:

		System.out.println(cantCitas+"<"+intCita.getCantCitas());
		
		if (cantCitas<intCita.getCantCitas()) {
			if (validaRegistrosPrevios()) {
				registrarCitaMedica();
		}else {
			JOptionPane.showMessageDialog(null, "No se puede registrar la cita, verifique que los empleados por planilla,\n" + "medicos y pacientes se encuentren previamente\nregistrados en el sistema","Advertencia",JOptionPane.WARNING_MESSAGE);

		}
		}else{
			JOptionPane.showMessageDialog(null, "No se puede registrar la cita, Ha superado el numero de citas pordia","Advertencia",JOptionPane.WARNING_MESSAGE);

		}
		break;
		case 3:
		if (validaRegistrosEmpleados()) {
			imprimirDatos();
		}
		break;
		case 4:
			JOptionPane.showMessageDialog(null, "Chao");
			break;
		default:
			break;
		}
	} while (opc!=4);
	JOptionPane.showMessageDialog(null, "salio");
	
	}
	
	
	
	/**
	 * Por medio de este metodo imprimirDatos se muestra un menu con los datos que desea imprimir
	 */
	private void imprimirDatos() {
		
		String menuMsj="Menu Reportes\n\n";
		menuMsj+="1. Imprimir Empleados de Planilla\n";
		menuMsj+="2. Imprimir Empleados Eventuales\n";
		menuMsj+="3. Imprimir Medicos\n";
		menuMsj+="4. Imprimir Pacientes\n";
		menuMsj+="5. Imprimir Citas\n";
		menuMsj+="6. Salir\n\n";
		
		int cod=Integer.parseInt(JOptionPane.showInputDialog(menuMsj+"Seleccione una opcion"));

		switch (cod) {
			case 1:
				if (!arrayEmpleadosPlanilla.isEmpty()) {
				System.out.println("***************************Empleados Planilla**************************************");
		
		for (int i = 0; i < arrayEmpleadosPlanilla.size(); i++) {

			System.out.println("Numero DNI: "+arrayEmpleadosPlanilla.get(i).getDni());

			System.out.println("Nombre:"+arrayEmpleadosPlanilla.get(i).getNombre()+" "+arrayEmpleadosPlanilla.get(i).getApellido());

			System.out.println("Codigo Empleado: "+arrayEmpleadosPlanilla.get(i).getCodEmpleado());

			System.out.println("Cargo: "+arrayEmpleadosPlanilla.get(i).getCargo());
		
			System.out.println("Salario mensual: "+arrayEmpleadosPlanilla.get(i).getSalarioMensual());
			System.out.println();
			
				}

				System.out.println("*************************************************************************************");

				}else{
					JOptionPane.showMessageDialog(null, "No existe informacion registrada","Error",JOptionPane.ERROR_MESSAGE);

				}
					break;
				case 2:
					if (!arrayEmpleadosEventual.isEmpty()) {

						System.out.println("******************************Empleados Eventuales**************************************");
						
				for (int i = 0; i < arrayEmpleadosEventual.size(); i++) {
					

					System.out.println("Numero DNI: "+arrayEmpleadosEventual.get(i).getDni());

					System.out.println("Nombre: "+arrayEmpleadosEventual.get(i).getNombre()+" "+arrayEmpleadosEventual.get(i).getApellido());

					System.out.println("Codigo Empleado: "+arrayEmpleadosEventual.get(i).getCodEmpleado());

					System.out.println("Cargo: "+arrayEmpleadosEventual.get(i).getCargo());

					System.out.println("Honorarios por hora: "+arrayEmpleadosEventual.get(i).getHonorariosHora());

					System.out.println("Fecha termino de contrato: "+arrayEmpleadosEventual.get(i).getFechaTerminoContrato());

					System.out.println();
				}

					System.out.println("*************************************************************************************");

				}else{
					JOptionPane.showMessageDialog(null, "No existe informacion registrada","Error",JOptionPane.ERROR_MESSAGE);
				}
					break;
				case 3:
					if (!arrayMedicos.isEmpty()) {
					System.out.println("**********************************Medicos*********************************************");

				for (int i = 0; i < arrayMedicos.size(); i++) {
					
				
				System.out.println("Numero DNI: "+arrayMedicos.get(i).getDni());

				System.out.println("Nombre: "+arrayMedicos.get(i).getNombre()+" "+arrayMedicos.get(i).getApellido());
				System.out.println("Codigo Empleado: "+arrayMedicos.get(i).getCodEmpleado());

				System.out.println("Cargo: "+arrayMedicos.get(i).getCargo());	
				
				System.out.println("Especialidad: "+arrayMedicos.get(i).getEspecialidad());

				System.out.println("Numero de consultorio: "+arrayMedicos.get(i).getNumConsultorio());

				System.out.println();
				}	
				
				System.out.println("*************************************************************************************");

						}else{
						JOptionPane.showMessageDialog(null, "No existe informacion registrada","Error",JOptionPane.ERROR_MESSAGE);

						}
							break;
						case 4:
							if (!arrayPacientes.isEmpty()) {

								System.out.println("**********************************Pacientes*********************************************");

						for (int i = 0; i < arrayPacientes.size(); i++) {
							
						System.out.println("Numero DNI: "+arrayPacientes.get(i).getDni());

						System.out.println("Nombre: "+arrayPacientes.get(i).getNombre()+" "+arrayPacientes.get(i).getApellido());
								
						System.out.println("Numero Historia Clinica: "+arrayPacientes.get(i).getNumHistoria());

						System.out.println("Sexo: "+arrayPacientes.get(i).getSexo());

						System.out.println("Grupo Sanguineo: "+arrayPacientes.get(i).getGrupoSanguineo());

						System.out.println("Lista Medicamentos");
						
						for (int j = 0; j < arrayPacientes.get(i).getListaMedicamentos().length; j++) {
							
						System.out.print(arrayPacientes.get(i).getListaMedicamentos()[j]+" / ");

						}
							System.out.println();
						}

							System.out.println("*************************************************************************************");

						}else{
							
							JOptionPane.showMessageDialog(null, "No existe informacion registrada","Error",JOptionPane.ERROR_MESSAGE);

						}
							break;
						case 5:
							
							if (!arrayCitas.isEmpty()) {
								System.out.println("**********************************Citas*********************************************");
								
								System.out.println(arrayCitas);

						for (int i = 0; i < arrayCitas.size(); i++) {
							
						System.out.println("Servicio: "+arrayCitas.get(i).getServicio());
						System.out.println("Paciente: "+arrayCitas.get(i).getPaciente().getNombre()+" "+arrayCitas.get(i).getPaciente().getApellido());
						System.out.println("Medico: "+arrayCitas.get(i).getMedico().getNombre()+" "+arrayCitas.get(i).getMedico().getApellido());
						System.out.println("Fecha: "+arrayCitas.get(i).getFecha());
						System.out.println("Hora: "+arrayCitas.get(i).getHora());

						System.out.println();
						
						}

						System.out.println("*************************************************************************************");

						}else{
							JOptionPane.showMessageDialog(null, "No existe informacion registrada","Error",JOptionPane.ERROR_MESSAGE);

						}
							break;
						default:
							break;
						}
						}
						/**
						 * @return El metodo validaRegistrosEmpleados indica si los empleados existen en los arrayList
						 */
						private boolean validaRegistrosEmpleados() {
						boolean retorno=false;
						if (!arrayEmpleadosPlanilla.isEmpty() || !arrayEmpleadosEventual.isEmpty()) {

						if (validarEmpleado()) {
						retorno=true;
						
						}else{
						JOptionPane.showMessageDialog(null, "No existen empleados con ese documento","Error",JOptionPane.ERROR_MESSAGE);

						}
						
						}else{
						JOptionPane.showMessageDialog(null, "No existen empleados Registrados","Error",JOptionPane.ERROR_MESSAGE);

						}
						return retorno;
						}
						
						/**
						 * @return El metodo ValidarEmpleadoPlanilla lo que hace es comparar el dato ingresado y lo compara con el de el arrayList
						 */
						private boolean validarEmpleadoPlanilla() {
						String documentoEmpleado=JOptionPane.showInputDialog("Ingrese el documento del empleado por planilla");
						boolean retorna=false;
						
						for (int i = 0; i < arrayEmpleadosPlanilla.size(); i++) {
							
						if (documentoEmpleado.equals(arrayEmpleadosPlanilla.get(i).getDni())) {

						retorna=true;
						
						}
						}
						return retorna;
						}
						/**
						 * @return El metodo ValidarEmpleado lo que hace es comparar el dato ingresado y lo compara con el de el arrayList
						 */
						private boolean validarEmpleado() {
							
						String documentoEmpleado=JOptionPane.showInputDialog("Ingrese el documento del empleado");

						boolean retorna=false;
						
						if (!arrayEmpleadosPlanilla.isEmpty()) {
							
						for (int i = 0; i < arrayEmpleadosPlanilla.size(); i++) {

						if (documentoEmpleado.equals(arrayEmpleadosPlanilla.get(i).getDni())) {
							retorna=true;
						}
						}
						}
						
						if (retorna==false) {
							
						if (!arrayEmpleadosEventual.isEmpty()) {
							
						for (int i = 0; i < arrayEmpleadosEventual.size(); i++) {
							
						if (documentoEmpleado.equals(arrayEmpleadosEventual.get(i).getDni())) {
							retorna=true;
						}
						
						}
						}
						}
						return retorna;
						}
						/**
						 * @return No lo tengo claro
						 */
						private boolean validaRegistrosPrevios() {
						boolean retorno=false;
						if (!arrayPacientes.isEmpty() && !arrayMedicos.isEmpty() && !arrayEmpleadosPlanilla.isEmpty()) {
							retorno=true;
						}
							return retorno;
						}
						
						/**
						 * El metodo registrarCitaMedica se utiliza para crear una cita medica con los empleados y pacientes previamente registrados, 
						 * si no encuentra el documento del empleado lanza la advertencia
						 */
						private void registrarCitaMedica() {
							
						if (validarEmpleadoPlanilla()) {
						
							CitaMedica miCita=new CitaMedica();
							miCita.setServicio(JOptionPane.showInputDialog("Ingrese el Servicio"));

							miCita.setPaciente(asignarPaciente());
							miCita.setMedico(asignaMedico());

							miCita.setFecha(JOptionPane.showInputDialog("Ingrese la fecha"));
							miCita.setHora(JOptionPane.showInputDialog("Ingrese la Hora"));

						JOptionPane.showMessageDialog(null, "La cita se ha registrado exitosamente!!!");
						
						arrayCitas.add(cantCitas, miCita);
						
						cantCitas++;
						
						}else{
							JOptionPane.showMessageDialog(null, "El documento no corresponde a un empleado por planilla","Advertencia",JOptionPane.WARNING_MESSAGE);

						}

						}
						/**
						 * @return Asigna un medico a la cita medica dependiendo del documento de uno que ya este registrado y lo compara, 
						 * de lo contrario muestra una advertencia y pide que valide el documento
						 */
						private Medico asignaMedico() {
						boolean repiteCiclo=false;
						Medico miMedico=null;
						do {
							
						String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del Medico");

						for (int i = 0; i < arrayMedicos.size(); i++) {
							
						if (documentoPaciente.equals(arrayMedicos.get(i).getDni())) {
							miMedico=arrayMedicos.get(i);
						}
						}
						if (miMedico!=null) {
							repiteCiclo=false;
						}else{
							repiteCiclo=true;
							JOptionPane.showMessageDialog(null, "El documento no corresponde a un Medico\n" + "Por favor ingrese un documento valido","Advertencia",JOptionPane.WARNING_MESSAGE);

						}
						} while (repiteCiclo==true);
						return miMedico;
						}
						/**
						 * @return Asigna un paciente a la cita medica dependiendo del documento de uno que ya este registrado y lo compara, 
						 * de lo contrario muestra una advertencia y pide que valide el documento
						 */
						private Paciente asignarPaciente() {
						boolean repiteCiclo=false;
						Paciente miPaciente=null;
						do {
							
						String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");

						for (int i = 0; i < arrayPacientes.size(); i++) {
						if (documentoPaciente.equals(arrayPacientes.get(i).getDni())) {
						miPaciente=arrayPacientes.get(i);
							}
						}
						if (miPaciente!=null) {
							repiteCiclo=false;
						}else{
							repiteCiclo=true;
							JOptionPane.showMessageDialog(null, "El documento no corresponde a un Paciente\n" + "Por favor ingrese un documento valido","Advertencia",JOptionPane.WARNING_MESSAGE);

						}


						} while (repiteCiclo==true);
						return miPaciente;
						}

						/**
						 * El metodo cargarMenuRegistro muestra al usuario las opciones de registro
						 */
						private void cargarMenuRegistro() {
						String cad="REGISTRO DE USUARIOS\nregistro\n\n";
						cad+="1. Registrar Empleado\n";
						cad+="2. Registrar Paciente\n";
						cad+="3. Regresar\n\n";
						
						int opc=Integer.parseInt(JOptionPane.showInputDialog(cad+"Ingrese una opcion"));

						switch (opc) {
						case 1:
						String tipoEmpleado="Tipo Empleado\n\n";
						tipoEmpleado+="1.Empleado Planilla\n";
						tipoEmpleado+="2.Empleado Eventual\n";
						tipoEmpleado+="3.Medico\n\n";
						
						
						int tipo=Integer.parseInt(JOptionPane.showInputDialog(tipoEmpleado+"Seleccione el tipo de empleado"));

						registrarEmpleado(tipo);
							break;
						case 2:
							registrarPaciente();
							break;
						case 3:
							break;
						default:
							break;
						}
						}
						/**
						 * El metodo registrarPaciente solicita la cantidad de pacientes y sus respectivos datos
						 */
						private void registrarPaciente() {
							
						if (arrayPacientes.isEmpty()) {
							
						int cantPaciente=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Pacientes a registrar"));
						
						for (int i = 0; i < cantPaciente; i++) {
							
						JOptionPane.showMessageDialog(null, "Registro de datos paciente "+(i+1));

						Paciente miPaciente=new Paciente();
						//datos persona1

						miPaciente.setDni(JOptionPane.showInputDialog("Ingrese el DNI del Paciente "+(i+1)));
						miPaciente.setNombre(JOptionPane.showInputDialog("Ingrese el Nombre del Paciente "+(i+1)));
						miPaciente.setApellido(JOptionPane.showInputDialog("Ingrese el Apellido del Paciente "+(i+1)));

						miPaciente.setFechaNacimiento(JOptionPane.showInputDialog("Ingrese la fecha de Nacimiento del Paciente "+(i+1)));
						miPaciente.setDireccion(JOptionPane.showInputDialog("Ingrese la Direccion del Paciente "+(i+1)));
						miPaciente.setCiudad(JOptionPane.showInputDialog("Ingrese Ciudad del Paciente "+(i+1)));

						//datos paciente

						miPaciente.setNumHistoria(JOptionPane.showInputDialog("Ingrese el Numero de la Historia Clinica del Paciente "+(i+1)));
						miPaciente.setSexo(JOptionPane.showInputDialog("Ingrese el Sexo del Paciente "+(i+1)));
						miPaciente.setGrupoSanguineo(JOptionPane.showInputDialog("Ingrese el Grupo Sanguineo del Paciente "+(i+1)));

						int cantMedic=Integer.parseInt(JOptionPane.showInputDialog("Cuantos medicamentos a los que es alergico el paciente "+(i+1)+" desea Registrar?"));
							
						String arregloMedicamentos[]=new String[cantMedic];
						
						for (int j = 0; j < arregloMedicamentos.length; j++) {
							
						arregloMedicamentos[j]=JOptionPane.showInputDialog("Ingrese el medicamento "+(j+1));
						
						}
						
						}
						JOptionPane.showMessageDialog(null, "El registro de Pacientes se ha realizado con exito");

						}else{
							JOptionPane.showMessageDialog(null, "Ya se han registrado los Pacientes","ERROR",JOptionPane.ERROR_MESSAGE);

						}
						}
						/**
						 * @param tipo, el metodo registrarEmpleado recibe un parametro de tipo entero llamado tipo, solicita la cantidad de pacientes y sus respectivos datos
						 */
						private void registrarEmpleado(int tipo) {
						switch (tipo) {
						case 1:
						if (arrayEmpleadosPlanilla.isEmpty()) {
							
						int cantEmpleadoPlanilla=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados por planilla a registrar"));

				for (int i = 0; i < cantEmpleadoPlanilla; i++) {
							
						JOptionPane.showMessageDialog(null, "Registro de datos Empleado Planilla "+(i+1));

						asignarValoresGeneralesEmpleado("Empleado por Planilla "+(i+1));

						EmpleadoPlanilla miEmpleadoPlanilla=new EmpleadoPlanilla();

						//datos persona
						miEmpleadoPlanilla.setDni(dni);
						miEmpleadoPlanilla.setNombre(nombre);
						miEmpleadoPlanilla.setApellido(apellido);

						miEmpleadoPlanilla.setFechaNacimiento(fechaNacimiento);

						miEmpleadoPlanilla.setDireccion(direccion);
						miEmpleadoPlanilla.setCiudad(ciudad);
						//datos empleado
						miEmpleadoPlanilla.setCodEmpleado(codEmpleado);
						miEmpleadoPlanilla.setNumHorasExtras(numHorasExt);
						miEmpleadoPlanilla.setFechaIngreso(fechaIngreso);

						miEmpleadoPlanilla.setArea(area);
						miEmpleadoPlanilla.setCargo(cargo);
						//datos empleado planilla

						miEmpleadoPlanilla.setSalarioMensual(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual del empleado por Planilla"+(i+1))));
						miEmpleadoPlanilla.setPorcentajeAdicional(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual del empleado por planilla"+(i+1))));
						
						
						arrayEmpleadosPlanilla.add(miEmpleadoPlanilla);

					}
							JOptionPane.showMessageDialog(null, "El registro de Empleados por Planilla se ha realizado con exito");

						} else {
							JOptionPane.showMessageDialog(null, "Ya se han registrado los empleados por Planilla","ERROR",JOptionPane.ERROR_MESSAGE);

				}
						break;
						
					case 2:
							
						if (arrayEmpleadosEventual.isEmpty()) {
							
							
							int cantEmpleadoEventual=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados eventuales a registrar"));

					for (int i = 0; i < cantEmpleadoEventual; i++) {
						
						JOptionPane.showMessageDialog(null, "Registro de datos Empleado Eventual "+(i+1));

						asignarValoresGeneralesEmpleado("Empleado Eventual "+(i+1));

						EmpleadoEventual miEmpleadoEventual=new EmpleadoEventual();

						//datos persona
						miEmpleadoEventual.setDni(dni);
						miEmpleadoEventual.setNombre(nombre);
						miEmpleadoEventual.setApellido(apellido);

						miEmpleadoEventual.setFechaNacimiento(fechaNacimiento);

						miEmpleadoEventual.setDireccion(direccion);
						miEmpleadoEventual.setCiudad(ciudad);
						//datos empleado
						miEmpleadoEventual.setCodEmpleado(codEmpleado);
						miEmpleadoEventual.setNumHorasExtras(numHorasExt);
						miEmpleadoEventual.setFechaIngreso(fechaIngreso);

						miEmpleadoEventual.setArea(area);
						miEmpleadoEventual.setCargo(cargo);
						//datos empleado eventual

						miEmpleadoEventual.setHonorariosHora(Double.parseDouble(JOptionPane.showInputDialog("Ingrese los honorarios hora del Empleado Eventual "+(i+1))));
						miEmpleadoEventual.setFechaTerminoContrato(JOptionPane.showInputDialog("Ingrese la fecha de terminacion de contrato del Empleado Eventual"+(i+1)));
					
						arrayEmpleadosEventual.add(miEmpleadoEventual);

						}
						JOptionPane.showMessageDialog(null, "El registro de Empleados Eventuales se ha realizado con exito");

						}
						else{
						JOptionPane.showMessageDialog(null, "Ya se han registrado los empleados Eventuales","ERROR",JOptionPane.ERROR_MESSAGE);

						}
							break;

						case 3:
							if (arrayMedicos.isEmpty()) {
								
							int cantMedicos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Medicos a registrar"));
								
						for (int i = 0; i < cantMedicos; i++) {
							
							JOptionPane.showMessageDialog(null, "Registro de datos Medico "+(i+1));

							asignarValoresGeneralesEmpleado("Medico "+(i+1));

							Medico miMedico=new Medico();
							//datos persona
							miMedico.setDni(dni);
							miMedico.setNombre(nombre);
							miMedico.setApellido(apellido);
							miMedico.setFechaNacimiento(fechaNacimiento);
							miMedico.setDireccion(direccion);
							miMedico.setCiudad(ciudad);
							//datos empleado
							miMedico.setCodEmpleado(codEmpleado);
							miMedico.setNumHorasExtras(numHorasExt);
							miMedico.setFechaIngreso(fechaIngreso);
							miMedico.setArea(area);
							miMedico.setCargo(cargo);
							//datos medico


							miMedico.setEspecialidad(JOptionPane.showInputDialog("Ingrese la especialidad del Medico "+(i+1)));
							miMedico.setNumConsultorio(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de consultorio del Medico "+(i+1))));
							
							arrayMedicos.add(miMedico);
							
						}
						
						JOptionPane.showMessageDialog(null, "El registro de Medicos se ha realizado con exito");

						}
						else{
						JOptionPane.showMessageDialog(null, "Ya se han registrado los Medicos","ERROR",JOptionPane.ERROR_MESSAGE);

						}
						break;
						default:
						break;
						}
						}
						/**
						 * @param tipo, El metodo asignarValoresGeneralesEmpleado recibe un parametro de tipo String llamado tipo, y solicita los datos 
						 * generales de empleado 
						 */
						private void asignarValoresGeneralesEmpleado(String tipo) {
							
							dni=JOptionPane.showInputDialog("Ingrese el DNI del "+tipo);
							
							nombre=JOptionPane.showInputDialog("Ingrese el nombre del "+tipo);

							apellido=JOptionPane.showInputDialog("Ingrese el apellido del "+tipo);

							fechaNacimiento=JOptionPane.showInputDialog("Ingrese la fecha Nacimiento del "+tipo);

							direccion=JOptionPane.showInputDialog("Ingrese la direccion del "+tipo);

							ciudad=JOptionPane.showInputDialog("Ingrese la ciudad del "+tipo);

							codEmpleado=JOptionPane.showInputDialog("Ingrese el cod Empleado del "+tipo);

							numHorasExt=JOptionPane.showInputDialog("Ingrese el num de Horas Extras del "+tipo);

							fechaIngreso=JOptionPane.showInputDialog("Ingrese la fecha Ingreso del "+tipo);

							area=JOptionPane.showInputDialog("Ingrese el area del "+tipo);
							
							cargo=JOptionPane.showInputDialog("Ingrese el cargo del "+tipo);
	
					}
						
				}