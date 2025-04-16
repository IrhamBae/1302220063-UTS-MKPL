package lib;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan gaji bulanan: ");
        int monthlySalary = scanner.nextInt();

        System.out.print("Masukkan pemasukan tambahan bulanan: ");
        int otherMonthlyIncome = scanner.nextInt();

        System.out.print("Masukkan jumlah bulan bekerja tahun ini (1-12): ");
        int numberOfMonthWorking = scanner.nextInt();

        System.out.print("Masukkan total pengurang/deductible: ");
        int deductible = scanner.nextInt();

        System.out.print("Apakah sudah menikah? (true/false): ");
        boolean isMarried = scanner.nextBoolean();

        System.out.print("Masukkan jumlah anak: ");
        int numberOfChildren = scanner.nextInt();

        int tax = TaxFunction.calculateTax(
                monthlySalary,
                otherMonthlyIncome,
                numberOfMonthWorking,
                deductible,
                isMarried,
                numberOfChildren
        );

        System.out.println("Pajak penghasilan yang harus dibayar: Rp " + tax);
    }
}
