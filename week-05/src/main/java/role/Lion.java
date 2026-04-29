package role;

import policy.GenerationSubmissionPolicy;
import policy.LionSubmissionPolicy;
import policy.SubmissionPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public SubmissionPolicy getRolePolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public SubmissionPolicy getGenerationPolicy() {
        return new GenerationSubmissionPolicy(getGeneration());
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getProfile() {
        return String.format("🎭 역할: %s\n" +
                        "👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s\n" +
                        "🆔 학번: %s",
                getRoleName(), getName(), getMajor(), getGeneration(), getPart(), studentId);
    }
}
