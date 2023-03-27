package com.onebox.hector.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "cart not found")
public class CartNotFoundException extends RuntimeException {
}