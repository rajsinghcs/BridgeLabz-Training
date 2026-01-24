import java.util.*;
import java.time.LocalDate;

class Policy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolderName,
                  LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{" + "policyNumber='" + policyNumber + '\'' + ", policyHolderName='" + policyHolderName + '\'' + ", expiryDate=" + expiryDate + ", coverageType='" + coverageType + '\'' + ", premiumAmount=" + premiumAmount + '}';
    }
}
