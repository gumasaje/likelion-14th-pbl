package role;

import policy.AlumniSubmissionPolicy;
import policy.GenerationSubmissionPolicy;
import policy.SubmissionPolicy;

public class Alumni extends Role {
    private String currentJob;

    public Alumni(String name, String major, int generation, String part, String currentJob) {
        super(name, major, generation, part);
        this.currentJob = currentJob;
    }

    @Override
    public SubmissionPolicy getRolePolicy() {
        return new AlumniSubmissionPolicy();
    }

    @Override
    public SubmissionPolicy getGenerationPolicy() {
        return new GenerationSubmissionPolicy(getGeneration());
    }

    @Override
    public String getRoleName() {
        return "알럼나이";
    }

    @Override
    public String getProfile() {
        return String.format("🎭 역할: %s\n" +
                        "👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s\n" +
                        "💼 현재 직무: %s",
                getRoleName(), getName(), getMajor(), getGeneration(), getPart(), currentJob);
    }
}
