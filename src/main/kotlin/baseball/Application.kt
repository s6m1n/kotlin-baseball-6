package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        startBaseballGame()
    } while (isRestartable())
}

fun startBaseballGame() {
    val answer = creatRandomNumberList()
    var user = getUserInput()
    if (user == answer) {
        println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}

fun creatRandomNumberList(): MutableList<Int> {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber))
            numbers.add(randomNumber)
    }
    return numbers
}

fun getUserInput(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    var userNumber = Console.readLine().toInt()
    val userNumberList = mutableListOf<Int>()
    repeat(3) {
        userNumberList.add(0, userNumber % 10)
        userNumber /= 10
    }
    return userNumberList
}

fun isRestartable(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val restartChar = Console.readLine()
    return ("1" == restartChar)
}