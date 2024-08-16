package vn.hoidanit.jobhunter.domain;

import org.springframework.http.HttpStatus;

public class RestResponse<T> {
     private int statusCode;
     private String error;

     private Object message;
     private T data;
      
     public int getStatusCode() {
          return statusCode;
     }
     public void setStatusCode(int i) {
          this.statusCode = i;
     }
     public String getError() {
          return error;
     }
     public void setError(String error) {
          this.error = error;
     }
     public Object getMessage() {
          return message;
     }
     public void setMessage(Object message) {
          this.message = message;
     }
     public T getData() {
          return data;
     }
     public void setData(T data) {
          this.data = data;
     }

     
}
