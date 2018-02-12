import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicketCheckout {

	public static void main(String[] args) {
		//Use HashMap to store different types of tickets and extras available
		Map<String, Float> ticketMap = new HashMap<String, Float>();
		ticketMap.put("Standard", (float) 7.9);
		ticketMap.put("Concession", (float) 5.4);
		ticketMap.put("IMax", (float) 0.9);
		ticketMap.put("Real3D", (float) 1.5);
		float ticketFloat = (float) 0;
		float extraFloat = (float) 0;
		//For formatting final float values
		DecimalFormat df = new DecimalFormat("###.##");
		//Implement scanner to register user input from console
		Scanner movieScan = new Scanner(System.in);

		System.out.println("---------------------------------------");
		System.out.println("Welcome to Flick Cinemas");
		System.out.println("Enter day of the week: Mon/Tue/Wed/Thurs/Fri/Sat/Sun");
		String weekDay = movieScan.next();
		movieScan.nextLine();

		System.out.println("What tickets would you like?: Standard/Concession");
		String ticketType = movieScan.next();
		movieScan.nextLine();

		System.out.println("Would you like to add any extras to the tickets?: IMax/Real3D/None");
		String ticketExtra = movieScan.next();
		movieScan.nextLine();

		System.out.println("How many tickets would you like?");
		int numTickets = movieScan.nextInt();
		movieScan.nextLine();

		// Determine type of ticket
		if (ticketType.equals("Standard")) {
			ticketFloat = ticketMap.get("Standard").floatValue();
		} else {
			ticketFloat = ticketMap.get("Concession").floatValue();
		}

		// Determine if any extras are added
		if (ticketExtra.equals("IMax")) {
			extraFloat = ticketMap.get("IMax").floatValue();
			ticketFloat = ticketFloat + extraFloat;
		} else if (ticketExtra.equals("Real3D")) {
			extraFloat = ticketMap.get("Real3D").floatValue();
			ticketFloat = ticketFloat + extraFloat;
		} else {
			extraFloat = 0;
			ticketFloat = ticketFloat + extraFloat;
		}

		//Determine if deal should be applied
		if (weekDay.equals("Thurs")) {
			int dealTicket = numTickets / 3;
			float moneySaved = (ticketFloat * numTickets) - (ticketFloat * dealTicket);

			// Formatted output
			System.out.printf("%d %s %s %s%s %n", numTickets, ticketType, ticketExtra, "tickets your total is £",
					df.format((ticketFloat * dealTicket)));
			System.out.printf("%s%s %s %n", "You have saved £",
					df.format(((ticketFloat * numTickets) - (ticketFloat * dealTicket))),
					"thanks to Three for One Thursdays");
		} else {
			System.out.printf("%s%s%n", "Your total is £", df.format((ticketFloat * numTickets)));
		}
		System.out.println("Thank you for visiting Flick Cinemas, enjoy your film");
		System.out.println("---------------------------------------");
	}

}
