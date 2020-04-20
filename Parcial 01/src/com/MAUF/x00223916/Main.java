package com.MAUF.x00223916;

import javax.swing.*;
import java.text.*;

//no se si el opition pane era opcional asi que lo uso por si acaso xd
public class Main {
static DecimalFormat dec = new DecimalFormat("#.00");
    public static void main(String[] args) {
        int o =0;
        ServicioProfesional a;
        a = new ServicioProfesional("","",0.00,0);
        PlazaFija b;
        b = new PlazaFija("","",0.00,0);
        //menu perron :v
        while(o != 3)
        {
            o = Integer.parseInt(JOptionPane.showInputDialog(null,menuPerron()));
            switch(o)
            {
                case 1:
                    int c = Integer.parseInt(JOptionPane.showInputDialog(null,"Registrar un empleado."
                            + "\n1. Servicios Profesionales."+ "\n2. Plazas Fijas." ));
                    if(c == 1)
                    {
                        a.nombre = JOptionPane.showInputDialog(null,"Nombre del empleado: ");
                        a.puesto = JOptionPane.showInputDialog(null,"Ingrese el puesto de trabajo: ");
                        a.salario = Double.parseDouble(String.valueOf(JOptionPane.showInputDialog(null,"Ingrese el sueldo que recive el empleado: ")));
                        if(a.salario <= 0)
                        {
                            JOptionPane.showMessageDialog(null,"Valor no valido");
                        }
                        int meses = Integer.parseInt(JOptionPane.showInputDialog(null,"Meses de contrato: "));
                        a.setMesesContrato(meses);
                        if(a.getMesesContrato() <= 0)
                        {
                            JOptionPane.showMessageDialog(null,"Meses de contratacion invalidos.");
                        }
                    }
                    else if(c == 2)
                    {
                        b.nombre = JOptionPane.showInputDialog(null,"Nombre del empleado: ");
                        b.puesto = JOptionPane.showInputDialog(null,"Ingrese el puesto de trabajo: ");
                        b.salario = Double.parseDouble(String.valueOf(JOptionPane.showInputDialog(null,"Ingrese el sueldo que recive el empleado: ")));
                        if(b.salario <= 0)
                        {
                            JOptionPane.showMessageDialog(null,"Valor no valido");
                        }
                        int ext = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de extension: "));
                        b.setExtension(ext);
                        if(b.getExtension() <= 0)
                        {
                            JOptionPane.showMessageDialog(null,"Numero de extension invalido.");
                        }
                    }
                    break;
                case 2:
                    int d = Integer.parseInt(JOptionPane.showInputDialog(null,"Registrar un empleado."
                            + "\n1. Servicios Profesionales."+ "\n2. Plazas Fijas." ));
                    if(d == 1)
                    {
                        ServicioProfesional sp = new ServicioProfesional(a.nombre,a.puesto,a.salario,a.getMesesContrato());
                        JOptionPane.showMessageDialog(null,"Nombre del empleado: "+ a.nombre);
                        JOptionPane.showMessageDialog(null,"Salario del empleado: " + a.salario);
                        JOptionPane.showMessageDialog(null,"Meses de contratacion: "+ a.getMesesContrato());
                        JOptionPane.showMessageDialog(null,"El salario neto del empleado es de: "+ Calculadoraimpuestos.calcularPago(sp));
                        JOptionPane.showMessageDialog(null,"El salario final del empleado es de: "+ Calculadoraimpuestos.mostrarTotales());
                    }
                    else if (d == 2)
                        {
                            PlazaFija pf = new PlazaFija(b.nombre,b.puesto,b.salario,b.getExtension());
                            JOptionPane.showMessageDialog(null,"Nombre del empleado: " + b.nombre);
                            JOptionPane.showMessageDialog(null,"Salario del empleado: : " + b.salario);
                            JOptionPane.showMessageDialog(null,"Numero de extension: " + b.getExtension());
                            JOptionPane.showMessageDialog(null,"El salario neto del empleado es de: "+ Calculadoraimpuestos.calcularPago(pf));
                            JOptionPane.showMessageDialog(null,"El salario final del empleado es de: "+ Calculadoraimpuestos.mostrarTotales());
                        }
                    else
                        {
                            JOptionPane.showMessageDialog(null,"Opcion no valida");
                        }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Finalizando procesos...");
                    JOptionPane.showMessageDialog(null,"Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ya llego don comedia!");
                    JOptionPane.showMessageDialog(null,"Se serio y mete un NUMERO  valido");
                    JOptionPane.showMessageDialog(null,"Perdon me altere, el estres uwu");
                    break;
            }
        }
    }
    static String menuPerron()
    {
        return "\n1. Registrar empleado. \n2. Pagos. \n3. Finalizar y salir.";
    }
}
