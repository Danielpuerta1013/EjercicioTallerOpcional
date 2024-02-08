package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer[] preciosPlay={300000,900000,2500000};
        Double totalCompra=0.0;
        int contadorPs3=0;
        int contadorPs4=0;
        int contadorPs5=0;
        int contadorC3=0;
        int contadorC4=0;
        int contadorC5=0;
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
            opcionCompra=sc.nextInt();
            do {
                System.out.print("escoja una opcion de compra o presione 0 para salir : ");
                opcionCompra=sc.nextInt();
                int[]cantidadCompras=opcionesProductos(opcionCompra);

            }while (opcionCompra!=0);
        } else if (opcionAntiguedad.equals("nuevo")) {
            MenuPrecios();
            System.out.println("promoción para clientes nuevos, cada consola viene con un control pero si compras" +
                    "otro extra podras escoger entre 5 juegos ");
            do {
                System.out.print("escoja una opcion de compra o presione 0 para salir : ");
                opcionCompra=sc.nextInt();
                int[]cantidadCompras=opcionesProductos(opcionCompra);
            }while (opcionCompra!=0);
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
    public static int[] opcionesProductos(int opcion){
        int []cantidadCompras=new int[6];

        if (opcion==1){
            cantidadCompras[0]++;
        } else if (opcion==2){
            cantidadCompras[1]++;
        } else if (opcion==3){
            cantidadCompras[2]++;
        } else if (opcion==4){
            cantidadCompras[3]++;
        } else if (opcion==5){
            cantidadCompras[4]++;
        } else if (opcion==6){
            cantidadCompras[5]++;
        }else {
            System.out.println("opcion incorrecta");
        }
        return cantidadCompras;
    }


}