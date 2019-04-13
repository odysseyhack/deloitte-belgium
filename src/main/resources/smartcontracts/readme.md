#### Here is where the compiled files will be stored for the Smartcontracts, these can be used to generate the
#### java classes representing the smartcontract.

##### To generate the smartcontract, navigate to the folder where the solidity contract is defined.
##### Run the following command to generate the bin and abi files:
##### solc NameOfTheContract.solc --bin --abi --optimize -o /home/peter/Documents/
##### solc NameOfTheContract.solc --bin --abi --optimize -o /path/to/destination/folder
##### web3j-4.2.0/bin/web3j solidity generate 
##### -b /home/peter/IdeaProjects/smecosystem_rest/src/main/resources/smartcontracts/HelloWorld/HelloWorld.bin 
##### -a /home/peter/IdeaProjects/smecosystem_rest/src/main/resources/smartcontracts/HelloWorld/HelloWorld.abi
##### -o /home/peter/IdeaProjects/smecosystem_rest/src/main/resources/smartcontracts/HelloWorld/ -p com.deloitte

###### web3j-4.2.0/bin/web3j solidity generate -b /home/peter/IdeaProjects/deloitte-belgium/src/main/resources/smartcontracts/MultiSig23/MultiSig23.bin -a /home/peter/IdeaProjects/deloitte-belgium/src/main/resources/smartcontracts/MultiSig23/MultiSig23.abi -o /home/peter/IdeaProjects/deloitte-belgium/src/main/resources/smartcontracts/MultiSig23/ -p com.deloitte
