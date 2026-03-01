package mate.academy

class HelloWorldAnonymousClasses {

    interface HelloWorldGreeting {
        fun greet(): String
        fun greetSomeone(someone: String): String
    }

    fun sayHello(names: List<String>): List<String> {
        val englishGreeting = object : HelloWorldGreeting {
            override fun greet() = "Hello world"
            override fun greetSomeone(someone: String) = "Hello $someone"
        }
        val frenchGreeting = object : HelloWorldGreeting {
            override fun greet() = "Salut tout le monde"
            override fun greetSomeone(someone: String) = "Salut $someone"
        }

        val spanishGreeting = object : HelloWorldGreeting {
            override fun greet() = "Hola, mundo"
            override fun greetSomeone(someone: String) = "Hola, $someone"
        }
        val greetings = listOf(englishGreeting, frenchGreeting, spanishGreeting)
        val result = mutableListOf<String>()

        // 1. Спершу додаємо загальні привітання (greet)
        for (language in greetings) {
            result.add(language.greet())
        }

        // 2. Потім для кожного імені додаємо персоналізовані привітання (greetSomeone)
        for (name in names) {
            for (language in greetings) {
                result.add(language.greetSomeone(name))
            }
        }

        return result
    }
}
