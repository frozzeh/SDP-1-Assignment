package travel;

import java.util.ArrayList;
import java.util.List;

public class TripBuilder {
    private String destination;
    private int durationDays;
    private TransportType transport = TransportType.FLIGHT;
    private MealPlan mealPlan = MealPlan.BREAKFAST_ONLY;
    private boolean hasInsurance = false;
    private final List<String> excursions = new ArrayList<>();

    public TripBuilder setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public TripBuilder setDurationDays(int durationDays) {
        this.durationDays = durationDays;
        return this;
    }

    public TripBuilder setTransport(TransportType transport) {
        this.transport = transport;
        return this;
    }

    public TripBuilder setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
        return this;
    }

    public TripBuilder setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
        return this;
    }

    public TripBuilder addExcursion(String excursion) {
        if (excursion != null && !excursion.isBlank()) {
            this.excursions.add(excursion);
        }
        return this;
    }

    public TravelTrip build() {
        if (destination == null || destination.isBlank()) {
            throw new IllegalStateException("Trip destination must be specified!");
        }
        if (durationDays <= 0) {
            throw new IllegalStateException("Trip duration must be at least 1 day!");
        }
        return new TravelTrip(destination, durationDays, transport, mealPlan, hasInsurance, new ArrayList<>(excursions));
    }
}