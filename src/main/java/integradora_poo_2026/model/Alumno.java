package integradora_poo_2026.model;

public class Alumno {
    private String nombre;
    private String apellidos;
    private int edad;
    private String matricula;
    private String correo;
    private String sexo;

    public Alumno() {
    }


    public Alumno(String nombre, String apellidos, int edad, String matricula, String correo, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.matricula = matricula;
        this.correo = correo;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return
                nombre + ',' +
                        apellidos + ',' +
                        edad +
                        matricula + ',' +
                        correo + ',' +
                        sexo
                ;
    }
}
