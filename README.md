# TSIIR
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=ilyamzr_TSIIR&metric=bugs)](https://sonarcloud.io/summary/new_code?id=ilyamzr_TSIIR)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=ilyamzr_TSIIR&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=ilyamzr_TSIIR)
 
Sonar - https://sonarcloud.io/project/overview?id=ilyamzr_TSIIR

# Раздел 1.3 Контейнеры, очереди, стеки. 
Общее планируемое время - 145 мин, общее фактическое время 155 мин

## Задача 1 - 1.3.9) Напишите программу, которая принимает из стандартного ввода выражение без левых скобок и выводит эквивалентое инфиксное выражение со вставленными недостающими скобками.

План - 40 мин.
Факт - 35 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Контейнеры_очереди_стеки/1/src/main/java/org/example/ExpressionWithBrackets.java

## Задача 2 - 1.3.15) Напишите клиент класса Queue который принимает в командной строке аргумент k и выводит k-ую с конца строку из введененых из стандартного ввода

План - 35 мин.
Факт - 30 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Контейнеры_очереди_стеки/2/src/main/java/org/example/Queue.java

## Задача 3 - 1.3.33) Напишите класс Deque который реализует следующий API-интерфейс с помощью двусвязного списка
-Deque()
-isEmpty()
-size()
-pushLeft()
-pushRight()
-popLeft()
-popRight()

План - 40 мин.
Факт - 50 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Контейнеры_очереди_стеки/3/src/main/java/org/example/Deque.java

## Задача 4 - 1.3.40) Напишите программу для чтения символов и хранения из в односвязном списке. При вводе символа который еще не встречался, вставьте его в начало списка. При вводе уже знакомого списка удалите его из списка и снова вставьте в начало.

План - 30 мин.
Факт - 30 мин.



# Раздел 2.5 Применение сортировок. 
Общее планируемое время - 155 мин, общее фактическое время 150 мин

## Задача 1 - 2.5.10) Создайте тип данных Version, который представляет номер версии ПО вроде 115.1.1, 115.10.1, 115.10.2. Реализуйте для него интерфейс Comparable, так, чтобы версия 115.1.1 была меньше, чем 115.10.1.

План - 25 мин.
Факт - 25 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Применение_сортировок/1/src/main/java/org/example/Version.java

## Задача 2 - 2.5.14) Сортировка доменных имен. Напишите тип данных Domain, представляющий доменные имена и содержащий метод compareTo(), который реализует есте- ственный для доменных имен порядок обратных имен. Например, для домена cs.princeton.edu обратным именем будет edu.princeton.cs. Это удобно для анализа журналов работы в Интернете. Совет: для разбиения строки з на фрагменты, разделяемые точками, используйте вызов s.split("\\."). Напиши- те клиент, который читает имена доменов из стандартного ввода и выводит упо- рядоченный список обратных доменных имен.

План - 25 мин.
Факт - 20 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Применение_сортировок/2/src/main/java/org/example/Domain.java

## Задача 3 - 2.5.21) Напишите тип данных Vector для использования в методах сортировки многомерных векторов, состоящих из d целых чисел. Векторы упорядочиваются по первому компоненту, векторы с одинаковыми первыми компонентами по второму компоненту, с одинаковыми вторыми компонентами - по третьему компоненту и т.д.

План - 45 мин.
Факт - 65 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Применение_сортировок/3/src/main/java/org/example/Vector.java

## Задача 4 - 2.5.28) Сортировка файлов по именам. Напишите программу FileSorter, которая при- нимает из командной строки имя каталога и выводит имена всех находящихся там файлов, упорядоченные по алфавиту. Совет: используйте тип данных File.

План - 60 мин.
Факт - 40 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Применение_сортировок/4/src/main/java/org/example/FileSorter.java


# Раздел 3.2 Деревья бинарного поиска. 
Общее планируемое время - 105 мин, общее фактическое время 120 мин

## Задача 1 - 3.2.29) Проверка бинарного дерева. Напишите рекурсивный метод isBinaryTree(), который принимает в качестве аргумента узел Node и возвращает true, если счетчик узлов и для поддерева с указанным корнем верен, и false в противном случае.

План - 20 мин.
Факт - 30 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Деревья_бинарного_поиска/1/src/main/java/org/example/BinaryTreeChecker.java

## Задача 2 - 3.2.31) Проверка на равные ключи. Напишите метод hasNoDuplicates(), который принимает в качестве аргумента узел Node и возвращает true, если в бинарном дереве с корнем в указанном узле нет равных ключей, и false в противном случае. Считайте, что проверка из предыдущего упражнения уже выполнена.

План - 30 мин.
Факт - 25 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Деревья_бинарного_поиска/2/src/main/java/org/example/DuplicatesChecker.java

## Задача 3 - 3.2.37) Поуровневый обход. Напишите метод printLevel(), который принимает в качест- ве аргумента узел Node и выводит ключи из поддерева с корнем в указанном узле по уровням - т.е. в порядке их расстояния до корня, а для узлов с одинаковым расстоянием в порядке слева направо. Совет: воспользуйтесь классом Queue. 

План - 25 мин.
Факт - 25 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Деревья_бинарного_поиска/3/src/main/java/org/example/BinaryTree.java

## Задача 4 - 3.2.40) Высота. Экспериментально определите среднюю высоту ДБП, построенных в 100 выполнениях вставки N случайных ключей в первоначально пустое дерево, для N = 10^4, 10^5 и 10^6. Сравните полученный результат с формулой 2,99*lgN, приведенной в тексте.

План - 30 мин.
Факт - 40 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Деревья_бинарного_поиска/4/src/main/java/org/example/BinaryTree.java



# Раздел 3.4 Хеш-таблицы. 
Общее планируемое время - 210 мин, общее фактическое время - 230 мин

## Задача 1 - 3.4.20) Добавьте в класс LinearProbingHashST метод, который вычисляет среднюю стоимость попадания в таблице, считая, что поиск может быть выполнен для каждого ключа в таблице с равной вероятностью.

План - 40 мин.
Факт - 55 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Хеш-таблицы/1/src/main/java/org/example/LinearProbingHashST.java

## Задача 2 - 3.4.36) Диапазон длин списков. Напишите программу, которая вставляет N ключей int в таблицу размером N/100 с раздельными цепочками, а затем определяет длину самого короткого и самого длинного списков, для N = 10^3, 10^4, 10^5 и 10^6.

План - 60 мин.
Факт - 60 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Хеш-таблицы/2/src/main/java/org/example/LinearProbingHashST.java

## Задача 3 - 3.4.31) Распределение с линейным опробованием. Напишите программу, которая вставляет N/2 случайных ключей типа int в таблицу размером N с линейным опробованием, а затем вычисляет среднюю стоимость промахов в полученной таблице в зависимости от длин кластеров, для N = 10^3, 10^4, 10^5 и 10^6.

План - 50 мин.
Факт - 45 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Хеш-таблицы/3/src/main/java/org/example/LinearProbingHashST.java

## Задача 4 - 3.2.39) Разработайте реализацию таблицы имен, в которой исполь- зуются две хеш-таблицы и две хеш-функции. Любой заданный ключ может нахо- диться в одной из таблиц, но не в обеих. При вставке нового ключа хешируйте его в одну из таблиц. Если позиция в этой таблице занята, замените ключ в ней но- вым ключом, а старый ключ хешируйте в другую таблицу (где опять возможно вы- швыривание ключа, который находится там). Если процесс зациклился, начните его снова. Поддерживайте заполнение таблиц менее чем наполовину. Этот метод использует константное количество проверок на равенство в худшем случае для поиска (в обычном смысле) и амортизированно константное время для вставок

План - 60 мин.
Факт - 70 мин.

Ссылка на код: https://github.com/ilyamzr/CIID/blob/main/Хеш-таблицы/4/src/main/java/org/example/CuckooHashTable.java


