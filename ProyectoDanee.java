/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dane;

import java.util.ArrayList;
import java.util.Scanner;
import javax.lang.model.SourceVersion;

class Departamento {
  private String nombre;
  private int numMunicipios;
  private double extension;
  private int numHabitantes;
  private double temperatura;
  private int indicativo;

  public Departamento(String nombre, int numMunicipios, double extension, int numHabitantes, double temperatura, int indicativo) {
    this.nombre = nombre;
    this.numMunicipios = numMunicipios;
    this.extension = extension;
    this.numHabitantes = numHabitantes;
    this.temperatura = temperatura;
    this.indicativo = indicativo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getNumMunicipios() {
    return numMunicipios;
  }

  public void setNumMunicipios(int numMunicipios) {
    this.numMunicipios = numMunicipios;
  }

  public double getExtension() {
    return extension;
  }

  public void setExtension(double extension) {
    this.extension = extension;
  }

  public int getNumHabitantes() {
    return numHabitantes;
  }

  public void setNumHabitantes(int numHabitantes) {
    this.numHabitantes = numHabitantes;
  }

  public double getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(double temperatura) {
    this.temperatura = temperatura;
  }

  public int getIndicativo() {
    return indicativo;
  }

  public void setIndicativo(int indicativo) {
    this.indicativo = indicativo;
  }

  public String toString() {
    return "Departamento: " + nombre + "\n" +
           "Número de municipios: " + numMunicipios + "\n" +
           "Extensión de tierra: " + extension + " mt2\n" +
           "Número de habitantes: " + numHabitantes + "\n" +
           "Temperatura promedio: " + temperatura + " °C\n" +
           "Indicativo telefónico: " + indicativo + "\n";
  }
}

class ProyectoDane {
  private ArrayList<Departamento> departamentos;

  public ProyectoDane() {
    departamentos = new ArrayList<Departamento>();
  }

  public void agregarDepartamento(Departamento d) {
    departamentos.add(d);
  }

  public Departamento buscarMayorExtensionMenorTemperatura() {
    if (departamentos.isEmpty()) {
      return null;
    }
    Departamento buscado = departamentos.get(0);
    for (int i = 1; i < departamentos.size(); i++) {
      Departamento actual = departamentos.get(i);
      if (actual.getExtension() > buscado.getExtension() && actual.getTemperatura() < buscado.getTemperatura()) {
        buscado = actual;
      }
    }
    return buscado;
  }

  public Departamento buscarMayorHabitantesMenorExtension() {
    if (departamentos.isEmpty()) {
      return null;
    }
    Departamento buscado = departamentos.get(0);
    for (int i = 1; i < departamentos.size(); i++) {
      Departamento actual = departamentos.get(i);
      if (actual.getNumHabitantes() > buscado.getNumHabitantes() && actual.getExtension() < buscado.getExtension()) {
        buscado = actual;
      }
    }
    return buscado;
  }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}

public class ProyectoDanee {
  public static void main(String[] args) {
    ProyectoDane proyecto = new ProyectoDane();
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;

    System.out.println("Bienvenido al proyecto del Dane");
    System.out.println("Seleccione una opción:");
    System.out.println("1. Agregar un departamento");
    System.out.println("2. Buscar el departamento con mayor extensión y menor temperatura");
    System.out.println("3. Buscar el departamento con mayor número de habitantes y menor extensión");
    System.out.println("4. Salir");

    while (continuar) {
      int opcion = sc.nextInt();
      switch (opcion) {
        case 1:
          System.out.println("Ingrese el nombre del departamento:");
          String nombre = sc.next();
          System.out.println("Ingrese el número de municipios del departamento:");
          int numMunicipios = sc.nextInt();
          System.out.println("Ingrese la extensión de tierra del departamento en mt2:");
          double extension = sc.nextDouble();
          System.out.println("Ingrese el número de habitantes del departamento:");
          int numHabitantes = sc.nextInt();
          System.out.println("Ingrese la temperatura promedio del departamento en °C:");
          double temperatura = sc.nextDouble();
          System.out.println("Ingrese el indicativo telefónico del departamento:");
          int indicativo = sc.nextInt();
          Departamento d = new Departamento(nombre, numMunicipios, extension, numHabitantes, temperatura, indicativo);
          proyecto.agregarDepartamento(d);
          System.out.println("El departamento ha sido agregado exitosamente.");
          break;
        case 2:
          Departamento mayorExtensionMenorTemperatura = proyecto.buscarMayorExtensionMenorTemperatura();
          if (mayorExtensionMenorTemperatura == null) {
            System.out.println("No hay departamentos registrados.");
          } else {
            System.out.println("El departamento con mayor extensión y menor temperatura es:");
            System.out.println(mayorExtensionMenorTemperatura);
          }
          break;
        case 3:
          Departamento mayorHabitantesMenorExtension = proyecto.buscarMayorHabitantesMenorExtension();
          if (mayorHabitantesMenorExtension == null) {
            System.out.println("No hay departamentos registrados.");
          } else {
            System.out.println("El departamento con mayor número de habitantes y menor extensión es:");
            System.out.println(mayorHabitantesMenorExtension);
          }
          break;
        case 4:
          continuar = false;
          break;
        default:
          System.out.println("Opción no válida. Por favor, elija una opción del menú.");
          break;
      }

      System.out.println("Seleccione una opción:");
      System.out.println("1. Agregar un departamento");
      System.out.println("2. Buscar el departamento con mayor extensión y menor temperatura");
      System.out.println("3. Buscar el departamento con mayor número de habitantes y menor extensión");
      System.out.println("4. Salir");
    }

    sc.close();
  }
}
