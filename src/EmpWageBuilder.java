import java.util.ArrayList;
public class EmpWageBuilder {
    private static final int FULL_DAY_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;

    private ArrayList<CompanyEmpWage> companyEmpWageList;

    public EmpWageBuilder() {
        companyEmpWageList = new ArrayList<>();
    }

    public void addCompanyEmpWage(CompanyEmpWage companyEmpWage) {
        companyEmpWageList.add(companyEmpWage);
    }

    public int getTotalWageByCompany(String companyName) {
        int totalWage = 0;
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            if (companyEmpWage.getCompanyName().equals(companyName)) {
                totalWage += companyEmpWage.getTotalWage();
            }
        }

        return totalWage;
    }

    public static void main(String[] args) {
        EmpWageBuilder empWageBuilder = new EmpWageBuilder();

        CompanyEmpWage companyEmpWage1 = new CompanyEmpWage("ABC Company", 20, 20, 100);
        CompanyEmpWage companyEmpWage2 = new CompanyEmpWage("XYZ Company", 30, 20, 100);

        empWageBuilder.addCompanyEmpWage(companyEmpWage1);
        empWageBuilder.addCompanyEmpWage(companyEmpWage2);

        int totalWageABCCompany = empWageBuilder.getTotalWageByCompany("ABC Company");
        int totalWageXYZCompany = empWageBuilder.getTotalWageByCompany("XYZ Company");

        System.out.println("Total wage for ABC Company is " + totalWageABCCompany);
        System.out.println("Total wage for XYZ Company is " + totalWageXYZCompany);
    }
}

class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int workingDays;
    private int workingHours;
    private int totalWage;

    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int workingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
        this.totalWage = calculateTotalWage();
    }

    public int calculateTotalWage() {
        return wagePerHour * workingDays * workingHours;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public int getTotalWage() {
        return totalWage;
    }
}
