package course.academy.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConstraintViolationException extends Exception {
    private List<ConstraintViolation> fieldViolations = Collections.emptyList();

    public ConstraintViolationException() {
    }

    public ConstraintViolationException(String message) {
        super(message);
    }

    public ConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstraintViolationException(Throwable cause) {
        super(cause);
    }

    public ConstraintViolationException(List<ConstraintViolation> fieldViolations) {
        this.fieldViolations = fieldViolations;
    }

    public ConstraintViolationException(String message, List<ConstraintViolation> fieldViolations) {
        super(message);
        this.fieldViolations = fieldViolations;
    }

    public ConstraintViolationException(String message, Throwable cause, List<ConstraintViolation> fieldViolations) {
        super(message, cause);
        this.fieldViolations = fieldViolations;
    }

    public ConstraintViolationException(Throwable cause, List<ConstraintViolation> fieldViolations) {
        super(cause);
        this.fieldViolations = fieldViolations;
    }

    public List<ConstraintViolation> getFieldViolations() {
        return fieldViolations;
    }

    public void setFieldViolations(List<ConstraintViolation> fieldViolations) {
        this.fieldViolations = fieldViolations;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConstraintViolationException{");
        sb.append("fieldViolations=").append(fieldViolations);
        sb.append(", message='").append(getMessage()).append('\'');
        sb.append(", cause=").append(getCause());
        sb.append(", stackTrace=").append(Arrays.toString(super.getStackTrace()));
        sb.append('}');
        return sb.toString();
    }
}
