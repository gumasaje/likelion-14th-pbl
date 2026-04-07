package policy;

public interface SubmissionPolicy {
    boolean canSubmit();

    static SubmissionPolicy ofGeneration(int generation) {
        return new GenerationSubmissionPolicy(generation);
    }
}