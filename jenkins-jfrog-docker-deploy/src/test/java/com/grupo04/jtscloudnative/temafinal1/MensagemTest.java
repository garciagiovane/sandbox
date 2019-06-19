package com.grupo04.jtscloudnative.temafinal1;

import com.grupo04.jtscloudnative.temafinal1.ServletMensagem;
import org.junit.Assert;
import org.junit.Test;

public class MensagemTest {

    @Test
    public void deveTestarMensagemHello() {
        ServletMensagem servletMensagem = new ServletMensagem();
        Assert.assertEquals("Hello, World", servletMensagem.executarMensagem());
    }
}
