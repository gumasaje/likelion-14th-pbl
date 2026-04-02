package bonus;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lion lion;

        System.out.println("🦁아기사자 이름을 입력해주세요.");
        String name = sc.nextLine();

        System.out.println("🎓전공을 입력해주세요.");
        String major = sc.nextLine();

        System.out.println("📌기수를 입력해주세요.");
        int generation = sc.nextInt();
        sc.nextLine();

        try {
            lion = new Lion(name, major, generation);
        } catch (IllegalArgumentException e) {
            System.out.println("❌" + e.getMessage());
            System.out.println("❌잘못된 아기사자 정보입니다.");
            return;
        }

        System.out.println("✅유효한 값으로 아기사자 객체가 생성되었습니다.");
        lion.printProfile();

        while (true) {
            System.out.println("===============");
            System.out.println("❓아기사자 정보를 수정하시겠습니까? (네 / 아니요)");
            String answer = sc.nextLine();

            if (answer.equals("네")) {
                try {
                    System.out.println("✏️수정할 정보를 입력해주세요. (이름 / 전공 / 기수)");
                    String field = sc.nextLine();

                    switch (field) {
                        case "이름":
                            System.out.println("✏️변경할 이름을 입력해주세요.");
                            String newName = sc.nextLine();
                            lion.changeName(newName);
                            break;
                        case "전공":
                            System.out.println("✏️변경할 전공을 입력해주세요.");
                            String newMajor = sc.nextLine();
                            lion.changeMajor(newMajor);
                            break;
                        case "기수":
                            System.out.println("✏️변경할 기수를 입력해주세요.");
                            int newGeneration = sc.nextInt();
                            sc.nextLine();
                            lion.changeGeneration(newGeneration);
                            break;
                        default:
                            System.out.println("❗️[오류] 잘못된 항목입니다. 이름, 전공, 기수만 입력해주세요.");
                            continue;
                    }

                    System.out.println("✅" + field + "이(가) 성공적으로 변경되었습니다.");
                    lion.printProfile();

                } catch (IllegalArgumentException e) {
                    System.out.println("❌" + e.getMessage());
                    System.out.println("❌변경에 실패했습니다. 다시 시도해주세요.");
                }
            } else if (answer.equals("아니요")) {
                System.out.println("📌아기사자 정보 수정을 종료합니다.");
                sc.close();
                return;
            } else {
                System.out.println("❗️[오류] 잘못된 명령어입니다. '네' 또는 '아니요'만 입력해주세요.");
            }
        }
    }
}
