package integradora_poo_2026.model;

public class Alumno {
    private String nombre;
    private String apellidos;
    private int edad;
    private String matricula;
    private String correoElectronico;
    private String sexo;

    // Constructor completo
    public Alumno(String nombre, String apellidos, int edad, String matricula, String correoElectronico, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.matricula = matricula;
        this.correoElectronico = correoElectronico;
        this.sexo = sexo;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", matricula='" + matricula + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}