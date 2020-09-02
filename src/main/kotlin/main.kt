fun main() {
    val seconds = 60 * 11
    println(agoToText(seconds))
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0 until 60 -> "был(а) в сети только что"
        in 60 until 60 * 60 -> "был(а) в сети ${minutesAgo(seconds)}"
        in 60 * 60 until 24 * 60 * 60 -> "был(а) в сети ${hoursAgo(seconds)}"
        in 24 * 60 * 60 until 24 * 60 * 60 * 2 -> "был(а) в сети вчера"
        else -> "был(а) в сети давно"
    }
}

fun minutesAgo(seconds: Int): String {
    val minutes = seconds / 60
    val minutesString = minutes.toString()
    val lastSymbol = minutesString.toCharArray()[minutesString.length - 1]
    val penultimateSymbol = penultimateSymbol(minutes)

    return when {
        lastSymbol == '1' && penultimateSymbol != '1' -> "$minutes минуту назад"
        (lastSymbol == '2' || lastSymbol == '3' || lastSymbol == '4') && penultimateSymbol != '1' -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursAgo(seconds: Int): String {
    val hours = seconds / 60 / 60
    val hoursString = hours.toString()
    val lastSymbol = hoursString.toCharArray()[hoursString.length - 1]
    val penultimateSymbol = penultimateSymbol(hours)

    return when {
        lastSymbol == '1' && penultimateSymbol != '1' -> "$hours час назад"
        (lastSymbol == '2' || lastSymbol == '3' || lastSymbol == '4') && penultimateSymbol != '1' -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}

fun penultimateSymbol(str: Int): Char {
    val strLength = str.toString().length
    return if (strLength > 1) str.toString()[strLength - 2] else '0'
}