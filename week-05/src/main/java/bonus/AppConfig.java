package bonus;

public class AppConfig {

    public enum RepositoryType {
        MEMORY,
        MOCK
    }

    private final RepositoryType repositoryType;

    public AppConfig(RepositoryType repositoryType) {
        this.repositoryType = repositoryType;
    }

    private MemberRepository memberRepository() {
        switch (repositoryType) {
            case MEMORY:
                return new MemoryMemberRepository();
            case MOCK:
                return new MockMemberRepository();
        }
        return null;
    }

    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
