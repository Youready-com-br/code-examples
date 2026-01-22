package br.com.youready.carrousel;

import java.time.LocalDate;

class RentalCompany {

    public LocalDate holidayPeriodStart;
    public LocalDate holidayPeriodEnd;
    public Long holidayDailyRate;
    public Long standardDailyRate;
    public long weeklyDiscount;

    public Long calculateCharge(LocalDate rentalStart,
                                LocalDate rentalEnd, int days) {
        return isHolidayPeriod(rentalStart, rentalEnd) ?
                holidayCharge(days) : standardCharge(days);
    }

    private Long standardCharge(int days) {
        return days * this.standardDailyRate - this.weeklyDiscount;
    }

    private Long holidayCharge(int days) {
        return days * this.holidayDailyRate;
    }

    private boolean isHolidayPeriod(LocalDate rentalStart,
                                    LocalDate rentalEnd) {
        return !rentalStart.isBefore(this.holidayPeriodStart) &&
                !rentalEnd.isAfter(this.holidayPeriodEnd);
    }
}
