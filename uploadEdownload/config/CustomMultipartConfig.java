package br.github.vraptor-upload.uploadEdownload.config;

import br.com.caelum.vraptor.interceptor.multipart.DefaultMultipartConfig;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class CustomMultipartConfig extends DefaultMultipartConfig {

    public long getSizeLimit() {
        return 20 * 1024 * 1024; // Limite de upload de arquivo 20MB
    }

}
