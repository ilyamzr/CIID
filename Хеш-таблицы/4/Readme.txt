3.2.31) Разработайте реализацию таблицы имен, в которой исполь- зуются две хеш-таблицы и две хеш-функции. Любой заданный ключ может нахо- диться в одной из таблиц, но не в обеих. При вставке нового ключа хешируйте его в одну из таблиц. Если позиция в этой таблице занята, замените ключ в ней но- вым ключом, а старый ключ хешируйте в другую таблицу (где опять возможно вы- швыривание ключа, который находится там). Если процесс зациклился, начните его снова. Поддерживайте заполнение таблиц менее чем наполовину. Этот метод использует константное количество проверок на равенство в худшем случае для поиска (в обычном смысле) и амортизированно константное время для вставок

План - 60 мин
Факт - 70 мин
