package exam

import java.io.File

fun example(inputName: String): Int {
    if ("ultimate question" in File(inputName).readText().toLowerCase()) {
        return 42
    }
    throw IllegalStateException()
}

// Пожалуйста добавьте необходимые параметры,
// тип результата, и измените имя функции (Shift+F6)

//В файле с именем, заданном параметром inputName, содержится величина атмосферного давления в различные дни года, например:
//01.01: 755, 05.01: 758, 12.01: 765, 20.01: 768, 24.01: 763, 30.01: 756, 2.02: 752, 5.02: 745, 10.02: 739, 14.02: 742
//Даты приводятся в формате День.Месяц, после даты следует двоеточие, величина атмосферного давления в мм, и через запятую
// -- следующая дата. Между запятой и следующей датой могут присутствовать переводы строк в любом количестве. Даты следуют в календарном порядке, по возрастанию.
//В параметре query передаётся строковый запрос, по которому следует найти соответствующие величины давления и вернуть их
// как результат функции в  формате, аналогичном входному (см. примеры ниже).
//1. Поддерживается два вида запросов: "x < next" и "x > next". Это означает, что давление в данный день меньше (или больше),
// чем давление в следующий день в списке. Ответ на "x < next":
//01.01: 755, 05.01: 758, 12.01: 765, 10.02: 739.


fun atmPressure(inputName: String, query: String): String {
    val inputFile = File(inputName)

    val result = mutableListOf<String>()
    val str = inputFile.readText()
    val dataList = str.split(",").toMutableList()
    for (i in dataList.indices) {
        dataList[i] = dataList[i].trim()
    }

    val pressuresList = mutableListOf<Int>()
    for (i in dataList) {
        val dateAndP = i.split(":")
        pressuresList.add(dateAndP[1].toInt())
    }
    for (i in pressuresList.indices) {
        if (i < pressuresList.lastIndex) {
            when (query) {
                "x < next" -> {
                    if (pressuresList[i] < pressuresList[i + 1]) result.add(dataList[i])
                }
                "x > next" -> {
                    if (pressuresList[i] > pressuresList[i + 1]) result.add(dataList[i])
                }
            }
        }
    }
    return result.joinToString(", ")
}