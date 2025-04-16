package lib;

import java.time.LocalDate;

public class TaxFunction {

    public static int calculateTax(
        int monthlySalary,
        int otherMonthlyIncome,
        int monthsWorked,
        int annualDeductible,
        boolean hasSpouse,
        int numberOfChildren
    ) {
        int tax = (monthlySalary + otherMonthlyIncome) * monthsWorked;
        tax -= annualDeductible;

        if (hasSpouse) {
            tax -= 4500000;
        }

        tax -= numberOfChildren * 2000000;

        tax *= 0.05;

        return Math.max(tax, 0);
    }

    public static int calculateTaxForEmployee(Employee employee) {
        LocalDate now = LocalDate.now();
        LocalDate joinDate = employee.getJoiningDate().getDateJoined();

        int monthsWorked;
        if (now.getYear() == joinDate.getYear()) {
            monthsWorked = now.getMonthValue() - joinDate.getMonthValue();
        } else {
            monthsWorked = 12;
        }

        return calculateTax(
                employee.getMonthlySalary(),
                employee.getOtherMonthlyIncome(),
                monthsWorked,
                employee.getAnnualDeductible(),
                employee.hasSpouse(),
                employee.getChildCount()
        );
    }
}
