package com.prestamos.api.exception;

import java.util.Map;
import java.util.HashMap;

public class LoanValidationException extends RuntimeException {
    private final String errorCode;
    private final String fieldName;
    private final Object rejectedValue;
    private final Map<String, Object> details;

    public LoanValidationException(String message, String errorCode, String fieldName) {
        super(message);
        this.errorCode = errorCode;
        this.fieldName = fieldName;
        this.rejectedValue = null;
        this.details = new HashMap<>();
    }

    public LoanValidationException(String message, String errorCode, String fieldName, Object rejectedValue) {
        super(message);
        this.errorCode = errorCode;
        this.fieldName = fieldName;
        this.rejectedValue = rejectedValue;
        this.details = new HashMap<>();
    }

    public LoanValidationException(String message, String errorCode, String fieldName, Object rejectedValue, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.fieldName = fieldName;
        this.rejectedValue = rejectedValue;
        this.details = new HashMap<>();
    }

    public LoanValidationException(String message, String errorCode, Map<String, Object> details) {
        super(message);
        this.errorCode = errorCode;
        this.fieldName = null;
        this.rejectedValue = null;
        this.details = details != null ? details : new HashMap<>();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void addDetail(String key, Object value) {
        this.details.put(key, value);
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoanValidationException[")
          .append("errorCode=").append(errorCode);
        if (fieldName != null) {
            sb.append(", fieldName=").append(fieldName);
        }
        if (rejectedValue != null) {
            sb.append(", rejectedValue=").append(rejectedValue);
        }
        sb.append("]: ").append(super.getMessage());
        return sb.toString();
    }

    public String getFormattedMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        if (fieldName != null && rejectedValue != null) {
            sb.append(" - Campo: ").append(fieldName)
              .append(", Valor rechazado: ").append(rejectedValue);
        } else if (fieldName != null) {
            sb.append(" - Campo afectado: ").append(fieldName);
        }
        return sb.toString();
    }
}