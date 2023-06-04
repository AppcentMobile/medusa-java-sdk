package mobi.appcent.medusa.store.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T> {

    public TypeReference() {}

    public Type getType() {
        Type mySuperclass = this.getClass().getGenericSuperclass();
        return ((ParameterizedType)mySuperclass).getActualTypeArguments()[0];
    }

 }