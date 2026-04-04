package role;

import policy.SubmissionPolicy;
import policy.StaffSubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getProfile() {
        return String.format("🎭 역할: 운영진\n" +
                        "👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s\n" +
                        "⭐️ 직책: %s",
                getName(), getMajor(), getGeneration(), getPart(), position);
    }
}
