# Servlets

**Сервлеты** — это основной механизм Java при построении бэкенда для веб-приложений, хотя напрямую он используется
нечасто,
но является неотъемлемой частью Spring MVC. Понимание принципов работы сервлетов сильно облегчит дальнейшую разработку
с использованием различных абстракций и надстроек над ними.

Фреймворк использует их для работы с HTTP-запросами.

## Логика появления

Ещё в прошлом веке программисты пришли к выводу, что многие серверные программы работают похожим образом.
Они принимают запрос от клиента, обрабатывают его и выдают ответ. На псевдокоде это можно описать примерно так.

``` 
открыть_порт(1234);
while (true) {
    запрос = принять_запрос()
  ответ = обработать(запрос)
  послать(ответ)
}
```

В псевдокоде выглядит просто, но на деле команды «принять запрос» и «послать запрос» должны учитывать множество
ситуаций.

* Сеть может быть ненадёжной, поэтому может прийти неполный запрос или ответ может не отправиться с первого раза.
* Если обработка идёт медленно, а запросов много, их нужно добавлять в очередь.
* За очередью нужно следить.
* Иногда приходят «мусорные» запросы, которые даже не стоит пытаться обрабатывать.
* Многопроцессорные (или многоядерные) системы могут обрабатывать несколько запросов одновременно. При этом логика
  распределения задач по ядрам не самая простая.

Поэтому закономерно возникла идея выделить логику принятия запроса и отправки ответа в отдельную, переиспользуемую
часть.
Для непосредственной реализации при этом оставить прикладным программистам только код, который непосредственно
обрабатывает запрос и создаёт ответ.
В мире Java та часть, которая переиспользуется, называется контейнер сервлетов (англ. servlet container),
а код под реализацию конкретной задачи по обработке запроса это и есть сервлет (англ. servlet).

**Сервлет** — это класс, который принимает запрос и выдаёт ответ. В каком-то смысле он похож на контроллер в Spring.
Каждый контроллер обычно обрабатывает свой путь — к примеру, /users, /posts и другие. Каждому сервлету также назначается
путь — одному /users, второму /posts и так далее, и они обрабатывают соответствующие HTTP-запросы.

**Контейнер сервлетов** — это компонент веб-сервера, который взаимодействует с сервлетами Java, отвечает за их жизненный
цикл,
обработку запросов/ответов и другие функции.

**Jakarta Servlets (Java Servlets)** — это стандартные серверные компоненты Java, которые позволяют обрабатывать
HTTP-запросы,
такие как GET, POST, PUT, DELETE и другие.

``` 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello, world!");
    }
} 
```

1. [ ] HttpServlet — это базовый класс для сервлетов, которые обрабатывают HTTP-запросы.
2. [ ] Метод doGet обрабатывает GET-запросы (также есть методы doPost для обработки POST-запросов, doPut для PUT и по
   аналогии для всех остальных методов HTTP).
3. [ ] Параметр request содержит в себе данные HTTP-запроса: заголовки, параметры и другие.
4. [ ] Параметр response — это заготовка для ответа, её нужно заполнить — добавить заголовки и/или тело ответа. В
   примере в тело ответа мы добавили строку “Hello, world!”.

**Чуть более содержательный пример**
Рассмотрим пример посложнее. Через параметры запроса a и b будут передавать целые числа, а в ответ нужно будет записать
результат сложения. Например, запрос http://localhost:8080/sum?a=2&b=3 должен выдавать 5. Таким бы мог быть сервлет для
этого.

``` 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        int sum = a + b;
        resp.getWriter().print(sum);
    }
}

```

Нам потребовалось сконвертировать значения параметров a и b из String в int и самостоятельно записать результат в тело
ответа.
Если бы реализовали бы то же самое через Spring через контроллер, то это бы выглядело примерно так.
Spring Framework автоматически переводит параметры в нужные типы и автоматически записывает результат метода в тело
HTTP-ответа.

``` 
package practicum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}

```

# Контейнеры сервлетов

Если сервлет — это класс, который принимает запрос и выдаёт ответ, то контейнер сервлетов (англ. servlet container
или web container) — это программа, которая делает всё остальное: открывает сетевой порт, принимает соединения,
парсит протокол HTTP, распределяет работу по ядрам процессора и вызывает методы сервлетов.
В одном контейнере сервлетов может одновременно работать несколько сервлетов. Каждый из них будет обрабатывать
свой тип HTTP-запросов.

С точки зрения программиста, который хочет написать какую-то логику обработки запросов, любой контейнер сервлетов
— это ящик, в который можно закинуть свой сервлет, и дальше всё само заработает.

## Работа с контейнером — вариант первый

Типичный процесс работы с контейнерами сервлетов в начале 2000-х годов выглядел примерно так.

* Администраторы настраивали и запускали контейнер сервлетов на выделенном сервере.
* Программисты периодически писали сервлеты и приносили их администраторам.
* Администраторы копировали сервлеты в специальную папку и перезапускали контейнер.
* Контейнер обнаруживал новые сервлеты и начинал передавать им запросы.

Причина такого подхода была простой: рабочему компьютеру разработчика просто не хватало ресурсов, чтобы запустить
полноценный контейнер. Но даже когда ресурсов стало хватать, некоторое время так продолжали работать по инерции.
Такой подход был не очень удобным по нескольким причинам. Во-первых, для разработки и отладки сервлетов программисту
требовалось содержать на своём компьютере точную копию контейнера, той же версии и с теми же настройками, что и на
сервере.
Во-вторых, за соответствием версий и настроек нужно было следить вручную. В-третьих, также вручную нужно было
настраивать
контейнер на сервере.

## Встроенные контейнеры — вариант второй

В какой-то момент появилась идея, что можно сделать самостоятельные приложения, которые сами будут запускать контейнер
и сами добавлять в него сервлеты.
Новый подход позволил задавать версию и настройки контейнера в его приложении, поэтому исчезла проблема с разными
версиями
и разными настройками. Плюс отпала необходимость вручную настраивать контейнер на сервере — достаточно запустить
приложение,
оно само настроит всё, что необходимо. Так контейнеры сервлетов стали встроенными.
Код запуска встроенного контейнера сервлетов выглядит примерно так.

``` 
public class org.workwork.c_java_core_one.homework_c3.Main {
    public static void main(String[] args) {
        SomeServletContainer.start();
        SomeServletContainer.addServlet(new MyFancyServlet());
    }
}
```

Такой контейнер готов к использованию. Он содержит методы start и addServlet — один позволяет программно запускать
контейнер из приложения, а второй добавлять сервлет.

💡 В случае со встроенным контейнером приложение будет содержать метод main. Он нужен для того, чтобы запустить
контейнер.

**Что выбирает Spring**
Spring Framework не отдаёт предпочтения ни первому, ни второму подходу — он работает с одинаковым успехом и через
подкладывание сервлетов на сервер, и со встроенным контейнером. Spring Boot, в свою очередь, по умолчанию настаивает
на подходе со встроенным контейнером, но оставляет возможность при желании использовать и альтернативный вариант с
отдельным контейнером. Для этого нужно будет повозиться с настройками SB.

Контейнеров много, но Tomcat один
С момента появления спецификации сервлетов в 1996 году, было создано около 20 разных реализаций контейнеров. Примерно
половина из них бесплатные и с открытым кодом, вторая половина — коммерческие. Полный список легко найти в интернете
по запросу “servlet container list”.
За много лет работы с контейнерами сервлетов в них были исправлены многие возможные ошибки и учтены важные нюансы.
Именно поэтому Spring использует эту технологию — чтобы не «переизобретать велосипед» и не тратить время на всё те
же нюансы и исправления, которые сообщество уже исправило за много лет совместной работы.

Мы не будем подробно рассматривать разные контейнеры и остановимся на самом популярном — **Apache Tomcat.** Именно его
Spring Boot использует по умолчанию для запуска встроенного контейнера.
Tomcat был создан в 1999 году как образец реализации контейнеров сервлетов (англ. reference implementation).
Позже его исходный код был открыт и передан в Apache Software Foundation (ASF) для дальнейшего развития. Открытый
исходный код позволил разработчикам со всего мира развивать проект. За много лет работы они сделали Tomcat надёжным и
быстрым.

## init()

## service()

## destroy()

Интерфейс Servlet определяет базовый контракт для всех сервлетов (классов, которые обрабатывают HTTP-запросы
и генерируют HTTP-ответы). Он содержит методы для инициализации, обработки запросов и уничтожения сервлета.
Классы, реализующие этот интерфейс, должны реализовать эти методы.

``` 
// Базовый интерфейс, должен реализовываться всеми сервлетами 
public interface Servlet {   
  public void init(ServletConfig config) throws ServletException;   
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;   
  public void destroy(); 
}
```

Абстрактный класс HttpServlet является расширением интерфейса Servlet и предоставляет дополнительные методы
для обработки HTTP-запросов и генерации HTTP-ответов. Он также предоставляет реализацию методов из интерфейса Servlet,
что делает его более удобным для использования.

Основное назначение этих классов - обработка HTTP-запросов.

``` 
// Абстрактный класс, позволяющий обрабатывать HTTP-запросы public 
abstract class HttpServlet extends GenericServlet {   
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;   
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;   
  ... 
}
```

``` 
// Пользовательский запрос 
public interface HttpServletRequest extends ServletRequest {   
public String getParameter(String name);   
public Enumeration<String> getHeaders(String name);   
... 
}

```

``` 
// Ответ 
public interface HttpServletResponse extends ServletResponse {   
  public void addCookie(Cookie cookie);   
  public PrintWriter getWriter() throws IOException;   
... 
}

```

## Конфигурация = 3 способа

### 1 способ

``` 
<!-- Традиционная конфигурация через WEB-INF/web.xml --> 
  <web-app>
     <servlet>
            <servlet-name>HelloWorld</servlet-name>
            <servlet-class>ru.productstar.servlets.HelloWorld</servlet-class>
            <init-param>
                  <param-name>key</param-name>
                  <param-value>42</param-value>
            </init-param>
     </servlet>
     <servlet-mapping>
            <servlet-name>HelloWorld</servlet-name>
            <url-pattern>/hello</url-pattern>
     </servlet-mapping>
  </web-app>
```

### 2 способ

``` 
// Конфигурация через аннотации 
@WebServlet (
       name = "HelloWorld ",
       urlPatterns = {"/hello"},
       initParams = {@WebInitParam(name="key", value = "42")}
) 
public class HelloWorld extends HttpServlet {
  // Код сервлета 
  }
```

### 3 способ

``` 
// Программная конфигурация
 @WebListener 
 public class CustomServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
           ServletContext servletContext = sce.getServletContext();
           ServletRegistration.Dynamic hw = servletContext.addServlet("HelloWorld", HelloWorld.class);
           hw.addMapping("/hello");
           hw.setInitParameter("key", "42");
    }
 }

```

## Servlet Context

**Servlet Context** — объект, который содержит метаинформацию обо всём веб-приложении.
Основные задачи:

* доступ к параметрам инициализации
* обмен парами ключ-значение между сервлетами
* программное добавление сервлетов, фильтров и слушателей
* доступ к ресурсам внутри приложения
* логирование
* перенаправление запросов между сервлетами

## Фильтры

**Фильтры** — компоненты, которые позволяют перехватывать запросы и ответы и манипулировать ими.

**Основные сценарии использования:**

* аутентификация и авторизация
* логирование и аудит
* трансформация запроса или ответа
* кэширование
* сжатие

``` 
@WebFilter(urlPatterns = "/*")
public class LogFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Request uri: " + req.getRequestURI());
        chain.doFilter(req, res);
    }
}
```

## Request Dispatching

**Request Dispatching** — механизм, с помощью которого управление передается от одного сервлета к другому в пределах
одного приложения.

**Существует два способа маршрутизации:**

* **Forward** — запрос отправляется на другой сервлет в том же приложении, который и отвечает клиенту
* **Include** — запрос отправляется на другой сервлет, его ответ включается в ответ исходного сервлета

## Event Listeners

**Event Listeners** — компоненты Java Servlets API, которые позволяют отслеживать различные события в жизненном цикле
веб-приложения и реагировать на них

**Типы Event Listeners**

* ServletContextListener
* HttpSessionListener
* ServletRequestListener
* *AttributeListener

# !!! ВАЖНО

# файл  web.xml = конфигурирует приложение

# плагин (jetty-maven-plugin) используется для запуска веб-приложения на локальном сервере Jetty,

который будет слушать порт 9000. Также указан путь к файлу web.xml, который содержит настройки и конфигурацию
веб-приложения.

# ПРИМЕР ИСПОЛЬЗОВАНИЯ

## 1. Создание сервлета, который отображает "Hello World!" в браузере:

```
public class HelloWorldServlet extends HttpServlet {
// это определение метода в классе HelloWorldServlet, который будет вызываться при получении HTTP GET-запроса и принимать объекты запроса и ответа, 
// а также может выбрасывать исключения типа ServletException и IOException.
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    response.setContentType("text/html"); //  Установка типа содержимого ответа на "text/html" - это установка типа MIME-содержимого, который будет отправлен в ответ на запрос.
    PrintWriter out = response.getWriter(); //  Получение объекта PrintWriter для записи HTML-кода ответа - это создание объекта PrintWriter, который будет использоваться для записи HTML-кода в ответ на запрос.
    out.println("<html><body>");
    out.println("<h1>Hello World!</h1>");
    out.println("</body></html>");
  }
}

```

## 2. Регистрация сервлета в файле web.xml:

``` 

// Определение сервлета в файле web.xml с именем HelloWorldServlet и указанием его класса 
// - это определение сервлета в файле конфигурации веб-приложения web.xml, 
// который будет иметь имя HelloWorldServlet и ссылаться на класс, который был создан ранее.
<servlet>
  <servlet-name>HelloWorldServlet</servlet-name>
  <servlet-class>com.example.HelloWorldServlet</servlet-class>
</servlet>

// Этот код является частью файла конфигурации веб-приложения web.xml и определяет связь между именем сервлета (HelloWorldServlet) 
// и URL-шаблоном (/hello). Таким образом, при обращении к URL-адресу, который соответствует данному шаблону (/hello), 
// будет вызван сервлет HelloWorldServlet. 

// <servlet-mapping> - это элемент XML-файла web.xml, который определяет соответствие между именем сервлета и URL-шаблоном. 
// Он используется для связи между классом сервлета и URL-шаблоном, чтобы при обращении к определенному URL-адресу вызывался нужный сервлет.

<servlet-mapping>
  <servlet-name>HelloWorldServlet</servlet-name>
  <url-pattern>/hello</url-pattern>
</servlet-mapping>

```

## 3. После развертывания приложения на сервере при обращении к URL "/hello" будет вызываться метод doGet() сервлета HelloWorldServlet, который отправит ответ с текстом "Hello World!" в браузер.

# Servlet Contex

**Servlet Context** - это объект, который представляет контекст выполнения сервлета в рамках веб-приложения.
Он используется для обмена данными между различными сервлетами и компонентами веб-приложения.

Пример использования Servlet Context может быть следующим: предположим, что у нас есть веб-приложение,
которое имеет несколько сервлетов, каждый из которых обрабатывает определенный тип запросов. В этом случае мы можем
использовать Servlet Context для передачи данных между этими сервлетами. Например, один сервлет может сохранить данные в
Servlet Context, а другой сервлет может получить эти данные и использовать их для своей работы.

Кроме того, Servlet Context может использоваться для хранения глобальных параметров и настроек веб-приложения,
таких как параметры базы данных или настройки безопасности.

``` 
public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем объект ServletContext
        ServletContext context = getServletContext();
        
        // Сохраняем значение в ServletContext
        context.setAttribute("myData", "Hello, world!");
        
        // Получаем значение из ServletContext
        String myData = (String) context.getAttribute("myData");
        
        // Отправляем ответ клиенту
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + myData + "</h1>");
        out.println("</body></html>");
    }
}
```

В этом примере мы получаем объект ServletContext, сохраняем значение "Hello, world!" в нем, затем получаем это значение
и отправляем его в ответе клиенту.

# HttpFilter

HttpFilter - это компонент веб-приложения, который позволяет обрабатывать запросы и ответы перед тем, как они будут
переданы сервлету или после того, как сервлет уже обработал запрос. HttpFilter может использоваться для реализации
различных задач, таких как **аутентификация, авторизация, логирование, сжатие данных и других операций.**

Пример использования HttpFilter может быть следующим: предположим, что у нас есть веб-приложение, которое требует
аутентификации пользователей перед тем, как они смогут получить доступ к определенным страницам. В этом случае мы
можем использовать HttpFilter для проверки аутентификации пользователя перед обработкой запроса. Если пользователь
не аутентифицирован, мы можем перенаправить его на страницу входа.

Кроме того, HttpFilter может использоваться для изменения запросов и ответов. Например, мы можем использовать
HttpFilter для сжатия данных перед отправкой ответа клиенту или для добавления заголовков к запросам и ответам.

``` 
public class AuthenticationFilter implements Filter {
    // будет вызываться при обработке запросов.
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Проверяем, аутентифицирован ли пользователь, с помощью метода getSession() объекта httpRequest и метода getAttribute() объекта session.
        if (httpRequest.getSession().getAttribute("user") == null) { 
            // Если пользователь не аутентифицирован, перенаправляем его на страницу входа
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        } else {
            // Если пользователь аутентифицирован, передаем запрос дальше по цепочке фильтров
            chain.doFilter(request, response);
        }
    }
}

```

В этом примере мы создаем HttpFilter для проверки аутентификации пользователя. Если пользователь не аутентифицирован,
мы перенаправляем его на страницу входа. Если пользователь аутентифицирован, мы передаем запрос дальше по цепочке
фильтров.

# FilterChain

**FilterChain** - это интерфейс, который представляет собой цепочку фильтров, которые обрабатывают запросы и ответы в
приложении.
Каждый фильтр в цепочке может изменять запрос и/или ответ, а также передавать их дальше по цепочке.

Когда запрос поступает в приложение, он проходит через цепочку фильтров, которые могут выполнять различные задачи,
например,
проверку аутентификации пользователя, компрессию данных, логирование и т.д.

После того как запрос прошел через все фильтры, он достигает сервлета или JSP страницы, которые обрабатывают его и
генерируют ответ.
Затем ответ проходит через ту же цепочку фильтров в обратном порядке, позволяя каждому фильтру изменять его содержимое
перед отправкой клиенту.

Использование FilterChain позволяет создавать более гибкие и масштабируемые приложения, так как каждый фильтр может
выполнять свою задачу независимо от других фильтров в цепочке.