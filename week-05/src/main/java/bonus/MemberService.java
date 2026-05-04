package bonus;

import role.Role;

import java.util.List;
import java.util.Set;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerMember(Role member) {
        if (memberRepository.isDuplicate(member.getName())) {
            throw new IllegalArgumentException("❌ [오류] 이미 존재하는 이름입니다.");
        }
        memberRepository.save(member);
    }

    public List<Role> findAllMembers() {
        return memberRepository.findAll();
    }

    public Set<String> findAllParts() {
        return memberRepository.findAllParts();
    }

    public Role findMemberByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Role> findMembersByPart(String part) {
        return memberRepository.findAllByPart(part);
    }

    public boolean isWritable() {
        return memberRepository.isWritable();
    }

    public void deleteMember(Role member) {
        memberRepository.deleteByName(member);
    }
}
