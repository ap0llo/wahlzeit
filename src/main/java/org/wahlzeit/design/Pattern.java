package org.wahlzeit.design;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Pattern {

    String name();

    String[] participants() default { };

    Class[] related() default { };
}
