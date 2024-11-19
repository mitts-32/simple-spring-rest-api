package com.spring.boot.rest.api.simple_spring_boot_api.errors;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  private String message;
  private HttpStatus status;
}
