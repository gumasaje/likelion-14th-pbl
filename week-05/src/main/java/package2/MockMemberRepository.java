package package2;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.*;

public class MockMemberRepository implements MemberRepository {
    private final List<Role> dummyList = new ArrayList<>();
    private final Map<String, List<Role>> dummyMap = new HashMap<>();

    public MockMemberRepository() {
        dummyList.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "20202020"));
        dummyList.add(new Lion("최사자", "컴퓨터공학과", 13, "프론트엔드", "20192019"));
        dummyList.add(new Staff("홍사자", "컴퓨터공학과", 12, "기획", "20182018"));
        dummyList.add(new Staff("구사자", "컴퓨터공학과", 11, "디자인", "20172017"));

        for (Role member : dummyList) {
            String part = member.getPart();
            if (!dummyMap.containsKey(part)) {
                dummyMap.put(part, new ArrayList<>());
            }
            dummyMap.get(part).add(member);
        }
    }

    @Override
    public void save(Role member) {
    }

    @Override
    public Role findByName(String name) {
        for (Role role : dummyList) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return dummyList;
    }

    @Override
    public Set<String> findAllParts() {
        return dummyMap.keySet();
    }

    @Override
    public List<Role> findAllByPart(String part) {
        return dummyMap.get(part);
    }

    @Override
    public boolean isDuplicate(String name) {
        return false;
    }

    @Override
    public boolean isWritable() {
        return false;
    }
}
