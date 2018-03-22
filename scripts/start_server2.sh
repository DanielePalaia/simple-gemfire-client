gfsh -e "connect --locator=10.3.3.140[10334]" 
gfsh -e "start server --name=node0 --bind-address=10.3.3.140 --server-port=40404 --locators=10.3.3.140[10334],10.3.3.141[10334] --initial-heap=5g --max-heap=5g  --critical-heap-percentage=90 --eviction-heap-percentage=80  --use-cluster-configuration=true"
