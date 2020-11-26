gfsh -e "start locator --name=locator0 --port=10334"
gfsh -e "configure pdx --read-serialized=true"
gfsh -e "start server --name=node0 --locators=localhost[10334] --initial-heap=5g --max-heap=5g  --critical-heap-percentage=90 --eviction-heap-percentage=80  --use-cluster-configuration=true"
