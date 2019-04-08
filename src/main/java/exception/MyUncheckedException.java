package exception;

public class MyUncheckedException extends RuntimeException {
    private String text;

    public MyUncheckedException(String message) {
        this.text = message;
    }
}
