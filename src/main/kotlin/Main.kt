import com.google.gson.Gson
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update
import com.pengrad.telegrambot.request.SendMessage
import http.HttpServer

fun main() {
    /**
     * Done! Congratulations on your new bot. You will find it at t.me/repeat_talk_bot. You can now add a description, about section and profile picture for your bot, see /help for a list of commands. By the way, when you've finished creating your cool bot, ping our Bot Support if you want a better username for it. Just make sure the bot is fully operational before you do this.

    Use this token to access the HTTP API:
    1668524653:AAFgmgpsWMVXJlj2o5PJGBj2Dljb6fdYI0I
    Keep your token secure and store it safely, it can be used by anyone to control your bot.

    For a description of the Bot API, see this page: https://core.telegram.org/bots/api
     */
    val BOT_TOKEN = "1668524653:AAFgmgpsWMVXJlj2o5PJGBj2Dljb6fdYI0I"
    System.setProperty("java.net.useSystemProxies", "true")
    System.setProperty("http.proxyHost", "127.0.0.1")
    System.setProperty("http.proxyPort", "7890")
    val bot = TelegramBot(BOT_TOKEN)
    val gson = Gson()
    bot.setUpdatesListener(object : UpdatesListener {
        override fun process(`updates`: MutableList<Update>?): Int {
            updates?.stream()?.forEach {
                if (it.message() != null) {
                    var getText = it.message().text()
                    var split = getText.split("-")
                    if (split.size == 2) {
                        var googleTranslation = googleTranslation(split.get(1), split.get(0))
                        bot.execute(SendMessage(it.message().chat().id(), googleTranslation))
                    } else {
                        bot.execute(SendMessage(it.message().chat().id(), "格式有错误!"))
                    }
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL
        }
    })
}

private fun googleTranslation(lan: String, ori: String): String {
    var tran = ""
    var translation = HttpServer.getInstance().getTranslation(ori, lan)
    val transient = translation.execute()
    if (transient.isSuccessful) {
        var body = transient.body()
        if (body != null) {
            var sentences = body.sentences
            println(sentences!!.get(0).trans)
            tran = sentences!!.get(0).trans!!.toString()
        }
    }
    return tran
}