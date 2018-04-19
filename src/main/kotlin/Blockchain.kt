package hawkoin

object Blockchain {
    val chain = mutableListOf<Block>()
    val latestBlock: Block
        get() = chain.last()

    init {
        chain.add(Block(0,"0","Genesis Block"))
    }

    fun addNewBlock(block:Block){
        if (isNewBlockValid(block))chain.add(block)
    }

    private fun isNewBlockValid(newBlock:Block):Boolean = ((newBlock.index == latestBlock.index+1)||(newBlock.previousHash== latestBlock.hash))
}