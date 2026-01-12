package br.com.youready.article.d_2026_01_13;

// AGENT: 4 to 57
public class BookingRefactored {
    private int duration;
    private int hourlyRate;
    private Client client;
    /* NEW */
    private BookingCharges charges = new BookingCharges();

    public void extend(int additionalHours) {
        if (additionalHours > 0) {
            this.duration += additionalHours;
        }
    }

    public void extendForDay() {
        this.extend(24);
    }

    /* NEW */
    int getAdditionalCharges() {
        return charges.getAdditionalCharges();
    }

    /* NEW */
    int getBaseCharge() {
        return charges.getBaseCharge(duration, hourlyRate);
    }

    /* NEW */
    public int getTotalCharge() {
        return getBaseCharge() + getAdditionalCharges();
    }

    /* NEW */
    public double getHourlyRateWithCharges() {
        return charges.getHourlyRateWithCharges(duration, hourlyRate);
    }

    public boolean isLongBooking() {
        return duration > 40;
    }

    public String summary() {
        return String.format("Booking for %s: %d hours at $%d/hour. " +
                        "Total: $%d",
                client.getName(), duration, hourlyRate, getTotalCharge());
    }

    public void applyDiscount(int discountPercentage) {
        if (discountPercentage > 0 && discountPercentage <= 100) {
            hourlyRate =
                    hourlyRate - (hourlyRate * discountPercentage / 100);
        }
    }
}
