package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private String employeeId;
    private PersonalData personalData;
    private JoiningDate joiningDate;
    private boolean isForeigner;
    private Gender gender;

    private int monthWorkingInYear;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private String spouseName;
    private String spouseIdNumber = "";

    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(String employeeId, PersonalData personalData, JoiningDate joiningDate, boolean isForeigner, Gender gender) {
        this.employeeId = employeeId;
        this.personalData = personalData;
        this.joiningDate = joiningDate;
        this.isForeigner = isForeigner;
        this.gender = gender;

        this.childNames = new LinkedList<>();
        this.childIdNumbers = new LinkedList<>();
    }

    public void setMonthlySalary(int grade) {
        int baseSalary;
        switch (grade) {
            case 1:
                baseSalary = 3000000;
                break;
            case 2:
                baseSalary = 5000000;
                break;
            case 3:
                baseSalary = 7000000;
                break;
            default:
                baseSalary = 0;
        }

        if (isForeigner) {
            baseSalary *= 1.5;
        }

        this.monthlySalary = baseSalary;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {
        LocalDate now = LocalDate.now();
        if (now.getYear() == joiningDate.getDateJoined().getYear()) {
            monthWorkingInYear = now.getMonthValue() - joiningDate.getDateJoined().getMonthValue();
        } else {
            monthWorkingInYear = 12;
        }

        return TaxFunction.calculateTax(
                monthlySalary,
                otherMonthlyIncome,
                monthWorkingInYear,
                annualDeductible,
                spouseIdNumber != null && !spouseIdNumber.isEmpty(),
                childIdNumbers.size()
        );
    }

    // Getter tambahan jika perlu mengakses informasi pribadi
    public PersonalData getPersonalData() {
        return personalData;
    }
}
