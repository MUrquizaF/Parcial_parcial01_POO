package com.MAUF.x00223916;
import javax.swing.*;

public class Calculadoraimpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private Calculadoraimpuestos(double totalRenta,double totalISSS,double totalAFP){

    }
    /*renta1 para sp,renta2 para pf
    * para no estar haciendo tab a cada rato xd
    * X es el restante = salario - afp - isss (gran robo la cosa)
    * rangoA 0.01-472.00 / neles
    * "B 472.01-895.24 / 0.1*(X - 472)+17.67
    * "C 895.25-2038.10 / 0.2(X - 895.24)+60
    * "D 2038.11++ / 0.3(X - 2038.10)+288.57
    * */
    public static double calcularPago(Empleado empleado){
        double money = 0;
        double scam = empleado.getSalario();
        /*usando instance of
        * (pongamela buena me quebre la cabeza medio dia en esto
        * y solo era la formula alrevez no se burlen :'v)*/
        if (empleado instanceof PlazaFija)
        {
          double renta2 = 0;
          double ISSS = (scam * .03);
          double AFP = (scam * .0625);
          double X = (scam - ISSS - AFP);
          //se salvo el prro
          if (X >= .1 && X <= 472.00)
          {
              renta2 = 0;
          }
          //solo la puntita xd
           if(X >= 472.01 && X <= 895.24)
           {
              renta2 = (.1*(X - 472.00) + 17.67);
           }
           //hoy si la sintio :v
            if(X >= 895.25 && X <= 2038.10)
            {
                renta2 = (.2*(X - 895.24) + 60);
            }
            //no pos F :c
            if(X >= 2038.11)
            {
                renta2 = (.3*(X - 2038.10) + 288.57);
            }
            totalRenta = renta2;
            totalAFP = AFP;
            totalISSS = ISSS;
            money = (X - renta2);
        }
        if(empleado instanceof  ServicioProfesional)
        {
            double renta1 = (scam * .1);
            totalRenta = renta1;
            money = (scam - renta1);
        }
        return money;// el pago del Empleado
    }
    public static String mostrarTotales(){
        /*System.out.println("Su total de renta es: " + totalRenta + "USD");
        System.out.println("Su total de las AFP es: " + totalAFP + "USD");
        System.out.println("Su total del seguro social es: " + totalISSS + "USD");*/
        return "\nSu total de renta es: " + totalRenta + "USD" + "\nSu total de las AFP es: " + totalAFP + "USD" + "\nSu total del seguro social es: " + totalISSS + "USD";
    }
}
