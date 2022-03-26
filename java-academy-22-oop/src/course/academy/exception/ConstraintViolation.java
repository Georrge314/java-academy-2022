package course.academy.exception;

import java.util.Objects;

public class ConstraintViolation {
    private String type;
    private String field;
    private Object invalidValue;
    private String errorMessage;

    public ConstraintViolation(String type,
                               String field,
                               Object invalidValue,
                               String errorMessage) {
        this.type = type;
        this.field = field;
        this.invalidValue = invalidValue;
        this.errorMessage = errorMessage;
    }

    public ConstraintViolation() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstraintViolation that = (ConstraintViolation) o;
        return Objects.equals(type, that.type) && Objects.equals(field, that.field) && Objects.equals(invalidValue, that.invalidValue) && Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, field, invalidValue, errorMessage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConstraintViolation{");
        sb.append("type='").append(type).append('\'');
        sb.append(", field='").append(field).append('\'');
        sb.append(", invalidValue=").append(invalidValue);
        sb.append(", errorMessage='").append(errorMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
