// Reto rápido · Nivel 1
// Pide el nombre y el año de nacimiento, y muestra la edad que cumple este año.
// Year pertenece a java.time: en un archivo compacto no hace falta importarlo.
void main() {
    String nombre = IO.readln("Nombre: ");
    int anioNacimiento = Integer.parseInt(IO.readln("Año de nacimiento: "));
    int anioActual = Year.now().getValue();
    int edad = anioActual - anioNacimiento;
    IO.println(nombre + ", en " + anioActual + " cumples " + edad + " años.");
}
