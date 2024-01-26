//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
data class User(val id: Int, val name: String)

object UserManager {
    private val users = mutableListOf<User>()

    fun addUser(id: Int, name: String) {
        val user = User(id, name)
        users.add(user)
    }

    fun listUsers() {
        users.forEach {
            println("${it.id} - ${it.name}")
        }
    }
}

fun main() {
    val quantity = readLine()?.toIntOrNull() ?: 0

    for (i in 1..quantity) {
        val name = readLine() ?: ""
        UserManager.addUser(i, name)
    }

    UserManager.listUsers()
}