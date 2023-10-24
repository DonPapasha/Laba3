fun main() {
    println("Hello, dear user!")
    print("How would you like me to call you: ")
    val name: String = readln()
    println("Okaaay, it's pretty strange name. $name...")
    var exit: Boolean = false
    while (!exit)
    {
        println(
            "MENU\n" +
                    "1 - Change (-) and (_) with CamelCase\n" +
                    "2 - Password and login\n" +
                    "3 - Dichotomy game\n" +
                    "Other - Exit"
        )

        var choice: String = readln()
        if (choice == "1") {
            toCamelCase()
        } else if (choice == "2") {
            simAuthorization()
        } else if (choice == "3") {
            dichotomyGame()
        } else
            exit = true
    }
}

fun toCamelCase()
{
    println("Enter your simple variable name (Ex: The_big_-camel-Var ---> TheBigCamelVar)")
    var text: String = readln()
    var textLetters = text.toCharArray()
    for(i in 0..text.length-1)
    {
        if(textLetters[i] == '-' || textLetters[i] == '_')
        {
            text = text.substring(0, i+1) + textLetters[i+1].uppercase() + text.substring(i+2)
            //text[i+1] = text[i+1].uppercase();
        }

    }
    text = text.filterNot { it == '-' || it =='_' || it == ' '}
    println(text)
}

fun simAuthorization()
{
    println("REGISTRATION\n")
    val baseData = mutableMapOf<String, String>("admin" to "admin")
    print("Think up and Enter your LOGIN: ")
    var login: String = readln()
    print("Think up and Enter your PASSWORD: ")
    var password: String = readln()
    baseData[login] = password
    var i: Int = 0
    println("\nNow let's sign in (3 tries). There is a surprise waiting for you!")
    while(i < 3)
    {
        print("Enter your LOGIN: ")
        login = readln()
        print("Enter your PASSWORD: ")
        password = readln()
        if (baseData.containsKey(login) and baseData.containsKey(password))
        {
            println("\nCONGRATULATIONS!!!")
            println(
                " ! ! ! ! \n" +
                        "/#######\\\n" +
                        "|#CAKEE#|\n" +
                        "\\#######/"
            )
            i = 3
        }
        else
        {
            println("Sorry, but there is no such login or password...")
            i++
        }
    }
}

fun dichotomyGame()
{
    val answer: Int = (0..100).random()
    println("In this simple game you should guess the random number in range from 0 to 100")
    println("You can do it in any way, but i recommend you it use dichotomy.")
    println("After each entered option, you will find out whether the number\n" +
            " you have guessed is greater or less. Good lick!")
    var corNumber: Int = -1
    var attempts: Int = 0
    while(corNumber != answer)
    {
        attempts ++
        println("Enter your number: ")
        corNumber = readln().toInt()
        if(corNumber == answer)
            println("CONGRATULATIONS!!!")
        else if (corNumber < answer)
            println("Your number is less < then required number.")
        else
            println("Your number is greater > then required number.")
    }
    println("The correct number was $corNumber.\n" +
            "The number of your attempts: $attempts")
}