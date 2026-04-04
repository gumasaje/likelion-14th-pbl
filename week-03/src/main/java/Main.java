import role.Lion;
import role.Role;
import role.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====== 🦁 아기사자 정보 입력 ======");

        System.out.print("👤 이름: ");
        String lionName = sc.nextLine();

        System.out.print("🎓 전공: ");
        String lionMajor = sc.nextLine();

        System.out.print("📌 기수: ");
        int lionGen = Integer.parseInt(sc.nextLine());

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = sc.nextLine();

        System.out.print("🆔 학번: ");
        String studentId = sc.nextLine();

        Role lion = new Lion(lionName, lionMajor, lionGen, lionPart, studentId);

        System.out.println("\n====== 🧑‍💼 운영진 정보 입력 ======");

        System.out.print("👤 이름: ");
        String staffName = sc.nextLine();

        System.out.print("🎓 전공: ");
        String staffMajor = sc.nextLine();

        System.out.print("📌 기수: ");
        int staffGen = Integer.parseInt(sc.nextLine());

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = sc.nextLine();

        System.out.print("⭐️ 직책 (대표/부대표/파트장/멘토): ");
        String position = sc.nextLine();

        Role staff = new Staff(staffName, staffMajor, staffGen, staffPart, position);

        System.out.println("\n======== 📋 결과 출력 =========\n");

        printRoleInfo(lion);
        printRoleInfo(staff);

        sc.close();
    }

    private static void printRoleInfo(Role role) {
        System.out.println(role.getProfile());

        String status = role.isSubmittable() ? "✅ 가능" : " ❌ 불가능";
        System.out.println("📝 과제 제출 가능 여부: " + status);

        System.out.println("-----------------------------");
    }
}
