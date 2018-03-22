package org.geode.test;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.client.*;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

public class Scenario {

    // Number of entry to insert for the experiment
    private static int numberOfElements=1000000;
    //Region reference
    private Region<String, Car> carRegion;

    // We create 3 different caches for 3 different region (without index, with index and resolved regions)
    private ClientCache cacheDefault;

    public void startGemfireServer(String host, String port)   {
        System.out.println("Attempting to start cache server");
        cacheDefault = new ClientCacheFactory()
                .addPoolLocator(host, Integer.valueOf(port))
                .setPdxSerializer(new ReflectionBasedAutoSerializer("org.geode.test.*"))
                .create();

        carRegion = cacheDefault
                .<String, Car>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY)
                .create("CARS");

        System.out.println("Cache server successfully started");
    }

    public void fillRegions()  {
        // Create And fill randomly the 3 different regions
        System.out.println();
        System.out.println("filling regions:");


        System.out.println("filling Cars region:");
        fillRegion(carRegion);

        System.out.println("cache and regions filled");
        System.out.println();
    }



    public void fillRegion(Region region)   {
        //Randomly insert elements
        RandomCar newCar = new RandomCar();
        for (int i = 0; i < numberOfElements; i++)   {
            newCar.random();
            region.create(newCar.getIdTag(), newCar);
        }
    }
}
