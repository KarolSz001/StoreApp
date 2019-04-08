package exception;

public class MyCheckedException extends Exception {
    String text;

    public MyCheckedException (String text) {
        this.text = text;
    }
}
