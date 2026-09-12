# Task Service Baseline Design

## 1. Goal

Simple Task Service позволяет пользователям создавать, назначать, отслеживать и комментировать задачи,
а также классифицировать их с помощью labels.
Сервис должен хранить историю ключевых изменений и обеспечивать контроль доступа к задачам и комментариям.


## 2. Functional Requirements

1. Пользователь может создать задачу с title, description, dueDate, labels и assignee.
2. Пользователь может получить задачу по id.
3. Пользователь может получить список задач с фильтрами.
4. Создатель или ответственный может редактировать задачу.
5. Создатель или ответственный может менять статус задачи.
6. Пользователь может добавить комментарий к любой задаче.
7. Автор комментария может редактировать свой комментарий.
8. Пользователь может добавлять и убирать labels у задачи.
9. Задачи физически не удаляются.
10. Ключевые изменения задачи должны попадать в audit log.
11. Пользователи хранятся в Keycloak 
12. Статусная модель: Todo, InProgress, OnHold, Canceled, Closed
13. Canceled, Closed - финальные статусы, их них нет переходов никуда
14. Задача создается в статусе Todo
15. Остальные переходы статусов не ограничены (только нет смысла статус сам в себя переводить)

## 3. Non-Functional Requirements

- Система должна быть доступна 99.9% времени
- Все изменения, сделанные пользователями, должны логироваться в бизнес логах
- Технические логи должны храниться в централизованной системе логирования
- Аутентификация через Keycloak/OIDC. Сервис получает user identity из JWT; в текущей модели в качестве identity используется email.
- Система должна допускать несколько экземпляров приложения в Kubernetes

## 4. Main Entities

### Task
- id
- reporterEmail
- assigneeEmail
- title
- description
- status
- createdAt
- updatedAt
- closedAt
- dueDate

(версии у нас нет даже в нашем энтерпрайс решении у задачи, не критично тут потерять изменения, маленькая вероятность)
### Comment

- id
- taskId
- authorEmail
- text
- createdAt
- updatedAt

### Label
- id
- value

### TaskLabel
- taskId
- labelId


### TaskAuditEvents
- id
- taskId
- userEmail
- operation
- object
- old_value
- new_value
- createdAt


## 5. Entity Relationships

Task 1:N Comment
Task M:N Label via task_labels
Task 1:N TaskAuditEvents

## 6. Invariants / Business Rules

- У задачи всегда есть создатель, но не всегда ответственный
- к комментарию всегда привязана задача
- Редактировать можно только свой комментарий
- Нельзя переводить задачу из финальных статусов (Closed/Canceled)
- При переводе в финальный статус проставляется closedAt
- редактировать задачу может только создатель\ответственный по задаче
- title не может быть пустым
- status должен быть одним из разрешённых значений
- closedAt заполнен только для финальных статусов
- если status не финальный, closedAt должен быть null
- dueDate может быть null, но если задан, должен быть валидной датой
- нельзя добавить один и тот же label к task дважды
- comment.text не может быть пустым
- пользователь может видеть все задачи
- изменение статуса должно быть атомарным с записью audit event
- 
## 7.User identity decision
- Пользователи хранятся в kk (email, фио, роли)
Плюсы этого:
- простая интеграция с kk
- нет дублирования данных по пользователям
Минусы:
- может измениться email пользователя

Принимаем риски смены email. Это редкий кейс и можно разово выполнить update по задачам в БД

## 8.Concurrent Update Strategy
 Решение по одновременному обновлению задачи
 На текущий момент возможен кейс, когда 2 пользователя будут одновременно обновлять задачу и данные одного обновления потеряются
 Т.к. обновлять задачу могут только создатель задачи и ответственный, но риск считаем низким и не критичным

## 9. API Draft

Черновик REST API:

- POST /tasks - Создание задачи
- GET /tasks/{id} - получение задачи
- GET /tasks - получение списка задач + фильтрация
- PATCH /tasks/{id} - редактирование задачи
- POST /tasks/{id}/comments - создание комментария к задаче
- PATCH /tasks/{id}/comments/{commentId} - редактирование комментария к задаче
- POST /tasks/{id}/labels/{labelId} - добавление существующего label к задаче
- DELETE /tasks/{id}/labels/{labelId} - удаление связи лейбла  задачи
- GET /labels - получение списка лейблов
- DELETE /labels/{labelId} - удаление лейбла, ошибка если он привязан к какой-то задаче
- POST /tasks/{id}/labels/ - добавление label к задаче
- POST /labels - создание label


## 10. Data Model Draft

Черновик таблиц:

- tasks
  id PK
  reporterEmail not null
  assigneeEmail
  title not null
  description nullable
  status not null
  created_at not null
  updated_at not null
  closed_at nullable
  due_date nullable

- comments
  id PK
  task_id FK tasks.id not null
  authorEmail not null
  text not null
  created_at not null
  updated_at not null

- labels
  id PK
  value not null unique

- task_labels
  task_id FK tasks.id
  label_id FK labels.id
  primary key(task_id, label_id)

- taskAuditEvents
 id PK
 taskId FK tasks.id not null
 userEmail not null
 operation not null
 object not null
 old_value nullable
 new_value nullable
 createdAt not null


## 11. Query Patterns
- получить список задач назначенных на пользователя;
- получить список задач, у которых приближается\прошел срок
- получить список открытых задач, созданных мной
- поиск задач с каким-то лейблом
- получить task by id (задачу могут видеть все)
- получить задачи по status
- получить audit history задачи


## 12. Index Ideas

tasks(assignee_email, updated_at)
tasks(reporter_email, status, created_at)
tasks(due_date, status)
comments(task_id, created_at)
task_labels(label_id, task_id)
task_audit_events(task_id, created_at)

## 13. Failure Modes
- попытка отредактировать не свою задачу
- попытка отредактировать не свой комментарий
- 2 пользователя меняют задачу одновременно
- удаляем лейбл, который используется в другой задаче
- duplicate request на создание задачи
- пользователь назначает несуществующего assignee
- task удалена/закрыта, но комментарий пытаются добавить
- БД недоступна
- audit event не записался
- Keycloak недоступен или токен невалиден
- запрос списка задач без pagination перегружает систему
- race condition при добавлении одного label двумя запросами


## 14. Open Questions
Что нужно уточнить у продукта/техлида?
 - нужна ролевая модель?
 - куда именно логировать изменения? Просто в clmp или нужны технические логи в БД
 - какая ожидается нагрузка на систему? Сколько пользователей\сколько планируется задач создавать в неделю?
 - Labels общие для всех пользователей или должны быть ограничены командой/проектом/пользователем?
