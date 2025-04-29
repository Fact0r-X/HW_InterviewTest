Text File Manipulator (домашнее задание)
Простое консольное приложение для обработки текстовых файлов.

🔥 Возможности

reverse – реверс строк

sort – сортировка строк.

shuffle – случайное перемешивание.

✨ Легкое добавление новых действий без изменения основного кода

🚀 Быстрый старт

Сборка:

```javac -d out src/main/java/ait/example/TextManipulatorAppl.java src/main/java/ait/example/action/*.java```  

Запуск:

```java -cp out ait.example.TextManipulatorAppl input.txt output.txt действие```  

Пример:

```java -cp out ait.example.TextManipulatorAppl input.txt output.txt reverse```  

💡 Как добавить новое действие

Создайте класс в папке action:

```java
package ait.example.action;  

import ait.example.TextManipulatorAppl.TextAction;  
import java.util.List;  

public class NewAction implements TextAction {  
    @Override  
    public String getName() {  
        return "newaction"; // Команда для вызова  
    }  

    @Override  
    public void execute(List<String> input, List<String> output) {  
        // Ваша логика  
        input.forEach(line -> output.add(line.transform()));  
    }  
}
``` 

Добавьте регистрацию в TextManipulatorAppl:

```java
static {  
    ACTIONS.put("newaction", new NewAction()); // Добавьте эту строку  
}
```  
Готово! Теперь можно использовать:

```java -cp out ait.example.TextManipulatorAppl input.txt output.txt newaction```  

🏗️ Структура проекта

```src/  
└── main/  
    └── java/  
        └── ait/  
            └── example/  
                ├── TextManipulatorAppl.java  # Главный класс  
                └── action/                   # Папка с действиями  
                    ├── ReverseAction.java  
                    ├── SortAction.java  
                    └── ShuffleAction.java
```  

⚠️ Обработка ошибок

Usage: ... – если неверное число аргументов

Error: ... – при проблемах с файлами

Коды завершения:

0 – успех

1 – ошибка аргументов

2 – ошибка обработки

📝 Примеры

Сортировка:

```java -cp out ait.example.TextManipulatorAppl data.txt sorted.txt sort```  

Перемешивание:

```java -cp out ait.example.TextManipulatorAppl data.txt shuffled.txt shuffle```  

📜 Лицензия

MIT License. Свободное использование и модификация.
