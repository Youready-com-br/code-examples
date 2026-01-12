package br.com.youready.carrousel;

import java.time.LocalDate;

public class DecomposeConditionalExample {

    private LocalDate rentalStart, rentalEnd;
    private RentalCompany rentalCompany;
    private Long days;
    private Long rentalCharge;

    void before() {
        // Start
        if (!rentalStart.isBefore(rentalCompany.holidayPeriodStart) &&
                !rentalEnd.isAfter(rentalCompany.holidayPeriodEnd)) {
            rentalCharge = days * rentalCompany.holidayDailyRate;
        } else {
            rentalCharge = days * rentalCompany.standardDailyRate - rentalCompany.weeklyDiscount;
        }
        // End
    }

    void after() {
        // Start
        if (isHolidayPeriod()) {
            rentalCharge = holidayCharge();
        } else {
            rentalCharge = standardCharge();
        }
        // End
     }

     void alternative() {
        // Start
        rentalCharge = isHolidayPeriod() ? holidayCharge() : standardCharge();
        // End
     }

    private Long standardCharge() {
        return days * rentalCompany.standardDailyRate - rentalCompany.weeklyDiscount;
    }

    private Long holidayCharge() {
        return days * rentalCompany.holidayDailyRate;
    }

    private boolean isHolidayPeriod() {
        return !rentalStart.isBefore(rentalCompany.holidayPeriodStart) &&
                !rentalEnd.isAfter(rentalCompany.holidayPeriodEnd);
    }
}

class RentalCompany {

    public LocalDate holidayPeriodStart;
    public LocalDate holidayPeriodEnd;
    public Long holidayDailyRate;
    public Long standardDailyRate;
    public long weeklyDiscount;
}
