package hawkoin

import java.security.MessageDigest

fun hashing(input:String):String{
    val bytes = input.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    var output = ""

    for (byte in digest){output += "%02x".format(byte)}

    return output
}