package package1;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Role> list = new ArrayList<>();

        while (true) {
            System.out.println("\n====== 🦁 멤버 관리 시스템 ======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            int command = Integer.parseInt(sc.nextLine());

            switch (command) {
                case 1: {
                    System.out.println("\n--- 📝 멤버 등록 ---");
                    System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                    int roleNum = Integer.parseInt(sc.nextLine());

                    if (roleNum != 1 && roleNum != 2) {
                        System.out.println("❌ [오류] 올바른 숫자를 입력해주세요.");
                        break;
                    }

                    System.out.print("👤 이름: ");
                    String name = sc.nextLine();

                    boolean isDuplicated = false;
                    for (Role member : list) {
                        if (member.getName().equals(name)) {
                            System.out.println("❌ [오류] 이미 존재하는 이름입니다.");
                            isDuplicated = true;
                            break;
                        }
                    }
                    if (isDuplicated) break;

                    System.out.print("🎓 전공: ");
                    String major = sc.nextLine();
                    System.out.print("📌 기수: ");
                    int generation = Integer.parseInt(sc.nextLine());
                    System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
                    String part = sc.nextLine();

                    Role newMember;
                    if (roleNum == 1) {
                        System.out.print("🆔 학번: ");
                        newMember = new Lion(name, major, generation, part, sc.nextLine());
                    } else {
                        System.out.print("⭐️ 직책: ");
                        newMember = new Staff(name, major, generation, part, sc.nextLine());
                    }

                    list.add(newMember);

                    System.out.println("✅ 등록 완료: " + newMember.getName());
                    break;
                }

                case 2: {
                    System.out.println("\n--- 📋 전체 멤버 목록 ---");
                    if (list.isEmpty()) {
                        System.out.println("❌ [오류] 등록된 멤버가 없습니다.");
                        break;
                    }

                    int index = 1;
                    for (Role member : list) {
                        System.out.printf("%d. [%s] %s - %d기\n", index++, member.getRoleName(), member.getName(), member.getGeneration());
                    }

                    System.out.printf("📊 총 %d명\n", list.size());
                    break;
                }

                case 3: {
                    System.out.println("\n--- 🔍 이름으로 검색 ---");
                    if (list.isEmpty()) {
                        System.out.println("❌ [오류] 리스트가 비어있습니다.");
                        break;
                    }

                    System.out.print("검색할 이름: ");
                    String findName = sc.nextLine();

                    boolean found = false;
                    for (Role member : list) {
                        if (member.getName().equals(findName)) {
                            System.out.println("\n✨ [검색 결과]");
                            System.out.println(member.getProfile());
                            String canSubmit = member.canSubmitByAll() ? "✅ 가능" : "❌ 불가능";
                            System.out.println("📝 과제 제출 가능 여부: " + canSubmit);

                            found = true;
                            break;
                        }
                    }

                    if (!found) System.out.println("❌ [오류] 해당 멤버를 찾을 수 없습니다.");
                    break;
                }

                case 4: {
                    System.out.println("\n👋 멤버 관리 시스템을 종료합니다.");
                    return;
                }

                default: {
                    System.out.println("\n❌ [오류] 올바른 숫자를 입력해주세요.");
                    break;
                }
            }
        }
    }
}
