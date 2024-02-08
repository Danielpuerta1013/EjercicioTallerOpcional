package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] cantidadCompras=new int[6];
        Integer[] preciosPlay={300000,900000,2500000,80000,200000,350000};
        Integer[] preciosControles={80000,200000,350000};
        Double totalCompra=0.0;
        int opcionCompra;
        Double descuentoAntiguo=0.2;
        String opcionAntiguedad;
        System.out.println("-------------------------");
        System.out.println("Bienvenido a la clinica del play");
        System.out.println("---------------------------------");
        System.out.println("señor usuario es cliente nuevo o antiguo?");
        opcionAntiguedad=sc.nextLine();
        if (opcionAntiguedad.equals("antiguo")){
            MenuPrecios();
            System.out.println("adicional recuerde que cada consola viene con un control y por ser cliente" +
                    "antiguo tiene un 20% de descuento en su compra y un control extra");
            do {
                System.out.print("escoja una opcion de compra o presione 0 para salir y mostrar el total: ");
                opcionCompra=sc.nextInt();
                cantidadCompras=opcionesProductos(opcionCompra,preciosPlay.length);
                totalCompra+=calcularTotal(cantidadCompras,preciosPlay);

            }while (opcionCompra!=0);
            System.out.println(cantidadCompras);
            System.out.println(totalCompra);


            Double totalConDescuento=calcularDescuento(totalCompra,20);
            System.out.println("el total de su compra es de: $"+totalConDescuento);
        } else if (opcionAntiguedad.equals("nuevo")) {
            MenuPrecios();
            System.out.println("promoción para clientes nuevos, cada consola viene con un control pero si compras" +
                    "otro extra podras escoger entre 5 juegos ");
            do {
                System.out.print("escoja una opcion de compra o presione 0 para salir y mostrar el total : ");
                opcionCompra=sc.nextInt();
                cantidadCompras=opcionesProductos(opcionCompra,preciosPlay.length);
                totalCompra+=calcularTotal(cantidadCompras,preciosPlay);
            }while (opcionCompra!=0);

            System.out.println("desea llevar la promoción de comprar un control extra y escoger 5 juegos " +
                    "si/no?");
            sc.nextLine();
            String opcionNuevo=sc.nextLine();
            if (opcionNuevo.equals("si")){
                System.out.println("que control desea llevar");
                System.out.println("1.control ps3-->80.000");
                System.out.println("2.control ps4-->200.000");
                System.out.println("3.control ps5-->350.000");


                int opcionControl=sc.nextInt();
                int[] cantidadControles=opcionesProductos(opcionControl,3);
                Double totalCompraAcumulada=calcularTotal(cantidadControles,preciosControles)+totalCompra;
                System.out.println("el total de la compra es de: "+totalCompraAcumulada);


            } else if (opcionNuevo.equals("no")) {

                System.out.println("el total de su compra es de: $"+totalCompra);
            }else{

                System.out.println("opcion incorrecta solo responda si/no");
            }
        }else {
            System.out.println("error de ingreso, digite antiguo o nuevo");
        }
    }
    public static void MenuPrecios(){
        System.out.println("1.play 3 --> 300.000");
        System.out.println("2.play 4 --> 900.000");
        System.out.println("3.play 5 --> 2500.000");
        System.out.println("4.control ps3-->80.000");
        System.out.println("5.control ps4-->200.000");
        System.out.println("6.control ps5-->350.000");
    }
    public static int[] opcionesProductos(int opcion, int longitudArreglo){
        int []cantidadCompras=new int[longitudArreglo];

        if (opcion >= 1 && opcion <= 6) {
            cantidadCompras[opcion - 1]++;
        } else {
            System.out.println("Opción incorrecta. Debe estar entre 1 y 6.");
        }

        return cantidadCompras;
    }

    public static double calcularTotal(int[]numeroProductos,Integer[]precios){
        double resultado=0.0;
        for (int i=0;i<numeroProductos.length;i++){
            resultado+=numeroProductos[i]*precios[i];
        }
        return resultado;
    }
    public static double calcularDescuento(double valor, int porcentajeDescuento){
        return valor-=(valor*porcentajeDescuento/100);
    }


}