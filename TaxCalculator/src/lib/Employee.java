package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private boolean gender; 
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber = "";

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	/**
	 * Fungs untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
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

		monthlySalary = baseSalary;
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(
			    monthlySalary, 
			    otherMonthlyIncome, 
			    monthWorkingInYear, 
			    annualDeductible, 
			    spouseIdNumber != null && !spouseIdNumber.equals(""), 
			    childIdNumbers.size()
			);
	}
    private String employeeId;
    private PersonalData personalData;
    private JoiningDate joiningDate;
    private boolean isForeigner;
    private Gender gender;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private String spouseName;
    private String spouseIdNumber = "";

    private List<String> childNames;
    private List<String> childIdNumbers;

    private TaxCalculatorService taxCalculatorService;

    public Employee(String employeeId, PersonalData personalData, JoiningDate joiningDate, boolean isForeigner, Gender gender, TaxCalculatorService taxCalculatorService) {
        this.employeeId = employeeId;
        this.personalData = personalData;
        this.joiningDate = joiningDate;
        this.isForeigner = isForeigner;
        this.gender = gender;
        this.taxCalculatorService = taxCalculatorService;

        this.childNames = new LinkedList<>();
        this.childIdNumbers = new LinkedList<>();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public JoiningDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(JoiningDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public void setForeigner(boolean isForeigner) {
        this.isForeigner = isForeigner;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public void setOtherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public void setAnnualDeductible(int annualDeductible) {
        this.annualDeductible = annualDeductible;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public void setSpouseIdNumber(String spouseIdNumber) {
        this.spouseIdNumber = spouseIdNumber;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public boolean hasSpouse() {
        return (spouseIdNumber != null && !spouseIdNumber.isEmpty());
    }

    public int getChildCount() {
        return childNames.size();
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
    public String getEmployeeId() {
        return employeeId;
    }
    public PersonalData getPersonalData() {
        return personalData;
        return taxCalculatorService.calculateAnnualIncomeTax(this);
    }
    //refactor//

