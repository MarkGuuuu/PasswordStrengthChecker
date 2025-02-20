public class Password {
    private final String password;
    private final int safetyScore;
    private final String passwordFeedback;

    public Password(String password, int score, String feedback) {
        this.password = password;
        this.safetyScore = score;
        this.passwordFeedback = feedback;
    }

    public String getPassword() { return password; }
    public int getSafetyScore() { return safetyScore; }
    public String getFeedback() { return passwordFeedback; }

    @Override
    public String toString() {
        return "Password: " + password + "\n" +
                "Safety Score: " + safetyScore + "/10\n" +
                "Feedback: " + passwordFeedback;
    }
}