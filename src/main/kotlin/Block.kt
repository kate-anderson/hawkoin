package hawkoin

import java.util.*

class Block (val index:Int, val previousHash:String, val data:Any,){
    val timestamp:Long = Date().time
    val hash = calculateHash()

    fun calculateHash():String{
        val input =(index.toString() + previousHash + timestamp + data).toByteArray()
        return DigestUtils.sha256Hex(input)
    }
}