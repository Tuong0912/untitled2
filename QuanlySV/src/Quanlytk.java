import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quanlytk {
    Scanner scanner = new Scanner(System.in);
    static Map<String, String> quanlytk = new HashMap<>();

    public Quanlytk() {
        quanlytk = ReadAndWrite.read();
    }

    public void login() {

        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = String.valueOf(scanner.nextInt());
        if (quanlytk.containsKey(name)) {
            if (quanlytk.get(name).equals(password)) {
                System.out.println("Đăng nhặp thành công");
                new Run().QuanLy(); //////////********\\\\\\\\\/
            } else {
                System.out.println("Nhập lại mật khẩu");
                scanner.nextLine();
                String password1 = scanner.nextLine();
                if (quanlytk.get(name).equals(password1)) {
                    System.out.println("Đăng nhập thành công");
                    new Run().QuanLy();
                } else {
                    System.out.println("Đăng nhập thất bại");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Tài Khoản không tồn tại , mời bạn đăng ký hoặc đăng nhập lại");
            int choice = Integer.parseInt(scanner.nextLine());
            while (true) {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Đăng ký");
                        this.dangKy();
                    }
                    case 2 -> {
                        System.out.println("Đăng nhập");
                        this.login();
                    }
                }
            }
        }
    }

    public void dangKy() {
        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        if (!quanlytk.isEmpty() && quanlytk.containsKey(pass)) {
            System.out.println("Tài khoản đã tồn tại");
        } else {
            TaiKhoan taiKhoan = new TaiKhoan(name, pass);
            quanlytk.put(taiKhoan.getAcc(), taiKhoan.getPassword());
            System.out.println("Đăng kí thành công");
        }
        ReadAndWrite.write(quanlytk);
    }

    public void doiMatKhau() {
        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        if (quanlytk.containsKey(name)) {
            if (quanlytk.get(name).equals(pass)) {
                System.out.println("Nhập mật khẩu mới");
                String pass1 = scanner.nextLine();
                if (quanlytk.get(pass1).contains(pass)) {
                    System.out.println("Mật khẩu đã tồn tại , mời nhập lại");
                    String pass2 = scanner.nextLine();
                    quanlytk.put(name, pass2);
                    System.out.println("Đổi mật khẩu thành công");
                } else {
                    quanlytk.put(name, pass1);
                    System.out.println("Đổi mật khẩu thành công");
                }
            } else {
                System.out.println("Sai mật khẩu");
            }
        } else {
            System.out.println("Tài khoản không tồn tại");
        }
    }
}
//"^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"