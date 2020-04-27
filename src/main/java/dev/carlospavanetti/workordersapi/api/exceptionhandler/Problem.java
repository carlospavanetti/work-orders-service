package dev.carlospavanetti.workordersapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Problem {
  private Integer status;
  private LocalDateTime timestamp;
  private String title;
  private List<Field> fields;

  @Data
  @AllArgsConstructor
  public static class Field {
    private String name;
    private String message;
  }

  public Problem(Integer status, String title) {
    this.status = status;
    this.title = title;
    this.timestamp = LocalDateTime.now();
  }

}
