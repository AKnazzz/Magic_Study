# Выполнение запланированных заданий в Spring Boot

Планирование - это процесс выполнения части логики приложения в определенное время в будущем. Запланированные
задания - это часть бизнес-логики, которая должна выполняться по таймеру. Spring позволяет нам запускать
запланированные задания в контейнере Spring с помощью некоторых простых аннотаций.

В этой статье мы покажем, как настраивать и запускать запланированные задания в приложениях Spring Boot.

## Создание приложения Spring Boot для планирования

Для работы некоторых примеров, давайте сначала создадим проект Spring Boot с помощью **Spring boot Initializr**, а затем
откроем проект в нашей любимой среде IDE. Мы не добавляли никаких зависимостей в Maven, pom.xml поскольку планировщик
является частью основного модуля платформы Spring.

## Включение расписания

По умолчанию планирование отключено. Перед добавлением любых запланированных заданий нам необходимо явно включить
планирование, добавив аннотацию **@enableScheduling**:

``` 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobschedulingApplication {

  public static void main(String[] args) {
    SpringApplication.run(JobschedulingApplication.class, args);
  }
}
```

Здесь мы добавили аннотацию @enableScheduling к нашему классу приложения, JobschedulingApplication чтобы включить
планирование.

Лучше всего переместить эту аннотацию в специальный класс в пакете, который содержит код для наших запланированных
заданий:

``` 
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class SchedulerConfig {

}
```

Планирование теперь будет активировано только тогда, когда мы загрузим класс SchedulerConfig приложение, что обеспечит
лучшую модуляризацию.

Когда аннотация @EnableScheduling обрабатывается, Spring сканирует пакеты приложений, чтобы найти все Spring Beans,
декорированные методами @Scheduled, и устанавливает график их выполнения.

## Включение планирования с помощью свойства

Мы также хотели бы отключить планирование во время выполнения тестов. Для этого нам нужно добавить условие в наш класс
SchedulerConfig. Давайте добавим аннотацию @ConditionalOnProperty с именем свойства, которое мы хотим использовать для
управления расписанием:

``` 
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {

}
```

Здесь мы указали имя свойства как scheduler.enabled. Мы хотим включить его по умолчанию. Для этого, мы также
устанавливаем значение matchIfMissing в котором true означает, что мы не должны установить это свойство для того,
чтобы планировать, но должны установить это свойство явно отключить планировщик.

## Добавление запланированных заданий

После включения планирования мы добавим задания в наше приложение для планирования. Мы можем превратить любой метод в
bean-компонент Spring для планирования, добавив к нему аннотацию @Scheduled.

@Scheduled является аннотацией уровня метода и применяется во время выполнения, чтобы отметить, что метод выполняться
будет по расписанию. Он принимает один атрибут из cron, fixedDelay или fixedRate для указания расписания выполнения в
разных форматах.

Аннотированный метод должен удовлетворять двум условиям:

Метод не должен иметь возвращаемого типа и поэтому должен быть возвращен void. Для методов с возвращаемым типом
возвращаемое значение игнорируется при вызове через планировщик.

Метод не должен принимать никаких входных параметров.

В следующих разделах мы рассмотрим различные варианты настройки планировщика для запуска запланированных заданий.

## Выполнение задания с фиксированной задержкой

Мы используем fixedDelay атрибут, чтобы настроить выполнение задания после фиксированной задержки, он означает
фиксированный интервал между концом предыдущего задания и началом нового задания.

**Новое задание всегда будет ждать завершения предыдущего задания.** Его следует использовать в ситуациях, когда вызовы
методов должны происходить последовательно.

В этом примере мы вычисляем цену продукта, выполняя метод в компоненте Spring с фиксированной задержкой:

```
@Service
public class PricingEngine {
  
  static final Logger LOGGER = 
    Logger.getLogger(PricingEngine.class.getName());
  private Double price;
  
  public Double getProductPrice() {
    return price;
    
  }
  
  @Scheduled(fixedDelay = 2000)
  public void computePrice() throws InterruptedException {
    
    ...
    ...
    LOGGER.info("computing price at "+ 
      LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)); 

    // added sleep to simulate method 
    // which takes longer to execute.   
    Thread.sleep(4000); 
  }
}
```

Здесь мы запланировали выполнение метода computePrice с фиксированной задержкой, установив значение для атрибута
fixedDelay в 2000миллисекунды или 2секунды.

Мы также переводим метод в режим ожидания на 4 секунды, Thread.sleep() чтобы смоделировать ситуацию, когда выполнение
метода занимает больше времени, чем интервал задержки. Следующее выполнение начнется только после того, как предыдущее
выполнение завершится, по крайней мере, через 4 секунды, даже если интервал задержки в 2 секунды истек.

## Выполнение задания с фиксированной частотой

Мы используем атрибут fixedRate, чтобы указать интервал для выполнения задания через фиксированный интервал времени. Его
следует использовать в ситуациях, когда вызовы методов независимы. Время выполнения метода не учитывается при решении,
когда начинать следующее задание.

В этом примере мы обновляем параметры ценообразования, выполняя метод с фиксированной частотой:

```  
@Service
public class PricingEngine {
  
  static final Logger LOGGER = 
     Logger.getLogger(PricingEngine.class.getName());
   
  @Scheduled(fixedRate = 3000)
  @Async
  public void refreshPricingParameters() {
    ...
    ...
    LOGGER.info("computing price at "+ 
      LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));  
  }
}

@Configuration
@EnableScheduling
@EnableAsync
@ConditionalOnProperty(name="scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {

}
```

Здесь мы аннотировали метод refreshPricingParameters аннотацией @Scheduled и установили для атрибута fixedRate
значение 3000 миллисекунды или 3 секунды. Это обеспечит запуск метода каждые 3 секунды.

Мы также добавили аннотацию @Async к методу @EnableAsync и к классу конфигурации: SchedulerConfig.

Аннотация @Async к методу позволяет выполнить его в отдельном потоке. В результате, когда предыдущее выполнение метода
занимает больше времени, чем интервал с фиксированной скоростью, последующий вызов метода сработает, даже если
предыдущий вызов все еще выполняется.

Это позволит выполнять несколько запусков метода параллельно в течение перекрывающегося временного интервала.

Без применения аннотации @Async метод всегда будет выполняться после завершения предыдущего выполнения, даже если
интервал с фиксированной скоростью истек.

## Отсрочка первого исполнения с помощью начальной задержки

При использовании обоих fixedDelay и fixedRate первый вызов метода начинается сразу после инициализации контекста
приложения. Однако мы можем отложить первое выполнение метода, указав интервал с помощью атрибута initialDelay,
как показано ниже:

``` 
@Service
public class PricingEngine {
  
  static final Logger LOGGER = 
    Logger.getLogger(PricingEngine.class.getName());

  @Scheduled(initialDelay = 2000, fixedRate = 3000)
  @Async
  public void refreshPricingParameters() {
    
    Random random = new Random();
    price = random.nextDouble() * 100;
    LOGGER.info("computing price at "+ 
      LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));  
  }
}
```

Здесь мы установили задержку первого выполнения метода initialDelay в 2000 миллисекунды или 2 секунды.

## Указание интервалов в формате длительности ISO

До сих пор в наших примерах мы указывали временной интервал в миллисекундах. Указание более высоких значений интервала
в часах или днях, что чаще всего имеет место в реальных ситуациях, трудночитаемо.

Поэтому вместо того, чтобы указывать большое значение, например, 7200000 для 2 часов, мы можем указать время в формате
длительности ISO, например PT02H.

В аннотации @Scheduler представлены атрибуты интервала fixedRateString и fixedDelayString в формате длительности ISO,
как показано в этом примере кода:

```  
@Service
public class PricingEngine {
  
  static final Logger LOGGER = 
    Logger.getLogger(PricingEngine.class.getName());
  private Double price;
  
  public Double getProductPrice() {
    return price;
    
  }
  
  @Scheduled(fixedDelayString = "PT02S"))
  public void computePrice() throws InterruptedException {
    
    Random random = new Random();
    price = random.nextDouble() * 100;
    LOGGER.info("computing price at "+ 
      LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));  
    Thread.sleep(4000);
  }
}
```

Здесь мы установили значение fixedDelayString как, PT02S чтобы указать фиксированную задержку не менее 2 секунд между
последовательными вызовами. Точно так же мы можем использовать fixedRateString для указания фиксированной частоты
в этом формате.

## Вынесение интервала в файл свойств

Мы также можем ссылаться на значение свойства из нашего файла свойств в качестве значения атрибутов fixedDelayString
или fixedRateString для экстернализации значений интервала, как показано ниже:

```  
@Service
public class PricingEngine {
  
  static final Logger LOGGER = 
    Logger.getLogger(PricingEngine.class.getName());
  private Double price;
  
  public Double getProductPrice() {
    return price;
    
  }
  
  @Scheduled(fixedDelayString = "${interval}")
  public void computePrice() throws InterruptedException {
    
    Random random = new Random();
    price = random.nextDouble() * 100;
    LOGGER.info("computing price at "+ 
      LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));  
    Thread.sleep(4000);
  }

}


interval=PT02S
```

Здесь мы установили фиксированный интервал задержки как свойство в нашем файле application.properties. Именованное
свойство interval установлено в 2 секунды в формате продолжительности PT02S.

## Использование выражений Cron для определения интервала

Мы также можем указать временной интервал в cron-подобном выражении в стиле UNIX для более сложных требований
планирования,
как показано в этом примере:

``` 
@Service
public class PricingEngine {
...
...
  @Scheduled(cron = "${interval-in-cron}")
  public void computePrice() throws InterruptedException {
    ...
    ...
    LOGGER.info("computing price at "+ 
      LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));  
  }

}
interval-in-cron=0 * * * * *
```

Здесь мы указали интервал, используя выражение cron, привязанное к свойству с именем, interval-in-cron, определенным в
нашем application.properties файле.

Выражение cron представляет собой строку из шести-семи полей, разделенных пробелом, для представления триггеров на
секунду, минуту, час, день месяца, месяц, день недели и, необязательно, год. Однако выражение cron в Spring Scheduler
состоит из шести полей, как показано ниже:

```
┌───────────── second (0-59)
│ ┌───────────── minute (0 - 59)
│ │ ┌───────────── hour (0 - 23)
│ │ │ ┌───────────── day of the month (1 - 31)
│ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
│ │ │ │ │ ┌───────────── day of the week (0 - 7)
│ │ │ │ │ │          (or MON-SUN -- 0 or 7 is Sunday)
│ │ │ │ │ │
 * * * * * *
```

Например, выражение cron: 0 15 10 * * *запускается в 10:15 каждый день (каждую 0-ю секунду, 15-ю минуту, 10-й час,
каждый день). *указывает, что выражение cron соответствует всем значениям поля. Например, *в поле минут означает каждую
минуту.

Такие выражения, как 0 0 * * * *, трудно читать. Чтобы улучшить читаемость, Spring поддерживает макросы для
представления часто используемых последовательностей, как в следующем примере кода:

```
@Service
public class PricingEngine {
...
...
@Scheduled(cron = "@hourly")
public void computePrice() throws InterruptedException {
...
...
LOGGER.info("computing price at "+
LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));  
}

}
```

Здесь мы указали часовой интервал с помощью макроса cron: hourly вместо менее читаемого выражения cron 0 0 * * * *.

Spring предоставляет следующие макросы:

**@hourly**,

**@yearly**,

**@monthly**,

**@weekly**, а также

**@daily**

**Развертывание нескольких экземпляров планировщика с помощью ShedLock**
Как мы уже видели с помощью Spring Scheduler, очень легко планировать задания, добавляя аннотации @Scheduler к методам в
Spring Beans. Однако в распределенных средах, когда мы развертываем несколько экземпляров нашего приложения, оно не
может обрабатывать синхронизацию планировщика по нескольким экземплярам. Вместо этого он выполняет задания одновременно
на каждом узле.

ShedLock - это библиотека, которая гарантирует, что наши запланированные задачи при развертывании в нескольких
экземплярах выполняются не более одного раза одновременно. Он использует механизм блокировки, устанавливая блокировку
для одного экземпляра выполняемого задания, которая предотвращает выполнение на другом экземпляре того же задания.

Для координации ShedLock использует внешнее хранилище данных, совместно используемое несколькими экземплярами. В
качестве внешнего хранилища данных может использоваться любая база данных JDBC, такая как Mongo Redis, Hazelcast,
ZooKeeper или другие.

ShedLock разработан для использования в ситуациях, когда у нас есть запланированные задачи, которые не готовы к
параллельному выполнению, но могут безопасно выполняться повторно. Более того, блокировки основаны на времени, и
ShedLock предполагает, что часы на узлах синхронизированы.

Давайте изменим наш пример, добавив зависимости:

```  
<dependency>
    <groupId>net.javacrumbs.shedlock</groupId>
    <artifactId>shedlock-spring</artifactId>
    <version>4.27.0</version>
</dependency>

<dependency>
  <groupId>net.javacrumbs.shedlock</groupId>
  <artifactId>shedlock-provider-jdbc-template</artifactId>
  <version>4.27.0</version>
</dependency>

<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>runtime</scope>
</dependency>
```

Мы добавили зависимости от основного модуля shedlock-spring вместе с зависимостями от shedlock-provider-jdbc-template
шаблона jdbc и от базы данных h2, которая будет использоваться в качестве общей базы данных. В производственных
сценариях
мы должны использовать персистентную базу данных, такую ​​как MySQL, Postgres и т. д.

Затем мы обновляем конфигурацию нашего планировщика, чтобы интегрировать библиотеку с Spring:

``` 
@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "10m")
@EnableAsync
@ConditionalOnProperty(name="scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {
  
  @Bean
  public LockProvider lockProvider(DataSource dataSource) {
    return new JdbcTemplateLockProvider(
        JdbcTemplateLockProvider.Configuration.builder()
        .withJdbcTemplate(new JdbcTemplate(dataSource))
        .usingDbTime() // Works on Postgres, MySQL, MariaDb, MS SQL, Oracle, DB2, HSQL and H2
        .build()
    );
  }

}
```

Здесь мы включили блокировку расписания с помощью аннотации @EnableSchedulerLock. Мы также настроили LockProvider,
создав экземпляр, JdbcTemplateLockProvider, который подключен к источнику данных с базой данных в памяти H2.

Далее мы создадим таблицу, которая будет использоваться в качестве общей базы данных.

```
DROP TABLE IF EXISTS shedlock;

CREATE TABLE shedlock(
name VARCHAR(64) NOT NULL,
lock_until TIMESTAMP(3) NOT NULL,
locked_at TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
locked_by VARCHAR(255) NOT NULL,
PRIMARY KEY (name)
);
```

Наконец, мы аннотируем наши запланированные задания, применив аннотацию @SchedulerLock:

```
@Service
public class PricingEngine {

static final Logger LOGGER =
Logger.getLogger(PricingEngine.class.getName());


@Scheduled(cron = "${interval-in-cron}")
@SchedulerLock(name = "myscheduledTask")
public void computePrice() throws InterruptedException {

    Random random = new Random();
    price = random.nextDouble() * 100;
    LOGGER.info("computing price at "+ 
      LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));  
    Thread.sleep(4000);
}  
...
...
}
```

Здесь мы добавили аннотацию @SchedulerLock к методу computePrice(). Блокируются только методы, помеченные аннотацией
@SchedulerLock, библиотека игнорирует все другие запланированные задачи. Мы также указали имя для блокировки как
myscheduledTask. Мы можем одновременно выполнять только одну задачу с тем же именем.

## Условия использования распределенного планировщика заданий Quartz

Quartz Scheduler - это распределенный планировщик заданий с открытым исходным кодом, который предоставляет множество
функций корпоративного класса, таких как поддержка JTA транзакций и кластеризации.

Среди его основных возможностей - поддержка сохранения задания для внешней базы данных, что очень полезно для
возобновления невыполненных заданий, а также для целей отчетности.

Кластеризация - еще одна ключевая функция Quartz, которую можно использовать для обеспечения отказоустойчивости и/или
балансировки нагрузки.

Spring Scheduler предпочтительнее, когда мы хотим реализовать простую форму планирования заданий, такую ​​как
выполнение методов для bean-компонента каждые X секунд или по расписанию cron, не беспокоясь о каких-либо побочных
эффектах перезапуска заданий после сбоев.

С другой стороны, если нам нужна кластеризация вместе с поддержкой персистентности заданий, то Quartz - лучшая
альтернатива.

## Заключение

Краткий обзор основных моментов этой статьи:

1. Планирование является частью основного модуля, поэтому нам не нужно добавлять какие-либо зависимости.
2. По умолчанию планирование отключено. Мы явно включаем планирование, добавляя @EnableScheduling аннотацию к классу
   конфигурации Spring.
3. Мы можем сделать планирование условным для свойства, чтобы мы могли включать и отключать планирование, задав
   свойство.
4. Мы создаем запланированные задания, украсив метод аннотацией @Scheduled.
5. Только методы с типом возвращаемого значения void и без параметров можно преобразовать в запланированные задания
   путем
   добавления аннотации @Scheduled.
6. Мы устанавливаем интервал выполнения, указав атрибут fixedRate или fixedDelay в аннотации @Scheduled.
7. Мы можем отложить первое выполнение метода, указав интервал с помощью атрибута initialDelay.
8. Мы можем развернуть несколько экземпляров планировщика с помощью библиотеки ShedLock, которая обеспечивает
   одновременный запуск только одного экземпляра, используя механизм блокировки в общей базе данных.
9. Мы можем использовать распределенный планировщик заданий, такой как Quartz, для решения более сложных сценариев
10. планирования, таких как возобновление невыполненных заданий и создание отчетов.

Вы можете найти весь исходный код, использованный в статье на Github.