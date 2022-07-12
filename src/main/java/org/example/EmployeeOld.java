package org.example;

/*Create the abstract base class Employee with protected string variable employeelD and public getFullInfo() method without an implementation. Create public constructor with one string parameter for this class.

Create two classes SalariedEmployee and ContractEmployee, which are inherited from the Employee class.
•Describe protected string field socialSecurityNumber in the class SalariedEmployee.
•Include a description of string protected federalTaxIDMember field in the class of ContractEmployee.
•Describe constructors with two parameters for ContractEmployee class and for SalariedEmployee class for initializing corresponding fields.
•getFullInfo should return String containing:
     • employeelD and socialSecurityNumber for SalariedEmployee
     • employeelD and federalTaxIDMember for ContractEmployee*/


public abstract class EmployeeOld {
    protected String employeeID;

    public abstract String getFullInfo();

    public EmployeeOld(String str) {
        this.employeeID = str;
    }
}

class SalariedEmployee extends EmployeeOld {
    protected String socialSecurityNumber;

    public SalariedEmployee(String SSN, String ID) {
        super(ID);
        this.socialSecurityNumber = SSN;
    }

    @Override
    public String getFullInfo() {
        return socialSecurityNumber+employeeID;
    }
}

class ContractEmployee extends EmployeeOld {
    protected String federalTaxIDMember;

    public ContractEmployee(String ftIDM, String ID) {
        super(ID);
        this.federalTaxIDMember = ftIDM;
    }

    @Override
    public String getFullInfo() {
        return federalTaxIDMember+employeeID;
    }
}