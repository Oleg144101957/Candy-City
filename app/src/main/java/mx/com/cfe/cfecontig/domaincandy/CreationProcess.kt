package mx.com.cfe.cfecontig.domaincandy

class CreationProcess(private val g: String, private val f: String) {

    fun create(): String{

        var result = ""
        result = if (f != "null"){
            createFStrategy()
        } else {
            createOStrategy()
        }

        return result
    }

    private fun createFStrategy(): String {
        val destination: Destination = DestinationBuilder()
            .gadid_key(g)
            .deeplink_key(f)
            .build()
        return destination.toString()
    }

    private fun createOStrategy(): String {
        val destination: Destination = DestinationBuilder()
            .gadid_key(g)
            .build()
        return destination.toString()
    }
}