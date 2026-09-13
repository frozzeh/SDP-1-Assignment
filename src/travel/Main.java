package travel;

public class Main {
    public static void main(String[] args) {
        TravelTrip customTrip = new TripBuilder()
                .setDestination("Italy")
                .setDurationDays(10)
                .setTransport(TransportType.TRAIN)
                .setMealPlan(MealPlan.BREAKFAST_ONLY)
                .setHasInsurance(true)
                .addExcursion("Colosseum Tour")
                .addExcursion("Vatican Museum")
                .build();

        System.out.println("Custom Trip: " + customTrip);

        TripDirector director = new TripDirector();

        TravelTrip luxuryTrip = director.makeLuxuryResortTrip(new TripBuilder(), "Maldives");
        System.out.println("Luxury Trip: " + luxuryTrip);

        TravelTrip budgetTrip = director.makeBudgetCityBreak(new TripBuilder(), "Prague");
        System.out.println("Budget Trip: " + budgetTrip);
    }
}