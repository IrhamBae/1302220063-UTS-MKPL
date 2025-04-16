package lib;

import java.time.LocalDate;


public class TaxCalculatorService {

    public int calculateAnnualIncomeTax(Employee employee) {
        LocalDate joinDate = employee.getJoiningDate().getDateJoined();
        LocalDate now = LocalDate.now();

        int monthsWorked;
        if (now.getYear() == joinDate.getYear()) {
            monthsWorked = now.getMonthValue() - joinDate.getMonthValue();
        } else {
            monthsWorked = 12;
        }

        return TaxFunction.calculateTax(
                employee.getMonthlySalary(),
                employee.getOtherMonthlyIncome(),
                monthsWorked,
                employee.getAnnualDeductible(),
                employee.hasSpouse(),
                employee.getChildCount()
        );
    }
}
