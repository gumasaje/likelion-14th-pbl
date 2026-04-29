package package1;

import role.Role;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    public void registerMember(Role member) {
        if (memberRepository.isDuplicate(member.getName())) {
            throw new IllegalArgumentException("❌ [오류] 이미 존재하는 이름입니다.");
        }
        memberRepository.save(member);
    }

    public List<Role> findAllMembers() {
        return memberRepository.findAll();
    }

    public Role findMemberByName(String name) {
        return memberRepository.findByName(name);
    }
}
