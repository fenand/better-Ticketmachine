/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // true si da premios false en caso contrario
    private boolean laMaquinaDaPremios;
    //Contador del numero de billetes vendidos de la maquina 
    private int numeroDeBilletesVendidos;
    //Numero maximo de billetes que puede vender
    private int numeroMaximoBilletes;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean daPremios, int maximoBilletes )
    {
        price = cost;
        balance = 0;
        total = 0;
        laMaquinaDaPremios = daPremios;
        numeroDeBilletesVendidos = 0;
        numeroMaximoBilletes = maximoBilletes;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0 )
        {
            if (numeroDeBilletesVendidos<numeroMaximoBilletes){
                balance = balance + amount;
            }
            else{
                System.out.println("No quedan billetes disponibles no se puede introducir dinero");
            }
        }
        else  
        {
            System.out.println("Use a positive amount rather than: " +
                amount);
        } 
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     * 
     * se modifico para dar premios si es true 
     */
    public void printTicket()
    {
        if(numeroDeBilletesVendidos < numeroMaximoBilletes)
        {
            if(balance >= price)
            {
                if(laMaquinaDaPremios) 
                {
                    // Simulate the printing of a ticket.
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Ticket");
                    System.out.println("# " + price + " cents.");
                    System.out.println("##################");
                    System.out.println();

                    // Update the total collected with the price.
                    total = total + price;
                    // Reduce the balance by the prince.
                    balance = balance - price;

                    System.out.println("##################");
                    System.out.println("# ---------------");
                    System.out.println("# Ticket de regalo");
                    System.out.println("##################");
                    System.out.println();

                    numeroDeBilletesVendidos = numeroDeBilletesVendidos + 1;
                }

                else if (balance >= price ) 
                {
                    // Simulate the printing of a ticket.
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Ticket");
                    System.out.println("# " + price + " cents.");
                    System.out.println("##################");
                    System.out.println();

                    // Update the total collected with the price.
                    total = total + price;
                    // Reduce the balance by the prince.
                    balance = balance - price;
                    numeroDeBilletesVendidos = numeroDeBilletesVendidos + 1;
                }
            }

            else 
            {
                System.out.println("You must insert at least: " +
                    (price - balance) + " more cents.");

            }
        }
        else{

            System.out.println("Se han vendido todos los billetes");

        }

    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    public int emtyMachine()
    {
        int amountToRefund;
        if (balance == 0){
            amountToRefund = total;
            total = 0;

        }
        else{
            System.out.println("La maquina tiene una operacion en curso -- ERROR");
            amountToRefund = -1;
        }
        return amountToRefund;
    }
}