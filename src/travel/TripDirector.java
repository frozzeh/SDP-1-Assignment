package travel;

public class TripDirector {

    public TravelTrip makeLuxuryResortTrip(TripBuilder builder, String destination) {
        return builder
                .setDestination(destination)
                .setDurationDays(7)
                .setTransport(TransportType.FLIGHT)
                .setMealPlan(MealPlan.ALL_INCLUSIVE)
                .setHasInsurance(true)
                .addExcursion("Yacht Tour")
                .addExcursion("Spa Package")
                .build();
    }

    public TravelTrip makeBudgetCityBreak(TripBuilder builder, String destination) {
        return builder
                .setDestination(destination)
                .setDurationDays(3)
                .setTransport(TransportType.BUS)
                .setMealPlan(MealPlan.BREAKFAST_ONLY)
                .setHasInsurance(false)
                .addExcursion("Walking City Sightseeing")
                .build();
    }
}