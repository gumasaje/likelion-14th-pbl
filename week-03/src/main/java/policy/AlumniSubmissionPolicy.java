package policy;

public class AlumniSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmit() {
        return true;
    }
}
