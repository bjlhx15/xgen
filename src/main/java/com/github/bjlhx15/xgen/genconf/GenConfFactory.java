package com.github.bjlhx15.xgen.genconf;

import com.github.bjlhx15.xgen.genconf.implementors.GenConfImplementor;

public class GenConfFactory {
    public static GenConfEbi createGenConfEbi(GenConfImplementor provider) {
        return GenConfEbo.getInstance(provider);
    }

    public static GenConfEbi createGenConfEbi() {
        return createGenConfEbi(null);
    }
}