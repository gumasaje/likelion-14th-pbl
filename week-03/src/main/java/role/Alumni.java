package role;

import policy.AlumniSubmissionPolicy;
import policy.SubmissionPolicy;

public class Alumni extends Role {

    private String currentJob;

    public Alumni(String name, String major, int generation, String part, String currentJob) {
        super(name, major, generation, part);
        this.currentJob = currentJob;
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return new AlumniSubmissionPolicy();
    }

    @Override
    public String getProfile() {
        return String.format("🎭 역할: 아기사자\n" +
                        "👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s\n" +
                        "💼 현재 직무: %s",
                getName(), getMajor(), getGeneration(), getPart(), currentJob);
    }
}
