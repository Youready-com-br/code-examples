package br.com.youready.article.d_2024_11_25.image6;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.lang.ArchRule;

public class OnionArchitectureConfiguration {

    public ArchRule getOnionArchitectureRule() {
        return onionArchitecture()
                .domainModels("com.myapp.domain.model..")
                .domainServices("com.myapp.domain.service..")
                .applicationServices("com.myapp.application..")
                .adapter("cli", "com.myapp.adapter.cli..")
                .adapter("persistence", "com.myapp.adapter.persistence..")
                .adapter("rest", "com.myapp.adapter.rest..");
    }
}
