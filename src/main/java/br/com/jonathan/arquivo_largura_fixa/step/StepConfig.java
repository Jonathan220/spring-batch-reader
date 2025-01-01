package br.com.jonathan.arquivo_largura_fixa.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jonathan.arquivo_largura_fixa.entities.Pessoa;

@Configuration
public class StepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step pessoaStep(ItemReader<Pessoa> reader, ItemWriter<Pessoa> writer){
        return stepBuilderFactory
        .get("pessoaStep")
        .<Pessoa, Pessoa>chunk(10)
        .reader(reader)
        .writer(writer)
        .build();
    }
}
