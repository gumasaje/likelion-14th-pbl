package package2;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberRepository memberRepository = null;

        while (memberRepository == null) {
            System.out.println("\n🔧 저장소를 선택하세요: ");
            System.out.println("1. MemoryMemberRepository (실제 저장)");
            System.out.println("2. MockMemberRepository (더미 데이터)");
            System.out.print("선택: ");
            String repositoryCommand = sc.nextLine();

            switch (repositoryCommand) {
                case "1":
                    memberRepository = new MemoryMemberRepository();
                    break;
                case "2":
                    memberRepository = new MockMemberRepository();
                    break;
                default:
                    System.out.println("❌ [오류] 올바른 숫자를 입력해주세요.");
                    break;
            }
        }

        MemberService memberService = new MemberService(memberRepository);

        while (true) {
            System.out.println("\n====== 🦁 멤버 관리 시스템 ======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            String command = sc.nextLine();

            switch (command) {
                case "1": {
                    if(!memberService.isWritable()) {
                        System.out.println("❌ [오류] 현재 저장소(Mock)는 읽기 전용입니다. 등록 기능을 사용할 수 없습니다.");
                        break;
                    }

                    System.out.println("\n--- 📝 멤버 등록 ---");
                    System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                    String roleNum = sc.nextLine();

                    if (!(roleNum.equals("1") || roleNum.equals("2"))) {
                        System.out.println("❌ [오류] 올바른 숫자를 입력해주세요.");
                        break;
                    }

                    System.out.print("👤 이름: ");
                    String name = sc.nextLine();
                    System.out.print("🎓 전공: ");
                    String major = sc.nextLine();
                    System.out.print("📌 기수: ");
                    int generation = Integer.parseInt(sc.nextLine());
                    System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
                    String part = sc.nextLine();

                    Role newMember;
                    if (roleNum.equals("1")) {
                        System.out.print("🆔 학번: ");
                        newMember = new Lion(name, major, generation, part, sc.nextLine());
                    } else {
                        System.out.print("⭐️ 직책: ");
                        newMember = new Staff(name, major, generation, part, sc.nextLine());
                    }

                    try {
                        memberService.registerMember(newMember);
                        System.out.println("✅ 등록 완료: " + newMember.getName());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case "2": {
                    System.out.println("\n--- 📋 전체 멤버 목록 ---");
                    List<Role> allMembers = memberService.findAllMembers();

                    if (allMembers.isEmpty()) {
                        System.out.println("❌ [오류] 등록된 멤버가 없습니다.");
                        break;
                    }

                    int index = 1;
                    for (Role member : allMembers) {
                        System.out.printf("%d. [%s] %s - %d기\n", index++, member.getRoleName(), member.getName(), member.getGeneration());
                    }

                    System.out.printf("📊 총 %d명\n", allMembers.size());
                    break;
                }

                case "3": {
                    System.out.println("\n--- 🔍 이름으로 검색 ---");
                    if (memberService.findAllMembers().isEmpty()) {
                        System.out.println("❌ [오류] 리스트가 비어있습니다.");
                        break;
                    }

                    System.out.print("검색할 이름: ");
                    String findName = sc.nextLine();

                    Role findMember = memberService.findMemberByName(findName);

                    if (findMember == null) {
                        System.out.println("❌ [오류] 해당 멤버를 찾을 수 없습니다.");
                        break;
                    }

                    System.out.println("\n✨ [검색 결과]");
                    System.out.println(findMember.getProfile());
                    String canSubmit = findMember.canSubmitByAll() ? "✅ 가능" : "❌ 불가능";
                    System.out.println("📝 과제 제출 가능 여부: " + canSubmit);
                    break;
                }

                case "4": {
                    System.out.println("\n--- 💻 파트별 조회 ---");
                    if (memberService.findAllParts().isEmpty()) {
                        System.out.println("❌ [오류] 등록된 파트가 없습니다.");
                        break;
                    }

                    System.out.println("📂 등록된 파트: " + memberService.findAllParts());
                    System.out.print("조회할 파트: ");
                    String findPart = sc.nextLine();

                    List<Role> partList = memberService.findMembersByPart(findPart);

                    if (partList == null) {
                        System.out.println("❌ [오류] 해당 파트에 등록된 멤버가 없습니다.");
                        break;
                    }

                    System.out.printf("\n✨ [%s 파트 멤버]\n", findPart);

                    int index = 1;
                    for (Role member : partList) {
                        System.out.printf("%d. %s (%s) - %d기\n", index++, member.getName(), member.getRoleName(), member.getGeneration());
                    }
                    break;
                }

                case "5": {
                    System.out.println("\n👋 멤버 관리 시스템을 종료합니다.");
                    return;
                }

                default: {
                    System.out.println("❌ [오류] 올바른 숫자를 입력해주세요.");
                    break;
                }
            }
        }
    }
}