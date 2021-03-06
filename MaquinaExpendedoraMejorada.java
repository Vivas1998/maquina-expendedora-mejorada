public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Billetes vendidos
    private int billetesVendidos;
    // Con o sin premio
    private boolean tipoMaquina;
    // Maximo de billetes
    private int maximoBilletesVendidos;
    // Series vendidas
    private int serieBilletesVendidos;
    
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean tipoDeMaquina, int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        tipoMaquina = tipoDeMaquina;
        maximoBilletesVendidos = maximoBilletes;
        serieBilletesVendidos = 0;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (billetesVendidos < maximoBilletesVendidos) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
        else {
            System.out.println("N?mero de billetes maximos vendidos.");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if (billetesVendidos < maximoBilletesVendidos) {
            int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
            if (cantidadDeDineroQueFalta <= 0) {  
                serieBilletesVendidos = serieBilletesVendidos + 1;
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                if(tipoMaquina == true && 0 == serieBilletesVendidos - 3) {
                    double descuento = (precioBillete * 10) / 100;
                    System.out.println("# Dispones de " + descuento + " euros de descuento para la tienda de regalos de " + estacionDestino);
                    serieBilletesVendidos = 0;
                }
                System.out.println("##################");
                System.out.println();         
                
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // Billetes Vendidos
                billetesVendidos = billetesVendidos + 1;
                }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
                        
            }
        }
        else {
            System.out.println("Todos los billetes estan vendidos.");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**
     * Vacia el dinero de los depositos de la maquina
     */
    public int vaciarDineroDeLaMaquina() {
        int dineroVaciado = -1;
        if (balanceClienteActual == 0) {
            dineroVaciado = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        else {
            System.out.println("Hay una operacion en curso con " + balanceClienteActual + " euros espere a finalizar la operaci?n");
        }
        return dineroVaciado;
    }
    
    /**
     * Numero de billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        return this.billetesVendidos;
    }
    
    /**
     * Imprimir numero de billetes vendidos
     */
    public void imprimeNumeroBileltesVendidos() {
        System.out.println("Se han impreso " + this.billetesVendidos);
    }
}
