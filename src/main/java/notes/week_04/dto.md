DTO нужны, чтобы отделить внешний API-контракт от внутренней domain/entity модели.

CreateTaskRequest описывает данные, которые клиент может передать при создании.
UpdateTaskRequest описывает частичное обновление, поэтому поля nullable.
TaskResponse описывает то, что сервер возвращает клиенту.
TaskStatus задаёт допустимые статусы.

@Controller/@RestController принимает HTTP-запросы.
@RequestMapping("/tasks") задаёт base path.
@PostMapping, @GetMapping, @PatchMapping связывают HTTP method + path с Java-методом.
@Valid запускает Bean Validation для request body.
ResponseEntity позволяет управлять HTTP status и body.