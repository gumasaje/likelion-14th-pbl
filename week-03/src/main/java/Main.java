import policy.GenerationSubmissionPolicy;
import role.Alumni;
import role.Lion;
import role.Role;
import role.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====== 🦁 아기사자 정보 입력 ======");
        BasicProfile lionProfile = readBasicProfile(sc);

        System.out.print("🆔 학번: ");
        String studentId = sc.nextLine();

        Role lion = new Lion(lionProfile.name, lionProfile.major, lionProfile.generation, lionProfile.part, studentId);

        System.out.println("\n====== 🧑‍💼 운영진 정보 입력 ======");
        BasicProfile staffProfile = readBasicProfile(sc);

        System.out.print("⭐️ 직책 (대표/부대표/파트장/멘토): ");
        String position = sc.nextLine();

        Role staff = new Staff(staffProfile.name, staffProfile.major, staffProfile.generation, staffProfile.part, position);

        System.out.println("\n====== 🎓‍ 알럼나이 정보 입력 ======");
        BasicProfile alumniProfile = readBasicProfile(sc);

        System.out.print("💼 현재 직무: ");
        String currentPosition = sc.nextLine();

        Role alumni = new Alumni(alumniProfile.name, alumniProfile.major, alumniProfile.generation, alumniProfile.part, currentPosition);

        System.out.println("\n======== 📋 결과 출력 =========\n");

        printRoleInfo(lion);
        printRoleInfo(staff);
        printRoleInfo(alumni);

        System.out.println("\n======== 🔍 조건 정책 결과 =========\n");
        System.out.println("📌 최소 기수 조건: " + GenerationSubmissionPolicy.MIN_GEN + "기 이상\n");

        printGenerationInfo(lion);
        printGenerationInfo(staff);
        printGenerationInfo(alumni);

        sc.close();
    }

    private static void printRoleInfo(Role role) {
        System.out.println(role.getProfile());

        String status = role.canSubmitByAll() ? "✅ 가능" : " ❌ 불가능";
        System.out.println("📝 과제 제출 가능 여부: " + status);

        System.out.println("-----------------------------");
    }

    private static BasicProfile readBasicProfile(Scanner sc) {
        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        System.out.print("🎓 전공: ");
        String major = sc.nextLine();

        System.out.print("📌 기수: ");
        int generation = Integer.parseInt(sc.nextLine());

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();

        return new BasicProfile(name, major, generation, part);
    }

    private static void printGenerationInfo(Role role) {
        System.out.println("👤 " + role.getName() + " (" + role.getGeneration() + "기)");

        String status = role.canSubmitByGeneration() ? "✅ 충족" : " ❌ 미충족";
        System.out.println("📝 기수 조건 충족 여부: " + status);

        System.out.println("-----------------------------");
    }

    static class BasicProfile {
        String name;
        String major;
        int generation;
        String part;

        BasicProfile(String name, String major, int generation, String part) {
            this.name = name;
            this.major = major;
            this.generation = generation;
            this.part = part;
        }
    }
}