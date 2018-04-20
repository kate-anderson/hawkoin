package hawkoin

object Blockchain {
    val chain = mutableListOf<Block>()
    val latestBlock: Block
        get() = chain.last()

    init {
        chain.add(Block(0,"0","Genesis Block",0))
    }

    fun addNewBlock(block:Block){
        if (isNewBlockValid(block))chain.add(block)
    }

    private fun isNewBlockValid(newBlock:Block):Boolean = ((newBlock.index == latestBlock.index+1)||(newBlock.previousHash== latestBlock.hash))

    private fun generatePOW(previousPOW:Int, difficulty:Int=1):Int{
        var proof = previousPOW +1
        val nonce = 18*difficulty

        while ((proof+previousPOW)%nonce != 0){
            proof +=1
        }
        return proof
    }
}