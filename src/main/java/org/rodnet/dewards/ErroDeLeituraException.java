package org.rodnet.dewards;

import java.net.MalformedURLException;

class ErroDeLeituraException extends RuntimeException {

    public ErroDeLeituraException(String mensagemDeErro, MalformedURLException e) {
        super(mensagemDeErro, e);
    }
}
