package hawkoin

import java.util.*

class Block (val index:Int, val previousHash:String, val data:Any, val proofOfWork:Int){
    val timestamp:Long = Date().time
    val hash = hashing((index.toString() + previousHash + timestamp + data))
}