# spring-mongodb

Простое и чистое REST API на **Spring Boot + MongoDB**, реализация CRUD.

| Метод   | Endpoint                            | Описание 
|---------|-------------------------------------|---------
| `GET`   | `/api/v1/user/{id}`                 | Получить элемент по `id` 
| `GET`   | `/api/v1/users`                     | Поиск с фильтрацией и пагинацией (`Example`, `Pageable`) 
| `POST`  | `/api/v1/user`                      | Создать новый элемент 
| `PUT`   | `/api/v1/user/{id}`                 | Обновить элемент по `id` 
| `DELETE`| `/api/v1/user/{id}`                 | Удалить элемент по `id` 

- **Spring Boot 3.5.7**
- **Spring Data MongoDB**
- **Lombok**
- **MongoDB**

<small>Тесты не реализованы — проект создан для демонстрации базового функционала.</small>

