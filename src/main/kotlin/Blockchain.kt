package hawkoin

object Blockchain {
    val chain = mutableListOf<Block>()
    val latestBlock: Block
        get() = chain.last()

    init {
        chain.add(Block(0,"0","Genesis Block",0))
    }

    fun mineBlock(data:Any):Block{
        val proofOfWork = generatePOW(latestBlock.proofOfWork)
        val block = Block(chain.size, latestBlock.hash,data,proofOfWork)

        addNewBlock(block)

        return latestBlock
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