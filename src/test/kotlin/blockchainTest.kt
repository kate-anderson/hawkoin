package hawkoin

import org.junit.Assert.*
import org.junit.Test

class blockchainTest{
    @Test
    fun genesisBlock(){

        //this isn't working because it is calling the mined block as the latestBlock
        val latestBlock = Blockchain.latestBlock.index
        val totalBlocks = Blockchain.chain.size

        assertEquals(0, latestBlock-totalBlocks+1)
    }

    @Test
    fun mineBlock(){
        val chain = Blockchain
        val genesisBlock = chain.latestBlock
        val minedBlock = chain.mineBlock("data")
        val expectedPOW = 18

        assertEquals(minedBlock, chain.latestBlock)
        assertEquals(genesisBlock.hash, minedBlock.previousHash)
        assertEquals("data", minedBlock.data)
        assertEquals(genesisBlock.index + 1, minedBlock.index)
        assertEquals(expectedPOW, minedBlock.proofOfWork)
        assertNotNull(minedBlock.hash)
        assertNotNull(minedBlock.timestamp)
    }

    @Test
    fun addBlock(){
        val chain = Blockchain
        val lastBlock = chain.latestBlock
        val newBlock = Block(chain.latestBlock.index+1,chain.latestBlock.hash,"transaction",0)
        chain.addNewBlock(newBlock)

        assertEquals(newBlock,chain.latestBlock)
        assertEquals(newBlock.previousHash, lastBlock.hash)
        assertNotNull(newBlock.hash)
        assertNotNull(newBlock.timestamp)
    }
}