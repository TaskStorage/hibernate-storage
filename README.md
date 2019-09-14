### Servlet Storage
Реализация простого сервиса хранения заметок.
Полный аналог [ServletStorage](https://github.com/TaskStorage/servletstorage) за исключением применения Hibernate вместо JDBC

Основные применяемые технологии:
- Servlet
- JSP + Bootstrap
- Hibernate + MySQL
- Maven

Для запуска необходимо поменять имя базы данных и данные пользователя в файле 
[hibernate.cfg.xml](https://github.com/TaskStorage/hibernate-storage/blob/master/src/main/resources/hibernate.cfg.xml)

Приложение позволяет:

- Создавать редактировать и удалять заметки
- Предоставляет механизм регистрации, авторизации и управления пользователями

