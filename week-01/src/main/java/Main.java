import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int count = 0;

            try {
                System.out.println("🦁저장할 아기사자 수를 5 이상 입력해주세요.");
                count = Integer.parseInt(sc.nextLine());

                if (count < 5) {
                    System.out.println("❗️[오류] 5 이상 입력해주세요.");
                    continue;
                }

            } catch (Exception e) {
                System.out.println("❗️[오류] 숫자만 입력할 수 있습니다.");
                continue;
            }

            String[] names = new String[count];

            for (int i = 0; i < names.length; i++) {
                System.out.println("✏️" + (i + 1) + "번째 아기사자 이름을 입력해주세요.");

                String name = sc.nextLine();

                if (name.trim().isEmpty()) {
                    System.out.println("⚠️이름이 비어있습니다. 다시 입력해주세요.");
                    i--;
                    continue;
                }

                boolean isDuplicated = false;
                for (int j = 0; j < i; j++) {
                    if (name.equals(names[j])) {
                        isDuplicated = true;
                        break;
                    }
                }

                if (isDuplicated) {
                    System.out.println("⚠️이미 등록된 이름입니다. 다시 입력해주세요.");
                    i--;
                    continue;
                }

                names[i] = name;
            }

            System.out.println("📋아기사자 명단을 최종적으로 출력합니다.");
            for (int i = 0; i < names.length; i++) {
                System.out.println("🦁" + (i + 1) + ". " + names[i]);
            }

            System.out.println("==================");
            System.out.println("⛔️프로그램을 종료하려면 'exit'를 입력하세요.");
            System.out.println("🔁계속 아기사자를 등록하려면 'restart'를 입력하세요.");

            while (true) {
                String command = sc.nextLine();
                if (command.equals("exit")) {
                    System.out.println("👋아기사자 명단 관리 프로그램을 종료합니다.");
                    sc.close();
                    return;
                } else if (command.equals("restart")) {
                    break;
                } else {
                    System.out.println("❗️[오류] 잘못된 명령어입니다. 'exit' 또는 'restart'만 입력해주세요.");
                }
            }
        }
    }
}