package net.eren.departmentservice.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMap {
    private String message;
    private ResponseStatus status;
    private String code;
    private Map<String,?> details;
    public ResponseStatus getStatus() {
        return (status == null) ? ResponseStatus.SUCCESS : status;
    }
    public String getCode() {
        return (code == null) ? "200" : code;
    }
}
