package tech.diligo.astora.runner;

public final class SingleTestResult {

    private final String name;
    private final String displayName;
    private final TestState state;
    private final Throwable exception;

    public SingleTestResult(String name, String displayName, TestState state, Throwable exception) {
        if ((state == TestState.FAILURE || state == TestState.ASSUMPTION_FAILURE) && exception == null) {
            throw new IllegalArgumentException("Missing exception for failed test");
        }

        this.name = name;
        this.displayName = displayName;
        this.state = state;
        this.exception = exception;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public TestState getState() {
        return state;
    }

    public Throwable getException() {
        return exception;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SingleTestResult{" + "name='" + name + '\'' + ", displayName='" + displayName + '\'' + ", state=" + state + ", exception=" + exception + '}';
    }
}
