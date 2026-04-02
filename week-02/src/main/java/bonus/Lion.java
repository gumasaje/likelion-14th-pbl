package bonus;

public class Lion {

    public String name;
    String major;
    private int generation;

    public Lion(String name, String major, int generation) {
        validate(name, major, generation);
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    private void validate(String name, String major, int generation) {
        validateName(name);
        validateMajor(major);
        validateGeneration(generation);
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비어 있습니다.");
        }
    }

    private void validateMajor(String major) {
        if (major == null || major.trim().isEmpty()) {
            throw new IllegalArgumentException("전공이 비어 있습니다.");
        }
    }

    private void validateGeneration(int generation) {
        if (generation < 1) {
            throw new IllegalArgumentException("기수는 1 이상이어야 합니다.");
        }
    }

    public void printProfile() {
        System.out.printf("👤이름: %s | 🎓전공: %s | 📌기수: %d%n", name, major, generation);
    }

    public void changeName(String newName) {
        validateName(newName);
        this.name = newName;
    }

    public void changeMajor(String newMajor) {
        validateMajor(newMajor);
        this.major = newMajor;
    }

    public void changeGeneration(int newGeneration) {
        validateGeneration(newGeneration);
        this.generation = newGeneration;
    }
}
