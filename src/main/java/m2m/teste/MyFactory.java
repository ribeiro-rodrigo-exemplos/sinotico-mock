package m2m.teste;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;

/**
 * Created by rodrigo on 27/11/17.
 */
public class MyFactory implements PortableFactory {

    public Portable create(int i) {
        if(i == 1)
            return new Alocacao();
        else
            return null;
    }
}
