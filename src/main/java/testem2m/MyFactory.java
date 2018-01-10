package testem2m;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;

public class MyFactory implements PortableFactory {

    public Portable create(int i) {
        if(i == 1)
            return new Alocacao();
        else
            return null;
    }
}
