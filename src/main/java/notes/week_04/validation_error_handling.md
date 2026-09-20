Validation + Error Handling

@Valid:
- запускает Bean Validation для request body
- проверяет @NotBlank, @Email, @Size, @FutureOrPresent и т.д.
- при ошибке Spring кидает MethodArgumentNotValidException

@RestControllerAdvice:
- глобальная обработка ошибок controller layer
- @ControllerAdvice + @ResponseBody

@ExceptionHandler:
- связывает тип exception с методом обработки

ErrorResponse:
- единый формат ошибки для клиентов

Typical mapping:
- validation error -> 400 Bad Request
- entity not found -> 404 Not Found
- forbidden action -> 403 Forbidden
- conflict/state problem -> 409 Conflict
- unexpected error -> 500 Internal Server Error

Do not expose:
- stacktrace
- internal class names
- sensitive data