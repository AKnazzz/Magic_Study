function calculateSum(x, y) {
  return Number(x) + Number(y);
}

// Обновите код в фукнции calculateSum, чтобы следующие выражения работали ожидаемым образом
console.log(calculateSum(10, '10')); // 20
console.log(calculateSum('5', '10')); // 15
console.log(calculateSum(8, 8.8)); // 16.8

function getWeatherRecommendations(isSunny, isRainy, isSnowy) {
  if (isRainy) {
    console.log('It is rainy, take an umbrella.');
  } else if (isSunny && isSnowy) {
    console.log(
      'Snow and sun are outside, do not forget the hat and sunglasses.'
    );
  } else if (isSnowy) {
    console.log('It is snow outside, do not forget the hat.');
  } else if (isSunny) {
    console.log('It is sunny, use sun protection.');
  } else {
    console.log('Casual day, have a great one!');
  }
}

// Используйте условные операторы в функции выше, чтобы следующие выражения работали ожидаемым образом
getWeatherRecommendations(true, false, false); // It is sunny, use sun protection.
getWeatherRecommendations(false, true, false); // It is rainy, take an umbrella.
getWeatherRecommendations(true, false, true); // Snow and sun are outside, do not forget the hat and sunglasses.
getWeatherRecommendations(false, false, true); // It is snow outside, do not forget the hat.
getWeatherRecommendations(false, false, false); // Сasual day, have a great one!

// Функция для проверки значения на false, измените функцию таким образом,
// чтобы только переменна boolean типа со значением false давала результат "Значение равно false"
function checkIfValIsFalse(value) {
  if (value === false) {
    console.log('Значение равно false');
  } else {
    console.log('Значение не равно false');
  }
}

checkIfValIsFalse(false); // "Значение равно false"
checkIfValIsFalse(0); // "Значение не равно false"
checkIfValIsFalse(''); // "Значение не равно false"
checkIfValIsFalse(null); // "Значение не равно false"

function stringOperations() {
    let greeting = "Hello, world!";

    // Вывод длины строки
    console.log(`Длина строки: ${greeting.length}`);

    // Получение символа строки по индексу
    console.log(`Символ по индексу 1: ${greeting.charAt(1)}`);

    // Преобразование строки в верхний регистр
    console.log(`Строка в верхнем регистре: ${greeting.toUpperCase()}`);

    // Поиск подстроки в строке
    let searchTerm = "world";
    if (greeting.includes(searchTerm)) {
        console.log(`Строка содержит подстроку ${searchTerm}`);
    }

    // Комбинирование строк (полное имя)
    let firstName = "John";
    let lastName = "Doe";
    console.log(`Полное имя: ${firstName} ${lastName}`);

    // Получение подстроки 'world' из строки 'Hello, world!'
    let subString = greeting.slice(3, 12);
    console.log(`Подстрока: ${subString}`);
}

stringOperations();
