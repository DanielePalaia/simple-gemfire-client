gfsh -e "start locator --name=locator0 --port=10334 --bind-address=192.168.1.4 --locators='192.168.1.3[10334]'"
gfsh -e "configure pdx --read-serialized=true" 
