package app;

import lib.Employee;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input data pegawai dari pengguna
        System.out.println("Masukkan ID Pegawai:");
        String employeeId = scanner.nextLine();

        System.out.println("Masukkan Nama Depan:");
        String firstName = scanner.nextLine();

        System.out.println("Masukkan Nama Belakang:");
        String lastName = scanner.nextLine();

        System.out.println("Masukkan Nomor Identitas:");
        String idNumber = scanner.nextLine();

        System.out.println("Masukkan Alamat:");
        String address = scanner.nextLine();

        System.out.println("Masukkan Tahun Bergabung:");
        int yearJoined = scanner.nextInt();

        System.out.println("Masukkan Bulan Bergabung (1-12):");
        int monthJoined = scanner.nextInt();

        System.out.println("Masukkan Tanggal Bergabung:");
        int dayJoined = scanner.nextInt();

        System.out.println("Apakah Pegawai Warga Negara Asing? (true/false):");
        boolean isForeigner = scanner.nextBoolean();

        System.out.println("Jenis Kelamin (true = Laki-laki, false = Perempuan):");
        boolean gender = scanner.nextBoolean();

        // Membuat objek Employee
        Employee employee = new Employee(employeeId, firstName, lastName, idNumber, address, yearJoined, monthJoined, dayJoined, isForeigner, gender);
     // Hitung dan tampilkan pajak tahunan
        int tax = employee.getAnnualIncomeTax();
        System.out.println("Pajak tahunan yang harus dibayarkan: Rp " + tax);

        scanner.close();
    }
}