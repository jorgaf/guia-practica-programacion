// Reto rápido · Nivel 2
// Lee tres notas sobre 10 y decide si el estudiante aprueba (promedio >= 7, es decir, 70 %).
void main() {
    double n1 = Double.parseDouble(IO.readln("Nota 1: "));
    double n2 = Double.parseDouble(IO.readln("Nota 2: "));
    double n3 = Double.parseDouble(IO.readln("Nota 3: "));
    double promedio = (n1 + n2 + n3) / 3;
    String estado = promedio >= 7 ? "APRUEBA" : "NO APRUEBA";
    IO.println("Promedio: %.2f -> %s".formatted(promedio, estado));
}
