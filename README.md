# Gemfire simple client

This is a simple Gemfire client which just populate some informations in regions. </br>

Regions are populated by Italian cars (Alfa Romeo, FCA, Lancia) </br>

Useful as demo or POC </br>

Before starting it you mush create a Gemfire cluster </br>

### Start a simple (non production ready) gemfire locator and a gemfire cache server and enable pdx

```
start locator --name=locator0 --port=10334</br>
configure pdx --read-serialized=true</br>
start server --name=node0 --locators=localhost[10334] --initial-heap=5g --max-heap=5g  --critical-heap-percentage=90 --eviction-heap-percentage=80  --use-cluster-configuration=true</br>
```

### Create now the regions Cars and Manufacturers:

```
create region --name=Cars --type=LOCAL
create region --name=Manufacturers --type=LOCAL
```

### Run the software (find in target directory the already compiled .jar) you should now see the regions populated in this way:

```
filling regions:
filling Cars region:
[info 2020/11/30 14:51:26.398 CET <main> tid=0x1] Auto serializer generating type for class org.geode.test.RandomCar for fields: 
    price: private int org.geode.test.Car.price
    idTag: private java.lang.String org.geode.test.Car.idTag
    manufacturer: private java.lang.String org.geode.test.Car.manufacturer
    model: private java.lang.String org.geode.test.Car.model
    colour: private java.lang.String org.geode.test.Car.colour
    DateImm: private java.lang.String org.geode.test.Car.DateImm


[info 2020/11/30 14:51:26.452 CET <main> tid=0x1] Caching PdxType[dsid=0, typenum=15523259
        name=org.geode.test.RandomCar
        fields=[
        price:int:0:idx0(relativeOffset)=0:idx1(vlfOffsetIndex)=0
        idTag:String:1:idx0(relativeOffset)=4:idx1(vlfOffsetIndex)=-1
        manufacturer:String:2:1:idx0(relativeOffset)=0:idx1(vlfOffsetIndex)=1
        model:String:3:2:idx0(relativeOffset)=0:idx1(vlfOffsetIndex)=2
        colour:String:4:3:idx0(relativeOffset)=0:idx1(vlfOffsetIndex)=3
        DateImm:String:5:4:idx0(relativeOffset)=0:idx1(vlfOffsetIndex)=4]]

[info 2020/11/30 14:51:28.772 CET <main> tid=0x1] Auto serializer generating type for class org.geode.test.Manufacturer for fields: 
    idTag: private java.lang.String org.geode.test.Manufacturer.idTag
    name: private java.lang.String org.geode.test.Manufacturer.name
    city: private java.lang.String org.geode.test.Manufacturer.city


[info 2020/11/30 14:51:28.777 CET <main> tid=0x1] Caching PdxType[dsid=0, typenum=258145
        name=org.geode.test.Manufacturer
        fields=[
        idTag:String:0:idx0(relativeOffset)=0:idx1(vlfOffsetIndex)=-1
        name:String:1:1:idx0(relativeOffset)=0:idx1(vlfOffsetIndex)=1
        city:String:2:2:idx0(relativeOffset)=0:idx1(vlfOffsetIndex)=2]]

cache and regions filled

```

You should see the regions populated and you can play with them </br>


```
gfsh>query --query='select * from /Cars limit 5';
Result : true
Rows   : 5


price |                idTag                 | manufacturer |   model   | colour | DateImm
----- | ------------------------------------ | ------------ | --------- | ------ | -------
15000 | 59191a8c-c3f3-44b9-999c-ae4b07672bb3 | FCA          | Punto     | Yellow | 2015
20000 | c6ad49d1-98ef-4e3a-bae2-112420e72806 | Lancia       | Y         | White  | 2014
25000 | 35d4ac8a-8400-4b8b-a298-4fdead5f36eb | Alfa Romeo   | Giulietta | Red    | 2013
25000 | f67ae05e-e25a-4bbc-94ed-24c5b6034dd4 | Alfa Romeo   | Giulietta | Red    | 2013
15000 | 6c25ee77-27b1-4492-b692-ec97c284b122 | FCA          | Punto     | Yellow | 2015
```

```
gfsh>query --query='select * from /Manufacturers';
Result : true
Limit  : 100
Rows   : 3

idTag |   name    | city
----- | --------- | ------
null  | Lancia    | Tourin
null  | FCA       | Tourin
null  | Alfa Rome | Tourin
```

