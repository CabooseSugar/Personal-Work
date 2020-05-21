package exercise7;

import java.util.Objects;

public class Doctor extends SalariedEmployee {
    public static void main(String[] args) {
        Doctor doc1 = new Doctor();

        System.out.println(doc1);

        Doctor doc2 = new Doctor("Optometry", 50.00);

        System.out.println(doc2);

        Doctor doc3 = new Doctor("Optometry", 50.00);
        Doctor doc4 = new Doctor("Dentistry", 25.00);

        if (doc2.equals(doc3))
            System.out.println("\ndoc2 = doc3");
        else
            System.out.println("\ndoc2 != doc3");
        if (doc2.equals(doc4))
            System.out.println("doc2 = doc4");
        else
            System.out.println("doc2 != doc4");

        System.out.println("\ndoc4 speciality = " + doc4.getSpeciality() + " and doc4 fee = " + doc4.getFee());

        System.out.println("\nSetting doc1 specialty to Pediatrics with a fee = 100...");
        doc1.setSpeciality("Pediatrics");
        doc1.setFee(100.0);

        System.out.print(doc1);

    }

    // INSTANCE DATA
    String speciality;
    double fee;

    // CONSTRUCTORS
    public Doctor() {
        super();
        speciality = "Undefined";
        fee = 0;
    }

    public Doctor(String speciality, double fee) {
        this.speciality = speciality;
        this.fee = fee;
    }

    public Doctor(String theName, Date theDate, double theSalary, String speciality, double fee) {
        super(theName, theDate, theSalary);
        this.speciality = speciality;
        this.fee = fee;
    }

    // ACCESSOR METHODS
    public String getSpeciality() {
        return speciality;
    }

    public double getFee() {
        return fee;
    }

    // MUTATOR METHODS
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }


    // TO STRING METHOD
    @Override
    public String toString() {
        return "Doctor{" +
                "speciality='" + speciality + '\'' +
                ", fee=" + fee +
                '}';
    }

    // EQUALS METHOD
    public boolean equals(Doctor doctor) {
        if (doctor.getFee() == this.getFee() &&
        doctor.getSpeciality().equals(this.getSpeciality()))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speciality, fee);
    }
}

/*
Doctor{speciality='Undefined', fee=0.0}
Doctor{speciality='Optometry', fee=50.0}

doc2 = doc3
doc2 != doc4

doc4 speciality = Dentistry and doc4 fee = 25.0

Setting doc1 specialty to Pediatrics with a fee = 100...
Doctor{speciality='Pediatrics', fee=100.0}
Process finished with exit code 0
 */